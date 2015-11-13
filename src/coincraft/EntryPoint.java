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
import org.bukkit.entity.Player;
import java.util.HashSet;
/**
 *
 * @author tking
 */


public class EntryPoint extends JavaPlugin {
    private HashSet<Player> ready, online_players;
    public Location battle;
    public Location jail;
    public void onEnable() {
        ready = new HashSet<Player>();
        online_players = new HashSet<Player>();
        Random randomizer = new Random();
        this.getServer().getLogger().info("Coincraft Enabled.");
        this.getServer().getPluginManager().registerEvents(new DispenserBlock(this.getServer()), this);
        this.getServer().getPluginManager().registerEvents(new BlockBreak(this.getServer(), this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerReady(this.getServer(), this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerJoined(this.getServer(), this), this);
        this.getServer().getPluginManager().registerEvents(new WorldLoaded(this.getServer(), this), this);
        this.getServer().getPluginManager().registerEvents(new BlockPlace(this.getServer(), this), this);
//        java.util.List<org.bukkit.World> w = this.getServer().getWorlds();

        //this.getServer().getWorld("battle").setSpawnLocation();
        // Zero the diamonds in our chunk.

        //Set<String> config = this.getConfig().getKeys(true);
        //   Set<String> config = this.getConfig().getKeys(true);

//this.getServer().getWorld("battle").getBlockAt(diamond).setType(org.bukkit.Material.DIAMOND_ORE);

    }
    public HashSet<Player> getOnline() {
        return online_players;
    }
    public HashSet<Player> getReady() {
        return ready;
    }

    public void playerReady(Player p)
    {
        ready.add(p);
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
