package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.Traits;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.stats.ExtraMaterialStats;
import slimeknights.tconstruct.tools.stats.HandleMaterialStats;
import slimeknights.tconstruct.tools.stats.HeadMaterialStats;

import javax.annotation.Nonnull;

import static slimeknights.tconstruct.library.utils.HarvestLevels.*;

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
        addMaterial(duralumin, 3, ORDER_HARVEST, false, 0xD1F1C1);
        addMaterial(electrical_copper, 3, ORDER_GENERAL, false, 0xE0B475);
        addMaterial(lavium, 4, ORDER_HARVEST, false, 0x81B366);
        addMaterial(qivium, 4, ORDER_WEAPON, false, 0xFF8F84);
        addMaterial(gausum, 4, ORDER_HARVEST, false, 0x75BCC6);
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
            addTraits(qivium, HeadMaterialStats.ID, Traits.qivium_fireplace.get());
            addTraits(qivium, HandleMaterialStats.ID, Traits.qivium_firestarter.get());
            addTraits(qivium, ExtraMaterialStats.ID, Traits.qivium_firestarter.get(), Traits.qivium_sunfire_blessing.get());

            addTraits(lavium, HeadMaterialStats.ID, Traits.lavium_ground_speed.get(), Traits.lavium_surface_curse.get());
            addTraits(lavium, HandleMaterialStats.ID, Traits.lavium_miner_blessing.get());
            addTraits(lavium, ExtraMaterialStats.ID, Traits.lavium_miner_blessing.get());

            addTraits(duralumin, HeadMaterialStats.ID, Traits.duralumin_ultra_durable.get());
            addTraits(duralumin, HandleMaterialStats.ID, Traits.duralumin_overused.get());
            addTraits(duralumin, ExtraMaterialStats.ID, Traits.duralumin_heat_transfer.get(), Traits.duralumin_overused.get());

            addTraits(electrical_copper, HeadMaterialStats.ID, Traits.electrical_copper_electrostatic.get(), Traits.electrical_copper_electric_damage.get());
            addTraits(electrical_copper, HandleMaterialStats.ID, Traits.electrical_copper_odin_blessing.get());
            addTraits(electrical_copper, ExtraMaterialStats.ID, Traits.electrical_copper_electric_damage.get());

            addDefaultTraits(gausum, Traits.magical_shrink.get());
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
