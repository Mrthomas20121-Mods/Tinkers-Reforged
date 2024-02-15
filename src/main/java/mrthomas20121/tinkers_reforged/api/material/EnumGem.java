package mrthomas20121.tinkers_reforged.api.material;

import mrthomas20121.tinkers_reforged.util.EnumData;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public enum EnumGem implements EnumData {
    EPIDOTE(EnumFluid.EPIDOTE),
    HUREAULITE(EnumFluid.HUREAULITE),
    RED_BERYL(EnumFluid.RED_BERYL);

    public final EnumFluid fluid;

    EnumGem(EnumFluid fluid) {
        this.fluid = fluid;
    }

    public TagKey<Block> getBlockTag() {
        return BlockTags.NEEDS_DIAMOND_TOOL;
    }

    public enum ItemType implements EnumData {
        GEM,
        DUST,
        PLATE;
    }
}
