package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedBlocks;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedItems;
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

import static mrthomas20121.tinkers_reforged.init.TinkersReforgedTags.Blocks.*;

public class ReforgedBlocksTags extends BlockTagsProvider {

    private static TagKey<Block> create(String name) {
        return BlockTags.create(new ResourceLocation(name));
    }

    public ReforgedBlocksTags(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, TinkersReforged.MOD_ID, existingFileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags() {

        tag(ROCK_TYPE_BLOCKS).addTags(Tags.Blocks.STONE, Tags.Blocks.END_STONES, Tags.Blocks.NETHERRACK);

        tag(RAW_ALUMINUM).add(TinkersReforgedBlocks.raw_aluminum_block.get());
        tag(RAW_KEPU).add(TinkersReforgedBlocks.raw_kepu_block.get());

        tag(Tags.Blocks.ORES).add(
                TinkersReforgedBlocks.aluminum_ore.get(),
                TinkersReforgedBlocks.kepu_ore.get(),
                TinkersReforgedBlocks.deepslate_aluminum_ore.get(),
                TinkersReforgedBlocks.deepslate_epidote_ore.get(),
                TinkersReforgedBlocks.deepslate_hureaulite_ore.get(),
                TinkersReforgedBlocks.red_beryl_ore.get(),
                TinkersReforgedBlocks.deepslate_red_beryl_ore.get()
        );

        tag(BLAZING_COPPER).add(TinkersReforgedBlocks.blazing_copper_block.get());
        tag(DURALUMIN).add(TinkersReforgedBlocks.duralumin_block.get());
        tag(ALUMINUM).add(TinkersReforgedBlocks.aluminum_block.get());
        tag(ELECTRICAL_COPPER).add(TinkersReforgedBlocks.electrical_copper_block.get());
        tag(LAVIUM).add(TinkersReforgedBlocks.lavium_block.get());
        tag(QIVIUM).add(TinkersReforgedBlocks.qivium_block.get());
        tag(GAUSUM).add(TinkersReforgedBlocks.gausum_block.get());
        tag(FELSTEEL).add(TinkersReforgedBlocks.felsteel_block.get());
        tag(KEPU).add(TinkersReforgedBlocks.kepu_block.get());
        tag(CHORUS_METAl).add(TinkersReforgedBlocks.chorus_metal_block.get());
        tag(DURASTEEL).add(TinkersReforgedBlocks.durasteel_block.get());
        tag(CRUSTEEL).add(TinkersReforgedBlocks.crusteel_block.get());
        tag(WAVY).add(TinkersReforgedBlocks.wavy_block.get());
        tag(YOKEL).add(TinkersReforgedBlocks.yokel_block.get());
        tag(BAOLIAN).add(TinkersReforgedBlocks.baolian_block.get());
        tag(EPIDOTE).add(TinkersReforgedBlocks.epidote_block.get());
        tag(GALU).add(TinkersReforgedBlocks.galu_block.get());
        tag(HUREAULITE).add(TinkersReforgedBlocks.hureaulite_block.get());
        tag(RED_BERYL).add(TinkersReforgedBlocks.red_beryl_block.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(
                        TinkersReforgedBlocks.kepu_ore.get(),
                        TinkersReforgedBlocks.kepu_block.get(),
                        TinkersReforgedBlocks.raw_kepu_block.get(),
                        TinkersReforgedBlocks.deepslate_epidote_ore.get(),
                        TinkersReforgedBlocks.deepslate_hureaulite_ore.get(),
                        TinkersReforgedBlocks.red_beryl_ore.get(),
                        TinkersReforgedBlocks.deepslate_red_beryl_ore.get(),
                        TinkersReforgedBlocks.blazing_copper_block.get()
                );
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(
                        TinkersReforgedBlocks.aluminum_ore.get(),
                        TinkersReforgedBlocks.raw_aluminum_block.get(),
                        TinkersReforgedBlocks.deepslate_aluminum_ore.get(),
                        TinkersReforgedBlocks.kepu_block.get(),
                        TinkersReforgedBlocks.raw_aluminum_block.get(),
                        TinkersReforgedBlocks.raw_kepu_block.get(),
                        TinkersReforgedBlocks.duralumin_block.get(),
                        TinkersReforgedBlocks.aluminum_block.get(),
                        TinkersReforgedBlocks.electrical_copper_block.get(),
                        TinkersReforgedBlocks.lavium_block.get(),
                        TinkersReforgedBlocks.qivium_block.get(),
                        TinkersReforgedBlocks.gausum_block.get(),
                        TinkersReforgedBlocks.felsteel_block.get(),
                        TinkersReforgedBlocks.chorus_metal_block.get(),
                        TinkersReforgedBlocks.durasteel_block.get(),
                        TinkersReforgedBlocks.crusteel_block.get(),
                        TinkersReforgedBlocks.wavy_block.get(),
                        TinkersReforgedBlocks.yokel_block.get(),
                        TinkersReforgedBlocks.baolian_block.get(),
                        TinkersReforgedBlocks.epidote_block.get(),
                        TinkersReforgedBlocks.galu_block.get(),
                        TinkersReforgedBlocks.hureaulite_block.get(),
                        TinkersReforgedBlocks.red_beryl_block.get()
                );

        tag(ALUMINUM_ORE).add(TinkersReforgedBlocks.aluminum_ore.get(), TinkersReforgedBlocks.deepslate_aluminum_ore.get());
        tag(KEPU_ORE).add(TinkersReforgedBlocks.kepu_ore.get());
        tag(EPIDOTE_ORE).add(TinkersReforgedBlocks.deepslate_epidote_ore.get());
        tag(HUREAULITE_ORE).add(TinkersReforgedBlocks.deepslate_hureaulite_ore.get());
        tag(RED_BERYL_ORE).add(TinkersReforgedBlocks.red_beryl_ore.get(), TinkersReforgedBlocks.deepslate_red_beryl_ore.get());
        tag(Tags.Blocks.ORES)
                .add(
                        TinkersReforgedBlocks.aluminum_ore.get(),
                        TinkersReforgedBlocks.deepslate_aluminum_ore.get(),
                        TinkersReforgedBlocks.kepu_ore.get(),
                        TinkersReforgedBlocks.deepslate_epidote_ore.get(),
                        TinkersReforgedBlocks.deepslate_hureaulite_ore.get(),
                        TinkersReforgedBlocks.red_beryl_ore.get(),
                        TinkersReforgedBlocks.deepslate_red_beryl_ore.get()
                );

        tag(Tags.Blocks.STORAGE_BLOCKS)
                .add(
                        TinkersReforgedBlocks.kepu_block.get(),
                        TinkersReforgedBlocks.raw_aluminum_block.get(),
                        TinkersReforgedBlocks.raw_kepu_block.get(),
                        TinkersReforgedBlocks.duralumin_block.get(),
                        TinkersReforgedBlocks.aluminum_block.get(),
                        TinkersReforgedBlocks.electrical_copper_block.get(),
                        TinkersReforgedBlocks.lavium_block.get(),
                        TinkersReforgedBlocks.qivium_block.get(),
                        TinkersReforgedBlocks.gausum_block.get(),
                        TinkersReforgedBlocks.felsteel_block.get(),
                        TinkersReforgedBlocks.chorus_metal_block.get(),
                        TinkersReforgedBlocks.durasteel_block.get(),
                        TinkersReforgedBlocks.crusteel_block.get(),
                        TinkersReforgedBlocks.wavy_block.get(),
                        TinkersReforgedBlocks.yokel_block.get(),
                        TinkersReforgedBlocks.baolian_block.get(),
                        TinkersReforgedBlocks.epidote_block.get(),
                        TinkersReforgedBlocks.galu_block.get(),
                        TinkersReforgedBlocks.hureaulite_block.get(),
                        TinkersReforgedBlocks.red_beryl_block.get()
                );

        tag(BlockTags.BEACON_BASE_BLOCKS)
                .add(
                        TinkersReforgedBlocks.kepu_block.get(),
                        TinkersReforgedBlocks.duralumin_block.get(),
                        TinkersReforgedBlocks.aluminum_block.get(),
                        TinkersReforgedBlocks.electrical_copper_block.get(),
                        TinkersReforgedBlocks.lavium_block.get(),
                        TinkersReforgedBlocks.qivium_block.get(),
                        TinkersReforgedBlocks.gausum_block.get(),
                        TinkersReforgedBlocks.felsteel_block.get(),
                        TinkersReforgedBlocks.chorus_metal_block.get(),
                        TinkersReforgedBlocks.durasteel_block.get(),
                        TinkersReforgedBlocks.crusteel_block.get(),
                        TinkersReforgedBlocks.wavy_block.get(),
                        TinkersReforgedBlocks.yokel_block.get(),
                        TinkersReforgedBlocks.baolian_block.get(),
                        TinkersReforgedBlocks.epidote_block.get(),
                        TinkersReforgedBlocks.galu_block.get(),
                        TinkersReforgedBlocks.hureaulite_block.get(),
                        TinkersReforgedBlocks.red_beryl_block.get()
                );

        tag(TinkerTags.Blocks.ANVIL_METAL)
                .add(
                        TinkersReforgedBlocks.kepu_block.get(),
                        TinkersReforgedBlocks.duralumin_block.get(),
                        TinkersReforgedBlocks.aluminum_block.get(),
                        TinkersReforgedBlocks.electrical_copper_block.get(),
                        TinkersReforgedBlocks.lavium_block.get(),
                        TinkersReforgedBlocks.qivium_block.get(),
                        TinkersReforgedBlocks.gausum_block.get(),
                        TinkersReforgedBlocks.felsteel_block.get(),
                        TinkersReforgedBlocks.chorus_metal_block.get(),
                        TinkersReforgedBlocks.durasteel_block.get(),
                        TinkersReforgedBlocks.crusteel_block.get(),
                        TinkersReforgedBlocks.wavy_block.get(),
                        TinkersReforgedBlocks.yokel_block.get(),
                        TinkersReforgedBlocks.baolian_block.get(),
                        TinkersReforgedBlocks.epidote_block.get(),
                        TinkersReforgedBlocks.galu_block.get(),
                        TinkersReforgedBlocks.hureaulite_block.get(),
                        TinkersReforgedBlocks.red_beryl_block.get()
                );

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        TinkersReforgedBlocks.aluminum_ore.get(),
                        TinkersReforgedBlocks.deepslate_aluminum_ore.get(),
                        TinkersReforgedBlocks.raw_aluminum_block.get(),
                        TinkersReforgedBlocks.raw_kepu_block.get(),
                        TinkersReforgedBlocks.kepu_block.get(),
                        TinkersReforgedBlocks.duralumin_block.get(),
                        TinkersReforgedBlocks.aluminum_block.get(),
                        TinkersReforgedBlocks.electrical_copper_block.get(),
                        TinkersReforgedBlocks.lavium_block.get(),
                        TinkersReforgedBlocks.qivium_block.get(),
                        TinkersReforgedBlocks.gausum_block.get(),
                        TinkersReforgedBlocks.felsteel_block.get(),
                        TinkersReforgedBlocks.chorus_metal_block.get(),
                        TinkersReforgedBlocks.durasteel_block.get(),
                        TinkersReforgedBlocks.crusteel_block.get(),
                        TinkersReforgedBlocks.wavy_block.get(),
                        TinkersReforgedBlocks.yokel_block.get(),
                        TinkersReforgedBlocks.baolian_block.get(),
                        TinkersReforgedBlocks.epidote_block.get(),
                        TinkersReforgedBlocks.deepslate_epidote_ore.get(),
                        TinkersReforgedBlocks.galu_block.get(),
                        TinkersReforgedBlocks.hureaulite_block.get(),
                        TinkersReforgedBlocks.deepslate_hureaulite_ore.get(),
                        TinkersReforgedBlocks.red_beryl_block.get(),
                        TinkersReforgedBlocks.red_beryl_ore.get(),
                        TinkersReforgedBlocks.deepslate_red_beryl_ore.get()
                );
    }
}
