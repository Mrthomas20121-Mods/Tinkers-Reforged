package com.mrthomas20121.tinkers_reforged.Module;

import java.util.ArrayList;

import com.mrthomas20121.libs.Fluid.FluidMoltenBase;
import com.mrthomas20121.libs.block.BlockFluid;
import com.mrthomas20121.tinkers_reforged.TinkersReforged;
import com.mrthomas20121.tinkers_reforged.Config.Config;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = TinkersReforged.MODID)
public class ModuleFluids {
    public static ArrayList<BlockFluid> blockFluids = new ArrayList<>(); 

    public static FluidMoltenBase lavium = new FluidMoltenBase("lavium", Materials.lavium.materialTextColor);
    public static FluidMoltenBase qivium = new FluidMoltenBase("qivium", Materials.qivium.materialTextColor);
    public static FluidMoltenBase kovar = new FluidMoltenBase("kovar", Materials.kovar.materialTextColor);
    public static FluidMoltenBase ludicrite = new FluidMoltenBase("ludicrite", Materials.ludicrite.materialTextColor);
    public static FluidMoltenBase blutonium = new FluidMoltenBase("blutonium", Materials.blutonium.materialTextColor);
    public static FluidMoltenBase infused_iron = new FluidMoltenBase("infused_iron", Materials.infused_iron.materialTextColor);
    public static FluidMoltenBase molten_of_the_sky = new FluidMoltenBase("molten_of_the_sky", Materials.ingot_of_the_sky.materialTextColor);
    public static FluidMoltenBase starmetal = new FluidMoltenBase("starmetal", Materials.starmetal.materialTextColor);
    public static FluidMoltenBase refined_obsidian = new FluidMoltenBase("refined_obsidian", Materials.refined_obsidian.materialTextColor);
    public static FluidMoltenBase refined_glowstone = new FluidMoltenBase("refined_glowstone", Materials.refined_glowstone.materialTextColor);
    public static FluidMoltenBase osmium = new FluidMoltenBase("osmium", Materials.osmium.materialTextColor);
    public static FluidMoltenBase ventium = new FluidMoltenBase("ventium", Materials.ventium.materialTextColor);
    public static FluidMoltenBase horizonite = new FluidMoltenBase("horizonite", Materials.horizonite.materialTextColor);
    public static FluidMoltenBase pyrope = new FluidMoltenBase("pyrope", Materials.pyrope.materialTextColor);
    public static FluidMoltenBase blackquartz = new FluidMoltenBase("black_quartz", Materials.blackquartz.materialTextColor);
    public static FluidMoltenBase enori = new FluidMoltenBase("enori", Materials.enori.materialTextColor);
    public static FluidMoltenBase voidCrystal = new FluidMoltenBase("void", Materials.void_crystal.materialTextColor);
    public static FluidMoltenBase emeradic = new FluidMoltenBase("emeradic", Materials.emeradic.materialTextColor);
    public static FluidMoltenBase palis = new FluidMoltenBase("palis", Materials.palis.materialTextColor);
    public static FluidMoltenBase diamantine = new FluidMoltenBase("diamantine", Materials.diamantine.materialTextColor);
    public static FluidMoltenBase redstonia = new FluidMoltenBase("redstonia", Materials.redstonia.materialTextColor);

