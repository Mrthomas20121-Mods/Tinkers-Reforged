package mrthomas20121.tinkers_reforged.datagen.tcon;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedItems;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedModifiers;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedToolDefinitions;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Blocks;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.data.tinkering.AbstractToolDefinitionDataProvider;
import slimeknights.tconstruct.library.tools.definition.harvest.IHarvestLogic;
import slimeknights.tconstruct.library.tools.definition.harvest.ModifiedHarvestLogic;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import javax.annotation.Nonnull;

import static slimeknights.tconstruct.tools.TinkerToolParts.*;

public class ReforgedToolDefinitionDataProvider extends AbstractToolDefinitionDataProvider {

    public ReforgedToolDefinitionDataProvider(DataGenerator generator) {
        super(generator, TinkersReforged.MOD_ID);
    }

    @Override
    protected void addToolDefinitions() {

        IHarvestLogic swordLogic = ModifiedHarvestLogic
                .builder(TinkerTags.Blocks.MINABLE_WITH_SWORD)
                .blockModifier(7.5f, Blocks.COBWEB)
                .blockModifier(100f, Blocks.BAMBOO, Blocks.BAMBOO_SAPLING)
                .build();

        define(TinkersReforgedToolDefinitions.GREATSWORD)
                // parts
                .part(TinkersReforgedItems.GREAT_BLADE)
                .part(toolHandle)
                .part(toolHandle)
                // stats
                .stat(ToolStats.ATTACK_DAMAGE, 4f)
                .stat(ToolStats.ATTACK_SPEED, 0.75f)
                .multiplier(ToolStats.MINING_SPEED, 0.5f)
                .multiplier(ToolStats.DURABILITY, 1.1f)
                .largeToolStartingSlots()
                .harvestLogic(swordLogic)
                // traits
                .trait(TinkersReforgedModifiers.returning);

        define(TinkersReforgedToolDefinitions.LONGSWORD)
                // parts
                .part(TinkersReforgedItems.LONG_BLADE)
                .part(toolHandle)
                .part(toolHandle)
                // stats
                .stat(ToolStats.ATTACK_DAMAGE, 3f)
                .stat(ToolStats.ATTACK_SPEED, 1.6f)
                .multiplier(ToolStats.MINING_SPEED, 0.5f)
                .multiplier(ToolStats.DURABILITY, 1.1f)
                .largeToolStartingSlots()
                .harvestLogic(swordLogic)
                // traits
                .trait(TinkersReforgedModifiers.long_range);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Tinkers Reforged Tool Definitions";
    }
}
