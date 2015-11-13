/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coincraft;
import org.bukkit.Server;
import org.bukkit.event.Listener;
import org.bukkit.Location;
import org.bukkit.event.EventPriority;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.EventHandler;
/**
 *
 * @author tking
 */
public class WorldLoaded implements Listener {
    private final Server server;
    private final EntryPoint master;
    public WorldLoaded(Server server, EntryPoint master /** This is a hackathon i'm tired, going to keep a reference to the core of the plugin */) {
        this.server = server;
        this.master = master;
    }
    @EventHandler (priority = EventPriority.LOW)
    public void worldLoaded(final WorldLoadEvent eve) {
        if(eve.getWorld().getName().equals("jail")) {
            eve.getWorld().setPVP(false);
            this.master.setJail(new Location(eve.getWorld(), 8, 69, -4));
            this.server.createWorld(new org.bukkit.WorldCreator("battle"));
            this.master.setBattle(new Location(this.server.getWorld("battle"),66, 68, 204));
        }
    }
}
