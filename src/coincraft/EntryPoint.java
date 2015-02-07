/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coincraft;
import java.util.Random;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Location;
import org.bukkit.Material;
import java.util.Set;
/**
 *
 * @author tking
 */


public class EntryPoint extends JavaPlugin {
    public Location battle;
    public Location jail;
    public void onEnable() {
     Random randomizer = new Random();
         this.getServer().getLogger().info("Coincraft Enabled.");
         this.getServer().getPluginManager().registerEvents(new BlockBreak(this.getServer()), this);
         this.getServer().getPluginManager().registerEvents(new PlayerReady(this.getServer(), this), this);
         this.getServer().getPluginManager().registerEvents(new PlayerJoined(this.getServer(), this), this);
         this.getServer().getPluginManager().registerEvents(new WorldLoaded(this.getServer(), this), this);
 //        java.util.List<org.bukkit.World> w = this.getServer().getWorlds();

        //this.getServer().getWorld("battle").setSpawnLocation();
         // Zero the diamonds in our chunk.

 
      //   Set<String> config = this.getConfig().getKeys(true);
       
//this.getServer().getWorld("battle").getBlockAt(diamond).setType(org.bukkit.Material.DIAMOND_ORE);
       
    }
    public Location getBattle() {
        return this.battle;
    }
    public Location getJail() {
        return this.jail;
    }
    public void setBattle(Location battle) {
        this.battle = battle;
    }
    public void setJail(Location jail) {
        this.jail = jail;
    }
    
}
