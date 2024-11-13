package com.nemonotfound.nemosambience.mixin;

import com.nemonotfound.nemosambience.tag.ModBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.nemonotfound.nemosambience.client.particle.ModParticles.FALLING_LEAVES_PARTICLE;


@Mixin(LeavesBlock.class)
public class LeavesBlockMixin {

	@Inject(at = @At("HEAD"), method = "randomDisplayTick")
	private void init(BlockState state, World world, BlockPos pos, Random random, CallbackInfo ci) {
		boolean shouldBlockDropLeaves = state.getRegistryEntry().isIn(ModBlockTags.DROPS_FALLING_LEAVES);

		if (shouldBlockDropLeaves) {
			generateParticles(world, pos, random);
		}
	}

	@Unique
	private void generateParticles(World world, BlockPos pos, Random random) {
		if (random.nextInt(20) == 0) {
			BlockPos blockPos = pos.down();
			BlockState blockState = world.getBlockState(blockPos);

			if (LeavesBlock.isFaceFullSquare(blockState.getCollisionShape(world, blockPos), Direction.UP)) {
				return;
			}

			ParticleUtil.spawnParticle(world, pos, random, FALLING_LEAVES_PARTICLE);
		}
	}
}