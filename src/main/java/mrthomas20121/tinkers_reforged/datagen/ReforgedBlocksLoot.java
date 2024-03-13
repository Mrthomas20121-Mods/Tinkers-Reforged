package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.block.EndOreBlock;
import mrthomas20121.tinkers_reforged.block.OverworldOreBlock;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedBlocks;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedItems;
import mrthomas20121.tinkers_reforged.api.material.EnumGem;
import mrthomas20121.tinkers_reforged.api.material.EnumMetal;
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
                .filter((block) -> TinkersReforged.MOD_ID.equals(Objects.requireNonNull(block.getRegistryName()).getNamespace())).toList();
    }

    @Override
    protected void addTables() {

        for(EnumMetal metal: EnumMetal.values()) {
            for(EnumMetal.BlockType blockType: EnumMetal.BlockType.values()) {
                blockType.getLoot().apply(this, TinkersReforgedBlocks.METAL_BLOCKS.get(metal).get(blockType).get());
            }
            if(metal.isThisOre()) {
                this.dropSelf(TinkersReforgedBlocks.RAW_ORES.get(metal).get());
                this.add(TinkersReforgedBlocks.ORES.get(metal).ore().get(), (block) -> createOreDrop(block, TinkersReforgedItems.RAW_ORES.get(metal).get()));
                if(metal.isThisOverworldOre()) {
                    this.add(((OverworldOreBlock) TinkersReforgedBlocks.ORES.get(metal)).deepslateOre().get(), (block) -> createOreDrop(block, TinkersReforgedItems.RAW_ORES.get(metal).get()));
                }
            }
        }

        for(EnumGem gem: EnumGem.values()) {
            this.dropSelf(TinkersReforgedBlocks.GEMS_BLOCKS.get(gem).get());
            this.add(TinkersReforgedBlocks.GEM_ORES.get(gem).ore().get(), (block) -> createOreDrop(block, TinkersReforgedItems.GEMS.get(gem).get(EnumGem.ItemType.GEM).get()));
            this.add(TinkersReforgedBlocks.GEM_ORES.get(gem).deepslateOre().get(), (block) -> createOreDrop(block, TinkersReforgedItems.GEMS.get(gem).get(EnumGem.ItemType.GEM).get()));
        }
    }
}
