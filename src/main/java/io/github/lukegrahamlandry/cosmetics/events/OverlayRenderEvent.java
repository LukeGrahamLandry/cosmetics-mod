package io.github.lukegrahamlandry.cosmetics.events;

import io.github.lukegrahamlandry.cosmetics.CosmeticArmorLayer;
import io.github.lukegrahamlandry.cosmetics.CosmeticsMain;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = CosmeticsMain.MODID, value = Side.CLIENT)
public class OverlayRenderEvent {
    // private static final Map<UUID, CosmeticArmorLayer> layers = new HashMap<>();

   //  static boolean init = false;


    /*
    @SubscribeEvent
    public static void renderthings(RenderPlayerEvent.Pre event){
        if (!init){
            event.getRenderer().addLayer(new CosmeticArmorLayer(event.getRenderer()));
            init = true;
            event.getRenderer().toString()
        }


        // event.getPartialRenderTick()
        UUID id = event.getEntity().getUniqueID();
        if (!layers.containsKey(id)){
            layers.put(id, new CosmeticArmorLayer(event.getRenderer()));
            event.getRenderer().addLayer(layers.get(id));
        }



        // event.getRenderer().getMainModel().bipedHeadwear = new ModelRenderer(new TestHelmet());
    }
    */

    @SubscribeEvent
    public static void water(RenderGameOverlayEvent.Post event){
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            Minecraft.getMinecraft().fontRenderer.drawString("LukeGrahamLandry#6888", 5, 5, 0xFFFFFF);
        }
    }
}

