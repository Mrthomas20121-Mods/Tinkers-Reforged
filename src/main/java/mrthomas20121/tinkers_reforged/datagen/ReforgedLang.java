package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.CastItems;
import mrthomas20121.tinkers_reforged.api.CastType;
import mrthomas20121.tinkers_reforged.api.ReforgedFluid;
import mrthomas20121.tinkers_reforged.init.Resources;
import mrthomas20121.tinkers_reforged.init.Traits;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.RegistryObject;
import org.apache.commons.lang3.StringUtils;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.Modifier;

import java.util.function.Supplier;

public class ReforgedLang extends LanguageProvider {

    public ReforgedLang(DataGenerator gen) {
        super(gen, TinkersReforged.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addGroup("Tinkers Reforged");
        add(Resources.venom_plate.get(), "Venom Plate");
        addBlock(Resources.aluminum_block, "Aluminum Block");
        addBlock(Resources.aluminum_ore, "Aluminum Ore");
        addItem(Resources.aluminum_dust, "Aluminum Dust");
        addItem(Resources.aluminum_ingot, "Aluminum Ingot");
        addItem(Resources.aluminum_nugget, "Aluminum Nugget");
        addBlock(Resources.duralumin_block, "Duralumin Block");
        addItem(Resources.duralumin_dust, "Duralumin Dust");
        addItem(Resources.duralumin_ingot, "Duralumin Ingot");
        addItem(Resources.duralumin_nugget, "Duralumin Nugget");
        addBlock(Resources.electrical_copper_block, "Electrical Copper Block");
        addItem(Resources.electrical_copper_dust, "Electrical Copper Dust");
        addItem(Resources.electrical_copper_ingot, "Electrical Copper Ingot");
        addItem(Resources.electrical_copper_nugget, "Electrical Copper Nugget");
        addBlock(Resources.lavium_block, "Lavium Block");
        addItem(Resources.lavium_dust, "Lavium Dust");
        addItem(Resources.lavium_ingot, "Lavium Ingot");
        addItem(Resources.lavium_nugget, "Lavium Nugget");
        addBlock(Resources.qivium_block, "Qivium Block");
        addItem(Resources.qivium_dust, "Qivium Dust");
        addItem(Resources.qivium_ingot, "Qivium Ingot");
        addItem(Resources.qivium_nugget, "Qivium Nugget");
        addBlock(Resources.gausum_block, "Gausum Block");
        addItem(Resources.gausum_dust, "Gausum Dust");
        addItem(Resources.gausum_ingot, "Gausum Ingot");
        addItem(Resources.gausum_nugget, "Gausum Nugget");

        addFluid(Resources.redstone, "Liquid Redstone");
        addFluid(Resources.duralumin, "Molten Duralumin");
        addFluid(Resources.electrical_copper, "Molten Electrical Copper");
        addFluid(Resources.lavium, "Molten Lavium");
        addFluid(Resources.qivium, "Molten Qivium");
        addFluid(Resources.blazing_copper, "Molten Blazing Copper");
        addFluid(Resources.gausum, "Molten Gausum");
        addFluid(Resources.lapis, "Molten Lapis");

        add(Resources.redstone.getBucket().get(), "Liquid Redstone Bucket");
        add(Resources.duralumin.getBucket().get(), "Molten Duralumin Bucket");
        add(Resources.electrical_copper.getBucket().get(), "Molten Electrical Copper Bucket");
        add(Resources.lavium.getBucket().get(), "Molten Lavium Bucket");
        add(Resources.qivium.getBucket().get(), "Molten Qivium Bucket");
        add(Resources.gausum.getBucket().get(), "Molten Gausum Bucket");
        add(Resources.lapis.getBucket().get(), "Molten Lapis Bucket");
        add(Resources.blazing_copper.getBucket().get(), "Molten Blazing Copper Bucket");

        for(CastType type: CastType.values()) {
            Item item = CastItems.casts.get(type).get();
            add(item, String.format("%s Aluminum Cast", capitalize(type.name().toLowerCase())));
        }

        addMaterial(ReforgedMaterials.duralumin, "Duralumin", "One of the earliest types of age-hardenable aluminum alloys", "German metal");
        addMaterial(ReforgedMaterials.electrical_copper, "Electrical Copper", "It's not as electric as people think", "Copper that was Electrified");
        addMaterial(ReforgedMaterials.lavium, "Lavium", "Cobalt Alloy", "Strong Cobalt Alloy");
        addMaterial(ReforgedMaterials.qivium, "Qivium", "Cobalt Alloy", "Strong Cobalt Alloy");
        addMaterial(ReforgedMaterials.gausum, "Gausum", "Ancient Debris Alloy", "Strong Ancient Debris Alloy");

        addModifier(Traits.duralumin_heat_transfer, "Heat Transfer", "Lava is transfering its softness to the block next to it", "Break a block faster if it is next to lava");
        addModifier(Traits.duralumin_overused, "Overused", "Speed go brr", "Better mining speed at low Durability.");
        addModifier(Traits.duralumin_ultra_durable, "Overused", "Brought back Duritos from Tinkers 1.12", "Your tool last longer most of the time.");
        addModifier(Traits.electrical_copper_electric_damage, "Electrical Damage", "Burst of energy", "Careful! Your tool is full of energy and could damage you anytime.");
        addModifier(Traits.electrical_copper_odin_blessing, "Odin's Blessing", "Odin loved to tell people they were worthy", "Buff each stats by 1.5.");
        addModifier(Traits.electrical_copper_electrostatic, "Electrostatic", "Shocking isn't it?", "You have a chance to \"Shock\" entity when attacking dealing 1/3 of their current hp as damage.");
        addModifier(Traits.lavium_ground_speed, "Ground Speed", "Great Speed sea level", "Mine Faster below sea level.");
        addModifier(Traits.lavium_miner_blessing, "Miner Blessing", "More Ores for the win", "Ore yield more drops.");
        addModifier(Traits.lavium_surface_curse, "Surface Curse", "Never lucky babyrage.", "Your tool lose durability on the surface.");
        addModifier(Traits.qivium_fireplace, "Fireplace", "Burn witch!", "Deal more damage to entities on fire.");
        addModifier(Traits.qivium_firestarter, "Firestarter", "More Fire!", "Attacks increases fire duration.");
        addModifier(Traits.qivium_sunfire_blessing, "Sunfire Blessing", "Fire is good.", "Your tool repair itself while you are on fire.");
        addModifier(Traits.venomous, "Venomous", "Venom is dangerous, i wouldn't bond with it.", "Your tool apply poison on hit with duration that scale on your damage dealt.");
    }

    public void addMaterial(MaterialId material, String name, String flavour, String desc) {
        String id = material.getPath();
        add("material.tinkers_reforged." + id, name);
        if (!flavour.equals(""))
            add("material.tinkers_reforged." + id + ".flavor", flavour);
        if (!desc.equals(""))
            add("material.tinkers_reforged." + id + ".encyclopedia", desc);
    }

    public void addModifier(RegistryObject<Modifier> modifier, String name, String flavour, String desc) {
        String id = modifier.getId().getPath();
        add("modifier.tinkers_reforged." + id, name);
        add("modifier.tinkers_reforged." + id + ".flavor", flavour);
        add("modifier.tinkers_reforged." + id + ".description", desc);
    }

    public void addFluid(ReforgedFluid supplier, String name) {
        add(String.format("fluid.%s.%s", TinkersReforged.MOD_ID, supplier.getFlowingFluid().getId().getPath().replace("_flowing", "")), name);
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
