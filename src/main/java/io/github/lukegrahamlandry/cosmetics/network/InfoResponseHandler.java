package io.github.lukegrahamlandry.cosmetics.network;

import io.github.lukegrahamlandry.cosmetics.CosmeticArmorLayer;
import io.github.lukegrahamlandry.cosmetics.CosmeticsMain;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class InfoResponseHandler implements IMessageHandler<InfoRequestPacket, IMessage> {
    @Override
    public IMessage onMessage(InfoRequestPacket message, MessageContext ctx) {
        CosmeticsMain.LOGGER.debug("message");
        Minecraft.getMinecraft().addScheduledTask(() -> {
            CosmeticArmorLayer.Parts parts = new CosmeticArmorLayer.Parts();
            parts.head = message.head;
            parts.chest = message.chest;
            parts.legs = message.legs;
            parts.feet = message.feet;
            CosmeticArmorLayer.TO_DISPLAY.put(message.player, parts);
        });
        return null;
    }
}
