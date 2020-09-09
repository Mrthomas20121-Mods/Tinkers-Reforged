package mrthomas20121.tinkers_reforged.resources;

import mrthomas20121.biolib.common.MaterialBuilder;
import mrthomas20121.biolib.util.FluidUtils;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import slimeknights.tconstruct.library.materials.Material;

import javax.annotation.Nullable;

public class Resource {

    private Fluid fluid;
    public MaterialBuilder builder;
    private String name;
    private int color;

    private Resource(String name, int color, Fluid fluid, int temp, MaterialBuilder builder)
    {
        this.name = "ref_"+name;
        this.color = color;
        this.fluid = fluid;
        this.builder = builder;

        this.fluid.setTemperature(temp);
        this.setMode(true);
    }
    public Resource(String name, int color, @Nullable String fluidName, int temp)
    {
        this(name, color, FluidUtils.createMetalFluid(fluidName == null? name: fluidName, color), temp, new MaterialBuilder(new Material("ref_"+name, color)));
    }
    public Resource(String name, int color, int temp)
    {
        this(name, color, name, temp);
    }
    public Resource(String name, int color)
    {
        this(name, color, name, 500);
    }
    public Resource(String name, int color, boolean fluid)
    {
        this(name, color);
        if(fluid)
        {
            this.setMode(false);
        }
    }

    public void setMode(boolean mode)
    {
        this.builder.setCraftable(!mode).setCastable(mode);
    }

    public void registerFluid()
    {
        FluidRegistry.registerFluid(this.fluid);
        FluidRegistry.addBucketForFluid(this.fluid);
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }

    public Fluid getFluid() {
        return fluid;
    }

    public MaterialBuilder builder() {
        return builder;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setFluid(Fluid fluid) {
        this.fluid = fluid;
    }

    public void setBuilder(MaterialBuilder builder) {
        this.builder = builder;
    }
}
