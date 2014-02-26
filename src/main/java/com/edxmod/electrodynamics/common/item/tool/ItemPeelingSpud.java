package com.edxmod.electrodynamics.common.item.tool;

import com.edxmod.electrodynamics.common.item.prefab.EDXToolItem;
import com.edxmod.electrodynamics.common.lib.EDXProps;
import com.edxmod.electrodynamics.common.tabs.EDXCreativeTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

/**
 * @author Thlayli.
 */
public class ItemPeelingSpud extends EDXToolItem {

    public ItemPeelingSpud() {
        setCreativeTab(EDXCreativeTab.TOOLS.get());
        setMaxStackSize(1);
        setUnlocalizedName("peelingSpud");
    }

}
