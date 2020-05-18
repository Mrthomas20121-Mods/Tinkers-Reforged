package com.mrthomas20121.libs;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.traits.ITrait;

public class RegistryLib {
    private Material mat = null;
    private HeadMaterialStats headStats = null;
    private HandleMaterialStats handleStats = null;
    private ExtraMaterialStats extraStats = null;
    private BowMaterialStats bowStats = null;
    private FletchingMaterialStats fletchingStats = null;
    private MaterialIntegration integration = null;

    public RegistryLib(Material material) {
        this.mat = material;
    }
    public Material getMat() {
        return this.mat;
    }

    public RegistryLib setCraftable(boolean bool) {
        this.mat.setCraftable(bool);
        return this;
    }
    public RegistryLib setCastable(boolean bool) {
        this.mat.setCastable(bool);
        return this;
    }

    public void registerHeadStats(int durability, float miningspeed, float attack, int harvestLevel) {
        this.headStats = new HeadMaterialStats(durability, miningspeed, attack, harvestLevel);
    }
    public void registerHandleStats(float modifier, int durability) {
        this.handleStats = new HandleMaterialStats(modifier, durability);
    }
    public void registerExtraStats(int extradurability) {
        this.extraStats = new ExtraMaterialStats(extradurability);
    }
    public void registerBowStats(float drawspeed, float range, float bonusDamage) {
        this.bowStats = new BowMaterialStats(drawspeed, range, bonusDamage);
    }
    public void registerFletchingStats(float accuracy, float modifier) {
        this.fletchingStats = new FletchingMaterialStats(accuracy, modifier);
    }
    public void addMaterialTrait(AbstractTrait trait) {
        this.mat.addTrait(trait);
    }
    public void addMaterialTrait(AbstractTrait trait, String dependency) {
        this.mat.addTrait(trait, dependency);
    }
    public void setFluid(Fluid fluid) {
        this.mat.setFluid(fluid);
    }

    public void addCommonItems(String ore) {
        this.mat.addCommonItems(ore);
    }
    public void addGemItem(String ore) {
        this.mat.addItem("gem"+ore, 1, Material.VALUE_Gem);
    }
    public void addIngotItem(String ore) {
        this.mat.addItem(ore, 1, Material.VALUE_Ingot);
    }
    public void addItem(String ore, int mat) {
        this.mat.addItem(ore, 1, mat);
    }
    public void addIngotItem(Item item) {
        this.mat.addItem(item, 1, Material.VALUE_Ingot);
    }
    public void addIngotItem(ItemStack item) {
        this.mat.addItem(item, 1, Material.VALUE_Ingot);
    }
    public void addPlankItem(Block block) {
        this.mat.addItem(block, Material.VALUE_Ingot);
    }
    public void addBlockItem(String ore) {
        this.mat.addItem("block"+ore, 9, Material.VALUE_Block);
    }
    public void addBlockItem(Block block) {
        this.mat.addItem(block, 9);
    }
    public void addGearItem(String ore) {
        this.mat.addItem("gear"+ore, 4, Material.VALUE_BrickBlock);
    }
    public void addPlateItem(String ore) {
        this.mat.addItem("plate"+ore, 1, Material.VALUE_Ingot);
    }

    public void setRepresentativeItem(String ore) {
        this.mat.setRepresentativeItem(ore);
    }
    public void setRepresentativeItem(ItemStack itemstack) {
        this.mat.setRepresentativeItem(itemstack);
    }
    public void setRepresentativeItem(Item item) {
        this.mat.setRepresentativeItem(item);
    }

