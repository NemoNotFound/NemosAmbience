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


@Mixin(Block.class)
public class BlockMixin {

    @Inject(at = @At("HEAD"), method = "getSoundGroup", cancellable = true)
    private void init(BlockState state, CallbackInfoReturnable<BlockSoundGroup> cir) {
        String blockName = Registries.BLOCK.getId(state.getBlock()).getPath();

        if (isLeafBlock(blockName)) {
            setSoundGroupReturnValue(cir);
        }
    }

    @Unique
    private boolean isLeafBlock(String blockName) {
        return blockName.equals("oak_leaves") ||
                blockName.equals("dark_oak_leaves") ||
                blockName.equals("birch_leaves") ||
                blockName.equals("spruce_leaves") ||
                blockName.equals("jungle_leaves") ||
                blockName.equals("mangrove_leaves") ||
                blockName.equals("acacia_leaves");

    }

    @Unique
    private void setSoundGroupReturnValue(CallbackInfoReturnable<BlockSoundGroup> cir) {
        cir.setReturnValue(BlockSoundGroup.AZALEA_LEAVES);
    }
}