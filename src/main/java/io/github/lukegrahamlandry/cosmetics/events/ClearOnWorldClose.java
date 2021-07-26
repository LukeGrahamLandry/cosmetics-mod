package io.github.lukegrahamlandry.cosmetics.events;

import io.github.lukegrahamlandry.cosmetics.CosmeticArmorLayer;
import io.github.lukegrahamlandry.cosmetics.CosmeticsMain;
import io.github.lukegrahamlandry.cosmetics.network.InfoRequestPacket;
import io.github.lukegrahamlandry.cosmetics.network.NetworkHandler;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid= CosmeticsMain.MODID)
public class ClearOnWorldClose {
    @SubscribeEvent
    public static void clear(PlayerEvent.PlayerLoggedOutEvent event){
        CosmeticsMain.LOGGER.debug("player leave. clearing cosmetics");
        CosmeticArmorLayer.TO_DISPLAY.clear();
    }
}

