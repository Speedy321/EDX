package com.edxmod.electrodynamics.common;

import com.edxmod.electrodynamics.common.config.EDXConfigurationMain;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.WorldChunkManager;

import java.util.List;
import java.util.Random;

/**
 * @author Royalixor
 */
public class ChunkManagerEDX extends WorldChunkManager {

    public ChunkManagerEDX(World world) {
        super(world);
    }

    @Override
    public ChunkPosition findBiomePosition(int x, int z, int radius, List biomesToSpawn, Random random) {
        int spawnSearchRadius = EDXConfigurationMain.spawnSearchRadius;
        return super.findBiomePosition(x, z, spawnSearchRadius, biomesToSpawn, random);
    }
}
