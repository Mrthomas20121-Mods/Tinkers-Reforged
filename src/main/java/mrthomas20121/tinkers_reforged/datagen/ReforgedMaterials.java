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

public class ReforgedMaterials extends AbstractMaterialDataProvider {

    public static final MaterialId duralumin = createMaterial("duralumin");
    public static final MaterialId electrical_copper = createMaterial("electrical_copper");
    public static final MaterialId lavium = createMaterial("lavium");
    public static final MaterialId qivium = createMaterial("qivium");
    public static final MaterialId gausum = createMaterial("gausum");

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
            addDefaultTraits(qivium, TinkersReforgedModifiers.qivium_firestarter);

            addDefaultTraits(lavium, TinkersReforgedModifiers.lavium_aridzone);

            addDefaultTraits(duralumin, TinkersReforgedModifiers.duralumin_ultra_durable);

            addDefaultTraits(electrical_copper, TinkersReforgedModifiers.electrical_copper_electro_web);

            addDefaultTraits(gausum, TinkersReforgedModifiers.gausum_titanic_damage);
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
                    new HeadMaterialStats(800, 7.4f, DIAMOND, 3f),
                    HandleMaterialStats.DEFAULT.withDurability(1.05f).withMiningSpeed(1.05f).withAttackSpeed(1.05f),
                    ExtraMaterialStats.DEFAULT);

            addMaterialStats(lavium,
                    new HeadMaterialStats(800, 7.5f, DIAMOND, 2.25f),
                    HandleMaterialStats.DEFAULT.withDurability(1.05f).withMiningSpeed(1.05f).withAttackSpeed(1.05f),
                    ExtraMaterialStats.DEFAULT);

            addMaterialStats(gausum,
                    new HeadMaterialStats(800, 7.4f, DIAMOND, 3f),
                    HandleMaterialStats.DEFAULT.withDurability(2f).withMiningSpeed(1.05f).withAttackSpeed(1.05f),
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
