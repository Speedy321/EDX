package com.edxmod.electrodynamics.common.item.prefab;

import com.edxmod.electrodynamics.common.lib.EDXProps;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * @author Thlayli
 */
public class EDXBasicItem extends Item {

    @Override
    public String getUnlocalizedName() {
        return "item.component." + getRawUnlocalizedName();
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return "item.component." + getRawUnlocalizedName();
    }

    //Returns the item's unlocalized name without the item prefix
    protected String getRawUnlocalizedName() {
        return super.getUnlocalizedName().substring(5);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(EDXProps.RESOURCE_PREFIX + getRawUnlocalizedName());
    }
}