    public void preInit(String ore) {
        TinkerRegistry.addMaterialStats(this.mat, headStats, handleStats, extraStats);
        if(this.bowStats != null) TinkerRegistry.addMaterialStats(this.mat, bowStats);
        if(this.fletchingStats != null) TinkerRegistry.addMaterialStats(this.mat, fletchingStats);
        if(this.integration == null) TinkerRegistry.integrate(addMaterialIntegration(ore)).preInit();
        else TinkerRegistry.integrate(this.integration).preInit();
    }
    public void preInit(String ore, Fluid fluid) {
        TinkerRegistry.addMaterialStats(this.mat, headStats, handleStats, extraStats);
        if(this.bowStats != null) TinkerRegistry.addMaterialStats(this.mat, bowStats);
        if(this.fletchingStats != null) TinkerRegistry.addMaterialStats(this.mat, fletchingStats);
        if(this.integration == null) TinkerRegistry.integrate(addMaterialIntegration(ore, fluid)).preInit();
        else TinkerRegistry.integrate(this.integration).preInit();
    }
    public void preInit(Fluid fluid) {
        TinkerRegistry.addMaterialStats(this.mat, headStats, handleStats, extraStats);
        if(this.bowStats != null) TinkerRegistry.addMaterialStats(this.mat, bowStats);
        if(this.fletchingStats != null) TinkerRegistry.addMaterialStats(this.mat, fletchingStats);
        if(this.integration == null) TinkerRegistry.integrate(addMaterialIntegration(fluid)).preInit();
        else TinkerRegistry.integrate(this.integration).preInit();
    }
    public void preInit(String ore, String oreRequirement, Fluid fluid) {
        TinkerRegistry.addMaterialStats(this.mat, headStats, handleStats, extraStats);
        if(this.bowStats != null) TinkerRegistry.addMaterialStats(this.mat, bowStats);
        if(this.fletchingStats != null) TinkerRegistry.addMaterialStats(this.mat, fletchingStats);
        if(this.integration == null) TinkerRegistry.integrate(addMaterialIntegration(ore, fluid, oreRequirement)).preInit();
        else TinkerRegistry.integrate(this.integration).preInit();
    }

    public void fletchingPreInit(String ore) {
        TinkerRegistry.addMaterialStats(this.mat, fletchingStats);
        TinkerRegistry.integrate(addMaterialIntegration(ore)).preInit();
    }
    public void bowPreInit(String ore) {
        TinkerRegistry.addMaterialStats(this.mat, bowStats);
        TinkerRegistry.integrate(addMaterialIntegration(ore)).preInit();
    }

    public void fletchingPreInit(String ore, Fluid fluid) {
        TinkerRegistry.addMaterialStats(this.mat, fletchingStats);
        TinkerRegistry.integrate(addMaterialIntegration(ore, fluid)).preInit();
    }
    public void bowPreInit(String ore, Fluid fluid) {
        TinkerRegistry.addMaterialStats(this.mat, bowStats);
        TinkerRegistry.integrate(addMaterialIntegration(ore, fluid)).preInit();
    }

    /**
     * Register Fluids in init if they are not registered in preinit
     * @param fluid
     * @param ore
     */
    public void registerInitFluid(Fluid fluid, String ore) {
        this.addCommonItems(ore);
        mat.setCraftable(false).setCastable(true);
        mat.setFluid(fluid);
    }

    public static void registerTrait(ITrait trait) {
        TinkerRegistry.addTrait(trait);
    }

    /**
     * add a material integration if no oredict exist for the mat items
     */
    private MaterialIntegration addMaterialIntegration() {
        this.integration =  new MaterialIntegration(this.mat);
        return this.integration;
    }
    /**
     * add a material integration with a oredict but no fluid.
     */
    private MaterialIntegration addMaterialIntegration(String ore) {
        this.integration = new MaterialIntegration(this.mat).setRepresentativeItem(ore);
        return this.integration;
    }
    /**
     * add a material integration with a fluid if no oredict exist for the mat items
     */
    private MaterialIntegration addMaterialIntegration(Fluid fluid) {
        this.integration = new MaterialIntegration(this.mat, fluid);
        return this.integration;
    }

    /**
     * add a material integration with a oredict and a fluid.
     */
    private MaterialIntegration addMaterialIntegration(String ore, Fluid fluid) {
        this.integration = new MaterialIntegration(this.mat, fluid, ore).setRepresentativeItem("ingot"+ore);
        return this.integration;
    }
    /**
     * add a material integration with a oredict, a oredict requirement and a fluid.
     */
    private MaterialIntegration addMaterialIntegration(String ore, Fluid fluid, String orerequirement) {
        this.integration = new MaterialIntegration(this.mat, fluid, ore, orerequirement+ore).setRepresentativeItem(orerequirement+ore);
        return this.integration;
    }
}
