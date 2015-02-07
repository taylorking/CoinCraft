/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coincraft;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;
import java.util.Random;
/**
 *
 * @author tking
 */
public class WorldGen extends org.bukkit.generator.ChunkGenerator {
    public byte[][] generateBlockSections(org.bukkit.World world, java.util.Random random, int chunkX, int chunkY, int chunkZ, BiomeGrid bgrid) {
     byte[][] result= new byte[world.getMaxHeight() / 16][]; 
     return result;
    }
}
