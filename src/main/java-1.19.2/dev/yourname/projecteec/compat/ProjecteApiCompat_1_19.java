package dev.yourname.projecteec.compat;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;

import java.lang.reflect.Method;

/**
 * ProjectE API compatibility layer for Minecraft 1.19.2
 * Handles ProjectE PE1.0.1 with Deep Dark and Wild Update compatibility
 */
public class ProjecteApiCompat_1_19 implements ProjecteApiCompat {
    
    private boolean projecteLoaded = false;
    private Class<?> emcApiClass = null;
    private Method getEmcValueMethod = null;
    private Method setEmcValueMethod = null;
    private Method hasEmcValueMethod = null;
    
    @Override
    public void initialize() {
        projecteLoaded = ModList.get().isLoaded("projecte");
        
        if (projecteLoaded) {
            try {
                // ProjectE API for 1.19.2
                emcApiClass = Class.forName("moze_intel.projecte.api.EMCApi");
                getEmcValueMethod = emcApiClass.getMethod("getEMCValue", ItemStack.class);
                setEmcValueMethod = emcApiClass.getMethod("setValue", ItemStack.class, long.class);
                hasEmcValueMethod = emcApiClass.getMethod("hasEMCValue", ItemStack.class);
                
                ProjecteEmcExpansion.LOGGER.info("ProjectE EMC API initialized for MC 1.19.2");
            } catch (Exception e) {
                ProjecteEmcExpansion.LOGGER.error("Failed to initialize ProjectE API", e);
                projecteLoaded = false;
            }
        }
    }
    
    @Override
    public long getEmcValue(Item item) {
        return getEmcValue(new ItemStack(item));
    }
    
    @Override
    public long getEmcValue(ItemStack stack) {
        if (!isProjecteAvailable()) return 0;
        
        try {
            Object result = getEmcValueMethod.invoke(null, stack);
            return result instanceof Long ? (Long) result : 0L;
        } catch (Exception e) {
            ProjecteEmcExpansion.LOGGER.debug("Failed to get EMC value for {}: {}", 
                stack.getItem().getDescriptionId(), e.getMessage());
            return 0;
        }
    }
    
    @Override
    public void setEmcValue(Item item, long emc) {
        if (!isProjecteAvailable()) return;
        
        try {
            setEmcValueMethod.invoke(null, new ItemStack(item), emc);
        } catch (Exception e) {
            ProjecteEmcExpansion.LOGGER.debug("Failed to set EMC value for {}: {}", 
                item.getDescriptionId(), e.getMessage());
        }
    }
    
    @Override
    public boolean hasEmcValue(Item item) {
        return hasEmcValue(new ItemStack(item));
    }
    
    @Override
    public boolean hasEmcValue(ItemStack stack) {
        if (!isProjecteAvailable()) return false;
        
        try {
            Object result = hasEmcValueMethod.invoke(null, stack);
            return result instanceof Boolean ? (Boolean) result : false;
        } catch (Exception e) {
            ProjecteEmcExpansion.LOGGER.debug("Failed to check EMC value for {}: {}", 
                stack.getItem().getDescriptionId(), e.getMessage());
            return false;
        }
    }
    
    @Override
    public String getProjecteVersion() {
        return "PE1.0.1";
    }
    
    @Override
    public boolean supportsFeature(String feature) {
        switch (feature) {
            case "reflection_api":
                return true;
            case "direct_api":
                return false;
            case "advanced_emc":
                return true;
            case "registry_names":
                return true;
            case "resource_locations":
                return true;
            case "deep_dark":
                return true; // Deep Dark biome support
            case "sculk_blocks":
                return true; // Sculk family support
            case "mangrove_swamp":
                return true; // Mangrove biome support
            case "mud_blocks":
                return true; // Mud family support
            case "froglight":
                return true; // Froglight support
            default:
                return false;
        }
    }
    
    @Override
    public boolean isProjecteAvailable() {
        return projecteLoaded && emcApiClass != null;
    }
}