package mrthomas20121.tinkers_reforged.Traits;

import mrthomas20121.biolib.common.MaterialBuilder;

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
    public static final TraitVillagerLove villager_love = new TraitVillagerLove(1);
    public static final TraitVillagerLove villager_love_2 = new TraitVillagerLove(2);
    public static final TraitRose rose = new TraitRose();
    public static final TraitCarbon carbon = new TraitCarbon();
    public static final TraitCurse curse = new TraitCurse();

    public static void preInit() {
        MaterialBuilder.registerTrait(ender);
        MaterialBuilder.registerTrait(enderfestation);
        MaterialBuilder.registerTrait(signal);
        MaterialBuilder.registerTrait(light);
        MaterialBuilder.registerTrait(astral);
        MaterialBuilder.registerTrait(AURA_INFUSION);
        MaterialBuilder.registerTrait(radioactive);
        MaterialBuilder.registerTrait(nuclearwaste);
        MaterialBuilder.registerTrait(life_steal);
        MaterialBuilder.registerTrait(pyromancy);
        MaterialBuilder.registerTrait(refined);
        MaterialBuilder.registerTrait(flux);
        MaterialBuilder.registerTrait(starshaped);
        MaterialBuilder.registerTrait(void_trait);
        MaterialBuilder.registerTrait(starry_night);
        MaterialBuilder.registerTrait(villager_love);
        MaterialBuilder.registerTrait(rose);
        MaterialBuilder.registerTrait(carbon);
        MaterialBuilder.registerTrait(curse);
    }
}
