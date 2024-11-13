package com.nemonotfound.nemosambience.tag;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemosambience.NemosAmbience.MOD_ID;
import static com.nemonotfound.nemosambience.NemosAmbience.log;

public class ModBlockTags {

    public static final TagKey<Block> DROPS_FALLING_LEAVES = TagKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, "drops_falling_leaves"));

    public static void register() {
        log.info("Registering block tags");
    }
}
