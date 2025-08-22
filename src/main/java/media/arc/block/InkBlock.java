package media.arc.block;

import media.arc.index.AfflictItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class InkBlock extends Block {
    private static final VoxelShape SHAPE = Block.createCuboidShape(0, 0, 0, 16, 1, 16);

    public InkBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        super.onEntityCollision(state, world, pos, entity);

        if (!world.isClient && entity instanceof ItemEntity itemEntity) {
            ItemStack stack = itemEntity.getStack();

            if (stack.isOf(AfflictItems.COIN)) {
                itemEntity.discard();

                // Trigger Affliction beam
                createAffliction(world, pos);
            }
        }
    }

    private void createAffliction(World world, BlockPos pos) {
        if (world instanceof ServerWorld serverWorld) {
            // Big explosion effect (no block damage)
            serverWorld.createExplosion(
                    null,
                    pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5,
                    16.0f,
                    false,
                    Explosion.DestructionType.NONE
            );

            // Schedule the first beam tick
            serverWorld.createAndScheduleBlockTick(pos, this, 4);
        }
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, net.minecraft.util.math.random.Random random) {
        // 200-block tall dark beam
        for (int y = 0; y < 200; y++) {
            // 5x5 area → radius of 2.5 around center
            for (double dx = -2.5; dx <= 2.5; dx += 0.5) {
                for (double dz = -2.5; dz <= 2.5; dz += 0.5) {
                    double px = pos.getX() + 0.5 + dx;
                    double py = pos.getY() + y;
                    double pz = pos.getZ() + 0.5 + dz;

                    // Summon smoke particle at this position
                    world.spawnParticles(
                            ParticleTypes.SMOKE,
                            px, py, pz,
                            1, 0, 0, 0, 0.01
                    );
                }
            }
        }

        // Reschedule beam continuation
        world.createAndScheduleBlockTick(pos, this, 4);
    }

}

