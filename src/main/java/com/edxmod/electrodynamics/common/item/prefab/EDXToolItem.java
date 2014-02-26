package com.edxmod.electrodynamics.common.item.prefab;
import net.minecraft.item.ItemStack;

/**
 * @author Thlayli
 */
public class EDXToolItem extends EDXBasicItem {

    @Override
    public String getUnlocalizedName(){
        return "item.tool." + getRawUnlocalizedName();
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return "item.tool." + getRawUnlocalizedName();
    }



}
