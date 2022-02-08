package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.Traits;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.tools.stats.ExtraMaterialStats;
import slimeknights.tconstruct.tools.stats.HandleMaterialStats;
import slimeknights.tconstruct.tools.stats.HeadMaterialStats;

import javax.annotation.Nonnull;

public class ReforgedMaterials extends AbstractMaterialDataProvider {

    public static final MaterialId aluminum = createMaterial("aluminum");
    public static final MaterialId duralumin = createMaterial("duralumin");
    public static final MaterialId electrical_copper = createMaterial("electrical_copper");
    public static final MaterialId lavium = createMaterial("lavium");
    public static final MaterialId qivium = createMaterial("qivium");

    private static MaterialId createMaterial(String name) {
        return new MaterialId(new ResourceLocation(TinkersReforged.MOD_ID, name));
    }

    public ReforgedMaterials(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void addMaterials() {
        addMaterial(aluminum, 2, ORDER_GENERAL, false, 0xD6E1E4);
        addMaterial(duralumin, 3, ORDER_HARVEST, false, 0xD1F1C1);
        addMaterial(electrical_copper, 3, ORDER_GENERAL, false, 0xE0B475);
        addMaterial(lavium, 4, ORDER_HARVEST, false, 0x81B366);
        addMaterial(qivium, 4, ORDER_WEAPON, false, 0xFF8F84);
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
            addTraits(qivium, ExtraMaterialStats.ID, Traits.qivium_firestarter.get());
            addTraits(qivium, ExtraMaterialStats.ID, Traits.qivium_sunfire_blessing.get());
        }

        @Override
        public String getName() {
            return "Tinkers Reforged Material Traits";
        }


    }
}
