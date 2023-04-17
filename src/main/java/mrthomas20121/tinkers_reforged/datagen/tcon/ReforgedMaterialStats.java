package mrthomas20121.tinkers_reforged.datagen.tcon;

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

        //addMaterialStats(ReforgedMaterialIds.aluminum,
        //        new HeadMaterialStats(210, 5.0f, IRON, 0.5f),
        //        HandleMaterialStats.DEFAULT.withDurability(0.90f).withMiningSpeed(1.1f).withAttackDamage(1.05f),
        //        ExtraMaterialStats.DEFAULT);

        addMaterialStats(ReforgedMaterialIds.blazing_copper,
                new HeadMaterialStats(210, 5.0f, DIAMOND, 0.5f),
                HandleMaterialStats.DEFAULT.withDurability(0.80f).withMiningSpeed(1.1f).withAttackDamage(1.05f),
                ExtraMaterialStats.DEFAULT,
                new LimbMaterialStats(210, 1, -0.1f, 0.1f),
                new GripMaterialStats(1.1f, 0.2f, 0.5f));

        addMaterialStats(ReforgedMaterialIds.qivium,
                new HeadMaterialStats(900, 5.5f, DIAMOND, 4f),
                HandleMaterialStats.DEFAULT.withAttackSpeed(1.05f),
                ExtraMaterialStats.DEFAULT,
                new LimbMaterialStats(900, -0.05f, 0.5f, 0.3f),
                new GripMaterialStats(1.3f, 0.3f, 1.3f));

        addMaterialStats(ReforgedMaterialIds.lavium,
                new HeadMaterialStats(900, 7.5f, DIAMOND, 2.25f),
                HandleMaterialStats.DEFAULT.withMiningSpeed(1.05f),
                ExtraMaterialStats.DEFAULT,
                new LimbMaterialStats(900, 0.5f, -0.05f, 0.3f),
                new GripMaterialStats(1.3f, 0.5f, 1.3f));

        addMaterialStats(ReforgedMaterialIds.gausum,
                new HeadMaterialStats(1150, 7.4f, DIAMOND, 3.1f),
                HandleMaterialStats.DEFAULT.withDurability(1.01f).withMiningSpeed(1.01f).withAttackSpeed(1.01f),
                ExtraMaterialStats.DEFAULT,
                new LimbMaterialStats(1150, 0.3f, 0.3f, 0.05f),
                new GripMaterialStats(1.4f, 0.3f, 1f));

        addMaterialStats(ReforgedMaterialIds.felsteel,
                new HeadMaterialStats(1000, 6f, NETHERITE, 3.8f),
                HandleMaterialStats.DEFAULT.withDurability(0.95f).withMiningSpeed(0.9f).withAttackSpeed(1.2f),
                ExtraMaterialStats.DEFAULT,
                new LimbMaterialStats(1000, -0.05f, -0.01f, 0.5f),
                new GripMaterialStats(1.4f, -0.05f, 1.2f));

        addMaterialStats(ReforgedMaterialIds.chorus_metal,
                new HeadMaterialStats(700, 5.7f, NETHERITE, 2.99f),
                HandleMaterialStats.DEFAULT.withDurability(0.9f).withMiningSpeed(1.11f).withAttackSpeed(0.8f),
                ExtraMaterialStats.DEFAULT,
                new LimbMaterialStats(700, 1f, -0.05f, 0.1f),
                new GripMaterialStats(1.3f, 0.1f, 1.2f));

        addMaterialStats(ReforgedMaterialIds.kepu,
                new HeadMaterialStats(690, 4.7f, NETHERITE, 3.5f),
                HandleMaterialStats.DEFAULT.withDurability(2.01f).withAttackSpeed(0.9f),
                ExtraMaterialStats.DEFAULT,
                new LimbMaterialStats(690, 0.05f, 0.8f, -0.03f),
                new GripMaterialStats(1.6f, -0.03f, 1.1f));

        addMaterialStats(ReforgedMaterialIds.duralumin,
                new HeadMaterialStats(550, 7f, DIAMOND, 3f),
                HandleMaterialStats.DEFAULT.withDurability(1.04f),
                ExtraMaterialStats.DEFAULT,
                new LimbMaterialStats(550, 0.5f, -0.5f, 0.5f),
                new GripMaterialStats(1.6f, 0.5f, 1.9f));

        // electrical copper is iron with a bit more durability and have a better mining level
        addMaterialStats(ReforgedMaterialIds.electrical_copper,
                new HeadMaterialStats(400, 6f, DIAMOND, 2f),
                HandleMaterialStats.DEFAULT.withDurability(0.9f),
                ExtraMaterialStats.DEFAULT,
                new LimbMaterialStats(400, -0.01f, 0.1f, 0.09f),
                new GripMaterialStats(0.9f, -0.05f, 2f));

        addMaterialStats(ReforgedMaterialIds.durasteel,
                new HeadMaterialStats(1400, 5.3f, NETHERITE, 3.7f),
                HandleMaterialStats.DEFAULT.withDurability(0.99f).withAttackSpeed(1.02f),
                ExtraMaterialStats.DEFAULT,
                new LimbMaterialStats(1400, -0.05f, -0.05f, 1f),
                new GripMaterialStats(1.2f, 0.1f, 2.1f));

        addMaterialStats(ReforgedMaterialIds.crusteel,
                new HeadMaterialStats(850, 6.6f, NETHERITE, 3.25f),
                HandleMaterialStats.DEFAULT.withDurability(1.02f).withAttackDamage(1.02f),
                ExtraMaterialStats.DEFAULT,
                new LimbMaterialStats(850, 0.09f, -0.05f, 1.1f),
                new GripMaterialStats(1.3f, 1.1f, 1f));

        addMaterialStats(ReforgedMaterialIds.wavy,
                new HeadMaterialStats(800, 6.9f, NETHERITE, 3.8f),
                HandleMaterialStats.DEFAULT.withDurability(0.95f).withMiningSpeed(0.75f),
                ExtraMaterialStats.DEFAULT,
                new LimbMaterialStats(800, 0.05f, -0.05f, 0.7f),
                new GripMaterialStats(0.9f, 0.6f, 1.5f));

        addMaterialStats(ReforgedMaterialIds.yokel,
                new HeadMaterialStats(900, 5.55f, DIAMOND, 3.55f),
                HandleMaterialStats.DEFAULT.withDurability(1.09f),
                ExtraMaterialStats.DEFAULT,
                new LimbMaterialStats(900, 2f, -0.5f, -0.03f),
                new GripMaterialStats(1f, -0.03f, 3f));

        addMaterialStats(ReforgedMaterialIds.baolian,
                new HeadMaterialStats(800, 6.5f, DIAMOND, 3f),
                HandleMaterialStats.DEFAULT.withDurability(1.1f),
                ExtraMaterialStats.DEFAULT,
                new LimbMaterialStats(800, 3f, -0.5f, 0f),
                new GripMaterialStats(1.5f, 0f, 1f));

        addMaterialStats(ReforgedMaterialIds.epidote,
                new HeadMaterialStats(550, 5.6f, DIAMOND, 2.2f),
                HandleMaterialStats.DEFAULT.withAttackDamage(1.1f),
                ExtraMaterialStats.DEFAULT,
                new LimbMaterialStats(550, 0.15f, 0.15f, 0.15f),
                new GripMaterialStats(1.1f, 0.15f, 2f));

        addMaterialStats(ReforgedMaterialIds.galu,
                new HeadMaterialStats(600, 6.8f, DIAMOND, 3.1f),
                HandleMaterialStats.DEFAULT.withDurability(0.8f),
                ExtraMaterialStats.DEFAULT,
                new LimbMaterialStats(600, -0.05f, 0.2f, 0.5f),
                new GripMaterialStats(1.2f, 0.5f, 1.5f));

        addMaterialStats(ReforgedMaterialIds.hureaulite,
                new HeadMaterialStats(550, 5.6f, DIAMOND, 2.2f),
                HandleMaterialStats.DEFAULT.withMiningSpeed(1.1f),
                ExtraMaterialStats.DEFAULT,
                new LimbMaterialStats(550, 0.9f, 0.09f, 0.9f),
                new GripMaterialStats(0.9f, 0.9f, 0.9f));

        addMaterialStats(ReforgedMaterialIds.red_beryl,
                new HeadMaterialStats(500, 5.5f, DIAMOND, 2.1f),
                HandleMaterialStats.DEFAULT.withAttackSpeed(1.1f),
                ExtraMaterialStats.DEFAULT,
                new LimbMaterialStats(500, 0.08f, 0.1f, 0.03f),
                new GripMaterialStats(1f, 1f, 1f));

        addMaterialStats(ReforgedMaterialIds.ender_bone,
                new HeadMaterialStats(150, 2.5f, STONE, 1.25f),
                HandleMaterialStats.DEFAULT.withDurability(0.75f).withAttackSpeed(1.1f),
                ExtraMaterialStats.DEFAULT,
                new LimbMaterialStats(150, 0.05f, 0.05f, -0.3f),
                new GripMaterialStats(0.6f, 0.1f, 2.45f));

        addMaterialStats(ReforgedMaterialIds.magma_steel,
                new HeadMaterialStats(1200, 7f, DIAMOND, 3f),
                HandleMaterialStats.DEFAULT.withAttackSpeed(1.15f),
                ExtraMaterialStats.DEFAULT,
                new LimbMaterialStats(1200, 0.8f, 0.5f, -0.08f),
                new GripMaterialStats(1.6f, -0.08f, 3f));

        addMaterialStats(ReforgedMaterialIds.cyber_steel,
                new HeadMaterialStats(1200, 7f, NETHERITE, 3f),
                HandleMaterialStats.DEFAULT.withAttackSpeed(1.15f),
                ExtraMaterialStats.DEFAULT,
                new LimbMaterialStats(1200, -0.8f, 0.5f, 1.8f),
                new GripMaterialStats(1.6f, 0.08f, 3f));

        addMaterialStats(ReforgedMaterialIds.gelot,
                new HeadMaterialStats(300, 6.2f, DIAMOND, 2.1f),
                HandleMaterialStats.DEFAULT.withDurability(0.9f).withMiningSpeed(0.9f),
                ExtraMaterialStats.DEFAULT,
                new LimbMaterialStats(300, 0.5f, 0.3f, -0.01f),
                new GripMaterialStats(0.6f, 0.5f, 5f));

        addMaterialStats(ReforgedMaterialIds.piroot,
                new HeadMaterialStats(1000, 6.5f, NETHERITE, 2.5f),
                HandleMaterialStats.DEFAULT.withDurability(1.5f).withMiningSpeed(0.9f),
                ExtraMaterialStats.DEFAULT,
                new LimbMaterialStats(1000, -0.1f, 0.4f, 0.01f),
                new GripMaterialStats(0.9f, -0.1f, 5f));
    }
}
