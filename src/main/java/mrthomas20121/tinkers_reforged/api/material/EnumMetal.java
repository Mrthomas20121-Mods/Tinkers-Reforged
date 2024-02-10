package mrthomas20121.tinkers_reforged.api.material;

import mrthomas20121.tinkers_reforged.datagen.ReforgedBlocksLoot;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedTags;
import mrthomas20121.tinkers_reforged.util.EnumData;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.Tags;
import slimeknights.tconstruct.shared.block.PlatformBlock;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public enum EnumMetal implements EnumData {
    ALUMINUM(true, BlockTags.NEEDS_STONE_TOOL, BlockTags.NEEDS_IRON_TOOL),
    BLAZIUM(Tags.Blocks.NEEDS_NETHERITE_TOOL),
    BOMIN(Tags.Blocks.NEEDS_NETHERITE_TOOL),
    DURALUMIN(BlockTags.NEEDS_DIAMOND_TOOL),
    DURASTEEL(Tags.Blocks.NEEDS_NETHERITE_TOOL),
    ELECTRIC_COPPER(BlockTags.NEEDS_DIAMOND_TOOL),
    ETRYX(Tags.Blocks.NEEDS_NETHERITE_TOOL),
    FEROBOLT(BlockTags.NEEDS_DIAMOND_TOOL),
    GALLIUM(true, BlockTags.NEEDS_DIAMOND_TOOL, Tags.Blocks.NEEDS_NETHERITE_TOOL),
    HOSIUM(BlockTags.NEEDS_DIAMOND_TOOL),
    KEPU(true, Tags.Blocks.NEEDS_NETHERITE_TOOL, TinkersReforgedTags.Blocks.NEED_KEPU_TOOLS),
    LAVIUM(Tags.Blocks.NEEDS_NETHERITE_TOOL),
    MOSITE(Tags.Blocks.NEEDS_NETHERITE_TOOL),
    QIVIUM(Tags.Blocks.NEEDS_NETHERITE_TOOL),
    TIBERIUM(TinkersReforgedTags.Blocks.NEED_KEPU_TOOLS),
    TITANIUM(true, Tags.Blocks.NEEDS_NETHERITE_TOOL, TinkersReforgedTags.Blocks.NEED_KEPU_TOOLS);

    private final boolean isOre;

    private final TagKey<Block> blockTag;
    private final TagKey<Block> oreMiningTag;

    EnumMetal(boolean isOre, TagKey<Block> blockTag, TagKey<Block> oreMiningTag) {
        this.isOre = isOre;
        this.blockTag = blockTag;
        this.oreMiningTag = oreMiningTag;
    }

    EnumMetal(TagKey<Block> blockTag) {
        this(true, blockTag, blockTag);
    }

    public boolean isThisOre() {
        return isOre;
    }

    public TagKey<Block> getBlockTag() {
        return this.blockTag;
    }

    public TagKey<Block> getOreMiningTag() {
        return this.oreMiningTag;
    }

    public enum BlockType implements EnumData {
        BLOCK(() -> new Block(BlockBehaviour.Properties.of(Material.METAL))),
        PLATFORM(() -> new PlatformBlock(BlockBehaviour.Properties.of(Material.METAL)));

        private final Supplier<Block> consumer;

        private final BiFunction<ReforgedBlocksLoot, Block, String> loot;

        BlockType(Supplier<Block> consumer) {
            this(consumer, (loot, block) -> {
                loot.dropSelf(block);
                return "";
            });
        }

        BlockType(Supplier<Block> consumer, BiFunction<ReforgedBlocksLoot, Block, String> loot) {
            this.consumer = consumer;
            this.loot = loot;
        }

        public Supplier<Block> getBlock() {
            return this.consumer;
        }

        public BiFunction<ReforgedBlocksLoot, Block, String> getLoot() {
            return loot;
        }
    }

    public enum ItemType implements EnumData {
        INGOT,
        NUGGET,
        DUST,
        PLATE
    }
}
