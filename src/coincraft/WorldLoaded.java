/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coincraft;
import org.bukkit.Server;
import org.bukkit.event.Listener;
import org.bukkit.Location;
import java.util.Random;
import org.bukkit.Material;
/**
 *
 * @author tking
 */
public class WorldLoaded implements Listener{
    private Server server;
    private EntryPoint master;
    public WorldLoaded(Server server, EntryPoint master /** This is a hackathon I don't give a shit */) {
        this.server = server;
        this.master = master;
    }
    @org.bukkit.event.EventHandler (priority = org.bukkit.event.EventPriority.LOW)
    public void worldLoaded(final org.bukkit.event.world.WorldLoadEvent eve) {
        String test = eve.getWorld().getName();
        test = eve.getWorld().toString();
        if(eve.getWorld().getName().equals("jail")){
           eve.getWorld().setPVP(false);
           this.master.setJail(new Location(eve.getWorld(), -32, 65, 14));
            this.server.createWorld(new org.bukkit.WorldCreator("battle"));
            this.master.setBattle(new Location(this.server.getWorld("battle"),66, 68, 204));
        }
    }
}
