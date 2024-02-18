package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.material.EnumFluid;
import mrthomas20121.tinkers_reforged.api.material.EnumGem;
import mrthomas20121.tinkers_reforged.api.material.EnumMetal;
import mrthomas20121.tinkers_reforged.block.OreBlock;
import mrthomas20121.tinkers_reforged.datagen.tcon.ReforgedMaterialIds;
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
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class ReforgedLang extends LanguageProvider {

    public ReforgedLang(DataGenerator gen) {
        super(gen, TinkersReforged.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addGroup("Tinkers Reforged Items");
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
                OreBlock block = TinkersReforgedBlocks.ORES.get(metal);
                addBlock(block.ore(), StringUtils.capitalize("%s_ore".formatted(metal.getName())));
                addBlock(block.deepslateOre(), StringUtils.capitalize("deepslate_%s_ore".formatted(metal.getName())));
                addBlock(TinkersReforgedBlocks.RAW_ORES.get(metal), StringUtils.capitalize("%s_ore".formatted(metal.getName())));
            }
            for(EnumMetal.BlockType blockType: EnumMetal.BlockType.values()) {
                addBlock(TinkersReforgedBlocks.METAL_BLOCKS.get(metal).get(blockType), StringUtils.capitalize("%s_%s".formatted(metal.getName(), blockType.getName())));
            }

            for(EnumMetal.ItemType itemType: EnumMetal.ItemType.values()) {
                addItem(TinkersReforgedItems.METALS.get(metal).get(itemType), StringUtils.capitalize("%s_%s".formatted(metal.getName(), itemType.getName())));
            }
        }

        for(EnumFluid enumFluid: EnumFluid.values()) {
            FluidObject<ForgeFlowingFluid> fluid = TinkersReforgedFluids.ALL_FLUIDS.get(enumFluid);
            addFluid(fluid, "Molten" + enumFluid.getName());
            add(fluid.get().getBucket(), "Molten %s Bucket".formatted(enumFluid.getName()));
        }

        for(EnumGem gem: EnumGem.values()) {
            OreBlock block = TinkersReforgedBlocks.GEM_ORES.get(gem);
            addBlock(block.ore(), StringUtils.capitalize("%s_ore".formatted(gem.getName())));
            addBlock(block.deepslateOre(), StringUtils.capitalize("deepslate_%s_ore".formatted(gem.getName())));
            addBlock(TinkersReforgedBlocks.GEMS_BLOCKS.get(gem), StringUtils.capitalize("%s_block".formatted(gem.getName())));

            for(EnumGem.ItemType itemType: EnumGem.ItemType.values()) {
                addItem(TinkersReforgedItems.GEMS.get(gem).get(itemType), StringUtils.capitalize("%s_%s".formatted(gem.getName(), itemType.getName())));
            }
        }

        addCast(TinkersReforgedItems.great_blade_cast);
        addCast(TinkersReforgedItems.long_blade_cast);

        addEffect(TinkersReforgedPotions.FROZEN, "Freeze");

        for(CastType type: CastType.values()) {
            Item item = TinkersReforgedItems.castMap.get(type).get();
            add(item, String.format("%s Aluminum Cast", capitalize(type.name().toLowerCase())));
        }

        addMaterial(ReforgedMaterialIds.aluminum, "Aluminum", "Strong and durable", "Aluminum Metal");
        addMaterial(ReforgedMaterialIds.duralumin, "Duralumin", "One of the earliest types of age-hardenable aluminum alloys", "Aluminum Alloy");
        addMaterial(ReforgedMaterialIds.electrical_copper, "Electrical Copper", "It's not as electric as people think", "Copper that was Electrified");
        addMaterial(ReforgedMaterialIds.lavium, "Lavium", "Cobalt Alloy", "Strong Cobalt Alloy");
        addMaterial(ReforgedMaterialIds.qivium, "Qivium", "Cobalt Alloy", "Strong Cobalt Alloy");
        addMaterial(ReforgedMaterialIds.gausum, "Gausum", "Ancient Debris Alloy", "Strong Ancient Debris Alloy");
        addMaterial(ReforgedMaterialIds.felsteel, "Felsteel", "Ancient Debris Alloy", "From the depth of the nether");
        addMaterial(ReforgedMaterialIds.chorus_metal, "Chorus Metal", "Chorus and Shulker alloy", "Chorus and Shulker alloy");
        addMaterial(ReforgedMaterialIds.kepu, "Kepu", "Come from the depth of the end", "Infused End Ore");
        addMaterial(ReforgedMaterialIds.durasteel, "Durasteel", "Wait it's not an ore?", "Mix of Ender and Netherite");
        addMaterial(ReforgedMaterialIds.crusteel, "Crusteel", "Nether Crust", "Copper nether alloy");
        addMaterial(ReforgedMaterialIds.wavy, "Wavy", "This smell bad", "Mushroom material");
        addMaterial(ReforgedMaterialIds.yokel, "Yokel", "Finally a sea metal", "Kelp alloy");
        addMaterial(ReforgedMaterialIds.baolian, "Baolian", "Hmm, a gemstone mix?", "Made from Obsidian and Hureaulite");
        addMaterial(ReforgedMaterialIds.epidote, "Epidote", "The faces are often deeply striated and crystals are often twinned", "Found in the depth of earth");
        addMaterial(ReforgedMaterialIds.galu, "Galu", "Hmm, a gemstone mix?", "Made from Obsidian and Epidote");
        addMaterial(ReforgedMaterialIds.hureaulite, "Hureaulite", "it's an Orange!", "Found in the depth of earth");
        addMaterial(ReforgedMaterialIds.red_beryl, "Red Beryl", "Beryl but Red", "Gemstone");
        addMaterial(ReforgedMaterialIds.ender_bone, "Enderbone", "Bone mixed with ender", "Bone but with more durability");
        addMaterial(ReforgedMaterialIds.blazing_copper, "Blazing Copper", "Its Blazing Hot!", "What if Blazing blood and Copper had a baby?");
        addMaterial(ReforgedMaterialIds.magma_steel, "Magma Steel", "A hot nether alloy", "Steel meet Magma");
        addMaterial(ReforgedMaterialIds.cyber_steel, "Cyber Steel", "A cool end alloy", "Steel meet Chorus Metal");
        addMaterial(ReforgedMaterialIds.gelot, "Gelot", "Strange alloy from the end", "When endstone and diamond meet");
        addMaterial(ReforgedMaterialIds.piroot, "Piroot", "Strange alloy from the end", "When endstone and netherite meet");

        addModifier(TinkersReforgedModifiers.gausum_titanic_damage, "Titanic Damage", "that's a lot of damage!", "Deal more damage to enemy with more HP than you(Scale with your titanic dmg modifier level).");
        addModifier(TinkersReforgedModifiers.lavium_aridzone, "Arid Zone", "That's quite hot!", "Increase mining speed and damage in hot/arid area");
        addModifier(TinkersReforgedModifiers.duralumin_ultra_durable, "Ultra Durable", "Anyone need Duritos?", "Your tool last longer most of the time.");
        addModifier(TinkersReforgedModifiers.electrical_copper_electrostatic, "Electrostatic", "I wouldn't touch it!", "Target is paralyzed for 3 second.");
        addModifier(TinkersReforgedModifiers.qivium_anti_armor, "Anti Armor", "Armor, what's that?", "Deal more damage to Armored Targets.");
        addModifier(TinkersReforgedModifiers.felsteel_fel_debris, "Fel Debris", "Watch out!", "Deal more damage in the nether.");

        addModifier(TinkersReforgedModifiers.ender_upgrade, "Ender Upgrade", "The end is night", "Deal more damage to the ender dragon.");
        addModifier(TinkersReforgedModifiers.cutting_edge, "Magic Power", "Magic everywhere", "ALL Damage dealt are magic.");
        addModifier(TinkersReforgedModifiers.durasteel_adaptability, "Adapting", "Power Up", "Each undead mob killed increase your attack damage and mining speed by. Cap at 15 by default.");
        addModifier(TinkersReforgedModifiers.giant_cells, "Giant Cells", "Micro Friends", "Mine Faster the lower your Health is.");
        addModifier(TinkersReforgedModifiers.terra, "Terra", "Caught between a rock and a hard place.", "Mine stone blocks faster(controlled by a tag)");
        addModifier(TinkersReforgedModifiers.spore_shot, "Spore Shot", "MMM Mushrooms.", "Apply Fungal on it. Entity with fungal take 2% of their health as damage when hit.");
        addModifier(TinkersReforgedModifiers.rare_earth, "Rare Earth", "Rare Earths for days!.", "Mobs drops are replaced by cobblestone/iron/gold/diamond.");
        addModifier(TinkersReforgedModifiers.water_power, "Water Power", "The ocean calls for you.", "Remove the mining penalty underwater.");
        addModifier(TinkersReforgedModifiers.effective_boost, "Effective Boost", "Potion Effects for days.", "Deal more damage for each active potion effect you have.");
        addModifier(TinkersReforgedModifiers.wet_soil, "Wet Soil", "Rain is good.", "Mine faster when it's raining(wherever the player is).");
        addModifier(TinkersReforgedModifiers.crystallized_punch, "Crystallized Punch", "5 hits and you're K.O.", "Every 5 attacks, deal 1% of the target HP as bonus magic damage.");
        addModifier(TinkersReforgedModifiers.collapsed, "Collapsed", "More damage while damaged.", "Deal more damage while damaged.");
        addModifier(TinkersReforgedModifiers.blazing_copper_spark, "Spark", "Better Crit damage.", "Deal more critical strike damage.");
        addModifier(TinkersReforgedModifiers.aluminum_rotective_mantle, "Protective Mantle", "Better than no protection!", "Prevent the 4th durability lose.");
        addModifier(TinkersReforgedModifiers.cyber_steel_swift_eye, "Swift Eye", "Eye of the tiger", "Enderman Drop Eye of ender instead of Ender Pearl.");
        addModifier(TinkersReforgedModifiers.magma_steel_unbending, "Unbending", "The Earth is shaking!", "Damage dealt below 6 pierce through armor.");
        addModifier(TinkersReforgedModifiers.tenacity, "Lust", "You have a bloodlust for hunger", "After killing an entity, restore some hunger.");
        addModifier(TinkersReforgedModifiers.half_powered_fists, "Half Powered Fists", "Don't take it personal kid", "Tool deal half damage but attack twice.");

        add("modifier.tinkers_reforged.adapting.attack_damage", "Adapting damage");
        add("modifier.tinkers_reforged.adapting.mining_speed", "Adapting mining speed");
        add("modifier.tinkers_reforged.fel_debris.bonus", "Damage in the nether.");
        add("modifier.tinkers_reforged.arid_zone.attack_damage", "Bonus damage in the current biome");
        add("modifier.tinkers_reforged.arid_zone.mining_speed", "Bonus mining speed in the current biome");
        add("modifier.tinkers_reforged.giant_cells.mining_speed", "Bonus mining speed");
        add("modifier.tinkers_reforged.adapting.cap", "You have reach the max bonus you can get with adapting");

        add("tinkers_reforged.modifier.excavation.value", "%s/100 excavated block.");
        add("tinkers_reforged.modifier.excavation.level", "%s Excavating Level.");
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

    public void addModifier(StaticModifier<Modifier> modifier, String name, String flavour, String desc) {
        String id = modifier.getId().getPath();
        add("modifier.tinkers_reforged." + id, name);
        add("modifier.tinkers_reforged." + id + ".flavor", flavour);
        add("modifier.tinkers_reforged." + id + ".description", desc);
    }

    public void addFluid(FluidObject<ForgeFlowingFluid> supplier, String name) {
        add(String.format("fluid.%s.%s", TinkersReforged.MOD_ID, supplier.getId().getPath().replace("_flowing", "")), name);
    }

    public void addGroup(String value) {
        add(String.format("itemGroup.%s", TinkersReforged.MOD_ID), value);
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
