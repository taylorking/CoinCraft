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
import com.mashape.unirest.request.*;
import org.bukkit.entity.Player;
/**
 *
 * @author tking
 */
public class PlayerReady implements Listener {
    private Server server;
    private EntryPoint p;
    public PlayerReady(Server s, EntryPoint p) {
        this.server = s;
        this.p = p;
    }
    @org.bukkit.event.EventHandler(priority=org.bukkit.event.EventPriority.LOW)
    public void onPlayerReady(final org.bukkit.event.block.BlockDamageEvent eve)
    {
        if(eve.getBlock().getWorld().getName().equals("jail")) {
       
        try{
            com.mashape.unirest.request.HttpRequest req = new com.mashape.unirest.request.HttpRequest(HttpMethod.GET, "http://bitmine.herokuapp.com/api/players/" + eve.getPlayer().getDisplayName());
            com.mashape.unirest.http.HttpResponse resp = req.asString();
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
                    this.p.playerReady(eve.getPlayer());
                    break;
            }
        } catch (Exception ex) {
            Exception e = ex;
        }
        
        if(this.p.getOnline().size() == this.p.getReady().size()) {
         randomize(p.getBattle().getWorld());
            for(Player person : this.p.getReady()) {
                person.teleport(this.p.getBattle());
            }
        }
        }
        // The player is ready. Send them to jon.
        // HTTP 404: Not Registered
        // HTTP 402: Not Paid
        // HTTP 200: Ready        
    } 
    public void randomize(org.bukkit.World world) {
        for(int x = 59; x < 83; x++) {
             for(int y = 0 ; y < world.getMaxHeight(); y++) { 
                 for(int z = 197; z < 218; z++) {
                     if(world.getBlockAt(x, y, z).getType().equals(org.bukkit.Material.DIAMOND_ORE)) {
                         world.getBlockAt(x,y,z).setType(org.bukkit.Material.STONE);
                     }
                 }
             }
           }
         Random randomizer = new Random();
         Location diamond = new Location(world,(double)59 + randomizer.nextInt(83 - 59),(double)randomizer.nextInt(5) + 1,(double) 197 + randomizer.nextInt(218 - 197));
         world.getBlockAt(diamond).setType(Material.DIAMOND_ORE);
         try {
         com.mashape.unirest.request.HttpRequestWithBody req = new com.mashape.unirest.request.HttpRequestWithBody(HttpMethod.POST, "http://bitmine.herokuapp.com/api/diamond");
         req.header("Content-Type", "application/json");
         req.body("{\"Diamond\":\"" + diamond.toString()+"\"}");
         com.mashape.unirest.http.HttpResponse resp = req.asJson();
         } catch (Exception ex)
         {
             Exception e = ex;
         }
    }
}

