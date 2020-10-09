package mrthomas20121.tinkers_reforged.modifiers;

import mrthomas20121.tinkers_reforged.config.ConfigModule;
import net.minecraftforge.fml.common.Loader;

public class Modifiers {

    public static ModuleModAA moduleModAA = null;
    public static ModuleModNaturesAura moduleModNaturesAura = null;
    public static ModuleModBop moduleModBop = null;
    public static ModuleModDarkUtils moduleModDarkUtils = null;

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
        if(Loader.isModLoaded("darkutils"))
        {
            moduleModDarkUtils = new ModuleModDarkUtils();
            moduleModDarkUtils.init();
        }
    }
}
