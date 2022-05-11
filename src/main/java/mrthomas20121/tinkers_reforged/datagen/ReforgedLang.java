package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.CastType;
import mrthomas20121.tinkers_reforged.init.*;
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
        addBlock(TinkersReforgedBlocks.aluminum_block, "Aluminum Block");
        addBlock(TinkersReforgedBlocks.aluminum_ore, "Aluminum Ore");
        addItem(TinkersReforgedItems.aluminum_dust, "Aluminum Dust");
        addItem(TinkersReforgedItems.aluminum_ingot, "Aluminum Ingot");
        addItem(TinkersReforgedItems.aluminum_nugget, "Aluminum Nugget");
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

        addFluid(TinkersReforgedFluids.redstone, "Liquid Redstone");
        addFluid(TinkersReforgedFluids.duralumin, "Molten Duralumin");
        addFluid(TinkersReforgedFluids.electrical_copper, "Molten Electrical Copper");
        addFluid(TinkersReforgedFluids.lavium, "Molten Lavium");
        addFluid(TinkersReforgedFluids.qivium, "Molten Qivium");
        addFluid(TinkersReforgedFluids.blazing_copper, "Molten Blazing Copper");
        addFluid(TinkersReforgedFluids.gausum, "Molten Gausum");
        addFluid(TinkersReforgedFluids.lapis, "Molten Lapis");

        add(TinkersReforgedFluids.redstone.get().getBucket(), "Liquid Redstone Bucket");
        add(TinkersReforgedFluids.duralumin.get().getBucket(), "Molten Duralumin Bucket");
        add(TinkersReforgedFluids.electrical_copper.get().getBucket(), "Molten Electrical Copper Bucket");
        add(TinkersReforgedFluids.lavium.get().getBucket(), "Molten Lavium Bucket");
        add(TinkersReforgedFluids.qivium.get().getBucket(), "Molten Qivium Bucket");
        add(TinkersReforgedFluids.gausum.get().getBucket(), "Molten Gausum Bucket");
        add(TinkersReforgedFluids.lapis.get().getBucket(), "Molten Lapis Bucket");
        add(TinkersReforgedFluids.blazing_copper.get().getBucket(), "Molten Blazing Copper Bucket");
        add("effect.tinkers_reforged.electro_web", "Electro Web");

        for(CastType type: CastType.values()) {
            Item item = TinkersReforgedItems.casts.get(type).get();
            add(item, String.format("%s Aluminum Cast", capitalize(type.name().toLowerCase())));
        }

        addMaterial(ReforgedMaterials.duralumin, "Duralumin", "One of the earliest types of age-hardenable aluminum alloys", "German metal");
        addMaterial(ReforgedMaterials.electrical_copper, "Electrical Copper", "It's not as electric as people think", "Copper that was Electrified");
        addMaterial(ReforgedMaterials.lavium, "Lavium", "Cobalt Alloy", "Strong Cobalt Alloy");
        addMaterial(ReforgedMaterials.qivium, "Qivium", "Cobalt Alloy", "Strong Cobalt Alloy");
        addMaterial(ReforgedMaterials.gausum, "Gausum", "Ancient Debris Alloy", "Strong Ancient Debris Alloy");

        addModifier(TinkersReforgedModifiers.gausum_titanic_damage, "Titanic Damage", "that's a lot of damage!", "Deal more damage to enemy with more HP than you.");
        addModifier(TinkersReforgedModifiers.lavium_aridzone, "Arid Zone", "That's quite hot!", "Increase mining speed and damage in hot/arid area");
        addModifier(TinkersReforgedModifiers.duralumin_ultra_durable, "Ultra Durable", "Brought back Duritos from Tinkers 1.12", "Your tool last longer most of the time.");
        addModifier(TinkersReforgedModifiers.electrical_copper_electro_web, "Electro Web", "Shocking isn't it?", "Apply Electro Web to an entity after hit.");
       addModifier(TinkersReforgedModifiers.qivium_firestarter, "Firestarter", "More Fire!", "Attacks increases fire duration.");
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
