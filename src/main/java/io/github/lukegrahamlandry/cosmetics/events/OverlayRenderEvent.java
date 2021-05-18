package io.github.lukegrahamlandry.cosmetics.events;

import io.github.lukegrahamlandry.cosmetics.BaseCosmeticLayer;
import io.github.lukegrahamlandry.cosmetics.CosmeticsLayer;
import io.github.lukegrahamlandry.cosmetics.CosmeticsMain;
import io.github.lukegrahamlandry.cosmetics.TestHelmet;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid= CosmeticsMain.MODID, value= Side.CLIENT)
public class OverlayRenderEvent {
    @SubscribeEvent
    public static void renderthings(RenderPlayerEvent.Pre event){
        // event.getPartialRenderTick()
        event.getRenderer().addLayer(new BaseCosmeticLayer(event.getRenderer()));
        // event.getRenderer().getMainModel().bipedHeadwear = new ModelRenderer(new TestHelmet());
    }
}

