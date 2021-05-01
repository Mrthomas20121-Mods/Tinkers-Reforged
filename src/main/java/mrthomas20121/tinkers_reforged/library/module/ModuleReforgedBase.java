package mrthomas20121.tinkers_reforged.library.module;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.commons.lang3.StringUtils;

public abstract class ModuleReforgedBase {

    public void earlyPreInit() {

    }

    public abstract void preInit();

    public abstract void init();

    public void postInit() {

    }

    public abstract boolean canLoad();

    public void registerItems(IForgeRegistry<Item> r) {

    }

    public void registerBlocks(IForgeRegistry<Block> r) {

    }

    public void registerRecipes(IForgeRegistry<IRecipe> r) {

    }

    public void registerModels() {

    }

    protected void register(IForgeRegistry<Item> r, Item item, String name) {
        item.setRegistryName(TinkersReforged.MODID, name);
        item.setTranslationKey(TinkersReforged.MODID+"."+name);
        item.setCreativeTab(ModuleManager.tab);
        r.register(item);
        ModuleManager.items.add(item);
    }

    protected void register(IForgeRegistry<Block> r, Block block, String name) {
        block.setRegistryName(TinkersReforged.MODID, name);
        block.setTranslationKey(TinkersReforged.MODID+"."+name);
        block.setCreativeTab(ModuleManager.tab);
        r.register(block);
        ModuleManager.blocks.add(block);
    }

    /**
     * Capitalize String
     */
    protected String cap(String str)
    {
        if(str.contains("_")) {
            String[] array = str.split("_");
            StringBuilder s = new StringBuilder();
            for(String string: array)
            {
                s.append(StringUtils.capitalize(string));
                s.append(" ");
            }
            return s.toString().substring(0, s.length()-1);
        }
        return StringUtils.capitalize(str);
    }
}
