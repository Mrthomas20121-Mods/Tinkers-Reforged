package mrthomas20121.tinkers_reforged.modifiers;

import mrthomas20121.biolib.common.ModifierModuleBase;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.util.ResourceLocation;

public class ModuleModEnvTech implements ModifierModuleBase {

    private ModDigging digging = new ModDigging();

    public ModDigging getDigging() {
        return digging;
    }

    @Override
    public void init() {
        digging.addItem("blockLitherite");
        digging.addItem("blockErodium");
        digging.addItem("blockKyronite");
        digging.addItem("blockPladium");
        digging.addItem("blockIonite");

        TinkersReforged.proxy.registerModifierModel(digging,
                new ResourceLocation(TinkersReforged.MODID, "models/item/modifiers/" + digging.getIdentifier()));
    }
}
