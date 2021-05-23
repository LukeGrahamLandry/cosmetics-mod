package io.github.lukegrahamlandry.cosmetics.network;

import io.github.lukegrahamlandry.cosmetics.CosmeticsMain;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class InfoResponseHandler implements IMessageHandler<InfoRequestPacket, IMessage> {
    @Override
    public IMessage onMessage(InfoRequestPacket message, MessageContext ctx) {
        CosmeticsMain.LOGGER.debug(message.player + " " + message.model);
        return null;
    }
}
