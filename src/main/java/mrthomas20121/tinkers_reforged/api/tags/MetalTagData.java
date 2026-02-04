package mrthomas20121.tinkers_reforged.api.tags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class MetalTagData extends TagData {

    private final TagKey<Item> ingotTag;
    private final TagKey<Item> nuggetTag;
    private final TagKey<Item> dustTag;
    private final TagKey<Item> plateTag;
    private final TagKey<Item> gearTag;
    private final TagKey<Block> blockTag;

    public MetalTagData(ResourceLocation name) {
        super(name);
        this.ingotTag = makeItemTag("ingots");
        this.nuggetTag = makeItemTag("nuggets");
        this.dustTag = makeItemTag("dusts");
        this.plateTag = makeItemTag("plates");
        this.gearTag = makeItemTag("gears");
        this.blockTag = makeBlockTag("storage_blocks");
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
