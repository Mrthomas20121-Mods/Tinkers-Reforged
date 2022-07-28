package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedModifiers;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.tools.data.material.MaterialIds;
import slimeknights.tconstruct.tools.stats.ExtraMaterialStats;
import slimeknights.tconstruct.tools.stats.HandleMaterialStats;
import slimeknights.tconstruct.tools.stats.HeadMaterialStats;

import javax.annotation.Nonnull;

import static net.minecraft.world.item.Tiers.*;

public class ReforgedMaterials extends AbstractMaterialDataProvider {

    public static final MaterialId duralumin = createMaterial("duralumin");
    public static final MaterialId electrical_copper = createMaterial("electrical_copper");
    public static final MaterialId lavium = createMaterial("lavium");
    public static final MaterialId qivium = createMaterial("qivium");
    public static final MaterialId gausum = createMaterial("gausum");
    public static final MaterialId felsteel = createMaterial("felsteel");
    public static final MaterialId chorus_metal = createMaterial("chorus_metal");
    public static final MaterialId kepu = createMaterial("kepu");
    public static final MaterialId durasteel = createMaterial("durasteel");
    public static final MaterialId crusteel = createMaterial("crusteel");
    public static final MaterialId wavy = createMaterial("wavy");
    public static final MaterialId yokel = createMaterial("yokel");
    public static final MaterialId ender_bone = createMaterial("ender_bone");

    private static MaterialId createMaterial(String name) {
        return new MaterialId(new ResourceLocation(TinkersReforged.MOD_ID, name));
    }

