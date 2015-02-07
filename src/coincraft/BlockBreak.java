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
public class BlockBreak implements org.bukkit.event.Listener {
    private org.bukkit.Server server;
    public BlockBreak(org.bukkit.Server server)
    {
        this.server = server;
    }        
   
    @org.bukkit.event.EventHandler(priority = org.bukkit.event.EventPriority.LOW)
    public void onBreak(final org.bukkit.event.block.BlockBreakEvent eve) {
        double y = eve.getBlock().getLocation().getZ();
        if((!eve.getPlayer().isOp() || !eve.getBlock().getType().equals(org.bukkit.Material.SIGN)) && (eve.getBlock().getLocation().getX() < 59 || eve.getBlock().getLocation().getX() > 83 || eve.getBlock().getLocation().getZ() > 218 || eve.getBlock().getLocation().getZ() < 197))
        {
            eve.setCancelled(true);
        }
        else if(eve.getBlock().getType().equals(org.bukkit.Material.DIAMOND_ORE))
        {
            try{
            java.net.URL url = new java.net.URL("http://");
            java.net.URLConnection conn = url.openConnection(); 
            
            } catch (Exception ex) {
                
            }
        }
        
    }
    
}
