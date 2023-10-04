package com.nemonotfound;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AmbienceMod implements ModInitializer {

    public static final String MOD_ID = "nemos-ambience";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final DefaultParticleType OAK_LEAVES_Particle = FabricParticleTypes.simple();
    public static final DefaultParticleType DARK_OAK_LEAVES_Particle = FabricParticleTypes.simple();
    public static final DefaultParticleType BIRCH_LEAVES_Particle = FabricParticleTypes.simple();
    public static final DefaultParticleType SPRUCE_LEAVES_Particle = FabricParticleTypes.simple();
    public static final DefaultParticleType JUNGLE_LEAVES_Particle = FabricParticleTypes.simple();
    public static final DefaultParticleType MANGROVE_LEAVES_Particle = FabricParticleTypes.simple();
    public static final DefaultParticleType ACACIA_LEAVES_Particle = FabricParticleTypes.simple();
    public static final SoundEvent LEAVES_STEP = SoundEvent.of(new Identifier(MOD_ID, "leaves_step"));
    public static final BlockSoundGroup LEAVES = new BlockSoundGroup(1.0f, 1.0f, SoundEvents.BLOCK_GRASS_BREAK,
            LEAVES_STEP, SoundEvents.BLOCK_GRASS_PLACE, SoundEvents.BLOCK_GRASS_HIT, SoundEvents.BLOCK_GRASS_FALL);



    @Override
    public void onInitialize() {
        LOGGER.info("Thanks for using Nemo's Ambience!");
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "oak_leaves"), OAK_LEAVES_Particle);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "dark_oak_leaves"), DARK_OAK_LEAVES_Particle);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "birch_leaves"), BIRCH_LEAVES_Particle);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "spruce_leaves"), SPRUCE_LEAVES_Particle);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "jungle_leaves"), JUNGLE_LEAVES_Particle);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "mangrove_leaves"), MANGROVE_LEAVES_Particle);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "acacia_leaves"), ACACIA_LEAVES_Particle);
        Registry.register(Registries.SOUND_EVENT, new Identifier(MOD_ID, "leaves_step"), LEAVES_STEP);
    }
}