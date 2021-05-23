package io.github.lukegrahamlandry.cosmetics.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

import java.util.UUID;

public class InfoRequestPacket implements IMessage {
    // A default constructor is always required
    public InfoRequestPacket(){}

    public String model;
    public UUID player;
    public InfoRequestPacket(UUID player, String model) {
        this.player = player;
        this.model = model;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        PacketBuffer buffer = new PacketBuffer(buf);
        buffer.writeUniqueId(player);
        buffer.writeString(model);

    }

    @Override
    public void fromBytes(ByteBuf buf) {
        PacketBuffer buffer = new PacketBuffer(buf);
        player = buffer.readUniqueId();
        model = buffer.readString(99);
    }
}