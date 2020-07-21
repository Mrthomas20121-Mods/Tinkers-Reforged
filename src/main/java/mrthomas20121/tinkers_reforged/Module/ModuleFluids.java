package mrthomas20121.tinkers_reforged.Module;

import java.util.ArrayList;

import mrthomas20121.biolib.block.BlockFluid;
import mrthomas20121.biolib.util.FluidUtils;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.Config.Config;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
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
    public static ArrayList<ItemBlock> blockFluids = new ArrayList<>();

    public static Fluid lavium = FluidUtils.createMetalFluid("lavium", Materials.lavium.materialTextColor);
    public static Fluid qivium = FluidUtils.createMetalFluid("qivium", Materials.qivium.materialTextColor);
    public static Fluid kovar = FluidUtils.createMetalFluid("kovar", Materials.kovar.materialTextColor);
    public static Fluid ludicrite = FluidUtils.createMetalFluid("ludicrite", Materials.ludicrite.materialTextColor);
    public static Fluid blutonium = FluidUtils.createMetalFluid("blutonium", Materials.blutonium.materialTextColor);
    public static Fluid infused_iron = FluidUtils.createMetalFluid("infused_iron", Materials.infused_iron.materialTextColor);
    public static Fluid molten_of_the_sky = FluidUtils.createMetalFluid("molten_of_the_sky", Materials.ingot_of_the_sky.materialTextColor);
    public static Fluid starmetal = FluidUtils.createMetalFluid("starmetal", Materials.starmetal.materialTextColor);
    public static Fluid refined_obsidian = FluidUtils.createMetalFluid("refined_obsidian", Materials.refined_obsidian.materialTextColor);
    public static Fluid refined_glowstone = FluidUtils.createMetalFluid("refined_glowstone", Materials.refined_glowstone.materialTextColor);
    public static Fluid osmium = FluidUtils.createMetalFluid("osmium", Materials.osmium.materialTextColor);
    public static Fluid ventium = FluidUtils.createMetalFluid("ventium", Materials.ventium.materialTextColor);
    public static Fluid horizonite = FluidUtils.createMetalFluid("horizonite", Materials.horizonite.materialTextColor);
    public static Fluid pyrope = FluidUtils.createMetalFluid("pyrope", Materials.pyrope.materialTextColor);
    public static Fluid blackquartz = FluidUtils.createMetalFluid("black_quartz", Materials.blackquartz.materialTextColor);
    public static Fluid enori = FluidUtils.createMetalFluid("enori", Materials.enori.materialTextColor);
    public static Fluid voidCrystal = FluidUtils.createMetalFluid("void", Materials.void_crystal.materialTextColor);
    public static Fluid emeradic = FluidUtils.createMetalFluid("emeradic", Materials.emeradic.materialTextColor);
    public static Fluid palis = FluidUtils.createMetalFluid("palis", Materials.palis.materialTextColor);
    public static Fluid diamantine = FluidUtils.createMetalFluid("diamantine", Materials.diamantine.materialTextColor);
    public static Fluid redstonia = FluidUtils.createMetalFluid("redstonia", Materials.redstonia.materialTextColor);

    public void preInit(FMLPreInitializationEvent e) {
        if(Config.qivium) {
            qivium.setTemperature(750);
            FluidRegistry.registerFluid(qivium);
            FluidRegistry.addBucketForFluid(qivium);
        }
        if(Config.lavium) {
            lavium.setTemperature(750);
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
                blackquartz.setTemperature(500);
                FluidRegistry.registerFluid(blackquartz);
                FluidRegistry.addBucketForFluid(blackquartz);
            }
            if(Config.enori) {
                enori.setTemperature(900);
                FluidRegistry.registerFluid(enori);
                FluidRegistry.addBucketForFluid(enori);
            }
            if(Config.voidcrystal) {
                voidCrystal.setTemperature(900);
                FluidRegistry.registerFluid(voidCrystal);
                FluidRegistry.addBucketForFluid(voidCrystal);
            }
            if(Config.emeratic) {
                emeradic.setTemperature(900);
                FluidRegistry.registerFluid(emeradic);
                FluidRegistry.addBucketForFluid(emeradic);
            }
            if(Config.palis) {
                palis.setTemperature(900);
                FluidRegistry.registerFluid(palis);
                FluidRegistry.addBucketForFluid(palis);
            }
            if(Config.diamantine) {
                diamantine.setTemperature(900);
                FluidRegistry.registerFluid(diamantine);
                FluidRegistry.addBucketForFluid(diamantine);
            }
            if(Config.redstonia) {
                redstonia.setTemperature(900);
                FluidRegistry.registerFluid(redstonia);
                FluidRegistry.addBucketForFluid(redstonia);
            }
        }
        if(Loader.isModLoaded("astralsorcery")) {
            if(Config.starmetal) {
                starmetal.setTemperature(850);
                FluidRegistry.registerFluid(starmetal);
                FluidRegistry.addBucketForFluid(starmetal);
            }
        }        
        if(Loader.isModLoaded("blue_skies")) {
            if(Config.pyrope) {
                pyrope.setTemperature(400);
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
                ludicrite.setTemperature(950);
                FluidRegistry.registerFluid(ludicrite);
                FluidRegistry.addBucketForFluid(ludicrite);
            }
            if(Config.blutonium) {
                blutonium.setTemperature(950);
                FluidRegistry.registerFluid(blutonium);
                FluidRegistry.addBucketForFluid(blutonium);
            }
        }
        if(Loader.isModLoaded("naturesaura")) {
            if(Config.infused_iron) {
                infused_iron.setTemperature(500);
                FluidRegistry.registerFluid(infused_iron);
                FluidRegistry.addBucketForFluid(infused_iron);
            }
            if(Config.ingot_of_the_sky) {
                molten_of_the_sky.setTemperature(600);
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
    public static void RegisterFluidBlock(IForgeRegistry<Block> r, Fluid f) {
        BlockFluid fluidBlock = new BlockFluid(f);
        fluidBlock.setRegistryName(TinkersReforged.MODID, "molten_"+f.getName());
        f.setUnlocalizedName(f.getName());
        ItemBlock itemBlock = new ItemBlock(fluidBlock);
        itemBlock.setRegistryName(fluidBlock.getRegistryName());
        blockFluids.add(itemBlock);
        r.register(fluidBlock);
    }
}
