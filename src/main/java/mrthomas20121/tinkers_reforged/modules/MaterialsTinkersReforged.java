package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.tinkers_reforged.library.ForgeUtils;
import mrthomas20121.tinkers_reforged.library.MaterialGen;
import mrthomas20121.tinkers_reforged.ReforgedTraits;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.library.block.ReforgedBlockGlass;
import mrthomas20121.tinkers_reforged.library.module.ModuleReforgedBase;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.commons.lang3.StringUtils;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.fluid.FluidMolten;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;
import slimeknights.tconstruct.tools.TinkerTraits;

public class MaterialsTinkersReforged extends ModuleReforgedBase {

    public static MaterialGen lavium = new MaterialGen("lavium", 0xA5E560, "Lavium", 800);
    public static MaterialGen qivium = new MaterialGen("qivium", 0xD893AF, "Qivium", 800);

    private FluidMolten kovar_fluid = new FluidMolten("kovar", 0xFFC09CE5);

    @Override
    public boolean canLoad() {
        return TinkersReforgedConfig.SettingMaterials.modules.tinkers_reforged;
    }

    @Override
    public void preInit() {
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
    public void init() {

        // register ores for the various parts
        String[] parts = { "ingot", "nugget", "dust", "plate", "gear" };
        for(Mats mat : Mats.values()) {
            String materialName = StringUtils.capitalize(mat.name().toLowerCase());
            for(String part: parts) {
                Item item = ForgeUtils.getItem(TinkersReforged.MODID, mat.name().toLowerCase()+"_"+part.toLowerCase());
                OreDictionary.registerOre(part.toLowerCase()+materialName, item);
            }
        }

        OreDictionary.registerOre("blockGlass", ForgeUtils.getBlock(TinkersReforged.MODID,"kovar_glass"));

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
            FluidStack purpleslime = FluidRegistry.getFluidStack("purpleslime", 125);
            FluidStack glass = FluidRegistry.getFluidStack("glass", Material.VALUE_Glass);
            FluidStack lavium = new FluidStack(FluidRegistry.getFluid("lavium"), Material.VALUE_Ingot);
            FluidStack qivium = new FluidStack(FluidRegistry.getFluid("qivium"), Material.VALUE_Ingot);
            FluidStack kovar = new FluidStack(FluidRegistry.getFluid("kovar"), Material.VALUE_Ingot);FluidRegistry.getFluidStack("kovar", Material.VALUE_Ingot);

            TinkerRegistry.registerAlloy(lavium, glass, cobalt, purpleslime);
            TinkerRegistry.registerAlloy(qivium, glass, ardite, purpleslime);
            TinkerRegistry.registerAlloy(kovar, lavium, qivium);
            TinkerSmeltery.registerOredictMeltingCasting(kovar.getFluid(), "Kovar");
        }

        TinkerRegistry.registerTableCasting(new ItemStack(ForgeUtils.getBlock(TinkersReforged.MODID,"kovar_glass"), 1), new ItemStack(Blocks.GLASS), kovar_fluid, Material.VALUE_SearedBlock);
    }

    public void registerItems(IForgeRegistry<Item> r) {
        String[] parts = { "ingot", "nugget", "dust", "plate", "gear" };

        for(Mats mat : Mats.values()) {
            for(String part: parts) {
                register(r, new Item(), mat.name().toLowerCase()+"_"+part.toLowerCase());
            }
        }
    }

    public void registerBlocks(IForgeRegistry<Block> r) {
        register(r, new ReforgedBlockGlass(), "kovar_glass");
    }

    private enum Mats {
        KOVAR,
        LAVIUM,
        QIVIUM
    }
}
