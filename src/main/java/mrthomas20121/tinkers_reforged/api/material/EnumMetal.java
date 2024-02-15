package mrthomas20121.tinkers_reforged.api.material;

import mrthomas20121.tinkers_reforged.datagen.ReforgedBlocksLoot;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedFluids;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedTags;
import mrthomas20121.tinkers_reforged.util.EnumData;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.shared.block.PlatformBlock;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public enum EnumMetal implements EnumData {
    ALUMINUM(true, BlockTags.NEEDS_STONE_TOOL, BlockTags.NEEDS_IRON_TOOL, TinkerFluids.moltenAluminum),
    BLAZIUM(Tags.Blocks.NEEDS_NETHERITE_TOOL, EnumFluid.BLAZIUM),
    BOMIN(Tags.Blocks.NEEDS_NETHERITE_TOOL, EnumFluid.BOMIN),
    DURALUMIN(BlockTags.NEEDS_DIAMOND_TOOL, EnumFluid.DURALUMIN),
    DURASTEEL(Tags.Blocks.NEEDS_NETHERITE_TOOL, EnumFluid.DURASTEEL),
    ELECTRIC_COPPER(BlockTags.NEEDS_DIAMOND_TOOL, EnumFluid.ELECTRICAL_COPPER),
    ETRYX(Tags.Blocks.NEEDS_NETHERITE_TOOL, EnumFluid.ETRYX),
    FEROBOLT(BlockTags.NEEDS_DIAMOND_TOOL, EnumFluid.FEROBOLT),
    GALLIUM(true, BlockTags.NEEDS_DIAMOND_TOOL, Tags.Blocks.NEEDS_NETHERITE_TOOL, EnumFluid.GALLIUM),
    HORNIUM(BlockTags.NEEDS_DIAMOND_TOOL, EnumFluid.HORNIUM),
    KEPU(true, Tags.Blocks.NEEDS_NETHERITE_TOOL, TinkersReforgedTags.Blocks.NEED_KEPU_TOOLS, EnumFluid.KEPU),
    LAVIUM(Tags.Blocks.NEEDS_NETHERITE_TOOL, EnumFluid.LAVIUM),
    MOSITE(Tags.Blocks.NEEDS_NETHERITE_TOOL, EnumFluid.MOSITE),
    QIVIUM(Tags.Blocks.NEEDS_NETHERITE_TOOL, EnumFluid.QIVIUM),
    TIBERIUM(TinkersReforgedTags.Blocks.NEED_KEPU_TOOLS, EnumFluid.TIBERIUM),
    TITANIUM(true, Tags.Blocks.NEEDS_NETHERITE_TOOL, TinkersReforgedTags.Blocks.NEED_KEPU_TOOLS, EnumFluid.TITANIUM);

    private final boolean isOre;

    private final TagKey<Block> blockTag;
    private final TagKey<Block> oreMiningTag;

    public final FluidObject<ForgeFlowingFluid> fluid;

    EnumMetal(boolean isOre, TagKey<Block> blockTag, TagKey<Block> oreMiningTag, EnumFluid enumFluid) {
        this(isOre, blockTag, oreMiningTag, TinkersReforgedFluids.ALL_FLUIDS.get(enumFluid));
    }

    EnumMetal(boolean isOre, TagKey<Block> blockTag, TagKey<Block> oreMiningTag, FluidObject<ForgeFlowingFluid> fluid) {
        this.isOre = isOre;
        this.blockTag = blockTag;
        this.oreMiningTag = oreMiningTag;
        this.fluid = fluid;
    }

    EnumMetal(TagKey<Block> blockTag, EnumFluid fluid) {
        this(true, blockTag, blockTag, fluid);
    }

    EnumMetal(TagKey<Block> blockTag, FluidObject<ForgeFlowingFluid> fluid) {
        this(true, blockTag, blockTag, fluid);
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
