package io.github.lukegrahamlandry.cosmetics.events;

import io.github.lukegrahamlandry.cosmetics.CosmeticArmorLayer;
import io.github.lukegrahamlandry.cosmetics.CosmeticsMain;
import io.github.lukegrahamlandry.cosmetics.network.InfoRequestPacket;
import io.github.lukegrahamlandry.cosmetics.network.NetworkHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IResourcePack;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.Random;

@Mod.EventBusSubscriber(modid= CosmeticsMain.MODID, value= Side.CLIENT)
public class KeyHandler {
    @SubscribeEvent
    public static void onPress(InputEvent.KeyInputEvent event){
        // NetworkHandler.INSTANCE.sendToServer(new InfoRequestPacket(Minecraft.getMinecraft().player.getUniqueID(), "from mod"));

    }
}

