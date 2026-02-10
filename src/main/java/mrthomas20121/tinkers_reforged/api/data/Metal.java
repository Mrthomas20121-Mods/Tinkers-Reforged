package mrthomas20121.tinkers_reforged.api.data;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.tags.MetalTagData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public enum Metal implements StringRepresentable {
    GRAPHITE(),
    YTTRIUM(true),
    BARIUM(true),
    ASTATINE(),
    TELLURIUM(),
    GERMANIUM(),
    BERKELIUM(),
    ACTINIUM(),
    THALLIUM(true);

    public static final Metal[] values = Metal.values();

    private final MetalTagData metalTags;

    private final String serializedName = this.name().toLowerCase(Locale.ROOT);
    private final boolean isOre;

    Metal(boolean isOre) {
        this.metalTags = new MetalTagData(new ResourceLocation(TinkersReforged.MOD_ID, this.serializedName));
        this.isOre = isOre;
    }

    Metal() {
        this(false);
    }

    public boolean isOre() {
        return isOre;
    }

    public MetalTagData getTags() {
        return metalTags;
    }

    public TagKey<Item> getIngotTag() {
        return this.metalTags.getIngotTag();
    }

    public TagKey<Item> getNuggetTag() {
        return this.metalTags.getNuggetTag();
    }

    public TagKey<Item> getDustTag() {
        return this.metalTags.getDustTag();
    }

    public TagKey<Item> getPlateTag() {
        return this.metalTags.getPlateTag();
    }

    public TagKey<Item> getGearTag() {
        return this.metalTags.getGearTag();
    }

    public TagKey<Block> getBlockTag() {
        return this.metalTags.getBlockTag();
    }

    @Override
    public @NotNull String getSerializedName() {
        return this.serializedName;
    }
}
