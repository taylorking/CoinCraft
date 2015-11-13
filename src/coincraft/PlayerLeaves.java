/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coincraft;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
/**
 *
 * @author tking
 */
public class PlayerLeaves implements Listener {
    private final EntryPoint pluginCore;
    public PlayerLeaves(EntryPoint pluginCore) {
        this.pluginCore = pluginCore;
    }
    @EventHandler(priority = EventPriority.LOW)
    public void onLeave(final PlayerQuitEvent eve)
    {
        this.pluginCore.getOnline().remove(eve.getPlayer());
    }
    public void onKick(final PlayerKickEvent eve) {
        this.pluginCore.getOnline().remove(eve.getPlayer());
    }
}
