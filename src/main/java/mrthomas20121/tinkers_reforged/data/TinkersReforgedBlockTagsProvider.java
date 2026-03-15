package mrthomas20121.tinkers_reforged.data;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.data.Metal;
import mrthomas20121.tinkers_reforged.api.holder.BlockMetalObject;
import mrthomas20121.tinkers_reforged.api.holder.BlockOreObject;
import mrthomas20121.tinkers_reforged.api.holder.BlockOverworldOreObject;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.common.TinkerTags;

import java.util.concurrent.CompletableFuture;

public class TinkersReforgedBlockTagsProvider extends BlockTagsProvider {

    public TinkersReforgedBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TinkersReforged.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        for(Metal metal: Metal.values) {

            tag(TinkerTags.Blocks.ANVIL_METAL).addTag(metal.getBlockTag());

            BlockMetalObject blockMetalObject = TinkersReforgedBlocks.METAl_BLOCKS.get(metal);

            tag(metal.getBlockTag()).add(blockMetalObject.get());

            if(metal.equals(Metal.YTTRIUM)) {
                BlockOverworldOreObject oreObject = TinkersReforgedBlocks.YTTRIUM_ORE;

                tag(metal.getRawBlockTag()).add(oreObject.getRawOreBlock());

                tag(metal.getOreBlock()).add(oreObject.get(), oreObject.getDeepslateOre());
                tag(Tags.Blocks.ORES).add(oreObject.get(), oreObject.getDeepslateOre());
            }
            else if(metal.equals(Metal.BARIUM)) {
                BlockOreObject oreObject = TinkersReforgedBlocks.BARIUM_ORE;

                tag(metal.getRawBlockTag()).add(oreObject.getRawOreBlock());

                tag(metal.getOreBlock()).add(oreObject.get());
                tag(Tags.Blocks.ORES).add(oreObject.get());
            }
            else if(metal.equals(Metal.THALLIUM)) {
                BlockOreObject oreObject = TinkersReforgedBlocks.THALLIUM_ORE;

                tag(metal.getRawBlockTag()).add(oreObject.getRawOreBlock());

                tag(metal.getOreBlock()).add(oreObject.get());
                tag(Tags.Blocks.ORES).add(oreObject.get());
            }
        }
    }
}
