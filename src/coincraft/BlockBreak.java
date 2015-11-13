/*
 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coincraft;
import com.mashape.unirest.http.HttpMethod;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import com.mashape.unirest.request.HttpRequestWithBody;
import com.mashape.unirest.http.HttpResponse;
import org.bukkit.Server;
import org.bukkit.event.Listener;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.Server;
/**
 *
 *
 * @author tking
 */
public class BlockBreak implements Listener {
    private final Server server;
    private final EntryPoint pluginCore;
    public BlockBreak(Server server, EntryPoint pluginCore)
    {
        this.server = server;
        this.pluginCore = pluginCore;
    }

    @EventHandler (priority = EventPriority.LOW)
    public void onBreak(final BlockBreakEvent eve) {
        double y = eve.getBlock().getLocation().getZ();
        // These magic numbers are the locations in the world of the playing field.
        if(!eve.getPlayer().isOp() && (eve.getBlock().getLocation().getX() < 59 || eve.getBlock().getLocation().getX() > 83 || eve.getBlock().getLocation().getZ() > 218 || eve.getBlock().getLocation().getZ() < 197))
        {
            eve.setCancelled(true);
        }
        else if(eve.getBlock().getType().equals(Material.DIAMOND_ORE))
        {
            try {
                HttpRequestWithBody req = new HttpRequestWithBody(HttpMethod.POST, "http://bitmine.herokuapp.com/api/winner");
                req.header("Content-Type","application/json");
                // Tell the server somebody has one
                req.body("{\"winner\":\"" + eve.getPlayer().getDisplayName() + "\",\"diamond\":\"" + eve.getBlock().toString() +"\"}");
                this.server.broadcastMessage(eve.getPlayer().getDisplayName() + " found the diamond!");
                // Tell the player they have one
                eve.getPlayer().sendMessage("You win!!!");
                HttpResponse resp = req.asJson();
            } catch(Exception ex)
            {
                Exception e = ex;
            }
            // Move everybody back to the jail
            for(Player pl : this.pluginCore.getOnline()) {
                pl.teleport(this.pluginCore.getJail());
            }
        }

    }
}
