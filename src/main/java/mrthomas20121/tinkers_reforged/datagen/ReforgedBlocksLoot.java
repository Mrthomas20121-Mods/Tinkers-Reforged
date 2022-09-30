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
        this.add(TinkersReforgedBlocks.aluminum_ore.get(), (block) -> createOreDrop(block, TinkersReforgedItems.raw_aluminum.get()));
        this.add(TinkersReforgedBlocks.deepslate_aluminum_ore.get(), (block) -> createOreDrop(block, TinkersReforgedItems.raw_aluminum.get()));
        this.dropSelf(TinkersReforgedBlocks.aluminum_block.get());
        this.dropSelf(TinkersReforgedBlocks.blazing_copper_block.get());
        this.dropSelf(TinkersReforgedBlocks.duralumin_block.get());
        this.dropSelf(TinkersReforgedBlocks.electrical_copper_block.get());
        this.dropSelf(TinkersReforgedBlocks.lavium_block.get());
        this.dropSelf(TinkersReforgedBlocks.qivium_block.get());
        this.dropSelf(TinkersReforgedBlocks.gausum_block.get());
        this.dropSelf(TinkersReforgedBlocks.felsteel_block.get());
        this.add(TinkersReforgedBlocks.kepu_ore.get(), (block) -> createOreDrop(block, TinkersReforgedItems.raw_kepu.get()));
        this.dropSelf(TinkersReforgedBlocks.kepu_block.get());
        this.dropSelf(TinkersReforgedBlocks.chorus_metal_block.get());
        this.dropSelf(TinkersReforgedBlocks.raw_aluminum_block.get());
        this.dropSelf(TinkersReforgedBlocks.raw_kepu_block.get());
        this.dropSelf(TinkersReforgedBlocks.durasteel_block.get());
        this.dropSelf(TinkersReforgedBlocks.crusteel_block.get());
        this.dropSelf(TinkersReforgedBlocks.wavy_block.get());
        this.dropSelf(TinkersReforgedBlocks.yokel_block.get());
        this.dropSelf(TinkersReforgedBlocks.baolian_block.get());
        this.dropSelf(TinkersReforgedBlocks.epidote_block.get());
        this.add(TinkersReforgedBlocks.deepslate_epidote_ore.get(), (block) -> createOreDrop(block, TinkersReforgedItems.epidote_gem.get()));
        this.dropSelf(TinkersReforgedBlocks.galu_block.get());
        this.dropSelf(TinkersReforgedBlocks.magma_steel_block.get());
        this.dropSelf(TinkersReforgedBlocks.cyber_steel_block.get());
        this.dropSelf(TinkersReforgedBlocks.hureaulite_block.get());
        this.add(TinkersReforgedBlocks.deepslate_hureaulite_ore.get(), (block) -> createOreDrop(block, TinkersReforgedItems.hureaulite_gem.get()));
        this.dropSelf(TinkersReforgedBlocks.red_beryl_block.get());
        this.add(TinkersReforgedBlocks.red_beryl_ore.get(), (block) -> createOreDrop(block, TinkersReforgedItems.red_beryl_gem.get()));
        this.add(TinkersReforgedBlocks.deepslate_red_beryl_ore.get(), (block) -> createOreDrop(block, TinkersReforgedItems.red_beryl_gem.get()));
    }
}
