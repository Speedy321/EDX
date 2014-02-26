package com.edxmod.electrodynamics.api;

import com.edxmod.electrodynamics.common.lib.EDXProps;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

/**
 * @author Royalixor
 */
public class EDXBlockHelper {

    public static Block get(String name) {
        return GameRegistry.findBlock(EDXProps.ID, name);
    }

    public static String getUniqueName(Block block) {
        return GameData.blockRegistry.getNameForObject(block);
    }

}
