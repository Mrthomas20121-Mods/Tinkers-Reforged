package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.Resources;
import mrthomas20121.tinkers_reforged.init.Traits;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.Modifier;

import java.util.function.Supplier;

public class ReforgedLang extends LanguageProvider {

    public ReforgedLang(DataGenerator gen) {
        super(gen, TinkersReforged.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
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

        addFluid(Resources.duralumin, "Molten Duralumin");
        addFluid(Resources.electrical_copper, "Molten Electrical Copper");
        addFluid(Resources.lavium, "Molten Lavium");
        addFluid(Resources.qivium, "Molten Qivium");

        add(Resources.duralumin.asItem(), "Duralumin Bucket");
        add(Resources.electrical_copper.asItem(), "Electrical Copper Bucket");
        add(Resources.lavium.asItem(), "Lavium Bucket");
        add(Resources.qivium.asItem(), "Qivium Bucket");

        addMaterial(ReforgedMaterials.aluminum, "Aluminum", "Lightweight metal", "Shiny metal");
        addMaterial(ReforgedMaterials.duralumin, "Duralumin", "One of the earliest types of age-hardenable aluminum alloys", "German metal");
        addMaterial(ReforgedMaterials.electrical_copper, "Electrical Copper", "It's not as electric as people think", "Copper that was Electrified");
        addMaterial(ReforgedMaterials.lavium, "Lavium", "Cobalt Alloy", "Strong Cobalt Alloy");
        addMaterial(ReforgedMaterials.qivium, "Qivium", "Ancient Debris Alloy", "Strong Ancient Debris Alloy");

        addModifier(Traits.aluminum_metalic, "Metalic", "Trade of durability for attack/mining speed, worth it?", "Lower durability but higher attack/mining speed");
        addModifier(Traits.aluminum_protective_layer, "Protective Layer", "This create a thin protective layer on your tool", "Double the mining speed underwater to protect against water penality");
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

    public void addFluid(FluidObject<ForgeFlowingFluid> supplier, String name) {
        add(String.format("fluid.%s.%s", TinkersReforged.MOD_ID, supplier.getId().getPath()), name);
    }
}
