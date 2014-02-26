package com.edxmod.electrodynamics.common.tile;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * @author dmillerw
 */
public class TileTable extends TileCore {

    public ItemStack stack;

    @Override
    public void readCustomNBT(NBTTagCompound nbt) {
        if (nbt.hasKey("stack")) {
            stack = ItemStack.loadItemStackFromNBT(nbt.getCompoundTag("stack"));
        } else {
            stack = null;
        }
    }

    @Override
    public void writeCustomNBT(NBTTagCompound nbt) {
        if (stack != null) {
            NBTTagCompound stackNBT = new NBTTagCompound();
            stack.writeToNBT(stackNBT);
            nbt.setTag("stack", stackNBT);
        }
    }

}
