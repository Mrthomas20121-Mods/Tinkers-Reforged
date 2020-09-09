package mrthomas20121.tinkers_reforged.Modifiers;

import net.minecraftforge.fml.common.Loader;

public class Modifiers {

    public static ModuleModAA moduleModAA = null;
    public static ModuleModNaturesAura moduleModNaturesAura = null;

    public static void init() {
        if(Loader.isModLoaded("actuallyadditions"))
        {
            moduleModAA = new ModuleModAA();
            moduleModAA.init();
        }
        if(Loader.isModLoaded("naturesaura"))
        {
            moduleModNaturesAura = new ModuleModNaturesAura();
            moduleModNaturesAura.init();
        }
    }
}
