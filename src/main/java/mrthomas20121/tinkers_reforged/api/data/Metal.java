package mrthomas20121.tinkers_reforged.api.data;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.tags.MetalTagData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.materials.definition.MaterialId;

import java.util.Arrays;
import java.util.Locale;

public enum Metal implements StringRepresentable {
    SLIMEBRONZE(750, MapColor.TERRACOTTA_GREEN),
    GRAPHITE(500, MapColor.COLOR_BLACK),
    YTTRIUM(true, 855, MapColor.COLOR_RED),
    ASTATINE(935, MapColor.TERRACOTTA_ORANGE),
    BARIUM(true, 1450, MapColor.TERRACOTTA_PURPLE),
    TELLURIUM(2000, MapColor.TERRACOTTA_RED),
    ACTINIUM(2000, MapColor.TERRACOTTA_GRAY),
    THALLIUM(true, 2500, MapColor.TERRACOTTA_CYAN),
    GERMANIUM(3000, MapColor.TERRACOTTA_PINK),
    BERKELIUM(2500, MapColor.COLOR_LIGHT_GREEN);

    public static final Metal[] values = Metal.values();

    public static final MaterialId[] TRIM_MATERIALS = Arrays.stream(values).map(Metal::asMaterial).toList().toArray(new MaterialId[] {});

    private final MetalTagData metalTags;

    private final String serializedName = this.name().toLowerCase(Locale.ROOT);
    private final boolean isOre;
    private final int temperature;
    private final MapColor mapColor;
    private final MaterialId id;

    Metal(boolean isOre, int temp, MapColor mapColor) {
        this.metalTags = new MetalTagData(new ResourceLocation(TinkersReforged.MOD_ID, this.serializedName), isOre);
        this.isOre = isOre;
        this.temperature = temp;
        this.mapColor = mapColor;
        this.id = new MaterialId(TinkersReforged.MOD_ID, this.serializedName);
    }

    Metal(int temperature, MapColor mapColor) {
        this(false, temperature, mapColor);
    }

    public MaterialId asMaterial() {
        return this.id;
    }

    public boolean isOre() {
        return isOre;
    }

    public int getTemperature() {
        return temperature;
    }

    public MapColor getMapColor() {
        return mapColor;
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

    public TagKey<Item> getBlockItemTag() {
        return this.metalTags.getBlockItemTag();
    }

    @Nullable
    public TagKey<Item> getRawItemTag() {
        return this.metalTags.getRawItemTag();
    }

    @Nullable
    public TagKey<Item> getRawBlockItemTag() {
        return this.metalTags.getRawBlockItemTag();
    }

    @Nullable
    public TagKey<Block> getRawBlockTag() {
        return this.metalTags.getRawBlockTag();
    }

    @Nullable
    public TagKey<Block> getOreBlock() {
        return this.metalTags.getOreBlock();
    }

    @Nullable
    public TagKey<Item> getOreBlockItem() {
        return this.metalTags.getOreBlockItem();
    }

    @Override
    public @NotNull String getSerializedName() {
        return this.serializedName;
    }
}
