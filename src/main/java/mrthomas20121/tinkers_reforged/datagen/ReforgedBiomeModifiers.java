package mrthomas20121.tinkers_reforged.datagen;

import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.material.EnumGem;
import mrthomas20121.tinkers_reforged.api.material.EnumMetal;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedWorldGen;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.JsonCodecProvider;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

public class ReforgedBiomeModifiers {

   public static JsonCodecProvider<BiomeModifier> getProvider(DataGenerator dataGenerator, ExistingFileHelper existingFileHelper) {

       RegistryAccess registryAccess = RegistryAccess.builtinCopy();
       RegistryOps<JsonElement> registryOps = RegistryOps.create(JsonOps.INSTANCE, registryAccess);

       Map<ResourceLocation, BiomeModifier> map = new HashMap<>();
       for(EnumMetal metal: EnumMetal.values()) {
           if(metal.isThisOre()) {
               HolderSet<PlacedFeature> placedFeature = HolderSet.direct(TinkersReforgedWorldGen.PLACED_METAL_ORES.get(metal).getHolder().get());

               TagKey<Biome> tagKey = metal.isThisOverworldOre() ? BiomeTags.IS_OVERWORLD : BiomeTags.IS_END;

               ForgeBiomeModifiers.AddFeaturesBiomeModifier modifier = new ForgeBiomeModifiers.AddFeaturesBiomeModifier(registryAccess.registryOrThrow(tagKey.registry()).getOrCreateTag(tagKey), placedFeature, GenerationStep.Decoration.UNDERGROUND_ORES);

               map.put(new ResourceLocation("tinkers_reforged:placed_"+metal.getName()), modifier);
           }
       }

       for(EnumGem gem: EnumGem.values()) {
           HolderSet<PlacedFeature> placedFeature = HolderSet.direct(TinkersReforgedWorldGen.PLACED_GEM_ORES.get(gem).getHolder().get());

           TagKey<Biome> tagKey = BiomeTags.IS_OVERWORLD;

           ForgeBiomeModifiers.AddFeaturesBiomeModifier modifier = new ForgeBiomeModifiers.AddFeaturesBiomeModifier(registryAccess.registryOrThrow(tagKey.registry()).getOrCreateTag(tagKey), placedFeature, GenerationStep.Decoration.UNDERGROUND_ORES);

           map.put(new ResourceLocation("tinkers_reforged:placed_"+gem.getName()), modifier);
       }

       return JsonCodecProvider.forDatapackRegistry(
               dataGenerator, existingFileHelper, TinkersReforged.MOD_ID, registryOps, ForgeRegistries.Keys.BIOME_MODIFIERS, map);
   }
}
