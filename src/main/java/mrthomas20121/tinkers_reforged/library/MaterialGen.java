package mrthomas20121.tinkers_reforged.library;

import mrthomas20121.biolib.library.Registry;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.fluid.FluidMolten;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.smeltery.PreferenceCastingRecipe;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

import java.util.ArrayList;

import static slimeknights.tconstruct.smeltery.TinkerSmeltery.castGem;

public class MaterialGen {

    private Material material;
    private Fluid fluid;
    private int temp;
    private String oredict;
    private ArrayList<OredictEntry> entries = new ArrayList<>();
    private boolean isGem;

    public MaterialGen(String name, int color, String oredict, int temp, boolean isGem) {
        this.material = new Material("ref_"+name, color);
        this.fluid = new FluidMolten(name, color);
        this.temp = temp;
        this.oredict = oredict;
        this.isGem = isGem;

        if(isGem) {
            this.entries.add(new OredictEntry("gem"+oredict, true));
        }
        else {
            this.entries.add(new OredictEntry("ingot"+oredict, true));
        }
        this.entries.add(new OredictEntry("block"+oredict));
        this.entries.add(new OredictEntry("dust"+oredict));
        this.entries.add(new OredictEntry("gear"+oredict));
        this.entries.add(new OredictEntry("plate"+oredict));
        this.entries.add(new OredictEntry("nugget"+oredict));
    }

    public MaterialGen(String name, int color, String oredict, int temp) {
        this(name, color, oredict, temp, false);
    }

    public void preInit() {
        boolean isRegistered = FluidRegistry.registerFluid(fluid);
        if(isRegistered) {
            Registry.addFluidBlock(TinkersReforged.MODID, fluid.getName());
        }
        fluid = FluidRegistry.getFluid(fluid.getName());
		fluid.setTemperature(temp);
        FluidRegistry.addBucketForFluid(fluid);
        Registry.addBToolForgeBlock("block"+oredict);
    }

    public void init()
    {
        fluid = FluidRegistry.getFluid(fluid.getName());
        if(!OreDictionary.getOres("ore"+oredict).isEmpty()) {
            TinkerRegistry.registerMelting("ore"+oredict, fluid, Material.VALUE_Ore());
        }
        for(OredictEntry entry : entries) {
            String ore = entry.getValue();
            if(!OreDictionary.getOres(ore).isEmpty()) {
                if(entry.isRepresentating()) material.setRepresentativeItem(ore);
                material.addItem(ore, 1, entry.getOredictValue());
            }
        }
        if(isGem) {
            initGem();
        }
        else {
            initMat();
        }
    }

    private void initMat() {
        material.setFluid(fluid);
        material.setCraftable(false).setCastable(true);
        new MaterialIntegration(material, fluid, oredict).toolforge().integrate();
    }

    private void initGem() {
        material.setFluid(fluid);
        material.setCraftable(false).setCastable(true);
        TinkerSmeltery.registerToolpartMeltingCasting(material);
        TinkerSmeltery.registerOredictMeltingCasting(fluid, oredict);
        TinkerRegistry.registerTableCasting(new PreferenceCastingRecipe("gem"+oredict,
                RecipeMatch.ofNBT(castGem),
                fluid,
                Material.VALUE_Ingot));
    }

    public Material getMaterial() {
        return material;
    }

    public String getIdentifier() {
        return material.getIdentifier();
    }
}
