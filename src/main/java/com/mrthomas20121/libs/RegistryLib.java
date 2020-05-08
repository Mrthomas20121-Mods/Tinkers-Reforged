package com.mrthomas20121.libs;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.traits.ITrait;

import javax.annotation.Nullable;

public class RegistryLib {
    private Material mat = null;
    private HeadMaterialStats headStats = null;
    private HandleMaterialStats handleStats = null;
    private ExtraMaterialStats extraStats = null;
    private BowMaterialStats bowStats = null;
    private FletchingMaterialStats fletchingStats = null;

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
    public void registerMaterialTrait(AbstractTrait trait) {
        if(this.isMatNull()) throw new Error("Material is null");
        this.mat.addTrait(trait);
    }
    public void registerMaterialTrait(AbstractTrait trait, String dependency) {
        if(this.isMatNull()) throw new Error("Material is null");
        this.mat.addTrait(trait, dependency);
    }
    public void setFluid(Fluid fluid) {
        if(this.isMatNull()) throw new Error("Material is null");
        this.mat.setFluid(fluid);
    }

    public void addCommonItems(String ore) {
        if(this.isMatNull()) throw new Error("Material is null");
        this.mat.addCommonItems(ore);
    }
    public RegistryLib addGemItem(String ore) {
        if(this.isMatNull()) throw new Error("Material is null");
        this.mat.addItem("gem"+ore, 1, Material.VALUE_Gem);
        return this;
    }
    public RegistryLib addIngotItem(String ore) {
        if(this.isMatNull()) throw new Error("Material is null");
        this.mat.addItem(ore, 1, Material.VALUE_Ingot);
        return this;
    }
    public RegistryLib addIngotItem(Item item) {
        if(this.isMatNull()) throw new Error("Material is null");
        this.mat.addItem(item, 1, Material.VALUE_Ingot);
        return this;
    }
    public RegistryLib addPlankItem(Block block) {
        if(this.isMatNull()) throw new Error("Material is null");
        this.mat.addItem(block, Material.VALUE_Ingot);
        return this;
    }
    public RegistryLib addBlockItem(String ore) {
        if(this.isMatNull()) throw new Error("Material is null");
        this.mat.addItem("block"+ore, 9, Material.VALUE_Block);
        return this;
    }
    public RegistryLib addBlockItem(Block block) {
        if(this.isMatNull()) throw new Error("Material is null");
        this.mat.addItem(block, 9);
        return this;
    }
    public RegistryLib addGearItem(String ore) {
        if(this.isMatNull()) throw new Error("Material is null");
        this.mat.addItem("gear"+ore, 4, Material.VALUE_BrickBlock);
        return this;
    }
    public RegistryLib addPlateItem(String ore) {
        if(this.isMatNull()) throw new Error("Material is null");
        this.mat.addItem("plate"+ore, 1, Material.VALUE_Ingot);
        return this;
    }

    public void setRepresentativeItem(String ore) {
        this.mat.setRepresentativeItem(ore);
    }

    /**
     * Register your material
     * @param ore oredict name(e.g ingotCopper, ingotSilver, ingotGold, gemAmethyst)
     */
    public void registerPreInit(String ore) {
        TinkerRegistry.addMaterialStats(this.mat, headStats, handleStats, extraStats);
        if(this.bowStats != null) TinkerRegistry.addMaterialStats(this.mat, bowStats);
        if(this.fletchingStats != null) TinkerRegistry.addMaterialStats(this.mat, fletchingStats);
        TinkerRegistry.integrate(this.registerMaterialIntegration(ore)).preInit();
    }
    public void registerFletchingPreInit(String ore) {
        TinkerRegistry.addMaterialStats(this.mat, fletchingStats);
        TinkerRegistry.integrate(this.registerMaterialIntegration(ore)).preInit();
    }
    public void registerBowPreInit(String ore) {
        TinkerRegistry.addMaterialStats(this.mat, bowStats);
        TinkerRegistry.integrate(this.registerMaterialIntegration(ore)).preInit();
    }

    public void registerFletchingPreInit(String ore, Fluid fluid) {
        TinkerRegistry.addMaterialStats(this.mat, fletchingStats);
        TinkerRegistry.integrate(this.registerMaterialIntegration(ore, fluid)).preInit();
    }
    public void registerBowPreInit(String ore, Fluid fluid) {
        TinkerRegistry.addMaterialStats(this.mat, bowStats);
        TinkerRegistry.integrate(this.registerMaterialIntegration(ore, fluid)).preInit();
    }
    /**
     * Register your material
     * @param ore oredict name(e.g ingotCopper, ingotSilver, ingotGold, gemAmethyst)
     * @param fluid a fluid
     */
    public void registerPreInit(String ore, Fluid fluid) {
        TinkerRegistry.addMaterialStats(this.mat, headStats, handleStats, extraStats);
        if(this.bowStats != null) TinkerRegistry.addMaterialStats(this.mat, bowStats);
        if(this.fletchingStats != null) TinkerRegistry.addMaterialStats(this.mat, fletchingStats);
        TinkerRegistry.integrate(this.registerMaterialIntegration(ore, fluid)).preInit();
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

    private MaterialIntegration registerMaterialIntegration(String ore) {
        return new MaterialIntegration(this.mat).setRepresentativeItem(ore);
    }

    private MaterialIntegration registerMaterialIntegration(String ore, Fluid fluid) {
        return new MaterialIntegration(this.mat, fluid).setRepresentativeItem(ore);
    }

    private boolean isMatNull() {
        return mat == null;
    }
}
