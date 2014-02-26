package com.edxmod.electrodynamics.common.block;

import com.edxmod.electrodynamics.ClientProxy;
import com.edxmod.electrodynamics.client.render.block.RenderBlockOre;
import com.edxmod.electrodynamics.common.block.prefab.EDXMultiBlock;
import com.edxmod.electrodynamics.common.lib.EDXProps;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Royalixor
 */
public class BlockOre extends EDXMultiBlock {

    public static Map<String, IIcon> iconCache = new HashMap<String, IIcon>();
    public IIcon[] iconOverlays;

    public BlockOre() {
        super(Material.rock);
        setHardness(3.0F);
        setStepSound(Block.soundTypeStone);
    }

    @Override
    public int[] getSubtypes() {
        return new int[]{0, 1, 2, 3, 4, 5, 6};
    }

    @Override
    public String getNameForType(int type) {
        switch (type) {
            case 0:
                return "chalcopyrite";
            case 1:
                return "cobaltite";
            case 2:
                return "galena";
            case 3:
                return "graphite";
            case 4:
                return "magnetite";
            case 5:
                return "nickel";
            case 6:
                return "wolframite";
            default:
                return "INVALID";
        }
    }

    @Override
    public boolean useCustomRender() {
        return false;
    }

    @Override
    public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {
        if (ClientProxy.renderPass == 1) {
            return iconOverlays[blockAccess.getBlockMetadata(x, y, z)];
        } else {
            if (!iconCache.containsKey(x + ":" + y + ":" + z)) {
                Block underlay = Blocks.stone;
                int underlayMeta = 0;

                for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
                    Block block = blockAccess.getBlock(x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ);
                    int meta = blockAccess.getBlockMetadata(x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ);

                    if (block != null && block.isOpaqueCube() && block != this) {
                        if (OreDictionary.getOreName(OreDictionary.getOreID(new ItemStack(block, 1, meta))).contains("stone")) {
                            underlay = block;
                            underlayMeta = meta;
                            break;
                        }
                    }
                }
                iconCache.put(x + ":" + y + ":" + z, underlay.getIcon(0, underlayMeta));
            }
            return iconCache.get(x + ":" + y + ":" + z);
        }
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        super.breakBlock(world, x, y, z, block, meta);

        if (world.isRemote && iconCache.containsKey(x + ":" + y + ":" + z)) {
            iconCache.remove(x + ":" + y + ":" + z);
        }
    }

    @Override
    public int getRenderType() {
        return RenderBlockOre.renderID;
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.iconOverlays = new IIcon[7];

        this.iconOverlays[0] = iconRegister.registerIcon(EDXProps.RESOURCE_PREFIX + "ore/chalcopyriteOre");
        this.iconOverlays[1] = iconRegister.registerIcon(EDXProps.RESOURCE_PREFIX + "ore/cobaltiteOre");
        this.iconOverlays[2] = iconRegister.registerIcon(EDXProps.RESOURCE_PREFIX + "ore/galenaOre");
        this.iconOverlays[3] = iconRegister.registerIcon(EDXProps.RESOURCE_PREFIX + "ore/graphiteOre");
        this.iconOverlays[4] = iconRegister.registerIcon(EDXProps.RESOURCE_PREFIX + "ore/magnetiteOre");
        this.iconOverlays[5] = iconRegister.registerIcon(EDXProps.RESOURCE_PREFIX + "ore/nickelOre");
        this.iconOverlays[6] = iconRegister.registerIcon(EDXProps.RESOURCE_PREFIX + "ore/wolframiteOre");
    }

    @Override
    public boolean canRenderInPass(int pass) {
        ClientProxy.renderPass = pass;
        return true;
    }

    @Override
    public int getRenderBlockPass() {
        return 1;
    }
}
