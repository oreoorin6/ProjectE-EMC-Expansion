package dev.yourname.projecteec;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ProjectE EMC Expansion for Minecraft 1.15.2
 * Buzzy Bees update with honey blocks and beehives
 */
@Mod(ProjecteEmcExpansion.MODID)
public class ProjecteEmcExpansion {
    public static final String MODID = "projecte_emc_expansion";
    public static final String NAME = "ProjectE EMC Expansion";
    public static final String VERSION = "1.0.0";
    
    public static final Logger LOGGER = LogManager.getLogger(NAME);
    
    private static boolean projecteLoaded = false;
    
    public ProjecteEmcExpansion() {
        // Register setup event
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        
        // Register configuration
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ProjecteConfig.SPEC);
        
        LOGGER.info("ProjectE EMC Expansion {} loaded for Minecraft 1.15.2", VERSION);
    }
    
    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("Setting up ProjectE EMC Expansion for MC 1.15.2...");
        
        // Check if ProjectE is loaded
        try {
            Class.forName("moze_intel.projecte.api.EMCApi");
            projecteLoaded = true;
            LOGGER.info("ProjectE detected! EMC Expansion features enabled.");
        } catch (ClassNotFoundException e) {
            projecteLoaded = false;
            LOGGER.warn("ProjectE not found! EMC Expansion features will be disabled.");
        }
        
        // Register to MinecraftForge event bus for game events
        MinecraftForge.EVENT_BUS.register(this);
        
        LOGGER.info("ProjectE EMC Expansion setup complete!");
    }
    
    public static boolean isProjecteAvailable() {
        return projecteLoaded;
    }
    
    public static String getVersion() {
        return VERSION;
    }
}