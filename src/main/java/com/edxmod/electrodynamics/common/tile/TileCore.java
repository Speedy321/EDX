package com.edxmod.electrodynamics.common.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

/**
 * @author dmillerw
 */
public abstract class TileCore extends TileEntity {

    public abstract void readCustomNBT(NBTTagCompound nbt);

    public abstract void writeCustomNBT(NBTTagCompound nbt);

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        readCustomNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        writeCustomNBT(nbt);
    }

    public Packet getDescriptionPacket() {
        NBTTagCompound nbt = new NBTTagCompound();
        writeToNBT(nbt);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt);
    }

    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        switch (pkt.func_148853_f()) {
            case 0:
                readFromNBT(pkt.func_148857_g());
        }
        getWorldObj().markBlockRangeForRenderUpdate(xCoord, yCoord, zCoord, xCoord, yCoord, zCoord);
    }

}
