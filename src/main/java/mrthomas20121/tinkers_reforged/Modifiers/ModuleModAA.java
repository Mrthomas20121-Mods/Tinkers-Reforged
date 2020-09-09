package mrthomas20121.tinkers_reforged.Modifiers;

import de.ellpeck.actuallyadditions.mod.items.InitItems;
import mrthomas20121.biolib.common.ModifierModuleBase;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ModuleModAA implements ModifierModuleBase {

    private EnderStarMod enderStarMod = new EnderStarMod();
    private LensOfTheKillerMod lensOfTheKillerMod = new LensOfTheKillerMod();
    private LensMinerMod lensMinerMod = new LensMinerMod();

    @Override
    public void init() {
        enderStarMod.addItem(new ItemStack(InitItems.itemMisc, 1, 19), 1, 1);
        lensOfTheKillerMod.addItem(new ItemStack(InitItems.itemMoreDamageLens), 1, 1);
        lensMinerMod.addItem(new ItemStack(InitItems.itemMiningLens), 1, 1);

        TinkersReforged.proxy.registerModifierModel(enderStarMod,
                new ResourceLocation(TinkersReforged.MODID, "models/item/modifiers/" + enderStarMod.getIdentifier()));
    }

    public EnderStarMod getEnderStarMod() {
        return enderStarMod;
    }

    public LensOfTheKillerMod getLensOfTheKillerMod() {
        return lensOfTheKillerMod;
    }

    public LensMinerMod getLensMinerMod() {
        return lensMinerMod;
    }
}
