/*
 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coincraft;
import com.mashape.unirest.http.HttpMethod;
/**
 *
 * @author tking
 */
public class BlockBreak implements org.bukkit.event.Listener {
    private org.bukkit.Server server;
    private EntryPoint p;
    public BlockBreak(org.bukkit.Server server, EntryPoint p)
    {
        this.server = server;
        this.p = p;
    }

    @org.bukkit.event.EventHandler(priority = org.bukkit.event.EventPriority.LOW)
    public void onBreak(final org.bukkit.event.block.BlockBreakEvent eve) {
        double y = eve.getBlock().getLocation().getZ();
        if(!eve.getPlayer().isOp() && (eve.getBlock().getLocation().getX() < 59 || eve.getBlock().getLocation().getX() > 83 || eve.getBlock().getLocation().getZ() > 218 || eve.getBlock().getLocation().getZ() < 197))
        {
            eve.setCancelled(true);
        }
        else if(eve.getBlock().getType().equals(org.bukkit.Material.DIAMOND_ORE))
        {
            try {
                com.mashape.unirest.request.HttpRequestWithBody req = new com.mashape.unirest.request.HttpRequestWithBody(HttpMethod.POST, "http://bitmine.herokuapp.com/api/winner");
                req.header("Content-Type","application/json");
                req.body("{\"winner\":\"" + eve.getPlayer().getDisplayName() + "\",\"diamond\":\"" + eve.getBlock().toString() +"\"}");
                this.server.broadcastMessage(eve.getPlayer().getDisplayName() + " found the diamond!");
                eve.getPlayer().sendMessage("You win!!!");
                com.mashape.unirest.http.HttpResponse resp = req.asJson();
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
