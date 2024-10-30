package com.nemonotfound.nemosambience.client.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemosambience.NemosAmbience.MOD_ID;
import static com.nemonotfound.nemosambience.NemosAmbience.log;

public class ModParticles {

    public static final SimpleParticleType FALLING_LEAVES_PARTICLE = registerParticle("falling_leaves", FabricParticleTypes.simple());

    public static void registerParticles() {
        log.info("Registering particles");
    }

    private static SimpleParticleType registerParticle(String path, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MOD_ID, path), particleType);
    }
}
