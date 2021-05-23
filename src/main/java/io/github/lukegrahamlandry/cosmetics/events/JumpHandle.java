package io.github.lukegrahamlandry.cosmetics.events;

import io.github.lukegrahamlandry.cosmetics.CosmeticArmorLayer;
import io.github.lukegrahamlandry.cosmetics.CosmeticsMain;
import io.github.lukegrahamlandry.cosmetics.network.InfoRequestPacket;
import io.github.lukegrahamlandry.cosmetics.network.NetworkHandler;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.Random;

@Mod.EventBusSubscriber(modid= CosmeticsMain.MODID, value= Side.CLIENT)
public class JumpHandle {
    @SubscribeEvent
    public static void renderthings(InputEvent.KeyInputEvent event){
        int i = new Random().nextInt(255);
        NetworkHandler.INSTANCE.sendToServer(new InfoRequestPacket(i));
        CosmeticsMain.LOGGER.debug("sent packet " + i);
    }
}

