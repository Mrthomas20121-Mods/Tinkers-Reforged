package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.datagen.tcon.ReforgedMaterialIds;
import mrthomas20121.tinkers_reforged.init.CastType;
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
        addItem(TinkersReforgedItems.LARGE_ROUND_PLATE, "Large Round Plate");
        addItem(TinkersReforgedItems.GREATSWORD, "Greatsword");
        addItem(TinkersReforgedItems.LONG_BLADE, "Long blade");
        addItem(TinkersReforgedItems.LONGSWORD, "Longsword");
        add("item.tinkers_reforged.great_sword.description", "A Giant Sword with knockback.");
        addBlock(TinkersReforgedBlocks.aluminum_block, "Aluminum Block");
        addBlock(TinkersReforgedBlocks.aluminum_ore, "Bauxite Ore");
        addBlock(TinkersReforgedBlocks.deepslate_aluminum_ore, "Deepslate Bauxite Ore");
        addItem(TinkersReforgedItems.aluminum_dust, "Aluminum Dust");
        addItem(TinkersReforgedItems.aluminum_ingot, "Aluminum Ingot");
        addItem(TinkersReforgedItems.aluminum_nugget, "Aluminum Nugget");
        addBlock(TinkersReforgedBlocks.blazing_copper_block, "Blazing Copper Block");
        addItem(TinkersReforgedItems.blazing_copper_dust, "Blazing Copper Dust");
        addItem(TinkersReforgedItems.blazing_copper_ingot, "Blazing Copper Ingot");
        addItem(TinkersReforgedItems.blazing_copper_nugget, "Blazing Copper Nugget");
        addBlock(TinkersReforgedBlocks.duralumin_block, "Duralumin Block");
        addItem(TinkersReforgedItems.duralumin_dust, "Duralumin Dust");
        addItem(TinkersReforgedItems.duralumin_ingot, "Duralumin Ingot");
        addItem(TinkersReforgedItems.duralumin_nugget, "Duralumin Nugget");
        addBlock(TinkersReforgedBlocks.electrical_copper_block, "Electrical Copper Block");
        addItem(TinkersReforgedItems.electrical_copper_dust, "Electrical Copper Dust");
        addItem(TinkersReforgedItems.electrical_copper_ingot, "Electrical Copper Ingot");
        addItem(TinkersReforgedItems.electrical_copper_nugget, "Electrical Copper Nugget");
        addBlock(TinkersReforgedBlocks.lavium_block, "Lavium Block");
        addItem(TinkersReforgedItems.lavium_dust, "Lavium Dust");
        addItem(TinkersReforgedItems.lavium_ingot, "Lavium Ingot");
        addItem(TinkersReforgedItems.lavium_nugget, "Lavium Nugget");
        addBlock(TinkersReforgedBlocks.qivium_block, "Qivium Block");
        addItem(TinkersReforgedItems.qivium_dust, "Qivium Dust");
        addItem(TinkersReforgedItems.qivium_ingot, "Qivium Ingot");
        addItem(TinkersReforgedItems.qivium_nugget, "Qivium Nugget");
        addBlock(TinkersReforgedBlocks.gausum_block, "Gausum Block");
        addItem(TinkersReforgedItems.gausum_dust, "Gausum Dust");
        addItem(TinkersReforgedItems.gausum_ingot, "Gausum Ingot");
        addItem(TinkersReforgedItems.gausum_nugget, "Gausum Nugget");
        addBlock(TinkersReforgedBlocks.felsteel_block, "Felsteel Block");
        addItem(TinkersReforgedItems.felsteel_dust, "Felsteel Dust");
        addItem(TinkersReforgedItems.felsteel_ingot, "Felsteel Ingot");
        addItem(TinkersReforgedItems.felsteel_nugget, "Felsteel Nugget");
        addItem(TinkersReforgedItems.kepu_ore, "Kepu Ore");
        addBlock(TinkersReforgedBlocks.kepu_block, "Kepu Block");
        addItem(TinkersReforgedItems.kepu_dust, "Kepu Dust");
        addItem(TinkersReforgedItems.kepu_ingot, "Kepu Ingot");
        addItem(TinkersReforgedItems.kepu_nugget, "Kepu Nugget");
        addBlock(TinkersReforgedBlocks.chorus_metal_block, "Chorus Metal Block");
        addItem(TinkersReforgedItems.chorus_metal_dust, "Chorus Metal Dust");
        addItem(TinkersReforgedItems.chorus_metal_ingot, "Chorus Metal Ingot");
        addItem(TinkersReforgedItems.chorus_metal_nugget, "Chorus Metal Nugget");
        addBlock(TinkersReforgedBlocks.durasteel_block, "Durasteel Block");
        addItem(TinkersReforgedItems.durasteel_dust, "Durasteel Dust");
        addItem(TinkersReforgedItems.durasteel_ingot, "Durasteel Ingot");
        addItem(TinkersReforgedItems.durasteel_nugget, "Durasteel Nugget");
        addBlock(TinkersReforgedBlocks.crusteel_block, "Crusteel Block");
        addItem(TinkersReforgedItems.crusteel_dust, "Crusteel Dust");
        addItem(TinkersReforgedItems.crusteel_ingot, "Crusteel Ingot");
        addItem(TinkersReforgedItems.crusteel_nugget, "Crusteel Nugget");
        addBlock(TinkersReforgedBlocks.wavy_block, "Wavy Block");
        addItem(TinkersReforgedItems.wavy_dust, "Wavy Dust");
        addItem(TinkersReforgedItems.wavy_ingot, "Wavy Ingot");
        addItem(TinkersReforgedItems.wavy_nugget, "Wavy Nugget");
        addBlock(TinkersReforgedBlocks.yokel_block, "Yokel Block");
        addItem(TinkersReforgedItems.yokel_dust, "Yokel Dust");
        addItem(TinkersReforgedItems.yokel_ingot, "Yokel Ingot");
        addItem(TinkersReforgedItems.yokel_nugget, "Yokel Nugget");
        addBlock(TinkersReforgedBlocks.baolian_block, "Baolian Block");
        addItem(TinkersReforgedItems.baolian_ingot, "Baolian Ingot");
        addItem(TinkersReforgedItems.baolian_dust, "Baolian Dust");
        addItem(TinkersReforgedItems.baolian_nugget, "Baolian Nugget");
        addBlock(TinkersReforgedBlocks.deepslate_epidote_ore, "Deepslate epidote Ore");
        addBlock(TinkersReforgedBlocks.epidote_block, "Epidote Block");
        addItem(TinkersReforgedItems.epidote_gem, "Epidote Gem");
        addBlock(TinkersReforgedBlocks.galu_block, "Galu Block");
        addItem(TinkersReforgedItems.galu_ingot, "Galu Ingot");
        addItem(TinkersReforgedItems.galu_dust, "Galu Dust");
        addItem(TinkersReforgedItems.galu_nugget, "Galu Nugget");
        addBlock(TinkersReforgedBlocks.magma_steel_block, "Magma Steel Block");
        addItem(TinkersReforgedItems.magma_steel_ingot, "Magma Steel Ingot");
        addItem(TinkersReforgedItems.magma_steel_dust, "Magma Steel Dust");
        addItem(TinkersReforgedItems.magma_steel_nugget, "Magma Steel Nugget");
        addBlock(TinkersReforgedBlocks.cyber_steel_block, "Cyber Steel Block");
        addItem(TinkersReforgedItems.cyber_steel_ingot, "Cyber Steel Ingot");
        addItem(TinkersReforgedItems.cyber_steel_dust, "Cyber Steel Dust");
        addItem(TinkersReforgedItems.cyber_steel_nugget, "Cyber Steel Nugget");
        addBlock(TinkersReforgedBlocks.gelot_block, "Gelot Block");
        addItem(TinkersReforgedItems.gelot_ingot, "Gelot Ingot");
        addItem(TinkersReforgedItems.gelot_dust, "Gelot Dust");
        addItem(TinkersReforgedItems.gelot_nugget, "Gelot Nugget");
        addBlock(TinkersReforgedBlocks.piroot_block, "Piroot Block");
        addItem(TinkersReforgedItems.piroot_ingot, "Piroot Ingot");
        addItem(TinkersReforgedItems.piroot_dust, "Piroot Dust");
        addItem(TinkersReforgedItems.piroot_nugget, "Piroot Nugget");
        addBlock(TinkersReforgedBlocks.deepslate_hureaulite_ore, "Deepslate Hureaulite Ore");
        addBlock(TinkersReforgedBlocks.hureaulite_block, "Hureaulite Block");
        addItem(TinkersReforgedItems.hureaulite_gem, "Hureaulite Gem");
        addBlock(TinkersReforgedBlocks.red_beryl_ore, "Red Beryl Block");
        addBlock(TinkersReforgedBlocks.deepslate_red_beryl_ore, "Deepslate Red Beryl Ore");
        addBlock(TinkersReforgedBlocks.red_beryl_block, "Red Beryl Block");
        addItem(TinkersReforgedItems.red_beryl_gem, "Red Beryl Gem");
        addItem(TinkersReforgedItems.raw_aluminum, "Raw Bauxite");
        addItem(TinkersReforgedItems.raw_kepu, "Raw Kepu");
        addBlock(TinkersReforgedBlocks.raw_aluminum_block, "Raw Bauxite Block");
        addBlock(TinkersReforgedBlocks.raw_kepu_block, "Raw Kepu Block");

        addCast(TinkersReforgedItems.great_blade_cast);
        addCast(TinkersReforgedItems.long_blade_cast);

        addFluid(TinkersReforgedFluids.redstone, "Liquid Redstone");
        addFluid(TinkersReforgedFluids.duralumin, "Molten Duralumin");
        addFluid(TinkersReforgedFluids.electrical_copper, "Molten Electrical Copper");
        addFluid(TinkersReforgedFluids.lavium, "Molten Lavium");
        addFluid(TinkersReforgedFluids.qivium, "Molten Qivium");
        addFluid(TinkersReforgedFluids.blazing_copper, "Molten Blazing Copper");
        addFluid(TinkersReforgedFluids.gausum, "Molten Gausum");
        addFluid(TinkersReforgedFluids.lapis, "Molten Lapis");
        addFluid(TinkersReforgedFluids.felsteel, "Molten Felsteel");
        addFluid(TinkersReforgedFluids.kepu, "Molten Kepu");
        addFluid(TinkersReforgedFluids.chorus_metal, "Molten Chorus Metal");
        addFluid(TinkersReforgedFluids.chorus, "Molten Chorus");
        addFluid(TinkersReforgedFluids.shulker, "Molten Shulker");
        addFluid(TinkersReforgedFluids.kelp, "Molten Kelp");
        addFluid(TinkersReforgedFluids.durasteel, "Molten Durasteel");
        addFluid(TinkersReforgedFluids.crusteel, "Molten Crusteel");
        addFluid(TinkersReforgedFluids.wavy, "Molten Wavy");
        addFluid(TinkersReforgedFluids.yokel, "Molten Yokel");
        addFluid(TinkersReforgedFluids.proto_lava, "Molten Proto Lava");
        addFluid(TinkersReforgedFluids.baolian, "Molten Baolian");
        addFluid(TinkersReforgedFluids.epidote, "Molten Epidote");
        addFluid(TinkersReforgedFluids.galu, "Molten Galu");
        addFluid(TinkersReforgedFluids.coal, "Liquid Coal");
        addFluid(TinkersReforgedFluids.magma_steel, "Molten Magma Steel");
        addFluid(TinkersReforgedFluids.cyber_steel, "Molten Cyber Steel");
        addFluid(TinkersReforgedFluids.hureaulite, "Molten Hureaulite");
        addFluid(TinkersReforgedFluids.red_beryl, "Molten Red Beryl");
        addFluid(TinkersReforgedFluids.gelot, "Molten Gelot");
        addFluid(TinkersReforgedFluids.piroot, "Molten Piroot");

        add(TinkersReforgedFluids.redstone.get().getBucket(), "Liquid Redstone Bucket");
        add(TinkersReforgedFluids.duralumin.get().getBucket(), "Molten Duralumin Bucket");
        add(TinkersReforgedFluids.electrical_copper.get().getBucket(), "Molten Electrical Copper Bucket");
        add(TinkersReforgedFluids.lavium.get().getBucket(), "Molten Lavium Bucket");
        add(TinkersReforgedFluids.qivium.get().getBucket(), "Molten Qivium Bucket");
        add(TinkersReforgedFluids.gausum.get().getBucket(), "Molten Gausum Bucket");
        add(TinkersReforgedFluids.lapis.get().getBucket(), "Molten Lapis Bucket");
        add(TinkersReforgedFluids.blazing_copper.get().getBucket(), "Molten Blazing Copper Bucket");
        add(TinkersReforgedFluids.felsteel.get().getBucket(), "Molten Felsteel Bucket");
        add(TinkersReforgedFluids.kepu.get().getBucket(), "Molten Kepu Bucket");
        add(TinkersReforgedFluids.chorus_metal.get().getBucket(), "Molten Chorus Metal Bucket");
        add(TinkersReforgedFluids.chorus.get().getBucket(), "Molten Chorus Bucket");
        add(TinkersReforgedFluids.shulker.get().getBucket(), "Molten Shulker Bucket");
        add(TinkersReforgedFluids.durasteel.get().getBucket(), "Molten Durasteel Bucket");
        add(TinkersReforgedFluids.kelp.get().getBucket(), "Molten Kelp Bucket");
        add(TinkersReforgedFluids.crusteel.get().getBucket(), "Molten Crusteel Bucket");
        add(TinkersReforgedFluids.wavy.get().getBucket(), "Molten Wavy Bucket");
        add(TinkersReforgedFluids.yokel.get().getBucket(), "Molten Yokel Bucket");
        add(TinkersReforgedFluids.proto_lava.get().getBucket(), "Molten Proto Lava Bucket");
        add(TinkersReforgedFluids.baolian.get().getBucket(), "Molten Baolian Bucket");
        add(TinkersReforgedFluids.epidote.get().getBucket(), "Molten Epidote Bucket");
        add(TinkersReforgedFluids.galu.get().getBucket(), "Molten Galu Bucket");
        add(TinkersReforgedFluids.coal.get().getBucket(), "Liquid Coal Bucket");
        add(TinkersReforgedFluids.magma_steel.get().getBucket(), "Molten Magma Steel Bucket");
        add(TinkersReforgedFluids.cyber_steel.get().getBucket(), "Molten Cyber Steel Bucket");
        add(TinkersReforgedFluids.hureaulite.get().getBucket(), "Molten Hureaulite Bucket");
        add(TinkersReforgedFluids.red_beryl.get().getBucket(), "Molten Red Beryl Bucket");
        add(TinkersReforgedFluids.gelot.get().getBucket(), "Molten Gelot Bucket");
        add(TinkersReforgedFluids.piroot.get().getBucket(), "Molten Piroot Bucket");

        addEffect(TinkersReforgedPotions.FREEZE, "Freeze");

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
        addItem(object.getGoldCast(), capitalize(object.getName().getPath())+ " Gold Cast");
        addItem(object.getSandCast(), capitalize(object.getName().getPath())+ " Sand Cast");
        addItem(object.getRedSandCast(), capitalize(object.getName().getPath())+ " Red Sand Cast");
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
