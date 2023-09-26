package com.nemonotfound.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.client.util.ParticleUtil;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.nemonotfound.AmbienceMod.OAK_LEAVES_Particle;


@Mixin(LeavesBlock.class)
public class LeavesBlockMixin {

	@Inject(at = @At("HEAD"), method = "randomDisplayTick")
	private void init(BlockState state, World world, BlockPos pos, Random random, CallbackInfo ci) {
		String leavesName = Registries.BLOCK.getId(state.getBlock()).getPath();

		if (leavesName.equals("oak_leaves")) {
			if (random.nextInt(20) != 0) {
				return;
			}
			BlockPos blockPos = pos.down();
			BlockState blockState = world.getBlockState(blockPos);
			if (LeavesBlock.isFaceFullSquare(blockState.getCollisionShape(world, blockPos), Direction.UP)) {
				return;
			}
			ParticleUtil.spawnParticle(world, pos, random, OAK_LEAVES_Particle);
		}
	}
}