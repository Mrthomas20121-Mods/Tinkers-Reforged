package mrthomas20121.tinkers_reforged.api.material;

import mrthomas20121.tinkers_reforged.util.EnumData;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public enum EnumGem implements EnumData {
    EPIDOTE,
    HUREAULITE,
    RED_BERYL;

    public TagKey<Block> getBlockTag() {
        return BlockTags.NEEDS_DIAMOND_TOOL;
    }

    public enum ItemType implements EnumData {
        GEM,
        DUST,
        PLATE;
    }
}
