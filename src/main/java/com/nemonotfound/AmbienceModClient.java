package com.nemonotfound;

import com.nemonotfound.client.particle.OakLeavesParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.FabricSpriteProvider;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;

public class AmbienceModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(AmbienceMod.OAK_LEAVES_Particle, (FabricSpriteProvider spriteProvider) -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ) -> new OakLeavesParticle(world, x, y, z, spriteProvider));
    }
}
