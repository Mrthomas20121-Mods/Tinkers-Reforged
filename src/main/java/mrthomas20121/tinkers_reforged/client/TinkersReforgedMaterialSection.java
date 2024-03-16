package mrthomas20121.tinkers_reforged.client;

import com.google.common.collect.ImmutableSet;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import slimeknights.tconstruct.library.client.book.sectiontransformer.materials.AbstractMaterialSectionTransformer;
import slimeknights.tconstruct.library.materials.MaterialRegistry;
import slimeknights.tconstruct.library.materials.definition.IMaterial;
import slimeknights.tconstruct.library.materials.stats.IMaterialStats;
import slimeknights.tconstruct.library.materials.stats.MaterialStatsId;
import slimeknights.tconstruct.tools.stats.ExtraMaterialStats;
import slimeknights.tconstruct.tools.stats.HandleMaterialStats;
import slimeknights.tconstruct.tools.stats.HeadMaterialStats;

import javax.annotation.Nonnull;
import java.util.Set;

public class TinkersReforgedMaterialSection extends AbstractMaterialSectionTransformer {

    private static final Set<MaterialStatsId> VISIBLE_STATS = ImmutableSet.of(HeadMaterialStats.ID, HandleMaterialStats.ID, ExtraMaterialStats.ID);

    public TinkersReforgedMaterialSection() {
        super("tinkers_reforged_materials", false);
    }

    @Override
    protected boolean isValidMaterial(@Nonnull IMaterial material) {
        for (IMaterialStats stats : MaterialRegistry.getInstance().getAllStats(material.getIdentifier())) {
            if (VISIBLE_STATS.contains(stats.getIdentifier())) {
                return material.getIdentifier().getNamespace().equals(TinkersReforged.MOD_ID);
            }
        }
        return false;
    }
}
