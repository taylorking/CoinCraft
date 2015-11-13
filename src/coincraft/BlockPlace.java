/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coincraft;
import org.bukkit.event.Listener;
import org.bukkit.Server;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.EventHandler;
/**
 *
 * @author tking
 */
public class BlockPlace implements Listener {
    private final Server server;
    private final EntryPoint pluginCore;
    public BlockPlace(Server server, EntryPoint pluginCore) {
        this.server = server;
        this.pluginCore = pluginCore;

    }
    @EventHandler (priority  = EventPriority.LOW)
    public void blockPlace(final BlockPlaceEvent eve) {
        // If the player is an OP they are allowed to put blocks wherever
        // These magic numbers are hardcoded locations in the minecraft world.
        if(!eve.getPlayer().isOp() && (eve.getBlock().getLocation().getX() < 59 ||
                                       eve.getBlock().getLocation().getX() > 83 || eve.getBlock().getLocation().getZ() > 218 ||
                                       eve.getBlock().getLocation().getZ() < 197))
        {
            eve.setCancelled(true);
        }

    }
}
