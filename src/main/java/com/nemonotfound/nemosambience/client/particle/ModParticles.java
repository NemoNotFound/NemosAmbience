package com.nemonotfound.nemosambience.client.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemosambience.NemosAmbience.MOD_ID;
import static com.nemonotfound.nemosambience.NemosAmbience.log;

public class ModParticles {

    public static final SimpleParticleType OAK_LEAVES_Particle = registerParticle("oak_leaves", FabricParticleTypes.simple());
    public static final SimpleParticleType DARK_OAK_LEAVES_Particle = registerParticle("dark_oak_leaves", FabricParticleTypes.simple());
    public static final SimpleParticleType BIRCH_LEAVES_Particle = registerParticle("birch_leaves", FabricParticleTypes.simple());
    public static final SimpleParticleType SPRUCE_LEAVES_Particle = registerParticle("spruce_leaves", FabricParticleTypes.simple());
    public static final SimpleParticleType JUNGLE_LEAVES_Particle = registerParticle("jungle_leaves", FabricParticleTypes.simple());
    public static final SimpleParticleType MANGROVE_LEAVES_Particle = registerParticle("mangrove_leaves", FabricParticleTypes.simple());
    public static final SimpleParticleType ACACIA_LEAVES_Particle = registerParticle("acacia_leaves", FabricParticleTypes.simple());

    public static void registerParticles() {
        log.info("Register Nemo's particles");
    }

    private static SimpleParticleType registerParticle(String path, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MOD_ID, path), particleType);
    }
}
