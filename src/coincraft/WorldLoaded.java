
package coincraft;
import org.bukkit.Server;
import org.bukkit.event.Listener;
import org.bukkit.Location;
import org.bukkit.event.EventPriority;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.EventHandler;
/**
 *
 * @author tking
 */
public class WorldLoaded implements Listener {
    private final Server server;
    private final EntryPoint pluginCore;
    public WorldLoaded(Server server, EntryPoint pluginCore) { // This is a hackathon i'm tired, going to keep a reference to the core of the plugin */) {
        this.server = server;
        this.pluginCore = pluginCore;
    }
    @EventHandler (priority = EventPriority.LOW)
    public void worldLoaded(final WorldLoadEvent eve) {
        if(eve.getWorld().getName().equals("jail")) {
            // Don't allow the players to kill each other, that could be come complicated if they respawn
            eve.getWorld().setPVP(false);
            // These magic numbers define the coordinates of the jail
            this.pluginCore.setJail(new Location(eve.getWorld(), 8, 69, -4));
            this.server.createWorld(new org.bukkit.WorldCreator("battle"));
            this.pluginCore.setBattle(new Location(this.server.getWorld("battle"),66, 68, 204));
        }
    }
}
