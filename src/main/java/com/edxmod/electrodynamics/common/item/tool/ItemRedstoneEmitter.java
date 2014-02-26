package com.edxmod.electrodynamics.common.item.tool;

import com.edxmod.electrodynamics.common.item.prefab.EDXMultiTool;
import com.edxmod.electrodynamics.common.item.prefab.EDXToolItem;
import com.edxmod.electrodynamics.common.lib.EDXProps;
import com.edxmod.electrodynamics.common.tabs.EDXCreativeTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

/**
 * @author Thlayli
 */
public class ItemRedstoneEmitter extends EDXMultiTool {

    public ItemRedstoneEmitter() {
        setCreativeTab(EDXCreativeTab.TOOLS.get());
        setMaxStackSize(1);
        setUnlocalizedNames(new String[]{"full_", "depleted_", "charging_"});
        setUnlocalizedName("redstoneEmitter");
    }
}
