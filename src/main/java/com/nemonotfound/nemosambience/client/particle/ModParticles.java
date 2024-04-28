package com.nemonotfound.nemosambience.client.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemosambience.NemosAmbience.MOD_ID;
import static com.nemonotfound.nemosambience.NemosAmbience.log;

public class ModParticles {

    public static final DefaultParticleType OAK_LEAVES_Particle = registerParticle("oak_leaves", FabricParticleTypes.simple());
    public static final DefaultParticleType DARK_OAK_LEAVES_Particle = registerParticle("dark_oak_leaves", FabricParticleTypes.simple());
    public static final DefaultParticleType BIRCH_LEAVES_Particle = registerParticle("birch_leaves", FabricParticleTypes.simple());
    public static final DefaultParticleType SPRUCE_LEAVES_Particle = registerParticle("spruce_leaves", FabricParticleTypes.simple());
    public static final DefaultParticleType JUNGLE_LEAVES_Particle = registerParticle("jungle_leaves", FabricParticleTypes.simple());
    public static final DefaultParticleType MANGROVE_LEAVES_Particle = registerParticle("mangrove_leaves", FabricParticleTypes.simple());
    public static final DefaultParticleType ACACIA_LEAVES_Particle = registerParticle("acacia_leaves", FabricParticleTypes.simple());

    public static void registerParticles() {
        log.info("Register Nemo's particles");
    }

    private static DefaultParticleType registerParticle(String path, DefaultParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, path), particleType);
    }
}
