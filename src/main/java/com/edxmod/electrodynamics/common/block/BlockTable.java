package com.edxmod.electrodynamics.common.block;

import com.edxmod.electrodynamics.client.render.tile.RenderTileTable;
import com.edxmod.electrodynamics.common.block.prefab.EDXTileMultiBlock;
import com.edxmod.electrodynamics.common.tile.TileTable;
import com.edxmod.electrodynamics.common.util.UtilArray;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * @author dmillerw
 */
public class BlockTable extends EDXTileMultiBlock {

    private static final String[] NAMES = new String[] {"wood", "stone"};

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);

        switch(meta) {
            case 0: {
                setBlockBounds(0, 0, 0, 1, RenderTileTable.WOOD_RENDER_MAX, 1);
                break;
            }

            case 1: {
                setBlockBounds(0, 0, 0, 1, RenderTileTable.STONE_RENDER_MAX, 1);
                break;
            }
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float fx, float fy, float fz) {
        if (!world.isRemote && !player.isSneaking()) {
            TileTable tile = (TileTable) world.getTileEntity(x, y, z);

            if (tile != null) {
                if (tile.stack == null && player.getHeldItem() != null) {
                    ItemStack stack = player.getHeldItem().copy();
                    stack.stackSize = 1;
                    tile.stack = stack;

                    player.getHeldItem().stackSize--;
                    if (player.getHeldItem().stackSize <= 0) {
                        player.setCurrentItemOrArmor(0, null);
                    }

                    world.markBlockForUpdate(x, y, z);
                    return true;
                } else if (tile.stack != null && player.getHeldItem() == null) {
                    player.setCurrentItemOrArmor(0, tile.stack.copy());
                    tile.stack = null;

                    world.markBlockForUpdate(x, y, z);
                    return true;
                } else if (tile.stack != null && player.getHeldItem() != null) {
                    if (tile.stack.isItemEqual(player.getHeldItem()) && (player.getHeldItem().stackSize + 1 <= player.getHeldItem().getItem().getItemStackLimit(player.getHeldItem()))) {
                        player.getHeldItem().stackSize++;
                        tile.stack = null;

                        world.markBlockForUpdate(x, y, z);
                        return true;
                    }
                }
            }
        }

        return !player.isSneaking();
    }

    @Override
    public int[] getSubtypes() {
        return UtilArray.getArrayIndexes(NAMES.length); // Forces all aspects of this block to base themselves off the NAMES array
    }

    @Override
    public String getNameForType(int type) {
        return NAMES[type];
    }

    @Override
    public boolean useCustomRender() {
        return true;
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return Blocks.planks.getIcon(side, meta);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileTable();
    }

}
