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
/**
 *
 *
 * @author tking
 */
public class BlockBreak implements Listener {
    private final Server server;
    private final EntryPoint p;
    public BlockBreak(org.bukkit.Server server, EntryPoint p)
    {
        this.server = server;
        this.p = p;
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
                req.body("{\"winner\":\"" + eve.getPlayer().getDisplayName() + "\",\"diamond\":\"" + eve.getBlock().toString() +"\"}");
                this.server.broadcastMessage(eve.getPlayer().getDisplayName() + " found the diamond!");
                eve.getPlayer().sendMessage("You win!!!");
                HttpResponse resp = req.asJson();
            } catch(Exception ex)
            {
                Exception e = ex;
            }
            for(org.bukkit.entity.Player pl : this.p.getOnline()) {
                pl.teleport(this.p.getJail());
            }
        }

    }
}
