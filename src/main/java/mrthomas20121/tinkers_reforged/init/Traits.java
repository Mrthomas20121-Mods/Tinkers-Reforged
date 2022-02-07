package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.trait.TraitFireplace;
import mrthomas20121.tinkers_reforged.trait.TraitFirestarter;
import mrthomas20121.tinkers_reforged.trait.TraitSunfireBlessing;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import slimeknights.tconstruct.library.modifiers.Modifier;

public class Traits {

    public static DeferredRegister<Modifier> MODIFIERS = DeferredRegister.create(Modifier.class, TinkersReforged.MOD_ID);

    public static RegistryObject<Modifier> qivium_fireplace = MODIFIERS.register("fireplace", TraitFireplace::new);
    public static RegistryObject<Modifier> qivium_firestarter = MODIFIERS.register("firestarter", TraitFirestarter::new);
    public static RegistryObject<Modifier> qivium_sunfire_blessing = MODIFIERS.register("sunfire_blessing", TraitSunfireBlessing::new);
}
