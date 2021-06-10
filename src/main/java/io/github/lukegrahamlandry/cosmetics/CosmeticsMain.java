package io.github.lukegrahamlandry.cosmetics;

import io.github.lukegrahamlandry.cosmetics.network.NetworkHandler;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

@Mod(modid = "lukescosmetics", name = "Luke's Cosmetics", version = "0.8", useMetadata=true)
public class CosmeticsMain {
    public static final String MODID = "lukescosmetics";
    public static final String NAME = "Luke's Cosmetics";
    public static final String VERSION = "0.8";

    public static Logger LOGGER;

    public CosmeticsMain() {
        GeckoLib.initialize();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LOGGER = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        NetworkHandler.initPackets();
    }
}
