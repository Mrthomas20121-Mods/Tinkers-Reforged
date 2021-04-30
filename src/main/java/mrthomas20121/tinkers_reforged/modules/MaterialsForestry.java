package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.objects.item.ItemBase;
import mrthomas20121.tinkers_reforged.library.ForgeUtils;
import mrthomas20121.tinkers_reforged.library.MaterialGen;
import mrthomas20121.tinkers_reforged.library.module.ModuleManager;
import mrthomas20121.tinkers_reforged.library.module.ModuleReforgedBase;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

public class MaterialsForestry extends ModuleReforgedBase {

    private String[] alloys = { "honey_alloy", "icey_alloy" };

    private MaterialGen honey_alloy = new MaterialGen("ref_honey_alloy", 0x0, "HoneyAlloy", 700);

    @Override
    public boolean canLoad() {
        return false;
    }

    @Override
    public void preInit() {
        honey_alloy.preInit();
    }

    @Override
    public void init() {
        for(String s: alloys) {
            for(ModuleManager.type type : ModuleManager.type.values()) {
                OreDictionary.registerOre(type.name().toLowerCase()+cap(s), ForgeUtils.getItemStack("tinkers_reforged", s+"_"+type.name().toLowerCase(), 0));
            }
        }

        honey_alloy.init();
    }

    @Override
    public void registerItems(IForgeRegistry<Item> r) {
        for(String s: alloys) {
            for(ModuleManager.type type : ModuleManager.type.values()) {
                register(r, new Item(), s+"_"+type.name().toLowerCase());
            }
        }
    }
}
