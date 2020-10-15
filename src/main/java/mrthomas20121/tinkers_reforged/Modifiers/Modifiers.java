package mrthomas20121.tinkers_reforged.modifiers;

import mrthomas20121.biolib.common.ModifierModuleBase;
import mrthomas20121.tinkers_reforged.config.ConfigModule;
import net.minecraftforge.fml.common.Loader;

public class Modifiers {

    public static ModifierModuleBase moduleModAA = null;
    public static ModifierModuleBase moduleModNaturesAura = null;
    public static ModifierModuleBase moduleModBop = null;
    public static ModifierModuleBase moduleModDarkUtils = null;
    public static ModifierModuleBase moduleModEnvTech = null;

    public static void init() {
        if(Loader.isModLoaded("actuallyadditions") && ConfigModule.actuallyadditions)
        {
            moduleModAA = new ModuleModAA();
            moduleModAA.init();
        }
        if(Loader.isModLoaded("naturesaura") && ConfigModule.naturesaura)
        {
            moduleModNaturesAura = new ModuleModNaturesAura();
            moduleModNaturesAura.init();
        }
        if(Loader.isModLoaded("biomesoplenty") && ConfigModule.biomesoplenty)
        {
            moduleModBop = new ModuleModBop();
            moduleModBop.init();
        }
        if(Loader.isModLoaded("darkutils") && ConfigModule.darkutils)
        {
            moduleModDarkUtils = new ModuleModDarkUtils();
            moduleModDarkUtils.init();
        }
        if(Loader.isModLoaded("environmentaltech") && ConfigModule.environmentaltech)
        {
            moduleModEnvTech = new ModuleModEnvTech();
            moduleModEnvTech.init();

        }
    }
}