    public void preInit(FMLPreInitializationEvent e) {
        if(Config.qivium) {
            FluidRegistry.registerFluid(qivium);
            FluidRegistry.addBucketForFluid(qivium);
        }
        if(Config.lavium) {
            FluidRegistry.registerFluid(lavium);
            FluidRegistry.addBucketForFluid(lavium);
        }
        if(Config.kovar) {
            kovar.setDensity(8);
            kovar.setTemperature(750);
            FluidRegistry.registerFluid(kovar);
            FluidRegistry.addBucketForFluid(kovar);
        }
        if(Loader.isModLoaded("actuallyadditions")) {
            if(Config.blackquartz) {
                FluidRegistry.registerFluid(blackquartz);
                FluidRegistry.addBucketForFluid(blackquartz);
            }
            if(Config.enori) {
                FluidRegistry.registerFluid(enori);
                FluidRegistry.addBucketForFluid(enori);
            }
            if(Config.voidcrystal) {
                FluidRegistry.registerFluid(voidCrystal);
                FluidRegistry.addBucketForFluid(voidCrystal);
            }
            if(Config.emeratic) {
                FluidRegistry.registerFluid(emeradic);
                FluidRegistry.addBucketForFluid(emeradic);
            }
            if(Config.palis) {
                FluidRegistry.registerFluid(palis);
                FluidRegistry.addBucketForFluid(palis);
            }
            if(Config.diamantine) {
                FluidRegistry.registerFluid(diamantine);
                FluidRegistry.addBucketForFluid(diamantine);
            }
            if(Config.redstonia) {
                FluidRegistry.registerFluid(redstonia);
                FluidRegistry.addBucketForFluid(redstonia);
            }
        }
        if(Loader.isModLoaded("astralsorcery")) {
            if(Config.starmetal) {
                FluidRegistry.registerFluid(starmetal);
                FluidRegistry.addBucketForFluid(starmetal);
            }
        }        
        if(Loader.isModLoaded("blue_skies")) {
            if(Config.pyrope) {
                FluidRegistry.registerFluid(pyrope);
                FluidRegistry.addBucketForFluid(pyrope);
            }
            if(Config.horizonite) {
                horizonite.setTemperature(700);
                FluidRegistry.registerFluid(horizonite);
                FluidRegistry.addBucketForFluid(horizonite);
            }
            if(Config.ventium) {
                ventium.setTemperature(500);
                FluidRegistry.registerFluid(ventium);
                FluidRegistry.addBucketForFluid(ventium);
            }
        }
        if(Loader.isModLoaded("bigreactors")) {
            if(Config.ludicrite) {
                FluidRegistry.registerFluid(ludicrite);
                FluidRegistry.addBucketForFluid(ludicrite);
            }
            if(Config.blutonium) {
                FluidRegistry.registerFluid(blutonium);
                FluidRegistry.addBucketForFluid(blutonium);
            }
        }
        if(Loader.isModLoaded("naturesaura")) {
            if(Config.infused_iron) {
                FluidRegistry.registerFluid(infused_iron);
                FluidRegistry.addBucketForFluid(infused_iron);
            }
            if(Config.ingot_of_the_sky) {
                FluidRegistry.registerFluid(molten_of_the_sky);
                FluidRegistry.addBucketForFluid(molten_of_the_sky);
            }
        }
        if(Loader.isModLoaded("mekanism")) { 
            if(Config.refined_obsidian) {
                refined_obsidian.setTemperature(700);
                FluidRegistry.registerFluid(refined_obsidian);
                FluidRegistry.addBucketForFluid(refined_obsidian);
            }
            if(Config.refined_glowstone) {
                refined_glowstone.setTemperature(700);
                FluidRegistry.registerFluid(refined_glowstone);
                FluidRegistry.addBucketForFluid(refined_glowstone);
            }
            if(Config.osmium) {
                osmium.setTemperature(550);
                FluidRegistry.registerFluid(osmium);
                FluidRegistry.addBucketForFluid(osmium);
            }
        }
    }
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> r = event.getRegistry();

        if(Config.qivium) {
            RegisterFluidBlock(r, qivium);
        }
        if(Config.lavium) {
            RegisterFluidBlock(r, lavium);
        }
        if(Config.kovar) {
            RegisterFluidBlock(r, kovar);
        }
        if(Loader.isModLoaded("bigreactors")) {
            if(Config.ludicrite) {
                RegisterFluidBlock(r, ludicrite);
            }
            if(Config.blutonium) {
                RegisterFluidBlock(r, blutonium);
            }
        }
        if(Loader.isModLoaded("naturesaura")) {
            if(Config.infused_iron) {
                RegisterFluidBlock(r, infused_iron);
            }
            if(Config.ingot_of_the_sky) {
                RegisterFluidBlock(r, molten_of_the_sky);
            }
        }
        if(Config.starmetal && Loader.isModLoaded("astralsorcery"))  {
            RegisterFluidBlock(r, starmetal);
        }
        if(Loader.isModLoaded("mekanism")) {
            if(Config.osmium) {
                RegisterFluidBlock(r, osmium);
            }
            if(Config.refined_obsidian) {
                RegisterFluidBlock(r, refined_obsidian);
            }
            if(Config.refined_glowstone) {
                RegisterFluidBlock(r, refined_glowstone);
            }
        }
        if(Loader.isModLoaded("blue_skies")) {
            if(Config.ventium) {
                RegisterFluidBlock(r, ventium);
            }
            if(Config.pyrope) {
                RegisterFluidBlock(r, pyrope);
            }
            if(Config.horizonite) {
                RegisterFluidBlock(r, horizonite);
            }
        }
        if(Loader.isModLoaded("actuallyadditions")) {
            if(Config.blackquartz) {
                RegisterFluidBlock(r, blackquartz);
            }
            if(Config.enori) {
                RegisterFluidBlock(r, enori);
            }
            if(Config.voidcrystal) {
                RegisterFluidBlock(r, voidCrystal);
            }
            if(Config.emeratic) {
                RegisterFluidBlock(r, emeradic);
            }
            if(Config.palis) {
                RegisterFluidBlock(r, palis);
            }
            if(Config.diamantine) {
                RegisterFluidBlock(r, diamantine);
            }
            if(Config.redstonia) {
                RegisterFluidBlock(r, redstonia);
            }
        }
    }
    protected static void RegisterFluidBlock(IForgeRegistry<Block> r, Fluid f) {
        BlockFluid fluidBlock = new BlockFluid(f);
        fluidBlock.setRegistryName(TinkersReforged.MODID, "molten_"+f.getName());
        blockFluids.add(fluidBlock);
        r.register(fluidBlock);
    }
}
