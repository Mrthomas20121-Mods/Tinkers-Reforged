package mrthomas20121.tinkers_reforged.data.material;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.data.Metal;
import mrthomas20121.tinkers_reforged.api.holder.ItemMetalObject;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.level.ItemLike;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.library.materials.definition.MaterialId;

import java.util.Map;

public class TinkersReforgedTrimMaterials {

    private static final String TRIM_FORMAT = TConstruct.makeDescriptionId("trim_material", "format");

    public static void bootstrap(BootstapContext<TrimMaterial> context) {
        material(context, Metal.GRAPHITE, 0x1c1c20, 0.3f);
        material(context, Metal.YTTRIUM, 0x451318, 0.4f);
        material(context, Metal.BARIUM, 0x2a1d5b, 0.5f);
        material(context, Metal.ASTATINE, 0xe99475, 0.2f);
        material(context, Metal.TELLURIUM, 0x522728, 0.6f);
        material(context, Metal.GERMANIUM, 0x4c183c, 0.7f);
        material(context, Metal.BERKELIUM, 0x40541e, 0.8f);
        material(context, Metal.ACTINIUM, 0x403e2f, 0.9f);
        material(context, Metal.THALLIUM, 0x28373c, 1f);
    }

    /** Registers a trim materials using the metal enum with the context */
    private static void material(BootstapContext<TrimMaterial> context, Metal metal, int color, float modelIndex) {
        material(context, metal.asMaterial(), TinkersReforgedItems.METALS.get(metal), color, modelIndex);
    }

    /** Registers a trim materials using the ingot with the context */
    private static void material(BootstapContext<TrimMaterial> context, MaterialId material, ItemMetalObject ingredient, int color, float modelIndex) {
        material(context, material, ingredient.getIngot(), color, modelIndex);
    }

    /** Registers a trim materials with the context */
    private static void material(BootstapContext<TrimMaterial> context, MaterialId material, ItemLike ingredient, int color, float modelIndex) {
        context.register(
                ResourceKey.create(Registries.TRIM_MATERIAL, material),
                TrimMaterial.create(material.getSuffix(), ingredient.asItem(), modelIndex,
                        Component.translatable(TRIM_FORMAT, Component.translatable(TinkersReforged.makeDescriptionId("material", material.getPath()))).withStyle(style -> style.withColor(color)),
                        Map.of())
        );
    }
}
