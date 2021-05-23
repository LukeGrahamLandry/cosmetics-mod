package io.github.lukegrahamlandry.cosmetics.network;

import io.github.lukegrahamlandry.cosmetics.CosmeticsMain;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkHandler {
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(CosmeticsMain.MODID);
    public static void initPackets() {
        INSTANCE.registerMessage(InfoResponseHandler.class, InfoRequestPacket.class, 0, Side.CLIENT);
        CosmeticsMain.LOGGER.debug("init packets");
    }
}
