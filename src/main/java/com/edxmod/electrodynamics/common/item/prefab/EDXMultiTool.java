package com.edxmod.electrodynamics.common.item.prefab;

import com.edxmod.electrodynamics.common.lib.EDXProps;
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
public class EDXMultiTool extends EDXToolItem{
    private String[] type;
    private IIcon[] icons;

    protected void setUnlocalizedNames(String[] type) {
        this.type = type;
    }
    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return "item.tool." + type[itemStack.getItemDamage()] + getRawUnlocalizedName().substring(0,1).toUpperCase() +
                getRawUnlocalizedName().substring(1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        icons = new IIcon[type.length];
        for(int i=0;i<icons.length;i++){
            icons[i] = iconRegister.registerIcon((EDXProps.RESOURCE_PREFIX + type[i] + getRawUnlocalizedName()));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int dmg)
    {
        return icons[dmg];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List list){
        for(int i=0;i<icons.length;i++){
            list.add(new ItemStack(item,1,i));
        }
    }

}
