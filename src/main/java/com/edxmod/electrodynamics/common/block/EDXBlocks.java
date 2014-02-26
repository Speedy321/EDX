package com.edxmod.electrodynamics.common.block;

import com.edxmod.electrodynamics.common.block.prefab.item.EDXItemMultiBlock;
import com.edxmod.electrodynamics.common.tile.TileTable;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

/**
 * @author Royalixor.
 */
public class EDXBlocks {

    public static void init() {
        registerBlocks();
        registerTileEntities();
    }

    private static void registerBlocks() {
        registerBlock(new BlockTable().setBlockName("table"), EDXItemMultiBlock.class);
        registerBlock(new BlockLimestone().setBlockName("limestone"), EDXItemMultiBlock.class);
        registerBlock(new BlockOre().setBlockName("ore"), EDXItemMultiBlock.class);
        registerBlock(new BlockStorage().setBlockName("storage"), EDXItemMultiBlock.class);
    }

    private static void registerTileEntities() {
        GameRegistry.registerTileEntity(TileTable.class, "table");
    }

    public static void registerBlock(Block block) {
        GameRegistry.registerBlock(block, block.getUnlocalizedName().replace("tile.", ""));
    }

    public static void registerBlock(Block block, Class<? extends ItemBlock> itemBlockClass) {
        GameRegistry.registerBlock(block, itemBlockClass, block.getUnlocalizedName().replace("tile.", ""));
    }

    public static void registerBlock(Block block, Class<? extends ItemBlock> itemBlockClass, Object... constructorArgs) {
        GameRegistry.registerBlock(block, itemBlockClass, block.getUnlocalizedName().replace("tile.", ""), null, constructorArgs);
    }
}
