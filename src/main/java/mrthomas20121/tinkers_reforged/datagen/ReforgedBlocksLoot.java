package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedBlocks;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedItems;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.stream.Collectors;

public class ReforgedBlocksLoot extends BlockLoot {

    @Nonnull
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getValues().stream()
                .filter((block) -> TinkersReforged.MOD_ID.equals(Objects.requireNonNull(block.getRegistryName()).getNamespace()))
                .collect(Collectors.toList());
    }

    @Override
    protected void addTables() {
        this.dropOther(TinkersReforgedBlocks.aluminum_ore.get(), TinkersReforgedItems.raw_aluminum.get());
        this.dropOther(TinkersReforgedBlocks.deepslate_aluminum_ore.get(), TinkersReforgedItems.raw_aluminum.get());
        this.dropSelf(TinkersReforgedBlocks.aluminum_block.get());
        this.dropSelf(TinkersReforgedBlocks.duralumin_block.get());
        this.dropSelf(TinkersReforgedBlocks.electrical_copper_block.get());
        this.dropSelf(TinkersReforgedBlocks.lavium_block.get());
        this.dropSelf(TinkersReforgedBlocks.qivium_block.get());
        this.dropSelf(TinkersReforgedBlocks.gausum_block.get());
        this.dropSelf(TinkersReforgedBlocks.felsteel_block.get());
        this.dropOther(TinkersReforgedBlocks.kepu_ore.get(), TinkersReforgedItems.raw_kepu.get());
        this.dropSelf(TinkersReforgedBlocks.kepu_block.get());
        this.dropSelf(TinkersReforgedBlocks.chorus_metal_block.get());
        this.dropSelf(TinkersReforgedBlocks.raw_aluminum_block.get());
        this.dropSelf(TinkersReforgedBlocks.raw_kepu_block.get());
        this.dropSelf(TinkersReforgedBlocks.durasteel_block.get());
        this.dropSelf(TinkersReforgedBlocks.crusteel_block.get());
        this.dropSelf(TinkersReforgedBlocks.wavy_block.get());
        this.dropSelf(TinkersReforgedBlocks.yokel_block.get());
    }
}
