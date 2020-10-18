package mrthomas20121.tinkers_reforged.modifiers;

import mrthomas20121.biolib.common.ModifierModuleBase;
import mrthomas20121.tinkers_reforged.modules.Modules;

public class Modifiers {

    public static ModifierModuleBase moduleModAA = null;
    public static ModifierModuleBase moduleModNaturesAura = null;
    public static ModifierModuleBase moduleModBop = null;
    public static ModifierModuleBase moduleModDarkUtils = null;
    public static ModifierModuleBase moduleModEnvTech = null;

    public static void init() {
        if(Modules.isLoaded("actuallyadditions"))
        {
            moduleModAA = new ModuleModAA();
            moduleModAA.init();
        }
        if(Modules.isLoaded("naturesaura"))
        {
            moduleModNaturesAura = new ModuleModNaturesAura();
            moduleModNaturesAura.init();
        }
        if(Modules.isLoaded("biomesoplenty"))
        {
            moduleModBop = new ModuleModBop();
            moduleModBop.init();
        }
        if(Modules.isLoaded("darkutils"))
        {
            moduleModDarkUtils = new ModuleModDarkUtils();
            moduleModDarkUtils.init();
        }
        if(Modules.isLoaded("environmentaltech"))
        {
            moduleModEnvTech = new ModuleModEnvTech();
            moduleModEnvTech.init();

        }
    }
}
