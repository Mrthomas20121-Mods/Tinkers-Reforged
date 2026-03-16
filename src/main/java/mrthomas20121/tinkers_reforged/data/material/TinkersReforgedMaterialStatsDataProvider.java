package mrthomas20121.tinkers_reforged.data.material;

import mrthomas20121.tinkers_reforged.api.data.Metal;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.tools.stats.*;

import static net.minecraft.world.item.Tiers.*;

public class TinkersReforgedMaterialStatsDataProvider extends AbstractMaterialStatsDataProvider {

    public TinkersReforgedMaterialStatsDataProvider(PackOutput packOutput, AbstractMaterialDataProvider materials) {
        super(packOutput, materials);
    }

    @Override
    protected void addMaterialStats() {

        addMeleeHarvest();
        addArmor();
        addRanged();
    }

    private void addRanged() {
        addMaterialStats(Metal.YTTRIUM.asMaterial(),
                new LimbMaterialStats(400, 0.10f, -0.05f, 0.1f),
                new GripMaterialStats(-0.1f, 0.1f, 0.6f));
    }

    private void addArmor() {
        addArmorShieldStats(Metal.SLIMEBRONZE.asMaterial(),
                PlatingMaterialStats.builder().durabilityFactor(14).armor(1, 3, 4, 2), StatlessMaterialStats.MAILLE);

        addArmorShieldStats(Metal.YTTRIUM.asMaterial(),
                PlatingMaterialStats.builder().durabilityFactor(18).armor(2, 4, 5, 2), StatlessMaterialStats.MAILLE);

        addArmorShieldStats(Metal.ASTATINE.asMaterial(),
                PlatingMaterialStats.builder().durabilityFactor(18).armor(2, 4, 6, 2).toughness(1), StatlessMaterialStats.MAILLE);

        addArmorShieldStats(Metal.GRAPHITE.asMaterial(),
                PlatingMaterialStats.builder().durabilityFactor(16).armor(1, 3, 5, 2), StatlessMaterialStats.MAILLE);

        addArmorShieldStats(Metal.BARIUM.asMaterial(),
                PlatingMaterialStats.builder().durabilityFactor(16).armor(2, 4, 6, 3).knockbackResistance(0.10f), StatlessMaterialStats.MAILLE);

        addArmorShieldStats(Metal.TELLURIUM.asMaterial(),
                PlatingMaterialStats.builder().durabilityFactor(16).armor(3, 4, 7, 4).toughness(1).knockbackResistance(0.16f), StatlessMaterialStats.MAILLE);

        addArmorShieldStats(Metal.ACTINIUM.asMaterial(),
                PlatingMaterialStats.builder().durabilityFactor(16).armor(3, 5, 6, 4).toughness(1).knockbackResistance(0.16f), StatlessMaterialStats.MAILLE);

        addArmorShieldStats(Metal.THALLIUM.asMaterial(),
                PlatingMaterialStats.builder().durabilityFactor(16).armor(3, 4, 7, 4).toughness(1), StatlessMaterialStats.MAILLE);

        addArmorShieldStats(Metal.BERKELIUM.asMaterial(),
                PlatingMaterialStats.builder().durabilityFactor(16).armor(3, 5, 7, 5).toughness(2).knockbackResistance(0.16f), StatlessMaterialStats.MAILLE);

        addArmorShieldStats(Metal.GERMANIUM.asMaterial(),
                PlatingMaterialStats.builder().durabilityFactor(16).armor(3, 5, 7, 5).toughness(2).knockbackResistance(0.16f), StatlessMaterialStats.MAILLE);
    }

    private void addMeleeHarvest() {

        addMaterialStats(Metal.SLIMEBRONZE.asMaterial(),
                new HeadMaterialStats(300, 5.5f, IRON, 1.5f),
                HandleMaterialStats.multipliers().attackSpeed(1.1f).build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(Metal.YTTRIUM.asMaterial(),
                new HeadMaterialStats(400, 6f, DIAMOND, 2f),
                HandleMaterialStats.multipliers().attackSpeed(1.1f).durability(1.10f).build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(Metal.ASTATINE.asMaterial(),
                new HeadMaterialStats(470, 6.2f, DIAMOND, 2.5f),
                HandleMaterialStats.multipliers().miningSpeed(0.9f).durability(1.1f).build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(Metal.GRAPHITE.asMaterial(),
                new HeadMaterialStats(350, 5.9f, DIAMOND, 2.3f),
                HandleMaterialStats.multipliers().attackDamage(1.1f).durability(0.8f).build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(Metal.BARIUM.asMaterial(),
                new HeadMaterialStats(990, 6.5f, DIAMOND, 2.5f),
                HandleMaterialStats.multipliers().durability(1.1f).attackDamage(0.9f).miningSpeed(0.9f).build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(Metal.TELLURIUM.asMaterial(),
                new HeadMaterialStats(1200, 7f, NETHERITE, 2.5f),
                HandleMaterialStats.multipliers().attackDamage(0.9f).build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(Metal.ACTINIUM.asMaterial(),
                new HeadMaterialStats(1200, 6f, NETHERITE, 3f),
                HandleMaterialStats.multipliers().miningSpeed(0.9f).build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(Metal.THALLIUM.asMaterial(),
                new HeadMaterialStats(1600, 7f, NETHERITE, 3f),
                HandleMaterialStats.multipliers().miningSpeed(0.8f).attackDamage(0.8f).durability(1.2f).build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(Metal.BERKELIUM.asMaterial(),
                new HeadMaterialStats(1850, 3f, NETHERITE, 5f),
                HandleMaterialStats.multipliers().durability(0.9f).miningSpeed(0.9f).build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(Metal.GERMANIUM.asMaterial(),
                new HeadMaterialStats(1850, 9f, NETHERITE, 3f),
                HandleMaterialStats.multipliers().durability(0.9f).attackDamage(0.9f).build(),
                StatlessMaterialStats.BINDING);

    }

    @Override
    public String getName() {
        return "Tinkers Reforged Material Stats Data Provider";
    }
}
