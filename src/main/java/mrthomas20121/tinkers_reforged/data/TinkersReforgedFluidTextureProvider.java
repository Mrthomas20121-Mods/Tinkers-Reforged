package mrthomas20121.tinkers_reforged.data;

import com.mojang.blaze3d.shaders.FogShape;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.data.Metal;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedFluids;
import net.minecraft.data.PackOutput;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.fluid.texture.AbstractFluidTextureProvider;
import slimeknights.mantle.fluid.texture.FluidTexture;
import slimeknights.mantle.registration.object.FlowingFluidObject;
import slimeknights.mantle.registration.object.FluidObject;

import static slimeknights.tconstruct.fluids.TinkerFluids.withoutMolten;

public class TinkersReforgedFluidTextureProvider extends AbstractFluidTextureProvider {
    public TinkersReforgedFluidTextureProvider(PackOutput packOutput) {
        super(packOutput, TinkersReforged.MOD_ID);
    }

    @Override
    public void addTextures() {
        for(Metal metal: Metal.values) {
            FlowingFluidObject<ForgeFlowingFluid> fluidObject = TinkersReforgedFluids.METALS.get(metal);
            if(metal.isOre()) {
                ore(fluidObject);
            }
            else {
                alloy(fluidObject);
            }
        }

        moltenSpecialFolder(TinkersReforgedFluids.CHARRED_PRISMARINE, "stone");
        alloy(TinkersReforgedFluids.MOLTEN_SERANDITE);
        alloy(TinkersReforgedFluids.MOLTEN_URANOPHANE);
    }

    @Override
    public String getName() {
        return "Tinkers Reforged Fluid Texture Provider";
    }

    /** Creates a texture using the given fixed name in the fluid folder */
    private FluidTexture.Builder named(FluidObject<?> fluid, String name) {
        return texture(fluid).root(TinkersReforged.getResource("fluid/"+name+"/"))
                .still().flowing().camera().calculateFogColor(true).fog(FogShape.SPHERE, 0.25f, 2);
    }

    /** Creates a texture in the molten using the fluid ID (stripping molten) */
    private FluidTexture.Builder molten(FluidObject<?> fluid) {
        return named(fluid, "molten/" + withoutMolten(fluid));
    }

    /** Creates a texture in the ore folder using the given name */
    private FluidTexture.Builder ore(FluidObject<?> fluid) {
        return moltenFolder(fluid, "ore");
    }

    /** Creates a texture in given subfolder of molten, stripping molten from the name */
    private FluidTexture.Builder moltenFolder(FluidObject<?> fluid, String folder) {
        return named(fluid, "molten/" + folder + "/" + withoutMolten(fluid));
    }

    /** Creates a texture in given subfolder of molten */
    private FluidTexture.Builder moltenSpecialFolder(FluidObject<?> fluid, String folder) {
        return named(fluid, "molten/" + folder + "/" + fluid.getId().getPath());
    }

    /** Creates a texture in the alloy folder using the given name */
    private FluidTexture.Builder alloy(FluidObject<?> fluid) {
        return moltenFolder(fluid, "alloy");
    }
}
