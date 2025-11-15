package dev.yourname.projecteec.calculator;

import dev.yourname.projecteec.compat.ProjecteApiCompat;
import net.minecraft.item.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Advanced EMC calculator for Minecraft 1.15.2
 * Supports Buzzy Bees update materials (honey, bees, beehives)
 */
public class AdvancedEmcCalculator_1_15 extends AdvancedEmcCalculator {
    
    private static final Logger LOGGER = LogManager.getLogger("EMC Calculator 1.15.2");
    
    public AdvancedEmcCalculator_1_15(ProjecteApiCompat apiCompat) {
        super(apiCompat);
    }
    
    @Override
    public void calculateCustomEmcValues() {
        LOGGER.info("Calculating custom EMC values for Minecraft 1.15.2 with Buzzy Bees support...");
        
        Map<Item, Long> customEmcValues = new HashMap<>();
        
        // Buzzy Bees Update (1.15) - Honey and Bee Materials
        
        // Honey Items
        addIfExists(customEmcValues, "honey_bottle", 128L); // Honey bottle
        addIfExists(customEmcValues, "honey_block", 512L); // Honey block (4 bottles)
        addIfExists(customEmcValues, "honeycomb", 64L); // Honeycomb from bees
        addIfExists(customEmcValues, "honeycomb_block", 256L); // Honeycomb block (4 honeycombs)
        
        // Bee-related Blocks
        addIfExists(customEmcValues, "bee_nest", 256L); // Natural bee nest
        addIfExists(customEmcValues, "beehive", 192L); // Crafted beehive (6 planks + 3 honeycomb)
        
        // Updated base materials that were refined in 1.15
        addIfExists(customEmcValues, "sweet_berries", 16L); // Sweet berries
        
        // Apply all custom EMC values
        for (Map.Entry<Item, Long> entry : customEmcValues.entrySet()) {
            apiCompat.setEmcValue(entry.getKey(), entry.getValue());
            LOGGER.debug("Set EMC value for {}: {}", 
                entry.getKey().getRegistryName(), entry.getValue());
        }
        
        LOGGER.info("Applied {} custom EMC values for Minecraft 1.15.2", customEmcValues.size());
    }
    
    private void addIfExists(Map<Item, Long> emcValues, String itemName, long emcValue) {
        try {
            Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemName));
            if (item != null && item != Items.AIR) {
                emcValues.put(item, emcValue);
            }
        } catch (Exception e) {
            LOGGER.debug("Item {} not found in 1.15.2, skipping EMC assignment", itemName);
        }
    }
    
    @Override
    public String getVersionInfo() {
        return "MC 1.15.2 - Buzzy Bees Update with honey, beehives, and bee-related materials";
    }
}