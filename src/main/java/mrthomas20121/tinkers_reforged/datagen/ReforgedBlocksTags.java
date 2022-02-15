package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.Resources;
import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.common.TinkerTags;

import javax.annotation.Nullable;

public class ReforgedBlocksTags extends BlockTagsProvider {

    private static final ITag.INamedTag<Block> ALUMINUM_ORE = BlockTags.bind("forge:ores/aluminum");

    private static final ITag.INamedTag<Block> DURALUMIN = BlockTags.bind("forge:storage_blocks/duralumin");
    private static final ITag.INamedTag<Block> ALUMINUM = BlockTags.bind("forge:storage_blocks/aluminum");
    private static final ITag.INamedTag<Block> ELECTRICAL_COPPER = BlockTags.bind("forge:storage_blocks/electrical_copper");
    private static final ITag.INamedTag<Block> LAVIUM = BlockTags.bind("forge:storage_blocks/lavium");
    private static final ITag.INamedTag<Block> QIVIUM = BlockTags.bind("forge:storage_blocks/qivium");
    private static final ITag.INamedTag<Block> GAUSUM = BlockTags.bind("forge:storage_blocks/gausum");

    public ReforgedBlocksTags(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, TinkersReforged.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(DURALUMIN).add(Resources.duralumin_block.get());
        tag(ALUMINUM).add(Resources.aluminum_block.get());
        tag(ELECTRICAL_COPPER).add(Resources.electrical_copper_block.get());
        tag(LAVIUM).add(Resources.lavium_block.get());
        tag(QIVIUM).add(Resources.qivium_block.get());
        tag(GAUSUM).add(Resources.gausum_block.get());

        tag(ALUMINUM_ORE).add(Resources.aluminum_ore.get());
        tag(Tags.Blocks.ORES).add(Resources.aluminum_ore.get());

        tag(Tags.Blocks.STORAGE_BLOCKS)
                .add(Resources.duralumin_block.get())
                .add(Resources.aluminum_block.get())
                .add(Resources.electrical_copper_block.get())
                .add(Resources.lavium_block.get())
                .add(Resources.qivium_block.get())
                .add(Resources.gausum_block.get());

        tag(BlockTags.BEACON_BASE_BLOCKS)
                .add(Resources.duralumin_block.get())
                .add(Resources.aluminum_block.get())
                .add(Resources.electrical_copper_block.get())
                .add(Resources.lavium_block.get())
                .add(Resources.qivium_block.get())
                .add(Resources.gausum_block.get());

        tag(TinkerTags.Blocks.ANVIL_METAL)
                .add(Resources.duralumin_block.get())
                .add(Resources.aluminum_block.get())
                .add(Resources.electrical_copper_block.get())
                .add(Resources.lavium_block.get())
                .add(Resources.qivium_block.get())
                .add(Resources.gausum_block.get());
    }
}
