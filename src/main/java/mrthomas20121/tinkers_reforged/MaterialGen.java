package mrthomas20121.tinkers_reforged;

import mrthomas20121.biolib.library.Registry;
import mrthomas20121.biolib.util.ConarmUtil;
import mrthomas20121.tinkers_reforged.trait.Traits;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.fluid.FluidMolten;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.smeltery.PreferenceCastingRecipe;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

import static slimeknights.tconstruct.smeltery.TinkerSmeltery.castGem;

public class MaterialGen {

    private Material material;
    private Fluid fluid;
    private int temp;
    private String oredict;
    private int isGem;

    public MaterialGen(String name, int color, String oredict, int temp, int isGem) {
        this.material = new Material("ref_"+name, color);
        this.fluid = new FluidMolten(name, color);
        this.temp = temp;
        this.oredict = oredict;
        this.isGem = isGem;
    }

    public MaterialGen(String name, int color, String oredict, int temp) {
        this(name, color, oredict, temp, 0);
    }

    public void preInit() {
        fluid.setTemperature(temp);
        if(!FluidRegistry.isFluidRegistered(fluid)) FluidRegistry.registerFluid(fluid);
        else fluid = FluidRegistry.getFluid(fluid.getName());
        FluidRegistry.addBucketForFluid(fluid);
        Registry.addFluidBlock(TinkersReforged.MODID, fluid.getName());
        if(isGem > 0) Registry.addBToolForgeBlock("block"+oredict);
    }

    public void init()
    {
        if(!OreDictionary.getOres("ore"+oredict).isEmpty()) {
            material.addItem("ore"+oredict, 1, Material.VALUE_Ore());
        }
        switch (isGem) {
            case 0:
                initMat();
                break;
            case 1:
                initGem();
        }
    }

    private void initMat() {
        material.setFluid(fluid);
        material.setCraftable(false).setCastable(true);
        material.addCommonItems(oredict);
        new MaterialIntegration(material, fluid, oredict).toolforge().integrate();
    }

    public void initOther(String orename) {
        material.setFluid(fluid);
        material.setCraftable(false).setCastable(true);
        material.addCommonItems(oredict);
        material.setRepresentativeItem("dust"+oredict);
        material.addItem(orename+oredict, 1, Material.VALUE_Ingot);
    }

    private void initGem() {
        material.setFluid(fluid);
        material.setCraftable(false).setCastable(true);
        material.addCommonItems(oredict);
        material.setRepresentativeItem("gem"+oredict);
        material.addItem("gem"+oredict, 1, Material.VALUE_Ingot);
        TinkerSmeltery.registerToolpartMeltingCasting(material);
        TinkerSmeltery.registerOredictMeltingCasting(fluid, oredict);
        TinkerRegistry.registerTableCasting(new PreferenceCastingRecipe("gem"+oredict,
                RecipeMatch.ofNBT(castGem),
                fluid,
                Material.VALUE_Ingot));
    }

    public void specialInit() {
        material.addCommonItems(oredict);
    }

    public Material getMaterial() {
        return material;
    }

    public String getIdentifier() {
        return material.getIdentifier();
    }
}
