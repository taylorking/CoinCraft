/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coincraft;
import com.mashape.unirest.http.HttpMethod;
import org.bukkit.event.Listener;
import org.bukkit.Server;
import org.bukkit.Location;
import java.util.Random;
import org.bukkit.Material;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.http.HttpResponse;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.World;
import com.mashape.unirest.request.HttpRequestWithBody;
/**
 *
 * @author tking
 */
public class PlayerReady implements Listener {
    private final Server server;
    private final EntryPoint pluginCore;
    public PlayerReady(Server s, EntryPoint pluginCore) {
        this.server = s;
        this.pluginCore = pluginCore;
    }
    @EventHandler(priority=EventPriority.LOW)
    public void onPlayerReady(final BlockDamageEvent eve) {
        if(eve.getBlock().getWorld().getName().equals("jail")) {

            try {
                HttpRequest req = new HttpRequest(HttpMethod.GET, "http://bitmine.herokuapp.com/api/players/" + eve.getPlayer().getDisplayName());
                HttpResponse resp = req.asString();
                switch(resp.getStatus()) {
                case 500:
                    this.server.broadcastMessage("HTTP 500 Jon has screwed something up.");
                    break;
                case 404:
                    eve.getPlayer().kickPlayer("Please register http://bitmine.herokuapp.com");
                    break;
                case 402:
                    eve.getPlayer().sendMessage("Please pay the buy in");
                    break;
                case 200:
                    eve.getPlayer().sendMessage("Buy in complete. You have been marked as ready to compete.");
                    this.pluginCore.playerReady(eve.getPlayer());
                    break;
                }
            } catch (Exception ex) {
                Exception e = ex;
            }
            // If everybody is ready, the game can begin.
            if(this.pluginCore.getOnline().size() == this.pluginCore.getReady().size()) {
                randomize(pluginCore.getBattle().getWorld());
                for(Player person : this.pluginCore.getReady()) {
                    person.teleport(this.pluginCore.getBattle());
                }
            }
        }
        // The player is ready. Send them to jon.
        // HTTP 404: Not Registered
        // HTTP 402: Not Paid
        // HTTP 200: Ready
    }
    // Clear the playing field, Replace all the diamond ore with stone, hide one diamond ore block
    public void randomize(World world) {
        // These magic numbers are the coordinates for our playing field.
        for(int x = 59; x < 83; x++) {
            for(int y = 0 ; y < world.getMaxHeight(); y++) {
                for(int z = 197; z < 218; z++) {
                    if(world.getBlockAt(x, y, z).getType().equals(Material.DIAMOND_ORE)) {
                        world.getBlockAt(x,y,z).setType(Material.STONE);
                    }
                }
            }
        }
        Random randomizer = new Random();
        Location diamond = new Location(world,(double)59 + randomizer.nextInt(83 - 59),(double)randomizer.nextInt(5) + 1,(double) 197 + randomizer.nextInt(218 - 197));
        world.getBlockAt(diamond).setType(Material.DIAMOND_ORE);
        // Tell the server where we hid the diamond.
        try {
            HttpRequestWithBody req = new HttpRequestWithBody(HttpMethod.POST, "http://bitmine.herokuapp.com/api/diamond");
            req.header("Content-Type", "application/json");
            req.body("{\"Diamond\":\"" + diamond.toString()+"\"}");
            HttpResponse resp = req.asJson();
        } catch (Exception ex) {
            Exception e = ex;
        }
    }
}

