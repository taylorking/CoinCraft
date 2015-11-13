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
    private final EntryPoint entry;
    public BlockPlace(Server server, EntryPoint entry) {
        this.server = server;
        this.entry = entry;

    }
    @EventHandler (priority  = EventPriority.LOW)
    public void blockPlace(final BlockPlaceEvent eve) {
        if(!eve.getPlayer().isOp() && (eve.getBlock().getLocation().getX() < 59 || eve.getBlock().getLocation().getX() > 83 || eve.getBlock().getLocation().getZ() > 218 || eve.getBlock().getLocation().getZ() < 197))
        {
            eve.setCancelled(true);
        }

    }
}