    public ReforgedMaterials(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void addMaterials() {
        addMaterial(duralumin, 3, ORDER_HARVEST, false);
        addMaterial(electrical_copper, 3, ORDER_GENERAL, false);
        addMaterial(lavium, 4, ORDER_HARVEST, false);
        addMaterial(qivium, 4, ORDER_WEAPON, false);
        addMaterial(gausum, 4, ORDER_HARVEST, false);
        addMaterial(felsteel, 4, ORDER_HARVEST, false);
        addMaterial(chorus_metal, 4, ORDER_HARVEST, false);
        addMaterial(kepu, 4, ORDER_HARVEST, false);
        addMaterial(durasteel, 4, ORDER_SPECIAL, false);
        addMaterial(crusteel, 4, ORDER_HARVEST, false);
        addMaterial(wavy, 4, ORDER_SPECIAL, false);
        addMaterial(yokel, 4, ORDER_WEAPON, false);
        addMaterial(ender_bone, 2, ORDER_SPECIAL, true);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Tinkers Reforged Materials";
    }

    public static class ReforgedTraits extends AbstractMaterialTraitDataProvider {

        public ReforgedTraits(DataGenerator gen, AbstractMaterialDataProvider materials) {
            super(gen, materials);
        }

        @Override
        protected void addMaterialTraits() {
            addDefaultTraits(qivium, TinkersReforgedModifiers.qivium_blazing_fire);

            addDefaultTraits(lavium, TinkersReforgedModifiers.lavium_aridzone);

            addDefaultTraits(duralumin, TinkersReforgedModifiers.duralumin_ultra_durable);

            addDefaultTraits(electrical_copper, TinkersReforgedModifiers.electrical_copper_electro_web);

            addDefaultTraits(gausum, TinkersReforgedModifiers.gausum_titanic_damage);

            addDefaultTraits(felsteel, TinkersReforgedModifiers.felsteel_fel_debris);

            addDefaultTraits(chorus_metal, TinkersReforgedModifiers.chorus_metal_levitating_blob);

            addDefaultTraits(kepu, TinkersReforgedModifiers.kepu_damage_lock);

            addDefaultTraits(durasteel, TinkersReforgedModifiers.durasteel_adapting);

            addDefaultTraits(wavy, TinkersReforgedModifiers.spore_shot);

            addDefaultTraits(crusteel, TinkersReforgedModifiers.giant_cells);

            addDefaultTraits(yokel, TinkersReforgedModifiers.terra);

            addDefaultTraits(ender_bone, TinkersReforgedModifiers.collapsed);
        }

        @Nonnull
        @Override
        public String getName() {
            return "Tinkers Reforged Material Traits";
        }
    }

    public static class ReforgedMaterialStats extends AbstractMaterialStatsDataProvider {

        public ReforgedMaterialStats(DataGenerator gen, AbstractMaterialDataProvider materials) {
            super(gen, materials);
        }

        @Nonnull
        @Override
        public String getName() {
            return "Tinkers Reforged Material Stats";
        }

        @Override
        protected void addMaterialStats() {

            addMaterialStats(qivium,
                    new HeadMaterialStats(900, 5f, DIAMOND, 3.9f),
                    HandleMaterialStats.DEFAULT.withAttackSpeed(1.05f),
                    ExtraMaterialStats.DEFAULT);

            addMaterialStats(lavium,
                    new HeadMaterialStats(900, 7.5f, DIAMOND, 2.25f),
                    HandleMaterialStats.DEFAULT.withMiningSpeed(1.05f),
                    ExtraMaterialStats.DEFAULT);

            addMaterialStats(gausum,
                    new HeadMaterialStats(1150, 7.4f, DIAMOND, 3.1f),
                    HandleMaterialStats.DEFAULT.withDurability(1.01f).withMiningSpeed(1.01f).withAttackSpeed(1.01f),
                    ExtraMaterialStats.DEFAULT);

            addMaterialStats(felsteel,
                    new HeadMaterialStats(1000, 6f, NETHERITE, 3.8f),
                    HandleMaterialStats.DEFAULT.withDurability(0.95f).withMiningSpeed(0.9f).withAttackSpeed(1.2f),
                    ExtraMaterialStats.DEFAULT);

            addMaterialStats(chorus_metal,
                    new HeadMaterialStats(700, 5f, NETHERITE, 3f),
                    HandleMaterialStats.DEFAULT.withDurability(0.9f).withMiningSpeed(1.11f).withAttackSpeed(0.8f),
                    ExtraMaterialStats.DEFAULT);

            addMaterialStats(kepu,
                    new HeadMaterialStats(690, 4f, NETHERITE, 3.5f),
                    HandleMaterialStats.DEFAULT.withDurability(2.01f).withAttackSpeed(0.9f),
                    ExtraMaterialStats.DEFAULT);

            addMaterialStats(duralumin,
                    new HeadMaterialStats(550, 7f, DIAMOND, 3f),
                    HandleMaterialStats.DEFAULT.withDurability(1.04f),
                    ExtraMaterialStats.DEFAULT);

            // electrical copper is iron with a bit more durability and have a better mining level
            addMaterialStats(electrical_copper,
                    new HeadMaterialStats(400, 6f, DIAMOND, 2f),
                    HandleMaterialStats.DEFAULT.withDurability(0.9f),
                    ExtraMaterialStats.DEFAULT);

            addMaterialStats(durasteel,
                    new HeadMaterialStats(1400, 4f, NETHERITE, 3.7f),
                    HandleMaterialStats.DEFAULT.withDurability(0.99f).withAttackSpeed(1.02f),
                    ExtraMaterialStats.DEFAULT);

            addMaterialStats(crusteel,
                    new HeadMaterialStats(850, 6.6f, NETHERITE, 3.25f),
                    HandleMaterialStats.DEFAULT.withDurability(1.02f).withAttackDamage(1.02f),
                    ExtraMaterialStats.DEFAULT);

            addMaterialStats(wavy,
                    new HeadMaterialStats(800, 6.9f, NETHERITE, 3.8f),
                    HandleMaterialStats.DEFAULT.withDurability(0.95f).withMiningSpeed(0.75f),
                    ExtraMaterialStats.DEFAULT);

            addMaterialStats(yokel,
                    new HeadMaterialStats(900, 5.55f, DIAMOND, 3.55f),
                    HandleMaterialStats.DEFAULT.withDurability(1.09f),
                    ExtraMaterialStats.DEFAULT);

            addMaterialStats(ender_bone,
                    new HeadMaterialStats(150, 2.5f, STONE, 1.25f),
                    HandleMaterialStats.DEFAULT.withDurability(0.75f).withAttackSpeed(1.1f),
                    ExtraMaterialStats.DEFAULT);
        }
    }
}
