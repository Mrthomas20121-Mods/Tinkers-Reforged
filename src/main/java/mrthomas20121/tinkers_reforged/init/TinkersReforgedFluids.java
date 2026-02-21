package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.data.Metal;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.object.FlowingFluidObject;
import slimeknights.tconstruct.common.registration.FluidDeferredRegisterExtension;

import java.util.EnumMap;

import static slimeknights.mantle.block.fluid.BurningLiquidBlock.createBurning;

public class TinkersReforgedFluids {

    public static FluidDeferredRegisterExtension FLUIDS = new FluidDeferredRegisterExtension(TinkersReforged.MOD_ID);

    public static FlowingFluidObject<ForgeFlowingFluid> CHARRED_PRISMARINE = FLUIDS.registerStone("charred_prismarine")
            .type(hot("charred_prismarine").temperature(500))
            .block(createBurning(MapColor.COLOR_LIGHT_BLUE, 12, 10, 2f))
            .bucket()
            .commonTag()
            .flowing();

    public static FlowingFluidObject<ForgeFlowingFluid> MOLTEN_URANOPHANE = FLUIDS.registerMetal("molten_uranophane")
            .type(hot("molten_uranophane").temperature(500))
            .block(createBurning(MapColor.COLOR_BLUE, 12, 10, 4f))
            .bucket()
            .commonTag()
            .flowing();

    public static FlowingFluidObject<ForgeFlowingFluid> MOLTEN_SERANDITE = FLUIDS.registerMetal("molten_serandite")
            .type(hot("molten_serandite").temperature(500))
            .block(createBurning(MapColor.COLOR_RED, 12, 10, 4f))
            .bucket()
            .commonTag()
            .flowing();

    public static EnumMap<Metal, FlowingFluidObject<ForgeFlowingFluid>> METALS = registerEnumMetal();

    private static EnumMap<Metal, FlowingFluidObject<ForgeFlowingFluid>> registerEnumMetal() {
        final EnumMap<Metal, FlowingFluidObject<ForgeFlowingFluid>> map = new EnumMap<>(Metal.class);

        Metal[] values = Metal.values;

        for(Metal metal: values) {
            String name = "molten_"+metal.getSerializedName();
            map.put(metal, FLUIDS.registerMetal(name)
                    .type(hot(name).temperature(metal.getTemperature()).lightLevel(12))
                    .block(createBurning(metal.getMapColor(), 12, 10, 5f))
                    .bucket()
                    .commonTag()
                    .flowing());
        }

        return map;
    }

    /** Creates a builder for a cool fluid with sounds */
    private static FluidType.Properties cool() {
        return FluidType.Properties.create()
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                .motionScale(0.0023333333333333335D)
                .canExtinguish(true);

    }

    /** Creates a builder for a cool fluid with sounds and description */
    private static FluidType.Properties cool(String name) {
        return cool().descriptionId(TinkersReforged.makeDescriptionId("fluid", name))
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY);
    }

    /** Creates a builder for a cool fluid with sounds and description */
    private static FluidType.Properties slime(String name) {
        return cool(name).density(1600).viscosity(1600);
    }

    /** Creates a builder for a cool fluid with sounds and description */
    @SuppressWarnings("SameParameterValue")
    private static FluidType.Properties powder(String name) {
        return FluidType.Properties.create().descriptionId(TinkersReforged.makeDescriptionId("fluid", name))
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_POWDER_SNOW)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_POWDER_SNOW);
    }

    /** Creates a builder for a hot with sounds and description */
    private static FluidType.Properties hot(String name) {
        return FluidType.Properties.create().density(2000).viscosity(10000).temperature(1000)
                .descriptionId(TinkersReforged.makeDescriptionId("fluid", name))
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                // from forge lava type
                .motionScale(0.0023333333333333335D)
                .canSwim(false).canDrown(false)
                .pathType(BlockPathTypes.LAVA).adjacentPathType(null);
    }
}
