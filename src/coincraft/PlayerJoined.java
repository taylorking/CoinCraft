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
    private EntryPoint master;

    public PlayerJoined(org.bukkit.Server server, EntryPoint master) {
        this.server = server;
        this.master = master;
    }
    @org.bukkit.event.EventHandler(priority = org.bukkit.event.EventPriority.LOW)
    public void onPlayerJoined(final org.bukkit.event.player.PlayerJoinEvent eve) {
        this.master.getOnline().add(eve.getPlayer());
        eve.getPlayer().teleport(this.master.getJail());
        //    eve.getPlayer().teleport(new org.bukkit.Location(this.server.getWorld("battle"),66, 208, 68));
    }


}

