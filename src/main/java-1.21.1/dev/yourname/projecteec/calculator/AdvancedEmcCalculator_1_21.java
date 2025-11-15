package dev.yourname.projecteec.calculator;

import dev.yourname.projecteec.compat.ProjecteApiCompat;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Advanced EMC calculator for Minecraft 1.21.1
 * Supports all materials up to and including the Tricky Trials update
 */
public class AdvancedEmcCalculator_1_21 extends AdvancedEmcCalculator {
    
    private static final Logger LOGGER = LogManager.getLogger("EMC Calculator 1.21.1");
    
    public AdvancedEmcCalculator_1_21(ProjecteApiCompat apiCompat) {
        super(apiCompat);
    }
    
    @Override
    public void calculateCustomEmcValues() {
        LOGGER.info("Calculating custom EMC values for Minecraft 1.21.1 with Tricky Trials support...");
        
        Map<Item, Long> customEmcValues = new HashMap<>();
        
        // Tricky Trials Update (1.21) - Trial Chamber Materials
        
        // Trial Spawners and Related Blocks
        addIfExists(customEmcValues, "trial_spawner", 32768L); // Very rare trial spawner
        addIfExists(customEmcValues, "vault", 16384L); // Vault block from trial chambers
        
        // Breeze Materials
        addIfExists(customEmcValues, "breeze_rod", 4096L); // Breeze rod (rare drop)
        
        // Copper Family - Complete Set
        addIfExists(customEmcValues, "copper_block", 576L); // 9 copper ingots * 64
        addIfExists(customEmcValues, "copper_ingot", 64L); // Base copper value
        addIfExists(customEmcValues, "raw_copper", 64L); // Raw copper same as ingot
        addIfExists(customEmcValues, "raw_copper_block", 576L); // 9 raw copper * 64
        addIfExists(customEmcValues, "copper_ore", 128L); // Ore bonus
        addIfExists(customEmcValues, "deepslate_copper_ore", 136L); // Slightly higher for deepslate
        
        // Oxidized Copper Variants
        addIfExists(customEmcValues, "exposed_copper", 64L);
        addIfExists(customEmcValues, "weathered_copper", 64L);
        addIfExists(customEmcValues, "oxidized_copper", 64L);
        addIfExists(customEmcValues, "waxed_copper_block", 72L); // Waxed versions slightly more
        addIfExists(customEmcValues, "waxed_exposed_copper", 72L);
        addIfExists(customEmcValues, "waxed_weathered_copper", 72L);
        addIfExists(customEmcValues, "waxed_oxidized_copper", 72L);
        
        // Cut Copper Variants
        addIfExists(customEmcValues, "cut_copper", 144L); // 4 cut from 1 block
        addIfExists(customEmcValues, "cut_copper_stairs", 108L); // 6 stairs from 4 blocks
        addIfExists(customEmcValues, "cut_copper_slab", 72L); // 6 slabs from 3 blocks
        
        // Crafter Block (1.21)
        addIfExists(customEmcValues, "crafter", 1024L); // Redstone automation block
        
        // Heavy Core (1.21)
        addIfExists(customEmcValues, "heavy_core", 8192L); // Rare trial chamber drop
        
        // Mace (1.21)
        addIfExists(customEmcValues, "mace", 12288L); // Heavy core + breeze rod crafting
        
        // Trial Keys and Ominous Items
        addIfExists(customEmcValues, "trial_key", 2048L); // Trial chamber key
        addIfExists(customEmcValues, "ominous_trial_key", 4096L); // Enhanced trial key
        addIfExists(customEmcValues, "ominous_bottle", 1024L); // Bad omen effect bottle
        
        // Updated Tuff Set (enhanced in 1.21)
        addIfExists(customEmcValues, "tuff", 1L);
        addIfExists(customEmcValues, "tuff_stairs", 1L); // Same as base
        addIfExists(customEmcValues, "tuff_slab", 1L);
        addIfExists(customEmcValues, "tuff_wall", 1L);
        addIfExists(customEmcValues, "polished_tuff", 1L);
        addIfExists(customEmcValues, "polished_tuff_stairs", 1L);
        addIfExists(customEmcValues, "polished_tuff_slab", 1L);
        addIfExists(customEmcValues, "polished_tuff_wall", 1L);
        addIfExists(customEmcValues, "tuff_bricks", 1L);
        addIfExists(customEmcValues, "tuff_brick_stairs", 1L);
        addIfExists(customEmcValues, "tuff_brick_slab", 1L);
        addIfExists(customEmcValues, "tuff_brick_wall", 1L);
        addIfExists(customEmcValues, "chiseled_tuff", 2L);
        addIfExists(customEmcValues, "chiseled_tuff_bricks", 2L);
        
        // Wind Charge (1.21)
        addIfExists(customEmcValues, "wind_charge", 512L); // Breeze mob drop
        
        // Trial Chamber Pottery Sherds
        addIfExists(customEmcValues, "flow_pottery_sherd", 256L);
        addIfExists(customEmcValues, "guster_pottery_sherd", 256L);
        addIfExists(customEmcValues, "scrape_pottery_sherd", 256L);
        
        // Trial Chamber Banner Patterns
        addIfExists(customEmcValues, "flow_banner_pattern", 512L);
        addIfExists(customEmcValues, "guster_banner_pattern", 512L);
        
        // Trial Chamber Armor Trims
        addIfExists(customEmcValues, "flow_armor_trim_smithing_template", 1024L);
        addIfExists(customEmcValues, "bolt_armor_trim_smithing_template", 1024L);
        
        // Previously added materials from earlier updates still valid
        
        // Deep Dark Materials (1.19)
        addIfExists(customEmcValues, "sculk", 2048L);
        addIfExists(customEmcValues, "sculk_catalyst", 8192L);
        addIfExists(customEmcValues, "sculk_sensor", 4096L);
        addIfExists(customEmcValues, "sculk_shrieker", 16384L);
        addIfExists(customEmcValues, "sculk_vein", 512L);
        addIfExists(customEmcValues, "echo_shard", 8192L);
        addIfExists(customEmcValues, "recovery_compass", 16384L);
        
        // Mangrove Wood Set (1.19)
        addIfExists(customEmcValues, "mangrove_log", 32L);
        addIfExists(customEmcValues, "mangrove_wood", 32L);
        addIfExists(customEmcValues, "stripped_mangrove_log", 32L);
        addIfExists(customEmcValues, "stripped_mangrove_wood", 32L);
        addIfExists(customEmcValues, "mangrove_planks", 8L);
        addIfExists(customEmcValues, "mangrove_leaves", 1L);
        addIfExists(customEmcValues, "mangrove_propagule", 32L);
        addIfExists(customEmcValues, "mangrove_roots", 8L);
        addIfExists(customEmcValues, "muddy_mangrove_roots", 16L);
        
        // Mud and Related (1.19)
        addIfExists(customEmcValues, "mud", 4L);
        addIfExists(customEmcValues, "packed_mud", 8L);
        addIfExists(customEmcValues, "mud_bricks", 16L);
        addIfExists(customEmcValues, "mud_brick_stairs", 12L);
        addIfExists(customEmcValues, "mud_brick_slab", 8L);
        addIfExists(customEmcValues, "mud_brick_wall", 16L);
        
        // Froglight Variants (1.19)
        addIfExists(customEmcValues, "ochre_froglight", 512L);
        addIfExists(customEmcValues, "verdant_froglight", 512L);
        addIfExists(customEmcValues, "pearlescent_froglight", 512L);
        
        // Frog Spawn and Tadpole Bucket (1.19)
        addIfExists(customEmcValues, "frogspawn", 64L);
        addIfExists(customEmcValues, "tadpole_bucket", 832L); // Bucket + tadpole
        
        // Goat Horn (1.19)
        addIfExists(customEmcValues, "goat_horn", 256L);
        
        // Apply all custom EMC values
        for (Map.Entry<Item, Long> entry : customEmcValues.entrySet()) {
            apiCompat.setEmcValue(entry.getKey(), entry.getValue());
            LOGGER.debug("Set EMC value for {}: {}", 
                entry.getKey().getDescriptionId(), entry.getValue());
        }
        
        LOGGER.info("Applied {} custom EMC values for Minecraft 1.21.1", customEmcValues.size());
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
            LOGGER.debug("Item {} not found in 1.21.1, skipping EMC assignment", itemName);
        }
    }
    
    @Override
    public String getVersionInfo() {
        return "MC 1.21.1 - Tricky Trials Update with Trial Chambers, Breeze, Copper Family, and Crafter support";
    }
}