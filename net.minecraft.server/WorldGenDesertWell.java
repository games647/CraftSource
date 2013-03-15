package net.minecraft.server;

import java.util.Random;

public class WorldGenDesertWell extends WorldGenerator {

    public WorldGenDesertWell() {}

    public boolean a(World world, Random random, int i, int j, int k) {
        while (world.isEmpty(i, j, k) && j > 2) {
            --j;
        }

        int l = world.getTypeId(i, j, k);

        if (l != Block.SAND.id) {
            return false;
        } else {
            int i1;
            int j1;

            for (i1 = -2; i1 <= 2; ++i1) {
                for (j1 = -2; j1 <= 2; ++j1) {
                    if (world.isEmpty(i + i1, j - 1, k + j1) && world.isEmpty(i + i1, j - 2, k + j1)) {
                        return false;
                    }
                }
            }

            for (i1 = -1; i1 <= 0; ++i1) {
                for (j1 = -2; j1 <= 2; ++j1) {
                    for (int k1 = -2; k1 <= 2; ++k1) {
                        world.setTypeIdAndData(i + j1, j + i1, k + k1, Block.SANDSTONE.id, 0, 2);
                    }
                }
            }

            world.setTypeIdAndData(i, j, k, Block.WATER.id, 0, 2);
            world.setTypeIdAndData(i - 1, j, k, Block.WATER.id, 0, 2);
            world.setTypeIdAndData(i + 1, j, k, Block.WATER.id, 0, 2);
            world.setTypeIdAndData(i, j, k - 1, Block.WATER.id, 0, 2);
            world.setTypeIdAndData(i, j, k + 1, Block.WATER.id, 0, 2);

            for (i1 = -2; i1 <= 2; ++i1) {
                for (j1 = -2; j1 <= 2; ++j1) {
                    if (i1 == -2 || i1 == 2 || j1 == -2 || j1 == 2) {
                        world.setTypeIdAndData(i + i1, j + 1, k + j1, Block.SANDSTONE.id, 0, 2);
                    }
                }
            }

            world.setTypeIdAndData(i + 2, j + 1, k, Block.STEP.id, 1, 2);
            world.setTypeIdAndData(i - 2, j + 1, k, Block.STEP.id, 1, 2);
            world.setTypeIdAndData(i, j + 1, k + 2, Block.STEP.id, 1, 2);
            world.setTypeIdAndData(i, j + 1, k - 2, Block.STEP.id, 1, 2);

            for (i1 = -1; i1 <= 1; ++i1) {
                for (j1 = -1; j1 <= 1; ++j1) {
                    if (i1 == 0 && j1 == 0) {
                        world.setTypeIdAndData(i + i1, j + 4, k + j1, Block.SANDSTONE.id, 0, 2);
                    } else {
                        world.setTypeIdAndData(i + i1, j + 4, k + j1, Block.STEP.id, 1, 2);
                    }
                }
            }

            for (i1 = 1; i1 <= 3; ++i1) {
                world.setTypeIdAndData(i - 1, j + i1, k - 1, Block.SANDSTONE.id, 0, 2);
                world.setTypeIdAndData(i - 1, j + i1, k + 1, Block.SANDSTONE.id, 0, 2);
                world.setTypeIdAndData(i + 1, j + i1, k - 1, Block.SANDSTONE.id, 0, 2);
                world.setTypeIdAndData(i + 1, j + i1, k + 1, Block.SANDSTONE.id, 0, 2);
            }

            return true;
        }
    }
}
