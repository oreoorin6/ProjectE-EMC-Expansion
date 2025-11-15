package dev.yourname.projecteec.calculator;

import dev.yourname.projecteec.compat.ProjecteApiCompat;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Advanced EMC calculator for Minecraft 1.19.2
 * Supports Deep Dark and Wild Update materials (sculk, echo shards, mangrove, mud, froglight)
 */
public class AdvancedEmcCalculator_1_19 extends AdvancedEmcCalculator {
    
    private static final Logger LOGGER = LogManager.getLogger("EMC Calculator 1.19.2");
    
    public AdvancedEmcCalculator_1_19(ProjecteApiCompat apiCompat) {
        super(apiCompat);
    }
    
    @Override
    public void calculateCustomEmcValues() {
        LOGGER.info("Calculating custom EMC values for Minecraft 1.19.2 with Deep Dark support...");
        
        Map<Item, Long> customEmcValues = new HashMap<>();
        
        // Deep Dark Materials (1.19)
        addIfExists(customEmcValues, "sculk", 2048L); // Base sculk block
        addIfExists(customEmcValues, "sculk_catalyst", 8192L); // Sculk catalyst (rare)
        addIfExists(customEmcValues, "sculk_sensor", 4096L); // Sculk sensor
        addIfExists(customEmcValues, "sculk_shrieker", 16384L); // Sculk shrieker (very rare)
        addIfExists(customEmcValues, "sculk_vein", 512L); // Sculk vein
        addIfExists(customEmcValues, "echo_shard", 8192L); // Echo shard from ancient cities
        addIfExists(customEmcValues, "recovery_compass", 16384L); // Recovery compass (8 echo shards)
        
        // Mangrove Wood Set (1.19)
        addIfExists(customEmcValues, "mangrove_log", 32L); // Mangrove log
        addIfExists(customEmcValues, "mangrove_wood", 32L); // Mangrove wood
        addIfExists(customEmcValues, "stripped_mangrove_log", 32L); // Stripped mangrove log
        addIfExists(customEmcValues, "stripped_mangrove_wood", 32L); // Stripped mangrove wood
        addIfExists(customEmcValues, "mangrove_planks", 8L); // Mangrove planks (4 from 1 log)
        addIfExists(customEmcValues, "mangrove_leaves", 1L); // Mangrove leaves
        addIfExists(customEmcValues, "mangrove_propagule", 32L); // Mangrove propagule (sapling)
        addIfExists(customEmcValues, "mangrove_roots", 8L); // Mangrove roots
        addIfExists(customEmcValues, "muddy_mangrove_roots", 16L); // Muddy mangrove roots
        
        // Mud and Related (1.19)
        addIfExists(customEmcValues, "mud", 4L); // Mud block
        addIfExists(customEmcValues, "packed_mud", 8L); // Packed mud
        addIfExists(customEmcValues, "mud_bricks", 16L); // Mud bricks
        addIfExists(customEmcValues, "mud_brick_stairs", 12L); // Mud brick stairs
        addIfExists(customEmcValues, "mud_brick_slab", 8L); // Mud brick slab
        addIfExists(customEmcValues, "mud_brick_wall", 16L); // Mud brick wall
        
        // Froglight Variants (1.19)
        addIfExists(customEmcValues, "ochre_froglight", 512L); // Ochre froglight
        addIfExists(customEmcValues, "verdant_froglight", 512L); // Verdant froglight
        addIfExists(customEmcValues, "pearlescent_froglight", 512L); // Pearlescent froglight
        
        // Frog Spawn and Tadpole Bucket (1.19)
        addIfExists(customEmcValues, "frogspawn", 64L); // Frog spawn
        addIfExists(customEmcValues, "tadpole_bucket", 832L); // Tadpole bucket (bucket + tadpole)
        
        // Goat Horn (1.19)
        addIfExists(customEmcValues, "goat_horn", 256L); // Goat horn
        
        // Apply all custom EMC values
        for (Map.Entry<Item, Long> entry : customEmcValues.entrySet()) {
            apiCompat.setEmcValue(entry.getKey(), entry.getValue());
            LOGGER.debug("Set EMC value for {}: {}", 
                entry.getKey().getDescriptionId(), entry.getValue());
        }
        
        LOGGER.info("Applied {} custom EMC values for Minecraft 1.19.2", customEmcValues.size());
    }
    
    private void addIfExists(Map<Item, Long> emcValues, String itemName, long emcValue) {
        try {
            Item item = ForgeRegistries.ITEMS.getValue(
                net.minecraft.resources.ResourceLocation.withDefaultNamespace(itemName)
            );
            if (item != null && item != Items.AIR) {
                emcValues.put(item, emcValue);
            }
        } catch (Exception e) {
            LOGGER.debug("Item {} not found in 1.19.2, skipping EMC assignment", itemName);
        }
    }
    
    @Override
    public String getVersionInfo() {
        return "MC 1.19.2 - Deep Dark & Wild Update with sculk, echo shards, mangrove, mud, and froglight support";
    }
}