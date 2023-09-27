package com.nemonotfound;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
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


    @Override
    public void onInitialize() {
        LOGGER.info("Thanks for using Nemo's Ambience!");
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "oak_leaves"), OAK_LEAVES_Particle);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "dark_oak_leaves"), DARK_OAK_LEAVES_Particle);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "birch_leaves"), BIRCH_LEAVES_Particle);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "spruce_leaves"), SPRUCE_LEAVES_Particle);
    }
}