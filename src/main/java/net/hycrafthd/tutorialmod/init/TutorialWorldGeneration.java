package net.hycrafthd.tutorialmod.init;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MinableConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraftforge.registries.ForgeRegistries;

public class TutorialWorldGeneration {
	
	public static void setup() {
		// Generate our tutorial block
		ForgeRegistries.BIOMES.getValues().forEach(biome -> {
			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createCompositeFeature(Feature.MINABLE, new MinableConfig(block -> block == Blocks.AIR.getDefaultState(), TutorialBlocks.tutorial.getDefaultState(), 12), Biome.COUNT_RANGE, new CountRangeConfig(20, 0, 0, 256)));
			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createCompositeFeature(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, Blocks.BLACK_WOOL.getDefaultState(), 20), Biome.DEPTH_AVERAGE, new DepthAverageConfig(20, 48, 16)));
		});
	}
	
}
