package mrthomas20121.tinkers_reforged.data;

import mrthomas20121.tinkers_reforged.api.data.Metal;
import mrthomas20121.tinkers_reforged.api.holder.BlockMetalObject;
import mrthomas20121.tinkers_reforged.api.holder.BlockOreObject;
import mrthomas20121.tinkers_reforged.api.holder.BlockOverworldOreObject;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TinkersReforgedBlockLoot extends BlockLootSubProvider {
    protected TinkersReforgedBlockLoot() {
        super(new HashSet<>(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        for(Metal metal: Metal.values) {
            if(metal.equals(Metal.YTTRIUM)) {
                BlockOverworldOreObject oreObject = TinkersReforgedBlocks.YTTRIUM_ORE;
                add(oreObject.get(), (block) -> createOreDrop(block, oreObject.getRawItem()));
                add(oreObject.getDeepslateOre(), (block) -> createOreDrop(block, oreObject.getRawItem()));
                dropSelf(oreObject.getRawOreBlock());
            }
            else if(metal.equals(Metal.BARIUM)) {
                BlockOreObject oreObject = TinkersReforgedBlocks.BARIUM_ORE;
                add(oreObject.get(), (block) -> createOreDrop(block, oreObject.getRawItem()));
                dropSelf(oreObject.getRawOreBlock());
            }
            else if(metal.equals(Metal.THALLIUM)) {
                BlockOreObject oreObject = TinkersReforgedBlocks.THALLIUM_ORE;

                add(oreObject.get(), (block) -> createOreDrop(block, oreObject.getRawItem()));
                dropSelf(oreObject.getRawOreBlock());
            }

            BlockMetalObject metalObject = TinkersReforgedBlocks.METAl_BLOCKS.get(metal);
            dropSelf(metalObject.get());
            dropSelf(metalObject.getPlatform());
        }
    }

    @Override
    public @NotNull Iterable<Block> getKnownBlocks() {
        List<Block> blocks = new ArrayList<>();

        for(Metal metal: Metal.values) {
            if(metal.equals(Metal.YTTRIUM)) {
                BlockOverworldOreObject oreObject = TinkersReforgedBlocks.YTTRIUM_ORE;
                blocks.add(oreObject.get());
                blocks.add(oreObject.getDeepslateOre());
                blocks.add(oreObject.getRawOreBlock());
            }
            else if(metal.equals(Metal.BARIUM)) {
                BlockOreObject oreObject = TinkersReforgedBlocks.BARIUM_ORE;
                blocks.add(oreObject.get());
                blocks.add(oreObject.getRawOreBlock());
            }
            else if(metal.equals(Metal.THALLIUM)) {
                BlockOreObject oreObject = TinkersReforgedBlocks.THALLIUM_ORE;
                blocks.add(oreObject.get());
                blocks.add(oreObject.getRawOreBlock());
            }

            BlockMetalObject metalObject = TinkersReforgedBlocks.METAl_BLOCKS.get(metal);
            blocks.add(metalObject.get());
            blocks.add(metalObject.getPlatform());
        }

        return blocks;
    }

    public static LootTableProvider create(PackOutput packOutput) {
        return new LootTableProvider(packOutput, new HashSet<>(), List.of(new LootTableProvider.SubProviderEntry(TinkersReforgedBlockLoot::new, LootContextParamSets.BLOCK)));
    }
}
