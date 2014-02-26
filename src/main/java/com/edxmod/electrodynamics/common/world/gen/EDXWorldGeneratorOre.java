package com.edxmod.electrodynamics.common.world.gen;

import com.edxmod.electrodynamics.api.EDXBlockHelper;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

/**
 * @author Royalixor
 */
public class EDXWorldGeneratorOre implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.isSurfaceWorld()) {
            int gen = 20;
            while (gen > 0) {
                int firstBlockXCoord = 16 * chunkX + random.nextInt(16);
                int firstBlockYCoord = random.nextInt(64);
                int firstBlockZCoord = 16 * chunkX + random.nextInt(16);
                WorldGenMinable worldGenMinable = new WorldGenMinable(EDXBlockHelper.get("ore"), 1, 0, Blocks.stone);
                worldGenMinable.generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
                gen--;
            }
            gen = 12;
            while (gen > 0) {
                int firstBlockXCoord = 16 * chunkX + random.nextInt(16);
                int firstBlockYCoord = random.nextInt(64);
                int firstBlockZCoord = 16 * chunkX + random.nextInt(16);
                WorldGenMinable worldGenMinable = new WorldGenMinable(EDXBlockHelper.get("ore"), 1, 1, Blocks.stone);
                worldGenMinable.generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
                gen--;
            }
            gen = 6;
            while (gen > 0) {
                int firstBlockXCoord = 16 * chunkX + random.nextInt(16);
                int firstBlockYCoord = random.nextInt(64);
                int firstBlockZCoord = 16 * chunkX + random.nextInt(16);
                WorldGenMinable worldGenMinable = new WorldGenMinable(EDXBlockHelper.get("ore"), 1, 2, Blocks.stone);
                worldGenMinable.generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
                gen--;
            }
            gen = 12;
            while (gen > 0) {
                int firstBlockXCoord = 16 * chunkX + random.nextInt(16);
                int firstBlockYCoord = random.nextInt(64);
                int firstBlockZCoord = 16 * chunkX + random.nextInt(16);
                WorldGenMinable worldGenMinable = new WorldGenMinable(EDXBlockHelper.get("ore"), 1, 3, Blocks.stone);
                worldGenMinable.generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
                gen--;
            }
            gen = 12;
            while (gen > 0) {
                int firstBlockXCoord = 16 * chunkX + random.nextInt(16);
                int firstBlockYCoord = random.nextInt(64);
                int firstBlockZCoord = 16 * chunkX + random.nextInt(16);
                WorldGenMinable worldGenMinable = new WorldGenMinable(EDXBlockHelper.get("ore"), 1, 4, Blocks.stone);
                worldGenMinable.generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
                gen--;
            }
            gen = 20;
            while (gen > 0) {
                int firstBlockXCoord = 16 * chunkX + random.nextInt(16);
                int firstBlockYCoord = random.nextInt(64);
                int firstBlockZCoord = 16 * chunkX + random.nextInt(16);
                WorldGenMinable worldGenMinable = new WorldGenMinable(EDXBlockHelper.get("ore"), 1, 5, Blocks.stone);
                worldGenMinable.generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
                gen--;
            }
            gen = 2;
            while (gen > 0) {
                int firstBlockXCoord = 16 * chunkX + random.nextInt(16);
                int firstBlockYCoord = random.nextInt(64);
                int firstBlockZCoord = 16 * chunkX + random.nextInt(16);
                WorldGenMinable worldGenMinable = new WorldGenMinable(EDXBlockHelper.get("ore"), 1, 6, Blocks.stone);
                worldGenMinable.generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
                gen--;
            }
        }
    }
}
