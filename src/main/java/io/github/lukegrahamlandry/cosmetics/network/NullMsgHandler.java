package io.github.lukegrahamlandry.cosmetics.network;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class NullMsgHandler implements IMessageHandler<InfoRequestPacket, IMessage> {
    // Do note that the default constructor is required, but implicitly defined in this case

    @Override
    public IMessage onMessage(InfoRequestPacket message, MessageContext ctx) {

        // No response packet
        return null;
    }
}
