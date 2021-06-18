package io.github.lukegrahamlandry.cosmetics.events;

import io.github.lukegrahamlandry.cosmetics.CosmeticArmorLayer;
import io.github.lukegrahamlandry.cosmetics.CosmeticsMain;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = CosmeticsMain.MODID, value = Side.CLIENT)
public class OverlayRenderEvent {
    private static final Map<UUID, CosmeticArmorLayer> layers = new HashMap<>();

    @SubscribeEvent
    public static void renderthings(RenderPlayerEvent.Pre event){
        // event.getPartialRenderTick()
        UUID id = event.getEntity().getUniqueID();
        if (!layers.containsKey(id)){
            layers.put(id, new CosmeticArmorLayer(event.getRenderer(), event.getEntity()));
            event.getRenderer().addLayer(layers.get(id));
        }

        // event.getRenderer().getMainModel().bipedHeadwear = new ModelRenderer(new TestHelmet());
    }
}

