/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coincraft;
import org.bukkit.event.Listener;
import org.bukkit.Server;
/**
 *
 * @author tking
 */
public class PlayerReady implements Listener {
    private Server server;
    public PlayerReady(Server s) {
        this.server = s;
    }
    @org.bukkit.event.EventHandler(priority=org.bukkit.event.EventPriority.LOW)
    public void onPlayerReady(final org.bukkit.event.block.NotePlayEvent eve)
    {
        // The player is ready. Send them to jon.
        
    }
}
