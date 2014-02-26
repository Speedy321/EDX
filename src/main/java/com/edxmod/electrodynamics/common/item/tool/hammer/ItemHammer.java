package com.edxmod.electrodynamics.common.item.tool.hammer;

import com.edxmod.electrodynamics.common.item.prefab.EDXMultiTool;
import com.edxmod.electrodynamics.common.item.prefab.EDXToolItem;
import com.edxmod.electrodynamics.common.lib.EDXProps;
import com.edxmod.electrodynamics.common.tabs.EDXCreativeTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

/**
 * @author Thlayli
 */
public class ItemHammer extends EDXMultiTool {

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public ItemHammer() {
        setCreativeTab(EDXCreativeTab.TOOLS.get());
        setMaxStackSize(1);
        setHasSubtypes(true);
        setUnlocalizedName("hammer");
        setUnlocalizedNames(new String[] {"stone","steel"});
    }
}
