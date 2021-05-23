package io.github.lukegrahamlandry.cosmetics.events;

import io.github.lukegrahamlandry.cosmetics.CosmeticArmorLayer;
import io.github.lukegrahamlandry.cosmetics.CosmeticsMain;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid= CosmeticsMain.MODID, value= Side.CLIENT)
public class OverlayRenderEvent {
    @SubscribeEvent
    public static void renderthings(RenderPlayerEvent.Pre event){
        // event.getPartialRenderTick()
        event.getRenderer().addLayer(new CosmeticArmorLayer(event.getRenderer(), event.getEntity()));
        // event.getRenderer().getMainModel().bipedHeadwear = new ModelRenderer(new TestHelmet());
    }
}

