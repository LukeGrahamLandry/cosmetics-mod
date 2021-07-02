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
public class TickEvent {

    // i think this does nothing
    @SubscribeEvent
    public static void sync(PlayerEvent.PlayerLoggedInEvent event){
        CosmeticsMain.LOGGER.debug("player login");
        // if (event.player.world.isRemote) NetworkHandler.INSTANCE.sendToServer(new InfoRequestPacket(Minecraft.getMinecraft().player.getUniqueID()));
    }

    /*
    static int timer = 0;
    @SubscribeEvent
    public static void renderthings(net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent event){

        if (event.side == Side.CLIENT) { // always true
            timer++;
            if (timer % 30 == 0){
                // NetworkHandler.INSTANCE.sendToServer(new InfoRequestPacket(Minecraft.getMinecraft().player.getUniqueID()));
            }
        }
    }
     */
}

