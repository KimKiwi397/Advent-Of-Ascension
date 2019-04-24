package net.nevermine.structures.precasia;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.nevermine.izer.Blockizer;

import java.util.Random;

public class AncientCactus1 extends WorldGenerator {

	public AncientCactus1() {
	}

	public boolean generate(World world, Random rand, int i, int j, int k) {

		world.setBlock(i + 0, j + 5, k + 2, Blockizer.AncientCactus);
		world.setBlock(i + 0, j + 6, k + 2, Blockizer.AncientCactus);
		world.setBlock(i + 0, j + 7, k + 2, Blockizer.AncientCactus);
		world.setBlock(i + 0, j + 8, k + 2, Blockizer.AncientCactus);
		world.setBlock(i + 1, j + 5, k + 2, Blockizer.AncientCactus);
		world.setBlock(i + 2, j + 0, k + 2, Blockizer.AncientCactus);
		world.setBlock(i + 2, j + 1, k + 2, Blockizer.AncientCactus);
		world.setBlock(i + 2, j + 2, k + 2, Blockizer.AncientCactus);
		world.setBlock(i + 2, j + 3, k + 2, Blockizer.AncientCactus);
		world.setBlock(i + 2, j + 4, k + 2, Blockizer.AncientCactus);
		world.setBlock(i + 2, j + 5, k + 0, Blockizer.AncientCactus);
		world.setBlock(i + 2, j + 5, k + 1, Blockizer.AncientCactus);
		world.setBlock(i + 2, j + 5, k + 2, Blockizer.AncientCactus);
		world.setBlock(i + 2, j + 5, k + 3, Blockizer.AncientCactus);
		world.setBlock(i + 2, j + 5, k + 4, Blockizer.AncientCactus);
		world.setBlock(i + 2, j + 6, k + 0, Blockizer.AncientCactus);
		world.setBlock(i + 2, j + 6, k + 2, Blockizer.AncientCactus);
		world.setBlock(i + 2, j + 6, k + 4, Blockizer.AncientCactus);
		world.setBlock(i + 2, j + 7, k + 0, Blockizer.AncientCactus);
		world.setBlock(i + 2, j + 7, k + 2, Blockizer.AncientCactus);
		world.setBlock(i + 2, j + 7, k + 4, Blockizer.AncientCactus);
		world.setBlock(i + 2, j + 8, k + 0, Blockizer.AncientCactus);
		world.setBlock(i + 2, j + 8, k + 2, Blockizer.AncientCactus);
		world.setBlock(i + 2, j + 8, k + 4, Blockizer.AncientCactus);
		world.setBlock(i + 3, j + 5, k + 2, Blockizer.AncientCactus);
		world.setBlock(i + 4, j + 5, k + 2, Blockizer.AncientCactus);
		world.setBlock(i + 4, j + 6, k + 2, Blockizer.AncientCactus);
		world.setBlock(i + 4, j + 7, k + 2, Blockizer.AncientCactus);
		world.setBlock(i + 4, j + 8, k + 2, Blockizer.AncientCactus);

		return true;
	}
}