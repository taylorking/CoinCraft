/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coincraft;
import org.bukkit.Server;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
/**
 *
 * @author tking
 */
public class PlayerJoined implements Listener {
    private Server server;
    private EntryPoint master;

    public PlayerJoined(Server server, EntryPoint master) {
        this.server = server;
        this.master = master;
    }
    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerJoined(final PlayerJoinEvent eve) {
        master.getOnline().add(eve.getPlayer());
        eve.getPlayer().teleport(this.master.getJail());
        //    eve.getPlayer().teleport(new org.bukkit.Location(this.server.getWorld("battle"),66, 208, 68));
    }


}

