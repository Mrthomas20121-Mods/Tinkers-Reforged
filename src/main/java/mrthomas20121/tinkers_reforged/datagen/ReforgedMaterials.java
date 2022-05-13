package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedModifiers;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.tools.stats.ExtraMaterialStats;
import slimeknights.tconstruct.tools.stats.HandleMaterialStats;
import slimeknights.tconstruct.tools.stats.HeadMaterialStats;

import javax.annotation.Nonnull;

import static net.minecraft.world.item.Tiers.DIAMOND;
import static net.minecraft.world.item.Tiers.NETHERITE;

public class ReforgedMaterials extends AbstractMaterialDataProvider {

    public static final MaterialId duralumin = createMaterial("duralumin");
    public static final MaterialId electrical_copper = createMaterial("electrical_copper");
    public static final MaterialId lavium = createMaterial("lavium");
    public static final MaterialId qivium = createMaterial("qivium");
    public static final MaterialId gausum = createMaterial("gausum");
    public static final MaterialId felsteel = createMaterial("felsteel");
    public static final MaterialId chorus_metal = createMaterial("chorus_metal");
    public static final MaterialId kepu = createMaterial("kepu");

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

            addDefaultTraits(kepu, TinkersReforgedModifiers.gausum_titanic_damage);
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
                    new HeadMaterialStats(600, 5f, DIAMOND, 5f),
                    HandleMaterialStats.DEFAULT.withDurability(1.05f).withMiningSpeed(1.05f).withAttackSpeed(1.05f),
                    ExtraMaterialStats.DEFAULT);

            addMaterialStats(lavium,
                    new HeadMaterialStats(600, 7.5f, DIAMOND, 2.25f),
                    HandleMaterialStats.DEFAULT.withDurability(1.05f).withMiningSpeed(1.05f).withAttackSpeed(1.05f),
                    ExtraMaterialStats.DEFAULT);

            addMaterialStats(gausum,
                    new HeadMaterialStats(1200, 7.4f, DIAMOND, 3f),
                    HandleMaterialStats.DEFAULT.withDurability(2f).withMiningSpeed(1.05f).withAttackSpeed(1.05f),
                    ExtraMaterialStats.DEFAULT);

            addMaterialStats(felsteel,
                    new HeadMaterialStats(1300, 6f, NETHERITE, 4f),
                    HandleMaterialStats.DEFAULT.withDurability(2.01f).withMiningSpeed(1.01f).withAttackSpeed(1.2f),
                    ExtraMaterialStats.DEFAULT);

            addMaterialStats(chorus_metal,
                    new HeadMaterialStats(900, 5f, NETHERITE, 5f),
                    HandleMaterialStats.DEFAULT.withDurability(2.01f).withMiningSpeed(1.01f).withAttackSpeed(1.2f),
                    ExtraMaterialStats.DEFAULT);

            addMaterialStats(kepu,
                    new HeadMaterialStats(600, 4f, NETHERITE, 6f),
                    HandleMaterialStats.DEFAULT.withDurability(2.01f).withMiningSpeed(1.01f).withAttackSpeed(1.2f),
                    ExtraMaterialStats.DEFAULT);

            addMaterialStats(duralumin,
                    new HeadMaterialStats(500, 7f, DIAMOND, 3f),
                    HandleMaterialStats.DEFAULT.withDurability(1.40f),
                    ExtraMaterialStats.DEFAULT);

            // electrical copper is iron with a bit more durability and have a better mining level
            addMaterialStats(electrical_copper,
                    new HeadMaterialStats(300, 6f, DIAMOND, 2f),
                    HandleMaterialStats.DEFAULT.withDurability(1.20f),
                    ExtraMaterialStats.DEFAULT);
        }
    }
}
