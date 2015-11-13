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
public class BlockPlace implements Listener {
    private Server server;
    private EntryPoint e;
    public BlockPlace(Server server, EntryPoint e) {
        this.server = server;
        this.e = e;

    }
    @org.bukkit.event.EventHandler (priority  = org.bukkit.event.EventPriority.LOW)
    public void blockPlace(final org.bukkit.event.block.BlockPlaceEvent eve) {
        if(!eve.getPlayer().isOp() && (eve.getBlock().getLocation().getX() < 59 || eve.getBlock().getLocation().getX() > 83 || eve.getBlock().getLocation().getZ() > 218 || eve.getBlock().getLocation().getZ() < 197))
        {
            eve.setCancelled(true);
        }

    }
}
