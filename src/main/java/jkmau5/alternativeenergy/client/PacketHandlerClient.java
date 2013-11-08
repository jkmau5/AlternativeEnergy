package jkmau5.alternativeenergy.client;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import jkmau5.alternativeenergy.network.AbstractPacket;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;

/**
 * No description given
 *
 * @author jk-5
 */
public class PacketHandlerClient implements IPacketHandler {

    @Override
    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
        AbstractPacket.readPacket(packet).processPacket(manager, null);
    }
}