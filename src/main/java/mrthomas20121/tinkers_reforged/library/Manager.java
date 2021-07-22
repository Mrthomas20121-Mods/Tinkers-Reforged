package mrthomas20121.tinkers_reforged.library;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.library.block.ReforgedBlockGlass;
import mrthomas20121.tinkers_reforged.library.block.ReforgedItemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.commons.lang3.StringUtils;
import slimeknights.tconstruct.library.modifiers.Modifier;

import javax.annotation.Nonnull;
import java.util.LinkedList;
import java.util.List;

public class Manager extends IManager<ModuleBase> {

    private final List<String> alloys = new LinkedList<>();
    private final List<Item> items = new LinkedList<>();
    private final List<Block> blocks = new LinkedList<>();
    private final List<Modifier> modifiers = new LinkedList<>();

    public CreativeTabs tab = new CreativeTabs(TinkersReforged.MODID) {
        @Nonnull
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ForgeUtils.getItem(TinkersReforged.MODID, "lavium_ingot"));
        }
    };

    public Manager() {
        super(new ResourceLocation(TinkersReforged.MODID, "manager"));
    }

    @Override
    public void add(ModuleBase module) {
        if(isLoaded(module)) {
            this.value.add(module);
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public List<Modifier> getModifiers() {
        return modifiers;
    }

    @Override
    public boolean isLoaded(ModuleBase module) {
        return Loader.isModLoaded(module.getRegistryName().getNamespace()) && module.canLoad();
    }

    @Override
    public ModuleBase get(int i) {
        return this.value.get(i);
    }

    @Override
    public void earlyPreInit() {
        this.value.forEach(IModule::earlyPreInit);
        this.value.forEach(module -> module.registerAlloys(alloys));
    }

    @Override
    public void preInit() {
        this.value.forEach(IModule::preInit);
    }

    @Override
    public void init() {
        this.value.forEach(IModule::init);
        this.value.forEach(moduleBase -> moduleBase.registerModifiers(modifiers));
        alloys.forEach(alloy -> {
            OreDictionary.registerOre("ingot"+cap(alloy), ForgeUtils.getItem(TinkersReforged.MODID, alloy+"_"+"ingot"));
            OreDictionary.registerOre("dust"+cap(alloy), ForgeUtils.getItem(TinkersReforged.MODID, alloy+"_"+"dust"));
            OreDictionary.registerOre("plate"+cap(alloy), ForgeUtils.getItem(TinkersReforged.MODID, alloy+"_"+"plate"));
            OreDictionary.registerOre("gear"+cap(alloy), ForgeUtils.getItem(TinkersReforged.MODID, alloy+"_"+"gear"));
            OreDictionary.registerOre("block"+cap(alloy), ForgeUtils.getBlock(TinkersReforged.MODID, alloy+"_"+"block"));
        });
    }

    @Override
    public void postInit() {
        this.value.forEach(IModule::postInit);
    }

    @Override
    public void registerRecipes(IForgeRegistry<IRecipe> r) {
        this.value.forEach(module -> module.registerRecipes(r));
    }

    @Override
    public void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> r = event.getRegistry();
        alloys.forEach(alloy -> {
            register(r, new Item(), alloy+"_ingot");
            register(r, new Item(), alloy+"_dust");
            register(r, new Item(), alloy+"_plate");
            register(r, new Item(), alloy+"_gear");
        });

        blocks.forEach(block -> r.register(new ReforgedItemBlock(block)));
    }

    @Override
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> r = event.getRegistry();
        alloys.forEach(alloy -> register(r, new Block(Material.IRON), alloy+"_block"));
        register(r, new ReforgedBlockGlass(), "kovar_glass");
    }

    private void register(IForgeRegistry<Block> r, Block block, String name) {
        block.setRegistryName(TinkersReforged.MODID, name);
        block.setTranslationKey(TinkersReforged.MODID+"."+name);
        block.setCreativeTab(tab);
        r.register(block);
        blocks.add(block);
    }

    private void register(IForgeRegistry<Item> r, Item item, String name) {
        item.setRegistryName(TinkersReforged.MODID, name);
        item.setTranslationKey(TinkersReforged.MODID+"."+name);
        item.setCreativeTab(tab);
        r.register(item);
        items.add(item);
    }

    private String cap(String str)
    {
        String[] array = str.split("_");
        StringBuilder s = new StringBuilder();
        for(String string: array)
        {
            s.append(StringUtils.capitalize(string));
        }
        return s.toString();
    }
}
