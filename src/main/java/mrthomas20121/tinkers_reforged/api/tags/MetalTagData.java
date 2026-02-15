package mrthomas20121.tinkers_reforged.api.tags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class MetalTagData extends TagData {

    private final TagKey<Item> ingotTag;
    private final TagKey<Item> nuggetTag;
    private final TagKey<Item> dustTag;
    private final TagKey<Item> plateTag;
    private final TagKey<Item> gearTag;
    private TagKey<Item> oreBlockItem;
    private TagKey<Item> rawItemTag;
    private final TagKey<Block> blockTag;
    private final TagKey<Item> blockItemTag;
    private TagKey<Block> rawBlockTag;
    private TagKey<Item> rawBlockItemTag;
    private TagKey<Block> oreBlock;

    public MetalTagData(ResourceLocation name, boolean isOre) {
        super(name);
        this.ingotTag = makeItemTag("ingots");
        this.nuggetTag = makeItemTag("nuggets");
        this.dustTag = makeItemTag("dusts");
        this.plateTag = makeItemTag("plates");
        this.gearTag = makeItemTag("gears");

        if(isOre) {
            this.rawItemTag = makeItemTag("raw_materials");
            this.rawBlockItemTag = makeExtraItemTag("storage_blocks/raw_");
            this.rawBlockTag = makeExtraBlockTag("storage_blocks/raw_");
            this.oreBlockItem = makeItemTag("ores");
            this.oreBlock = makeBlockTag("ores");
        }

        this.blockTag = makeBlockTag("storage_blocks");
        this.blockItemTag = makeItemTag("storage_blocks");
    }

    @Nullable
    public TagKey<Item> getRawBlockItemTag() {
        return rawBlockItemTag;
    }

    @Nullable
    public TagKey<Item> getRawItemTag() {
        return rawItemTag;
    }

    @Nullable
    public TagKey<Block> getRawBlockTag() {
        return rawBlockTag;
    }

    @Nullable
    public TagKey<Block> getOreBlock() {
        return oreBlock;
    }

    @Nullable
    public TagKey<Item> getOreBlockItem() {
        return oreBlockItem;
    }

    public TagKey<Item> getBlockItemTag() {
        return blockItemTag;
    }

    public TagKey<Item> getIngotTag() {
        return ingotTag;
    }

    public TagKey<Item> getNuggetTag() {
        return nuggetTag;
    }

    public TagKey<Item> getDustTag() {
        return dustTag;
    }

    public TagKey<Item> getPlateTag() {
        return plateTag;
    }

    public TagKey<Item> getGearTag() {
        return gearTag;
    }

    public TagKey<Block> getBlockTag() {
        return blockTag;
    }
}
