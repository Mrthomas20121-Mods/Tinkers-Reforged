package com.mrthomas20121.tinkers_reforged.Traits;

import com.mrthomas20121.libs.RegistryLib;

public class Traits {

    public static final TraitEnder ender = new TraitEnder();
    public static final TraitEnderfestation enderfestation = new TraitEnderfestation();
    public static final TraitSignal signal = new TraitSignal();
    public static final TraitBright light = new TraitBright();
    public static final TraitAstral astral = new TraitAstral();
    public static final TraitAuraInfusion AURA_INFUSION = new TraitAuraInfusion();
    public static final TraitRadioactive radioactive = new TraitRadioactive();
    public static final TraitNuclearWaste nuclearwaste = new TraitNuclearWaste();
    public static final TraitLifeSteal life_steal = new TraitLifeSteal();
    public static final TraitPyromancy pyromancy = new TraitPyromancy();
    public static final TraitRefined refined = new TraitRefined();
    public static final TraitFlux flux = new TraitFlux();
    public static final TraitStarShaped starshaped = new TraitStarShaped();
    public static final TraitVoid void_trait = new TraitVoid();
    public static final TraitStarryNight starry_night = new TraitStarryNight();

    public static void preInit() {
        RegistryLib.registerTrait(ender);
        RegistryLib.registerTrait(enderfestation);
        RegistryLib.registerTrait(signal);
        RegistryLib.registerTrait(light);
        RegistryLib.registerTrait(astral);
        RegistryLib.registerTrait(AURA_INFUSION);
        RegistryLib.registerTrait(radioactive);
        RegistryLib.registerTrait(nuclearwaste);
        RegistryLib.registerTrait(life_steal);
        RegistryLib.registerTrait(pyromancy);
        RegistryLib.registerTrait(refined);
        RegistryLib.registerTrait(flux);
        RegistryLib.registerTrait(starshaped);
        RegistryLib.registerTrait(void_trait);
        RegistryLib.registerTrait(starry_night);
    }
}
