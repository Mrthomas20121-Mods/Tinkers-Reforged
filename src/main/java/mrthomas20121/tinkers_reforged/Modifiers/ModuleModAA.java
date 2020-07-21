package mrthomas20121.tinkers_reforged.Modifiers;

import de.ellpeck.actuallyadditions.mod.items.InitItems;
import mrthomas20121.biolib.common.ModifierModuleBase;
import net.minecraft.item.ItemStack;

public class ModuleModAA implements ModifierModuleBase {

    private EnderStarMod enderStarMod = new EnderStarMod();

    @Override
    public void init() {
        enderStarMod.addItem(new ItemStack(InitItems.itemMisc, 1, 19), 1, 1);
    }

    public EnderStarMod getEnderStarMod() {
        return enderStarMod;
    }
}
