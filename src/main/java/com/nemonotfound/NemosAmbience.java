package com.nemonotfound;

import com.nemonotfound.nemosambience.client.particle.ModParticles;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NemosAmbience implements ModInitializer {

    public static final String MOD_ID = "nemos-ambience";
    public static final Logger log = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        log.info("Thanks for using Nemo's Ambience!");
        ModParticles.registerParticles();
    }
}