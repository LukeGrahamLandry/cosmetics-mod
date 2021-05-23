package io.github.lukegrahamlandry.cosmetics.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

import java.util.UUID;

public class InfoRequestPacket implements IMessage {
    public String head;
    public String chest;
    public String legs;
    public String feet;

    // A default constructor is always required
    public InfoRequestPacket(){}

    public UUID player;
    public InfoRequestPacket(UUID player, String head, String chest, String legs, String feet) {
        this.player = player;
        this.head = head;
        this.chest = chest;
        this.legs = legs;
        this.feet = feet;
    }

    public InfoRequestPacket(UUID uniqueID) {
        this(uniqueID, "a", "b", "c", "d");
    }

    @Override
    public void toBytes(ByteBuf buf) {
        PacketBuffer buffer = new PacketBuffer(buf);
        buffer.writeUniqueId(player);
        buffer.writeString(head);
        buffer.writeString(chest);
        buffer.writeString(legs);
        buffer.writeString(feet);

    }

    @Override
    public void fromBytes(ByteBuf buf) {
        PacketBuffer buffer = new PacketBuffer(buf);
        player = buffer.readUniqueId();
        head = buffer.readString(99);
        chest = buffer.readString(99);
        legs = buffer.readString(99);
        feet = buffer.readString(99);
    }
}