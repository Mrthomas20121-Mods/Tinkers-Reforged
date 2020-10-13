package mrthomas20121.tinkers_reforged.modifiers;

import de.ellpeck.actuallyadditions.mod.items.InitItems;
import mrthomas20121.biolib.common.ModifierModuleBase;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ModuleModAA implements ModifierModuleBase {

    private ModEnderStar modEnderStar = new ModEnderStar();
    private ModLensKiller modLensKiller = new ModLensKiller();
    private ModLensMiner modLensMiner = new ModLensMiner();

    @Override
    public void init() {
        modEnderStar.addItem(new ItemStack(InitItems.itemMisc, 1, 19), 1, 1);
        modLensKiller.addItem(new ItemStack(InitItems.itemMoreDamageLens), 1, 1);
        modLensMiner.addItem(new ItemStack(InitItems.itemMiningLens), 1, 1);

        TinkersReforged.proxy.registerModifierModel(modEnderStar,
                new ResourceLocation(TinkersReforged.MODID, "models/item/modifiers/" + modEnderStar.getIdentifier()));

        TinkersReforged.proxy.registerModifierModel(modLensKiller,
                new ResourceLocation(TinkersReforged.MODID, "models/item/modifiers/" + modLensKiller.getIdentifier()));
    }

    public ModEnderStar getModEnderStar() {
        return modEnderStar;
    }

    public ModLensKiller getModLensKiller() {
        return modLensKiller;
    }

    public ModLensMiner getModLensMiner() {
        return modLensMiner;
    }
}
