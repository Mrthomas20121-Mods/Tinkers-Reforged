package mrthomas20121.tinkers_reforged.Modifiers;

import net.minecraftforge.fml.common.Loader;

public class Modifiers {

    public static ModuleModAA moduleModAA = new ModuleModAA();

    public static void init() {
        if(Loader.isModLoaded("actuallyadditions"))
        {
            moduleModAA.init();
        }
    }
}
