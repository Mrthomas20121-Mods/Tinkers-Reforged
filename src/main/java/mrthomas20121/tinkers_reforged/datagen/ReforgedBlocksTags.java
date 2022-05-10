package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.Resources;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.common.TinkerTags;

import javax.annotation.Nullable;

public class ReforgedBlocksTags extends BlockTagsProvider {

    private static final TagKey<Block> ALUMINUM_ORE = create("forge:ores/aluminum");

    private static final TagKey<Block> DURALUMIN = create("forge:storage_blocks/duralumin");
    private static final TagKey<Block> ALUMINUM = create("forge:storage_blocks/aluminum");
    private static final TagKey<Block> ELECTRICAL_COPPER = create("forge:storage_blocks/electrical_copper");
    private static final TagKey<Block> LAVIUM = create("forge:storage_blocks/lavium");
    private static final TagKey<Block> QIVIUM = create("forge:storage_blocks/qivium");
    private static final TagKey<Block> GAUSUM = create("forge:storage_blocks/gausum");

    private static TagKey<Block> create(String name) {
        return BlockTags.create(new ResourceLocation(name));
    }

    public ReforgedBlocksTags(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, TinkersReforged.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(DURALUMIN).add(TinkersReforgedBlocks.duralumin_block.get());
        tag(ALUMINUM).add(TinkersReforgedBlocks.aluminum_block.get());
        tag(ELECTRICAL_COPPER).add(TinkersReforgedBlocks.electrical_copper_block.get());
        tag(LAVIUM).add(TinkersReforgedBlocks.lavium_block.get());
        tag(QIVIUM).add(TinkersReforgedBlocks.qivium_block.get());
        tag(GAUSUM).add(TinkersReforgedBlocks.gausum_block.get());

        tag(ALUMINUM_ORE).add(TinkersReforgedBlocks.aluminum_ore.get());
        tag(Tags.Blocks.ORES).add(TinkersReforgedBlocks.aluminum_ore.get());

        tag(Tags.Blocks.STORAGE_BLOCKS)
                .add(TinkersReforgedBlocks.duralumin_block.get())
                .add(TinkersReforgedBlocks.aluminum_block.get())
                .add(TinkersReforgedBlocks.electrical_copper_block.get())
                .add(TinkersReforgedBlocks.lavium_block.get())
                .add(TinkersReforgedBlocks.qivium_block.get())
                .add(TinkersReforgedBlocks.gausum_block.get());

        tag(BlockTags.BEACON_BASE_BLOCKS)
                .add(TinkersReforgedBlocks.duralumin_block.get())
                .add(TinkersReforgedBlocks.aluminum_block.get())
                .add(TinkersReforgedBlocks.electrical_copper_block.get())
                .add(TinkersReforgedBlocks.lavium_block.get())
                .add(TinkersReforgedBlocks.qivium_block.get())
                .add(TinkersReforgedBlocks.gausum_block.get());

        tag(TinkerTags.Blocks.ANVIL_METAL)
                .add(TinkersReforgedBlocks.duralumin_block.get())
                .add(TinkersReforgedBlocks.aluminum_block.get())
                .add(TinkersReforgedBlocks.electrical_copper_block.get())
                .add(TinkersReforgedBlocks.lavium_block.get())
                .add(TinkersReforgedBlocks.qivium_block.get())
                .add(TinkersReforgedBlocks.gausum_block.get());
    }
}
