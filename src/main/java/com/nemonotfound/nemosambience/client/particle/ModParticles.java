package com.nemonotfound.nemosambience.client.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemosambience.NemosAmbience.MOD_ID;
import static com.nemonotfound.nemosambience.NemosAmbience.log;

public class ModParticles {

    public static final DefaultParticleType FALLING_LEAVES_PARTICLE = registerParticle("falling_leaves", FabricParticleTypes.simple());
    public static final DefaultParticleType PALE_OAK_FALLING_LEAVES_PARTICLE = registerParticle("pale_oak_falling_leaves", FabricParticleTypes.simple());

    public static void registerParticles() {
        log.info("Register Nemo's particles");
    }

    private static DefaultParticleType registerParticle(String path, DefaultParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, path), particleType);
    }
}
