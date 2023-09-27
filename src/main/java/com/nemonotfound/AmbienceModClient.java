package com.nemonotfound;

import com.nemonotfound.client.particle.LeavesParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.FabricSpriteProvider;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;

import static com.nemonotfound.AmbienceMod.*;

public class AmbienceModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(OAK_LEAVES_Particle, (FabricSpriteProvider spriteProvider) -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ) -> new LeavesParticle(world, x, y, z, spriteProvider));
        ParticleFactoryRegistry.getInstance().register(DARK_OAK_LEAVES_Particle, (FabricSpriteProvider spriteProvider) -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ) -> new LeavesParticle(world, x, y, z, spriteProvider));
        ParticleFactoryRegistry.getInstance().register(BIRCH_LEAVES_Particle, (FabricSpriteProvider spriteProvider) -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ) -> new LeavesParticle(world, x, y, z, spriteProvider));
        ParticleFactoryRegistry.getInstance().register(SPRUCE_LEAVES_Particle, (FabricSpriteProvider spriteProvider) -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ) -> new LeavesParticle(world, x, y, z, spriteProvider));
        ParticleFactoryRegistry.getInstance().register(JUNGLE_LEAVES_Particle, (FabricSpriteProvider spriteProvider) -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ) -> new LeavesParticle(world, x, y, z, spriteProvider));
        ParticleFactoryRegistry.getInstance().register(MANGROVE_LEAVES_Particle, (FabricSpriteProvider spriteProvider) -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ) -> new LeavesParticle(world, x, y, z, spriteProvider));
        ParticleFactoryRegistry.getInstance().register(ACACIA_LEAVES_Particle, (FabricSpriteProvider spriteProvider) -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ) -> new LeavesParticle(world, x, y, z, spriteProvider));
    }
}
