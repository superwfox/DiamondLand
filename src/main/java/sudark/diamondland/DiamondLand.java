package sudark.diamondland;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class DiamondLand extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new ChunkLoadListener(), this);
    }

    public class ChunkLoadListener implements Listener {
        @EventHandler
        public void onChunkLoad(ChunkLoadEvent event) {
            if (!event.isNewChunk()) return;

            Chunk chunk = event.getChunk();
            int minY = 59;
            int maxY = 120;

            for (int x = 0; x < 16; x++) {
                for (int z = 0; z < 16; z++) {
                    for (int y = minY; y < maxY; y++) {
                        Block block = chunk.getBlock(x, y, z);
                        Material type = block.getType();

                        if (type == Material.DIRT || type == Material.GRASS_BLOCK) {
                            block.setType(Material.DIAMOND_ORE);
                        }

                    }
                }
            }
        }
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
