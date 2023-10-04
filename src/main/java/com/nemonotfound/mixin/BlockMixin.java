package com.nemonotfound.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registries;
import net.minecraft.sound.BlockSoundGroup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.nemonotfound.AmbienceMod.LEAVES;


@Mixin(Block.class)
public class BlockMixin {

	@Inject(at = @At("HEAD"), method = "getSoundGroup", cancellable = true)
	private void init(BlockState state, CallbackInfoReturnable<BlockSoundGroup> cir) {
		String blockName = Registries.BLOCK.getId(state.getBlock()).getPath();

        switch (blockName) {
            case "oak_leaves" -> setSoundGroupReturnValue(cir);
            case "dark_oak_leaves" -> setSoundGroupReturnValue(cir);
            case "birch_leaves" -> setSoundGroupReturnValue(cir);
            case "spruce_leaves" -> setSoundGroupReturnValue(cir);
            case "jungle_leaves" -> setSoundGroupReturnValue(cir);
            case "mangrove_leaves" -> setSoundGroupReturnValue(cir);
            case "acacia_leaves" -> setSoundGroupReturnValue(cir);
        }
	}

	@Unique
	private void setSoundGroupReturnValue(CallbackInfoReturnable<BlockSoundGroup> cir) {
		cir.setReturnValue(LEAVES);
	}
}