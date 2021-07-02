package io.github.lukegrahamlandry.cosmetics;

import io.github.lukegrahamlandry.cosmetics.network.NetworkHandler;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

@Mod(modid = "lukescosmetics", name = "Luke's Cosmetics", version = "0.8", useMetadata=true, dependencies = "required-after:geckolib3")
public class CosmeticsMain {
    public static final String MODID = "lukescosmetics";

    public static Logger LOGGER;

    public CosmeticsMain() {
        GeckoLib.initialize();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER = event.getModLog();
        NetworkHandler.initPackets();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public static void renderthings(FMLPostInitializationEvent event){
        Minecraft.getMinecraft().getRenderManager().getSkinMap().forEach((name, renderer) -> {
            renderer.addLayer(new CosmeticArmorLayer(renderer));
            System.out.println(name + " renderer");
        });
    }
}
