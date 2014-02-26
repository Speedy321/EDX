package com.edxmod.electrodynamics;

import com.edxmod.electrodynamics.client.render.block.RenderBlockOre;
import com.edxmod.electrodynamics.client.render.item.RenderItemTable;
import com.edxmod.electrodynamics.client.render.tile.RenderTileTable;
import com.edxmod.electrodynamics.common.lib.EDXProps;
import com.edxmod.electrodynamics.common.tile.TileTable;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.client.MinecraftForgeClient;

/**
 * @author Royalixor.
 */
public class ClientProxy extends CommonProxy {

    public static int renderPass;

    @Override
    public void registerRenders() {
        // BLOCK
        RenderingRegistry.registerBlockHandler(new RenderBlockOre());

        // TILE
        ClientRegistry.bindTileEntitySpecialRenderer(TileTable.class, new RenderTileTable());

        // ITEM
        MinecraftForgeClient.registerItemRenderer(GameRegistry.findItem(EDXProps.ID, "table"), new RenderItemTable());
    }

}
