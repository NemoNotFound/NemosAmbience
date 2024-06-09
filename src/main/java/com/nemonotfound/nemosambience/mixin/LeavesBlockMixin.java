package com.nemonotfound.nemosambience.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.nemonotfound.nemosambience.client.particle.ModParticles.*;


@Mixin(LeavesBlock.class)
public class LeavesBlockMixin {

	@Inject(at = @At("HEAD"), method = "randomDisplayTick")
	private void init(BlockState state, World world, BlockPos pos, Random random, CallbackInfo ci) {
		String leavesName = Registries.BLOCK.getId(state.getBlock()).getPath();
		boolean isLeavesBlock = state.getRegistryEntry().isIn(BlockTags.LEAVES);

		if (isLeavesBlock) {
			generateLeafParticles(world, pos, random, leavesName);
		}
	}

	@Unique
	private void generateLeafParticles(World world, BlockPos pos, Random random, String leavesName) {
		switch (leavesName) {
			case "oak_leaves" -> generateParticles(world, pos, random, OAK_LEAVES_Particle);
			case "dark_oak_leaves" -> generateParticles(world, pos, random, DARK_OAK_LEAVES_Particle);
			case "birch_leaves" -> generateParticles(world, pos, random, BIRCH_LEAVES_Particle);
			case "spruce_leaves" -> generateParticles(world, pos, random, SPRUCE_LEAVES_Particle);
			case "jungle_leaves" -> generateParticles(world, pos, random, JUNGLE_LEAVES_Particle);
			case "mangrove_leaves" -> generateParticles(world, pos, random, MANGROVE_LEAVES_Particle);
			case "acacia_leaves" -> generateParticles(world, pos, random, ACACIA_LEAVES_Particle);
		}
	}

	@Unique
	private void generateParticles(World world, BlockPos pos, Random random, SimpleParticleType particleType) {
		if (random.nextInt(20) == 0) {
			BlockPos blockPos = pos.down();
			BlockState blockState = world.getBlockState(blockPos);
			if (LeavesBlock.isFaceFullSquare(blockState.getCollisionShape(world, blockPos), Direction.UP)) {
				return;
			}
			ParticleUtil.spawnParticle(world, pos, random, particleType);
		}
	}
}