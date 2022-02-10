package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.Resources;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.data.recipe.ICommonRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.ISmelteryRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.IToolRecipeHelper;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.tools.data.material.MaterialIds;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class ReforgedRecipes extends RecipeProvider implements IConditionBuilder, IMaterialRecipeHelper, IToolRecipeHelper, ISmelteryRecipeHelper, ICommonRecipeHelper {

    public ReforgedRecipes(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void buildShapelessRecipes(@Nonnull Consumer<IFinishedRecipe> consumer) {

        String materialFolder = "materials/";
        String meltingFolder = "melting/";
        String castingFolder = "casting/";

        metalCasting(consumer, Resources.duralumin, Resources.duralumin_block.get(), Resources.duralumin_ingot.get(), Resources.duralumin_nugget.get(), castingFolder, "duralumin");
        metalCasting(consumer, Resources.electrical_copper, Resources.electrical_copper_block.get(), Resources.electrical_copper_ingot.get(), Resources.electrical_copper_nugget.get(), castingFolder, "electrical_copper");
        metalCasting(consumer, Resources.lavium, Resources.lavium_block.get(), Resources.lavium_ingot.get(), Resources.lavium_nugget.get(), castingFolder, "lavium");
        metalCasting(consumer, Resources.qivium, Resources.qivium_block.get(), Resources.qivium_ingot.get(), Resources.qivium_nugget.get(), castingFolder, "qivium");

        metalMelting(consumer, Resources.duralumin.get(), "duralumin", false, meltingFolder, false);
        metalMelting(consumer, Resources.electrical_copper.get(), "electrical_copper", false, meltingFolder, false);
        metalMelting(consumer, Resources.lavium.get(), "lavium", false, meltingFolder, false);

        materialComposite(consumer, MaterialIds.cobalt, ReforgedMaterials.lavium, TinkerFluids.liquidSoul, 1000, true, materialFolder+"lavium_");
        materialComposite(consumer, MaterialIds.cobalt, ReforgedMaterials.qivium, TinkerFluids.magma, 1000, true, materialFolder+"qivium_");
    }

    @Nonnull
    @Override
    public String getModId() {
        return TinkersReforged.MOD_ID;
    }
}
