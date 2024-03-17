package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.material.EnumFluid;
import mrthomas20121.tinkers_reforged.api.material.EnumGem;
import mrthomas20121.tinkers_reforged.api.material.EnumMaterial;
import mrthomas20121.tinkers_reforged.api.material.EnumMetal;
import mrthomas20121.tinkers_reforged.block.IOreBlock;
import mrthomas20121.tinkers_reforged.block.OverworldOreBlock;
import mrthomas20121.tinkers_reforged.api.cast.CastType;
import mrthomas20121.tinkers_reforged.init.*;
import mrthomas20121.tinkers_reforged.item.CastObject;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import org.apache.commons.lang3.StringUtils;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.util.LazyModifier;

public class ReforgedLang extends LanguageProvider {

    public ReforgedLang(DataGenerator gen) {
        super(gen, TinkersReforged.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.tinkers_reforged.resources", "Tinkers Reforged Resources");
        add("itemGroup.tinkers_reforged.casts", "Tinkers Reforged Casts");
        add("itemGroup.tinkers_reforged.tools", "Tinkers Reforged Tools");
        add("itemGroup.tinkers_reforged.tool_parts", "Tinkers Reforged Tool Parts");
        add("pattern.tinkers_reforged.great_blade", "Great Blade Pattern");
        add("pattern.tinkers_reforged.large_round_plate", "Large Round Plate Pattern");
        addItem(TinkersReforgedItems.book, "Reforging Guide");
        addItem(TinkersReforgedItems.ender_bone, "Ender Bone");
        addItem(TinkersReforgedItems.GREAT_BLADE, "Great Blade");
        addItem(TinkersReforgedItems.GREATSWORD, "Greatsword");
        addItem(TinkersReforgedItems.LONG_BLADE, "Long blade");
        addItem(TinkersReforgedItems.LONGSWORD, "Longsword");
        add("item.tinkers_reforged.great_sword.description", "A Giant Sword with knockback.");
        add("item.tinkers_reforged.longsword.description", "A Giant thin Sword with Increased range.");

        for(EnumMetal metal: EnumMetal.values()) {
            if(metal.isThisOre()) {
                IOreBlock block = TinkersReforgedBlocks.ORES.get(metal);
                addBlock(block.ore(), capitalize("%s_ore".formatted(metal.getName())));
                if(metal.isThisOverworldOre()) {
                    addBlock(((OverworldOreBlock) block).deepslateOre(), capitalize("deepslate_%s_ore".formatted(metal.getName())));
                }
                addBlock(TinkersReforgedBlocks.RAW_ORES.get(metal), capitalize("raw_%s_ore".formatted(metal.getName())));
                addItem(TinkersReforgedItems.RAW_ORES.get(metal), capitalize("raw_%s".formatted(metal.getName())));
            }
            for(EnumMetal.BlockType blockType: EnumMetal.BlockType.values()) {
                addBlock(TinkersReforgedBlocks.METAL_BLOCKS.get(metal).get(blockType), capitalize("%s_%s".formatted(metal.getName(), blockType.getName())));
            }

            for(EnumMetal.ItemType itemType: EnumMetal.ItemType.values()) {
                addItem(TinkersReforgedItems.METALS.get(metal).get(itemType), capitalize("%s_%s".formatted(metal.getName(), itemType.getName())));
            }
        }

        for(EnumFluid enumFluid: EnumFluid.values()) {
            FluidObject<ForgeFlowingFluid> fluid = TinkersReforgedFluids.ALL_FLUIDS.get(enumFluid);
            addFluid(fluid, "Molten " + capitalize(enumFluid.getName()));
            add(fluid.get().getBucket(), "Molten %s Bucket".formatted(capitalize(enumFluid.getName())));
        }

        for(EnumGem gem: EnumGem.values()) {
            OverworldOreBlock block = TinkersReforgedBlocks.GEM_ORES.get(gem);
            addBlock(block.ore(), capitalize("%s_ore".formatted(gem.getName())));
            addBlock(block.deepslateOre(), capitalize("deepslate_%s_ore".formatted(gem.getName())));
            addBlock(TinkersReforgedBlocks.GEMS_BLOCKS.get(gem), capitalize("%s_block".formatted(gem.getName())));

            for(EnumGem.ItemType itemType: EnumGem.ItemType.values()) {
                addItem(TinkersReforgedItems.GEMS.get(gem).get(itemType), capitalize("%s_%s".formatted(gem.getName(), itemType.getName())));
            }
        }

        addCast(TinkersReforgedItems.great_blade_cast);
        addCast(TinkersReforgedItems.long_blade_cast);

        addEffect(TinkersReforgedPotions.FROZEN, "Freeze");

        for(CastType type: CastType.values()) {
            Item item = TinkersReforgedItems.ALU_CASTS.get(type).get();
            add(item, String.format("%s Aluminum Cast", capitalize(type.name().toLowerCase())));
        }

        for(EnumMaterial material: EnumMaterial.values()) {
            addMaterial(material.id, capitalize(material.getName()), "", material.materialDesc);
            addModifier(material.mod, capitalize(material.mod.getId().getPath()),capitalize(material.mod.getId().getPath()), material.modifierDesc);
        }

        addModifier(TinkersReforgedModifiers.returning, "Returning", "Returning.", "Increases Attack Knockback.");
        addModifier(TinkersReforgedModifiers.long_range, "Long Range", "Long Range.", "Increases Attack and Entity Range.");

        // kepu harvest tier
        add("stat.tconstruct.harvest_tier.tinkers_reforged.kepu", "Kepu");
        // modifier bonus texts
        add("modifier.tinkers_reforged.biome_effect.attack_damage", "Bonus damage in the current biome");
        add("modifier.tinkers_reforged.biome_effect.mining_speed", "Bonus mining speed in the current biome");
        add("modifier.tinkers_reforged.excavation.value", "%s/100 excavated block.");
        add("modifier.tinkers_reforged.excavation.level", "%s Excavating Level.");

        // potion stuff
        add("item.minecraft.potion.effect.frozen", "Frozen Potion");
        add("item.minecraft.splash_potion.effect.frozen", "Frozen Splash Potion");
        add("item.minecraft.lingering_potion.effect.frozen", "Frozen Lingering Potion");
    }

    public void addCast(CastObject object) {
        //addItem(object.getGoldCast(), capitalize(object.getName().getPath())+ " Gold Cast");
        //addItem(object.getSandCast(), capitalize(object.getName().getPath())+ " Sand Cast");
        //addItem(object.getRedSandCast(), capitalize(object.getName().getPath())+ " Red Sand Cast");
    }

    public void addMaterial(MaterialId material, String name, String flavour, String desc) {
        String id = material.getPath();
        add("material.tinkers_reforged." + id, name);
        if (!flavour.equals(""))
            add("material.tinkers_reforged." + id + ".flavor", flavour);
        if (!desc.equals(""))
            add("material.tinkers_reforged." + id + ".encyclopedia", desc);
    }

    public void addModifier(LazyModifier modifier, String name, String flavour, String desc) {
        String id = modifier.getId().getPath();
        add("modifier.tinkers_reforged." + id, name);
        add("modifier.tinkers_reforged." + id + ".flavor", flavour);
        add("modifier.tinkers_reforged." + id + ".description", desc);
    }

    public void addFluid(FluidObject<ForgeFlowingFluid> supplier, String name) {
        add(String.format("fluid.%s.%s", TinkersReforged.MOD_ID, supplier.getId().getPath().replace("_flowing", "")), name);
    }

    public String capitalize(String input) {
        if(input.contains("_")) {
            String[] split = input.split("_");
            StringBuilder output = new StringBuilder();
            for(String s : split) {
                output.append(StringUtils.capitalize(s));
                output.append(" ");
            }
            return output.toString().trim();
        }
        return StringUtils.capitalize(input);
    }
}
