/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coincraft;
import org.bukkit.event.Listener;
import org.bukkit.Server;
import org.bukkit.Location;
import java.util.Random;
import org.bukkit.Material;
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
        
        eve.getPlayer().teleport(p.getBattle());
        randomize(p.getBattle().getWorld());
        eve.setCancelled(true);
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
         this.server.getLogger().info("Diamond ore at: " + diamond.toString());
    }
}
