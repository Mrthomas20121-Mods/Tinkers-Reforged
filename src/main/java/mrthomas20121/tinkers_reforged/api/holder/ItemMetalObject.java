package mrthomas20121.tinkers_reforged.api.holder;

import mrthomas20121.tinkers_reforged.api.tags.MetalTagData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import slimeknights.mantle.registration.object.ItemObject;

import java.util.Objects;
import java.util.function.Supplier;

public class ItemMetalObject extends ItemObject<Item> {

    private final Supplier<? extends Item> nugget;
    private final Supplier<? extends Item> dust;
    private final Supplier<? extends Item> plate;
    private final Supplier<? extends Item> gear;

    public ItemMetalObject(ResourceLocation name, ItemObject<Item> ingot, ItemObject<Item> nugget, ItemObject<Item> dust, ItemObject<Item> plate, ItemObject<Item> gear) {
        super(ingot);
        this.nugget = nugget;
        this.dust = dust;
        this.plate = plate;
        this.gear = gear;
    }

    public Item getIngot() {
        return this.get();
    }

    public Item getNugget() {
        return Objects.requireNonNull(nugget.get(), "ItemMetalObject is missing nugget item");
    }

    public Item getDust() {
        return Objects.requireNonNull(dust.get(), "ItemMetalObject is missing dust item");
    }

    public Item getPlate() {
        return Objects.requireNonNull(plate.get(), "ItemMetalObject is missing plate item");
    }

    public Item getGear() {
        return Objects.requireNonNull(gear.get(), "ItemMetalObject is missing gear item");
    }
}
