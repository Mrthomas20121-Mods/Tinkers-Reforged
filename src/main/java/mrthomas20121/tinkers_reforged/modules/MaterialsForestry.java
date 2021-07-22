package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.tinkers_reforged.Reference;
import mrthomas20121.tinkers_reforged.library.MaterialGen;
import mrthomas20121.tinkers_reforged.library.ModuleBase;
import net.minecraft.util.ResourceLocation;

import java.util.List;

public class MaterialsForestry extends ModuleBase {

    private final MaterialGen honey_alloy = new MaterialGen("ref_honey_alloy", 0x0, "HoneyAlloy", 700);
    private final MaterialGen iceys_alloy = new MaterialGen("ref_icey_alloy", 0x0, "IceyAlloy", 700);

    public MaterialsForestry() {
        super(new ResourceLocation(Reference.forestry, "module"));
    }

    @Override
    public boolean canLoad() {
        return false;
    }

    @Override
    public void preInit() {
        honey_alloy.preInit();
    }

    @Override
    public void init() {

        honey_alloy.init();
    }

    @Override
    public void registerAlloys(List<String> alloys) {
        alloys.add("honey_alloy");
        alloys.add("icey_alloy");
    }
}
