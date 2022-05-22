package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedItems;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedModifiers;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedToolDefinitions;
import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.tinkering.AbstractToolDefinitionDataProvider;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.tools.TinkerModifiers;

import javax.annotation.Nonnull;

import static slimeknights.tconstruct.tools.TinkerToolParts.*;

public class ReforgedToolDefinitionDataProvider extends AbstractToolDefinitionDataProvider {

    public ReforgedToolDefinitionDataProvider(DataGenerator generator) {
        super(generator, TinkersReforged.MOD_ID);
    }

    @Override
    protected void addToolDefinitions() {
        define(TinkersReforgedToolDefinitions.FRYING_PAN)
                // parts
                .part(TinkersReforgedItems.LARGE_ROUND_PLATE)
                .part(toolHandle)
                // stats
                .stat(ToolStats.ATTACK_DAMAGE, 1.5f)
                .stat(ToolStats.ATTACK_SPEED, 1.6f)
                .multiplier(ToolStats.MINING_SPEED, 0.7f)
                .multiplier(ToolStats.DURABILITY, 1.2f)
                .largeToolStartingSlots()
                // traits
                .trait(TinkerModifiers.necrotic, 2)
                .trait(TinkerModifiers.fiery, 2);

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
                // traits
                .trait(TinkersReforgedModifiers.cutting_edge);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Tinkers Reforged Tool Definitions";
    }
}
