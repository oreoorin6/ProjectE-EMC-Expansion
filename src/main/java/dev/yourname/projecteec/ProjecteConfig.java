package dev.yourname.projecteec;

import net.minecraftforge.common.ForgeConfigSpec;

/**
 * Configuration for ProjectE EMC Expansion
 */
public class ProjecteConfig {
    
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    
    public static final ForgeConfigSpec.BooleanValue ENABLE_ADVANCED_EMC_CALCULATION;
    public static final ForgeConfigSpec.BooleanValue ENABLE_RECIPE_SCANNING;
    public static final ForgeConfigSpec.IntValue EMC_CACHE_SIZE;
    public static final ForgeConfigSpec.DoubleValue EMC_MULTIPLIER;
    
    static {
        BUILDER.push("General Settings");
        
        ENABLE_ADVANCED_EMC_CALCULATION = BUILDER
            .comment("Enable advanced EMC calculation for items without EMC values")
            .define("enableAdvancedEmcCalculation", true);
            
        ENABLE_RECIPE_SCANNING = BUILDER
            .comment("Enable recipe scanning for EMC calculation")
            .define("enableRecipeScanning", true);
            
        EMC_CACHE_SIZE = BUILDER
            .comment("Size of EMC calculation cache")
            .defineInRange("emcCacheSize", 1000, 100, 10000);
            
        EMC_MULTIPLIER = BUILDER
            .comment("Global EMC multiplier for calculated values")
            .defineInRange("emcMultiplier", 1.0, 0.1, 10.0);
        
        BUILDER.pop();
    }
    
    public static final ForgeConfigSpec SPEC = BUILDER.build();
}