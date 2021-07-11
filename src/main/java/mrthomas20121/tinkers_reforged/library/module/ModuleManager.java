package mrthomas20121.tinkers_reforged.library.module;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.library.ForgeUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.commons.lang3.StringUtils;
import slimeknights.tconstruct.library.modifiers.Modifier;

import java.util.*;

@Mod.EventBusSubscriber(modid = TinkersReforged.MODID)
public class ModuleManager {

    private static LinkedHashMap<String, ModuleReforgedBase> modules = new LinkedHashMap<>();
    public static List<Item> items = new ArrayList<>();
    public static List<Block> blocks = new ArrayList<>();
    public static List<Modifier> modifiers = new ArrayList<>();
    public static List<String> alloys = new ArrayList<>();

    public static CreativeTabs tab = new CreativeTabs("tinkers_reforged") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.REDSTONE);
        }
    };

    public enum type {
        INGOT,
        DUST,
        NUGGET,
        PLATE,
        GEAR
    }

    public static void registerAlloy(String name) {
        alloys.add(name);
    }

    public static void addModule(String dep, ModuleReforgedBase module) {
        modules.put(dep, module);
    }

    public static void earlyPreInit() {
        modules.forEach((mod, module)-> {
            if(isModLoaded(mod) && module.canLoad()) {
                module.earlyPreInit();
            }
        });
    }

    public static void preInit() {
        modules.forEach((mod, module)-> {
            if(isModLoaded(mod) && module.canLoad()) {
                module.preInit();
            }
        });
    }

    public static void init() {
        modules.forEach((mod, module)-> {
            if(isModLoaded(mod) && module.canLoad()) {
                module.init();
            }
        });

        for(String alloy : alloys) {
            for(type t: type.values()) {
                Item item = ForgeUtils.getItem(TinkersReforged.MODID, alloy+t.name().toLowerCase());
                OreDictionary.registerOre(t.name().toLowerCase()+cap(alloy), item);
            }

            Block block = ForgeUtils.getBlock(TinkersReforged.MODID, alloy+"_block");
            OreDictionary.registerOre("block"+cap(alloy), block);
        }
    }

    public static void postInit() {
        modules.forEach((mod, module)-> {
            if(isModLoaded(mod) && module.canLoad()) {
                module.postInit();
            }
        });
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> r = event.getRegistry();

        for(String alloy : alloys) {
            for(type t: type.values()) {
                register(r, new Item(), alloy+"_"+t.name().toLowerCase());
            }
        }

        for(Block block: blocks) {
            r.register(new ItemBlock(block).setRegistryName(block.getRegistryName()).setTranslationKey(block.getTranslationKey()).setCreativeTab(block.getCreativeTab()));
        }
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> r = event.getRegistry();

        for(String alloy : alloys) {
            register(r, new Block(Material.IRON), alloy+"_block");
        }
		
		modules.forEach((mod, module)-> {
            if(isModLoaded(mod) && module.canLoad()) {
                module.registerBlocks(r);
            }
        });
    }

    private static boolean isModLoaded(String mod) {
        return Loader.isModLoaded(mod);
    }

    private static void register(IForgeRegistry<Item> r, Item item, String name) {
        item.setRegistryName(TinkersReforged.MODID, name);
        item.setTranslationKey(TinkersReforged.MODID+"."+name);
        item.setCreativeTab(ModuleManager.tab);
        r.register(item);
        items.add(item);
    }

    private static void register(IForgeRegistry<Block> r, Block block, String name) {
        block.setRegistryName(TinkersReforged.MODID, name);
        block.setTranslationKey(TinkersReforged.MODID+"."+name);
        block.setCreativeTab(ModuleManager.tab);
        r.register(block);
        blocks.add(block);
    }

    private static String cap(String str)
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
