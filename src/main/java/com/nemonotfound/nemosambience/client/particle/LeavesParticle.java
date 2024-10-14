package com.nemonotfound.nemosambience.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.BlockPos;

@Environment(value=EnvType.CLIENT)
public class LeavesParticle
extends SpriteBillboardParticle {

    private float rotSpeed;
    private final float particleRandom;
    private final float spinAcceleration;

    public LeavesParticle(ClientWorld world, double x, double y, double z, SpriteProvider spriteProvider) {
        super(world, x, y, z);
        float f;
        this.setSprite(spriteProvider.getSprite(this.random.nextInt(12), 12));
        this.rotSpeed = (float)Math.toRadians(this.random.nextBoolean() ? -30.0 : 30.0);
        this.particleRandom = this.random.nextFloat();
        this.spinAcceleration = (float)Math.toRadians(this.random.nextBoolean() ? -5.0 : 5.0);
        this.maxAge = 300;
        this.gravityStrength = 7.5E-4f;
        this.scale = f = this.random.nextBoolean() ? 0.05f : 0.075f;
        this.setBoundingBoxSpacing(f, f);
        this.velocityMultiplier = 1.0f;

        setParticleColor(world);
    }

    private void setParticleColor(ClientWorld world) {
        int color = getFoliageColor(world);

        float red = ((color >> 16) & 0xFF) / 255.0f;
        float green = ((color >> 8) & 0xFF) / 255.0f;
        float blue = (color & 0xFF) / 255.0f;

        this.setColor(red, green, blue);
    }

    private int getFoliageColor(ClientWorld world) {
        if (world == null) {
            return FoliageColors.getDefaultColor();
        }

        BlockPos pos = BlockPos.ofFloored(x, y, z);
        Block leavesBlock = world.getBlockState(pos.up()).getBlock();
        String leavesName = Registries.BLOCK.getId(leavesBlock).getPath();

        if (leavesName.equals("birch_leaves")) {
            return FoliageColors.getBirchColor();
        } else if (leavesName.equals("spruce_leaves")) {
            return FoliageColors.getSpruceColor();
        }

        return BiomeColors.getFoliageColor(world, pos);
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        if (this.maxAge-- <= 0) {
            this.markDead();
        }
        if (this.dead) {
            return;
        }
        float f = 300 - this.maxAge;
        float g = Math.min(f / 300.0f, 1.0f);
        double d = Math.cos(Math.toRadians(this.particleRandom * 60.0f)) * 2.0 * Math.pow(g, 1.25);
        double e = Math.sin(Math.toRadians(this.particleRandom * 60.0f)) * 2.0 * Math.pow(g, 1.25);
        this.velocityX += d * (double)0.0025f;
        this.velocityZ += e * (double)0.0025f;
        this.velocityY -= this.gravityStrength;
        this.rotSpeed += this.spinAcceleration / 20.0f;
        this.prevAngle = this.angle;
        this.angle += this.rotSpeed / 20.0f;
        this.move(this.velocityX, this.velocityY, this.velocityZ);
        if (this.onGround || this.maxAge < 299 && (this.velocityX == 0.0 || this.velocityZ == 0.0)) {
            this.markDead();
        }
        if (this.dead) {
            return;
        }
        this.velocityX *= this.velocityMultiplier;
        this.velocityY *= this.velocityMultiplier;
        this.velocityZ *= this.velocityMultiplier;
    }
}

