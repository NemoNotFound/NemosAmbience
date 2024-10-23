package com.nemonotfound.nemosambience;

import com.nemonotfound.nemosambience.client.particle.LeavesParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.FabricSpriteProvider;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.particle.SimpleParticleType;

import static com.nemonotfound.nemosambience.client.particle.ModParticles.*;

public class NemosAmbienceClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerParticle(FALLING_LEAVES_PARTICLE);
        registerParticle(PALE_OAK_FALLING_LEAVES_PARTICLE);
    }

    private void registerParticle(SimpleParticleType particleType) {
        ParticleFactoryRegistry.getInstance()
                .register(particleType, (FabricSpriteProvider spriteProvider) ->
                        (parameters, world, x, y, z, velocityX, velocityY, velocityZ) ->
                                new LeavesParticle(world, x, y, z, spriteProvider));
    }
}
