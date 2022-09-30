package mrthomas20121.tinkers_reforged.datagen.tcon;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.tools.stats.ExtraMaterialStats;
import slimeknights.tconstruct.tools.stats.HandleMaterialStats;
import slimeknights.tconstruct.tools.stats.HeadMaterialStats;

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

        addMaterialStats(ReforgedMaterialIds.aluminum,
                new HeadMaterialStats(210, 5.0f, IRON, 0.5f),
                HandleMaterialStats.DEFAULT.withDurability(0.90f).withMiningSpeed(1.1f).withAttackDamage(1.05f),
                ExtraMaterialStats.DEFAULT);

        addMaterialStats(ReforgedMaterialIds.blazing_copper,
                new HeadMaterialStats(210, 5.0f, DIAMOND, 0.5f),
                HandleMaterialStats.DEFAULT.withDurability(0.80f).withMiningSpeed(1.1f).withAttackDamage(1.05f),
                ExtraMaterialStats.DEFAULT);

        addMaterialStats(ReforgedMaterialIds.qivium,
                new HeadMaterialStats(900, 5.5f, DIAMOND, 4f),
                HandleMaterialStats.DEFAULT.withAttackSpeed(1.05f),
                ExtraMaterialStats.DEFAULT);

        addMaterialStats(ReforgedMaterialIds.lavium,
                new HeadMaterialStats(900, 7.5f, DIAMOND, 2.25f),
                HandleMaterialStats.DEFAULT.withMiningSpeed(1.05f),
                ExtraMaterialStats.DEFAULT);

        addMaterialStats(ReforgedMaterialIds.gausum,
                new HeadMaterialStats(1150, 7.4f, DIAMOND, 3.1f),
                HandleMaterialStats.DEFAULT.withDurability(1.01f).withMiningSpeed(1.01f).withAttackSpeed(1.01f),
                ExtraMaterialStats.DEFAULT);

        addMaterialStats(ReforgedMaterialIds.felsteel,
                new HeadMaterialStats(1000, 6f, NETHERITE, 3.8f),
                HandleMaterialStats.DEFAULT.withDurability(0.95f).withMiningSpeed(0.9f).withAttackSpeed(1.2f),
                ExtraMaterialStats.DEFAULT);

        addMaterialStats(ReforgedMaterialIds.chorus_metal,
                new HeadMaterialStats(700, 5.7f, NETHERITE, 2.99f),
                HandleMaterialStats.DEFAULT.withDurability(0.9f).withMiningSpeed(1.11f).withAttackSpeed(0.8f),
                ExtraMaterialStats.DEFAULT);

        addMaterialStats(ReforgedMaterialIds.kepu,
                new HeadMaterialStats(690, 4.7f, NETHERITE, 3.5f),
                HandleMaterialStats.DEFAULT.withDurability(2.01f).withAttackSpeed(0.9f),
                ExtraMaterialStats.DEFAULT);

        addMaterialStats(ReforgedMaterialIds.duralumin,
                new HeadMaterialStats(550, 7f, DIAMOND, 3f),
                HandleMaterialStats.DEFAULT.withDurability(1.04f),
                ExtraMaterialStats.DEFAULT);

        // electrical copper is iron with a bit more durability and have a better mining level
        addMaterialStats(ReforgedMaterialIds.electrical_copper,
                new HeadMaterialStats(400, 6f, DIAMOND, 2f),
                HandleMaterialStats.DEFAULT.withDurability(0.9f),
                ExtraMaterialStats.DEFAULT);

        addMaterialStats(ReforgedMaterialIds.durasteel,
                new HeadMaterialStats(1400, 5.3f, NETHERITE, 3.7f),
                HandleMaterialStats.DEFAULT.withDurability(0.99f).withAttackSpeed(1.02f),
                ExtraMaterialStats.DEFAULT);

        addMaterialStats(ReforgedMaterialIds.crusteel,
                new HeadMaterialStats(850, 6.6f, NETHERITE, 3.25f),
                HandleMaterialStats.DEFAULT.withDurability(1.02f).withAttackDamage(1.02f),
                ExtraMaterialStats.DEFAULT);

        addMaterialStats(ReforgedMaterialIds.wavy,
                new HeadMaterialStats(800, 6.9f, NETHERITE, 3.8f),
                HandleMaterialStats.DEFAULT.withDurability(0.95f).withMiningSpeed(0.75f),
                ExtraMaterialStats.DEFAULT);

        addMaterialStats(ReforgedMaterialIds.yokel,
                new HeadMaterialStats(900, 5.55f, DIAMOND, 3.55f),
                HandleMaterialStats.DEFAULT.withDurability(1.09f),
                ExtraMaterialStats.DEFAULT);

        addMaterialStats(ReforgedMaterialIds.baolian,
                new HeadMaterialStats(800, 6.5f, DIAMOND, 3f),
                HandleMaterialStats.DEFAULT.withDurability(1.1f),
                ExtraMaterialStats.DEFAULT);

        addMaterialStats(ReforgedMaterialIds.epidote,
                new HeadMaterialStats(550, 5.6f, DIAMOND, 2.2f),
                HandleMaterialStats.DEFAULT.withAttackDamage(1.1f),
                ExtraMaterialStats.DEFAULT);

        addMaterialStats(ReforgedMaterialIds.galu,
                new HeadMaterialStats(600, 6.8f, DIAMOND, 3.1f),
                HandleMaterialStats.DEFAULT.withDurability(0.8f),
                ExtraMaterialStats.DEFAULT);

        addMaterialStats(ReforgedMaterialIds.hureaulite,
                new HeadMaterialStats(550, 5.6f, DIAMOND, 2.2f),
                HandleMaterialStats.DEFAULT.withMiningSpeed(1.1f),
                ExtraMaterialStats.DEFAULT);

        addMaterialStats(ReforgedMaterialIds.red_beryl,
                new HeadMaterialStats(500, 5.5f, DIAMOND, 2.1f),
                HandleMaterialStats.DEFAULT.withAttackSpeed(1.1f),
                ExtraMaterialStats.DEFAULT);

        addMaterialStats(ReforgedMaterialIds.ender_bone,
                new HeadMaterialStats(150, 2.5f, STONE, 1.25f),
                HandleMaterialStats.DEFAULT.withDurability(0.75f).withAttackSpeed(1.1f),
                ExtraMaterialStats.DEFAULT);

        addMaterialStats(ReforgedMaterialIds.magma_steel,
                new HeadMaterialStats(1200, 7f, DIAMOND, 3f),
                HandleMaterialStats.DEFAULT.withAttackSpeed(1.15f),
                ExtraMaterialStats.DEFAULT);

        addMaterialStats(ReforgedMaterialIds.cyber_steel,
                new HeadMaterialStats(1200, 7f, NETHERITE, 3f),
                HandleMaterialStats.DEFAULT.withAttackSpeed(1.15f),
                ExtraMaterialStats.DEFAULT);
    }
}
