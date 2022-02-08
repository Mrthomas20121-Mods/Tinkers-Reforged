package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.init.Resources;
import net.minecraft.data.loot.BlockLootTables;

public class ReforgedBlocksLoot extends BlockLootTables {

    @Override
    protected void addTables() {
        this.dropSelf(Resources.aluminum_block.get());
        this.dropSelf(Resources.duralumin_block.get());
        this.dropSelf(Resources.electrical_copper_block.get());
        this.dropSelf(Resources.lavium_block.get());
        this.dropSelf(Resources.qivium_block.get());
    }
}
