package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.trait.aluminum.TraitMetalic;
import mrthomas20121.tinkers_reforged.trait.aluminum.TraitProtectiveLayer;
import mrthomas20121.tinkers_reforged.trait.electrical_copper.*;
import mrthomas20121.tinkers_reforged.trait.duralumin.*;
import mrthomas20121.tinkers_reforged.trait.lavium.*;
import mrthomas20121.tinkers_reforged.trait.qivium.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import slimeknights.tconstruct.library.modifiers.Modifier;

public class Traits {

    public static DeferredRegister<Modifier> MODIFIERS = DeferredRegister.create(Modifier.class, TinkersReforged.MOD_ID);

    public static RegistryObject<Modifier> qivium_fireplace = MODIFIERS.register("fireplace", TraitFireplace::new);
    public static RegistryObject<Modifier> qivium_firestarter = MODIFIERS.register("firestarter", TraitFirestarter::new);
    public static RegistryObject<Modifier> qivium_sunfire_blessing = MODIFIERS.register("sunfire_blessing", TraitSunfireBlessing::new);

    public static RegistryObject<Modifier> lavium_ground_speed = MODIFIERS.register("ground_speed", TraitGroundSpeed::new);
    public static RegistryObject<Modifier> lavium_surface_curse = MODIFIERS.register("surface_curse", TraitLavSurfaceCurse::new);
    public static RegistryObject<Modifier> lavium_miner_blessing = MODIFIERS.register("miner_blessing", TraitMinerBlessing::new);

    public static RegistryObject<Modifier> electrical_copper_electrostatic = MODIFIERS.register("electrostatic", TraitElectrostatic::new);
    public static RegistryObject<Modifier> electrical_copper_odin_blessing = MODIFIERS.register("odin_blessing", TraitOdinBlessing::new);
    public static RegistryObject<Modifier> electrical_copper_electric_damage = MODIFIERS.register("electric_damage", TraitElectricDamage::new);

    public static RegistryObject<Modifier> duralumin_ultra_durable = MODIFIERS.register("ultra_durable", TraitUltraDurable::new);
    public static RegistryObject<Modifier> duralumin_overused = MODIFIERS.register("overused", TraitOverused::new);
    public static RegistryObject<Modifier> duralumin_heat_transfer = MODIFIERS.register("heat_transfer", TraitHeatTransfer::new);

    public static RegistryObject<Modifier> aluminum_protective_layer = MODIFIERS.register("protective_layer", TraitProtectiveLayer::new);
    public static RegistryObject<Modifier> aluminum_metalic = MODIFIERS.register("metalic", TraitMetalic::new);
}
