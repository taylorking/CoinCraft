/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coincraft;
import org.bukkit.event.Listener;
/**
 *
 * @author tking
 */
public class PlayerLeaves implements Listener {
    private EntryPoint e;

    public PlayerLeaves(EntryPoint e) {
        this.e = e;
    }
    @org.bukkit.event.EventHandler (priority = org.bukkit.event.EventPriority.LOW)
    public void onLeave(final org.bukkit.event.player.PlayerQuitEvent eve)
    {
        this.e.getOnline().remove(eve.getPlayer());
    }
    public void onKick(final org.bukkit.event.player.PlayerKickEvent eve) {
        this.e.getOnline().remove(eve.getPlayer());
    }
}
