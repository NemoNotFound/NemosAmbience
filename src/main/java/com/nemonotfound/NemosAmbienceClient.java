package com.nemonotfound;

import com.nemonotfound.nemosambience.client.particle.LeavesParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.FabricSpriteProvider;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.particle.DefaultParticleType;

import static com.nemonotfound.nemosambience.client.particle.ModParticles.*;

public class NemosAmbienceClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerParticle(OAK_LEAVES_Particle);
        registerParticle(DARK_OAK_LEAVES_Particle);
        registerParticle(BIRCH_LEAVES_Particle);
        registerParticle(SPRUCE_LEAVES_Particle);
        registerParticle(JUNGLE_LEAVES_Particle);
        registerParticle(MANGROVE_LEAVES_Particle);
        registerParticle(ACACIA_LEAVES_Particle);
    }

    private void registerParticle(DefaultParticleType particleType) {
        ParticleFactoryRegistry.getInstance()
                .register(particleType, (FabricSpriteProvider spriteProvider) ->
                        (parameters, world, x, y, z, velocityX, velocityY, velocityZ) ->
                                new LeavesParticle(world, x, y, z, spriteProvider));
    }
}
