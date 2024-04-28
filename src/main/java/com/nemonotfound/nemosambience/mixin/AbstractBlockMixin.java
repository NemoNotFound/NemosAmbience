package com.nemonotfound.nemosambience.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.BlockSoundGroup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(AbstractBlock.class)
public class AbstractBlockMixin {

    @Inject(at = @At("HEAD"), method = "getSoundGroup", cancellable = true)
    private void init(BlockState state, CallbackInfoReturnable<BlockSoundGroup> cir) {
        boolean isLeavesBlock = state.getRegistryEntry().isIn(BlockTags.LEAVES);
        String blockName = Registries.BLOCK.getId(state.getBlock()).getPath();

        if (isLeavesBlock && !blockName.equals("cherry_leaves")) {
            cir.setReturnValue(BlockSoundGroup.AZALEA_LEAVES);
        }
    }
}