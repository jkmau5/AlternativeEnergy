package jkmau5.alternativeenergy.network;

import jkmau5.alternativeenergy.world.item.AltEngItems;
import jkmau5.alternativeenergy.world.tileentity.TileEntityPowerBox;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetworkManager;
import net.minecraft.tileentity.TileEntity;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * No description given
 *
 * @author jk-5
 */
public class PacketOutputspeedUpgrade extends AbstractPacket {

    private TileEntityPowerBox tile;
    private int numUpgrades;

    private int x, y, z;

    public PacketOutputspeedUpgrade(){} //We need the empty constructor here!
    public PacketOutputspeedUpgrade(TileEntityPowerBox tile, int numUpgrades){
        this.x = tile.xCoord;
        this.y = tile.yCoord;
        this.z = tile.zCoord;
        this.tile = tile;
        this.numUpgrades = numUpgrades;
    }

    @Override
    public void writePacket(DataOutput data) throws IOException {
        data.writeInt(this.x);
        data.writeInt(this.y);
        data.writeInt(this.z);
        data.writeInt(this.numUpgrades);
    }

    @Override
    public void readPacket(DataInput data) throws IOException {
        this.x = data.readInt();
        this.y = data.readInt();
        this.z = data.readInt();
    }

    @Override
    public void processPacket(INetworkManager manager, EntityPlayer player) {
        TileEntity tile = player.worldObj.getBlockTileEntity(this.x, this.y, this.z);
        if(tile == null || !(tile instanceof TileEntityPowerBox)) return;
        TileEntityPowerBox powerBox = (TileEntityPowerBox) tile;
        if(this.numUpgrades == 0){
            powerBox.outputSpeedSlot.put(null);
        }else{
            powerBox.outputSpeedSlot.put(new ItemStack(AltEngItems.itemUpgrade, this.numUpgrades, 1));
        }
        powerBox.forceOutputSpeedUpdate();
    }
}
