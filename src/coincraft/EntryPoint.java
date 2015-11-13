
package coincraft;
/**
 * Coincraft. Taylor King 2015
 * This was a hackathon project written in only a few hours, with a few hours of sleep.
 * I spent more time making it work than making it good.
 * Expect to see things like magic numbers and things that might not make sense.
 */
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Location;

import org.bukkit.plugin.PluginManager;
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

    @Override
    public void onEnable() {
        ready = new HashSet<>();
        online_players = new HashSet<>();
        PluginManager pluginManager = this.getServer().getPluginManager();
        this.getServer().getLogger().info("Coincraft Enabled.");
        pluginManager.registerEvents(new BlockBreak(this.getServer(), this), this);
        pluginManager.registerEvents(new PlayerReady(this.getServer(), this), this);
        pluginManager.registerEvents(new PlayerJoined(this.getServer(), this), this);
        pluginManager.registerEvents(new WorldLoaded(this.getServer(), this), this);
        pluginManager.registerEvents(new BlockPlace(this.getServer(), this), this);
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
