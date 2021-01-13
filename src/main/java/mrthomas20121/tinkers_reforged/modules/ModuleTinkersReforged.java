package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.library.MaterialGen;
import mrthomas20121.tinkers_reforged.ReforgedRegistry;
import mrthomas20121.tinkers_reforged.ReforgedTraits;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.library.Utils;
import mrthomas20121.tinkers_reforged.library.block.ReforgedBlockGlass;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.commons.lang3.StringUtils;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.fluid.FluidMolten;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleTinkersReforged implements ModuleBase {

    public static MaterialGen lavium = new MaterialGen("lavium", 0x9FAF59, "Lavium", 800);
    public static MaterialGen qivium = new MaterialGen("qivium", 0xAF7259, "Qivium", 800);

    private FluidMolten kovar_fluid = new FluidMolten("kovar", 0x5369C6);

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {
        FluidRegistry.registerFluid(kovar_fluid);
        FluidRegistry.addBucketForFluid(kovar_fluid);

        if(TinkersReforgedConfig.SettingMaterials.materials.lavium) {
            lavium.preInit();
            lavium.getMaterial().addTrait(TinkerTraits.momentum);
            lavium.getMaterial().addTrait(ReforgedTraits.lifeSteal, MaterialTypes.HEAD);
            TinkerRegistry.addMaterial(lavium.getMaterial());
            TinkerRegistry.addMaterialStats(lavium.getMaterial(),
                    new HeadMaterialStats(1000, 12.2f, 12.2f, HarvestLevels.COBALT),
                    new HandleMaterialStats(1.3f, 100),
                    new ExtraMaterialStats(100),
                    new BowMaterialStats(5.2f, 5.1f, 5.2f));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.qivium) {
            qivium.preInit();
            qivium.getMaterial().addTrait(TinkerTraits.momentum);
            qivium.getMaterial().addTrait(ReforgedTraits.pyromency, MaterialTypes.HEAD);
            TinkerRegistry.addMaterial(qivium.getMaterial());
            TinkerRegistry.addMaterialStats(qivium.getMaterial(),
                    new HeadMaterialStats(1000, 12.2f, 12.2f, HarvestLevels.COBALT),
                    new HandleMaterialStats(1.3f, 100),
                    new ExtraMaterialStats(100),
                    new BowMaterialStats(5.2f, 5.2f, 5.2f));
        }
    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {
        if(TinkersReforgedConfig.SettingMaterials.materials.lavium) {
            lavium.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.qivium) {
            qivium.init();
        }

        if(TinkersReforgedConfig.SettingGeneral.enableAlloyRecipes)
        {
            FluidStack ardite = FluidRegistry.getFluidStack("ardite", Material.VALUE_SearedBlock);
            FluidStack cobalt = FluidRegistry.getFluidStack("cobalt", Material.VALUE_SearedBlock);
            FluidStack purpleslime = FluidRegistry.getFluidStack("purpleslime", Material.VALUE_Ingot);
            FluidStack glass = FluidRegistry.getFluidStack("glass", Material.VALUE_Glass);
            FluidStack lavium = new FluidStack(FluidRegistry.getFluid("lavium"), Material.VALUE_Ingot);
            FluidStack qivium = new FluidStack(FluidRegistry.getFluid("qivium"), Material.VALUE_Ingot);
            FluidStack kovar = new FluidStack(FluidRegistry.getFluid("kovar"), Material.VALUE_Ingot);FluidRegistry.getFluidStack("kovar", Material.VALUE_Ingot);

            TinkerRegistry.registerAlloy(lavium, glass, cobalt, purpleslime);
            TinkerRegistry.registerAlloy(qivium, glass, ardite, purpleslime);
            TinkerRegistry.registerAlloy(kovar, lavium, qivium);
            TinkerSmeltery.registerOredictMeltingCasting(kovar.getFluid(), "Kovar");
        }

        TinkerRegistry.registerTableCasting(new ItemStack(Utils.getItem("kovar_glass"), 1), new ItemStack(Blocks.GLASS), kovar_fluid, Material.VALUE_SearedBlock);
    }

    public static void registerItems(IForgeRegistry<Item> r) {

        for(Mats mat : Mats.values()) {
            String materialName = StringUtils.capitalize(mat.name().toLowerCase());
            for(String p: mat.properties) {
                Item item = register(r, new Item(), materialName.toLowerCase()+"_"+p.toLowerCase());
                ReforgedRegistry.addItem(item);
                OreDictionary.registerOre(p.toLowerCase()+materialName, item);
            }
        }
    }

    public static void registerBlocks(IForgeRegistry<Block> r) {
        ReforgedRegistry.addBlock(register(r, new ReforgedBlockGlass(), "kovar_glass"));
    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }

    private static Item register(IForgeRegistry<Item> r, Item item, String name) {
        item.setRegistryName(TinkersReforged.MODID, name);
        item.setTranslationKey(TinkersReforged.MODID+"."+name);
        item.setCreativeTab(CreativeTabs.MATERIALS);
        r.register(item);
        return item;
    }
    private static Block register(IForgeRegistry<Block> r, Block block, String name) {
        block.setRegistryName(TinkersReforged.MODID, name);
        block.setTranslationKey(TinkersReforged.MODID+"."+name);
        r.register(block);
        return block;
    }

    private enum Mats {
        KOVAR("ingot", "nugget", "dust", "plate", "gear"),
        LAVIUM("ingot", "nugget", "dust", "plate", "gear"),
        QIVIUM("ingot", "nugget", "dust", "plate", "gear");

        String[] properties;

        Mats() {
            this("ingot", "nugget");
        }

        Mats(String ...properties) {
            this.properties = properties;
        }
    }
}
