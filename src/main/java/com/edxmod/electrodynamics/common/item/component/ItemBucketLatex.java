package com.edxmod.electrodynamics.common.item.component;

import com.edxmod.electrodynamics.common.item.prefab.EDXBasicItem;
import com.edxmod.electrodynamics.common.lib.EDXProps;
import com.edxmod.electrodynamics.common.tabs.EDXCreativeTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

/**
 * @author Thlayli.
 */
public class ItemBucketLatex extends EDXBasicItem {

    public ItemBucketLatex() {
        setCreativeTab(EDXCreativeTab.ITEMS.get());
        setMaxStackSize(1);
        setUnlocalizedName("bucketLatex");
    }

}
