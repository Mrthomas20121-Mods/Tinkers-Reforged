package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.Resources;
import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.stream.Collectors;

public class ReforgedBlocksLoot extends BlockLootTables {

    @Nonnull
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getValues().stream()
                .filter((block) -> TinkersReforged.MOD_ID.equals(Objects.requireNonNull(block.getRegistryName()).getNamespace()))
                .collect(Collectors.toList());
    }

    @Override
    protected void addTables() {
        this.dropSelf(Resources.aluminum_ore.get());
        this.dropSelf(Resources.aluminum_block.get());
        this.dropSelf(Resources.duralumin_block.get());
        this.dropSelf(Resources.electrical_copper_block.get());
        this.dropSelf(Resources.lavium_block.get());
        this.dropSelf(Resources.qivium_block.get());
    }
}
