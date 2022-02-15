package mrthomas20121.tinkers_reforged.api;

import mrthomas20121.tinkers_reforged.init.Resources;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nullable;

/**
 * WIP Metal class. plan to replace Resources Blocks/items/fluid registrer with an instance of this.
 */
public class Metal {

    private ReforgedFluid fluid;
    private RegistryObject<Block> ore = null;
    private RegistryObject<Block> block = null;
    private RegistryObject<Item> ingot = null;
    private RegistryObject<Item> dust = null;
    private RegistryObject<Item> nugget = null;
    private final String name;

    public Metal(String name, int temp, int light, boolean ore, boolean fluid) {
        if(fluid) {
            this.fluid = ReforgedFluid.register(String.format("molten_%s", name), temp, light);
        }
        this.name = name;
        registerResources(ore);
    }

    public Metal(String name, int temp, boolean ore, boolean fluid) {
        this(name, temp, 0, ore, fluid);
    }

    public Metal(String name, boolean ore) {
        this(name, 0, 0, ore, false);
    }

    public void registerResources(boolean ore) {
        if(ore) {
            registerBlock(String.format("%s_ore", this.name), ore);
        }
        registerBlock(String.format("%s_block", this.name), ore);
        ingot = registerItem(String.format("%s_ingot", this.name));
        dust = registerItem(String.format("%s_dust", this.name));
        nugget = registerItem(String.format("%s_nugget", this.name));
    }

    public RegistryObject<Item> registerItem(String name) {
        return Resources.ITEMS.register(name, Resources::registerItem);
    }

    public void registerBlock(String name, boolean ore) {
        RegistryObject<Block> block = Resources.BLOCKS.register(name, ore? Resources::registerOreBlock: Resources::registerMetalBlock);
        Resources.ITEMS.register(name, () -> Resources.registerItemBlock(block.get()));
        if(ore) {
            this.ore = block;
        }
        else {
            this.block = block;
        }
    }

    @Nullable
    public RegistryObject<Block> getOre() {
        return ore;
    }

    public RegistryObject<Block> getBlock() {
        return block;
    }

    public RegistryObject<Item> getIngot() {
        return ingot;
    }

    public RegistryObject<Item> getDust() {
        return dust;
    }

    public RegistryObject<Item> getNugget() {
        return nugget;
    }

    @Nullable
    public ReforgedFluid getFluid() {
        return fluid;
    }

    public Fluid getStill() {
        return this.fluid.getStill();
    }

    public Fluid getFlowing() {
        return this.fluid.getStill();
    }
}
