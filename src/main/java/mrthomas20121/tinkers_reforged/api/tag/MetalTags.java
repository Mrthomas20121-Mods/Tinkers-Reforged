package mrthomas20121.tinkers_reforged.api.tag;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.material.EnumMetal;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

/**
 * This code is inspired by  from https://github.com/BluSunrize/ImmersiveEngineering/blob/1.19.2/src/api/java/blusunrize/immersiveengineering/api/IETags.java#L181
 *
 */
public class MetalTags {

    public final TagKey<Item> ingot;
    public final TagKey<Item> nugget;
    @Nullable
    public final TagKey<Item> raw_ore;
    public final TagKey<Item> plate;
    public final TagKey<Item> dust;
    public final TagKey<Block> storage;
    public final TagKey<Item> storageItem;
    public final TagKey<Block> platform;
    public final TagKey<Item> platformItem;
    @Nullable
    public final TagKey<Block> oreBlock;
    @Nullable
    public final TagKey<Item> oreBlockItem;
    @Nullable
    public final TagKey<Block> rawBlock;
    @Nullable
    public final TagKey<Item> rawBlockItem;

    public MetalTags(EnumMetal metal) {
        String name = metal.getName();

        this.ingot = item(ingotMetal(name));
        this.nugget = item(nuggetMetal(name));
        this.plate = item(plateMetal(name));
        this.dust = item(dustMetal(name));
        if(metal.isThisOre()) {
            this.raw_ore = item(raw_metal(name));
            this.rawBlock = block(storageBlock("raw_"+name));
            this.rawBlockItem = item(storageBlock("raw_"+name));
            this.oreBlock = block(oreMetal(name));
            this.oreBlockItem = item((oreMetal(name)));
        }
        else {
            this.raw_ore = null;
            this.rawBlock = null;
            this.rawBlockItem = null;
            this.oreBlock = null;
            this.oreBlockItem = null;
        }

        this.platform = block(modLoc("platforms/"+name));
        this.platformItem = item(modLoc("platforms/"+name));
        this.storage = block(storageBlock(name));
        this.storageItem = item(storageBlock(name));
    }

    private TagKey<Item> item(ResourceLocation loc) {
        return TagKey.create(Registry.ITEM_REGISTRY, loc);
    }

    private TagKey<Block> block(ResourceLocation loc) {
        return TagKey.create(Registry.BLOCK_REGISTRY, loc);
    }

    private ResourceLocation ingotMetal(String name) {
        return forgeLoc("ingots/"+name);
    }

    private ResourceLocation nuggetMetal(String name) {
        return forgeLoc("nuggets/"+name);
    }

    private ResourceLocation plateMetal(String name) {
        return forgeLoc("plates/"+name);
    }

    private ResourceLocation dustMetal(String name) {
        return forgeLoc("dusts/"+name);
    }

    private ResourceLocation raw_metal(String name) {
        return forgeLoc("raw_materials/"+name);
    }

    private ResourceLocation storageBlock(String name) {
        return forgeLoc("storage_blocks/"+name);
    }

    private ResourceLocation oreMetal(String name) {
        return forgeLoc("ores/"+name);
    }

    private ResourceLocation modLoc(String name) {
        return new ResourceLocation(TinkersReforged.MOD_ID, name);
    }

    private ResourceLocation forgeLoc(String name) {
        return new ResourceLocation("forge", name);
    }
}
