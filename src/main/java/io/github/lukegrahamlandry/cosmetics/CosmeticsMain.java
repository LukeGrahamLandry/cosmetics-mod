package io.github.lukegrahamlandry.cosmetics;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = CosmeticsMain.MODID, name = CosmeticsMain.NAME, version = CosmeticsMain.VERSION)
public class CosmeticsMain
{
    public static final String MODID = "lukescosmetics";
    public static final String NAME = "Luke's Cosmetics";
    public static final String VERSION = "0.8";

    public static Logger LOGGER;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LOGGER = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // some example code
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
