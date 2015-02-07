/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coincraft;

/**
 *
 * @author tking
 */
public class PlayerJoined implements org.bukkit.event.Listener {
    private org.bukkit.Server server;
    public PlayerJoined(org.bukkit.Server server) {
        this.server = server;
    }
    @org.bukkit.event.EventHandler(priority = org.bukkit.event.EventPriority.LOW)
    public void onPLayerJoined(final org.bukkit.event.player.PlayerJoinEvent eve) {
        eve.getPlayer().getUniqueId().toString();
        eve.getPlayer().teleport(((EntryPoint)this.server).getJail());
        //    eve.getPlayer().teleport(new org.bukkit.Location(this.server.getWorld("battle"),66, 208, 68));
    }
    
    
}

