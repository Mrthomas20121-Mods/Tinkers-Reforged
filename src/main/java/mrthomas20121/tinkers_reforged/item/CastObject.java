package mrthomas20121.tinkers_reforged.item;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class CastObject {

    private final ResourceLocation name;
    private final TagKey<Item> singleUseTag;
    private final TagKey<Item> multiUseTag;

    public CastObject(String name) {
        this.name = new ResourceLocation(name);
        this.singleUseTag = makeTag("single_use");
        this.multiUseTag = makeTag("multi_use");
    }

    protected TagKey<Item> makeTag(String type) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(name.getNamespace(), "casts/" + type + "/" + name.getPath()));
    }

    public ResourceLocation getName() {
        return name;
    }

    public TagKey<Item> getMultiUseTag() {
        return multiUseTag;
    }

    public TagKey<Item> getSingleUseTag() {
        return singleUseTag;
    }
}
