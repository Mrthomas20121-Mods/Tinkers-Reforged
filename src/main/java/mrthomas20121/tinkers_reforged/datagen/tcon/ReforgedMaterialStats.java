package mrthomas20121.tinkers_reforged.datagen.tcon;

import mrthomas20121.tinkers_reforged.api.material.EnumMaterial;
import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.tools.stats.*;

import javax.annotation.Nonnull;

import static net.minecraft.world.item.Tiers.*;

public class ReforgedMaterialStats extends AbstractMaterialStatsDataProvider {

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
        for(EnumMaterial material: EnumMaterial.values()) {
            addMaterialStats(material.id, material.stats.stats);
        }
    }
}
