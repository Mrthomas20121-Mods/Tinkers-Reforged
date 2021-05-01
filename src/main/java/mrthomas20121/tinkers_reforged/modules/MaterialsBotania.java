package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.library.Registry;
import mrthomas20121.tinkers_reforged.Reference;
import mrthomas20121.tinkers_reforged.ReforgedTraits;
import mrthomas20121.tinkers_reforged.compat.BotaniaCompat;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.library.ForgeUtils;
import mrthomas20121.tinkers_reforged.library.module.ModuleReforgedBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class MaterialsBotania extends ModuleReforgedBase {

    private Material manasteel = new Material("ref_manasteel", 0x3389FF);
    private Material livingwood = new Material("ref_livingwood", 0x2E1106);
    private Material livingrock = new Material("ref_livingrock", 0xCCCEBC);
    private Material dreamwood = new Material("ref_dreamwood", 0xA6BCB6);

    @Override
    public boolean canLoad() {
        return TinkersReforgedConfig.SettingMaterials.modules.botania;
    }

    @Override
    public void preInit() {
        if(TinkersReforgedConfig.SettingMaterials.materials.manasteel) {
            manasteel.addTrait(ReforgedTraits.manaInfusion, MaterialTypes.HEAD);
            manasteel.addTrait(ReforgedTraits.manaBoost);
            TinkerRegistry.addMaterial(manasteel);
            TinkerRegistry.addMaterialStats(manasteel,
                    new HeadMaterialStats(204, 6f, 4f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1.2f, 9),
                    new ExtraMaterialStats(50),
                    new BowMaterialStats(0.5f, 1.4f, 7f));
            Registry.addBToolForgeBlock("blockManasteel");
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.livingwood) {
            livingwood.addTrait(ReforgedTraits.living);
            TinkerRegistry.addMaterial(livingwood);
            TinkerRegistry.addMaterialStats(livingwood,
                    new HeadMaterialStats(200, 4f, 4f, HarvestLevels.IRON),
                    new HandleMaterialStats(1.2f, 0),
                    new ExtraMaterialStats(50),
                    new BowMaterialStats(2f, 1.7f, 5f));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.livingrock) {
            livingrock.addTrait(ReforgedTraits.living);
            TinkerRegistry.addMaterial(livingrock);
            TinkerRegistry.addMaterialStats(livingrock,
                    new HeadMaterialStats(200, 4f, 4f, HarvestLevels.IRON),
                    new HandleMaterialStats(1.2f, 0),
                    new ExtraMaterialStats(50),
                    new BowMaterialStats(3f, 1.7f, 3f));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.dreamwood) {
            dreamwood.addTrait(TinkerTraits.ecological);
            TinkerRegistry.addMaterial(dreamwood);
            TinkerRegistry.addMaterialStats(dreamwood,
                    new HeadMaterialStats(200, 4f, 4f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1.3f, 0),
                    new ExtraMaterialStats(50),
                    new BowMaterialStats(3f, 1.7f, 3f));
        }
    }

    @Override
    public void init() {
        if(TinkersReforgedConfig.SettingMaterials.materials.manasteel) {
            manasteel.setRepresentativeItem("ingotManasteel");
            manasteel.addItemIngot("ingotManasteel");
            for(IToolPart part : TinkerRegistry.getToolParts())
            {
                if(part.canUseMaterial(manasteel) && (part.canBeCasted() || part.canBeCrafted()))
                {
                    BotaniaCompat.addManaInfusionRecipe(part.getItemstackWithMaterial(manasteel), part.getItemstackWithMaterial(TinkerRegistry.getMaterial(TinkersReforgedConfig.SettingGeneral.mods.manasteel.material)), TinkersReforgedConfig.SettingGeneral.mods.manasteel.cost);
                }
            }
            OreDictionary.registerOre("blockManasteel", new ItemStack(ForgeUtils.getItem(Reference.botania, "storage"), 1, 0));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.livingwood) {
            livingwood.addItem(ForgeUtils.getBlock(Reference.botania, "livingwood"), 1);
            livingwood.setRepresentativeItem(ForgeUtils.getBlock(Reference.botania, "livingwood"));
            livingwood.setCraftable(true);
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.livingrock) {
            livingrock.addItem(ForgeUtils.getBlock(Reference.botania, "livingrock"), 1);
            livingrock.setRepresentativeItem(ForgeUtils.getBlock(Reference.botania, "livingrock"));
            livingrock.setCraftable(true);
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.dreamwood) {
            dreamwood.setCraftable(true);
            dreamwood.addItem(ForgeUtils.getBlock(Reference.botania, "dreamwood"), 1);
            dreamwood.setRepresentativeItem(ForgeUtils.getBlock(Reference.botania, "dreamwood"));
        }
    }
}
