package mrthomas20121.tinkers_reforged.data;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.data.Metal;
import mrthomas20121.tinkers_reforged.api.holder.BlockMetalObject;
import mrthomas20121.tinkers_reforged.api.holder.BlockOreObject;
import mrthomas20121.tinkers_reforged.api.holder.BlockOverworldOreObject;
import mrthomas20121.tinkers_reforged.api.holder.ItemMetalObject;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedBlocks;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class TinkersReforgedItemTagsProvider extends ItemTagsProvider {

    public TinkersReforgedItemTagsProvider(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, TinkersReforged.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        for(Metal metal: Metal.values) {

            BlockMetalObject blockMetalObject = TinkersReforgedBlocks.METAl_BLOCKS.get(metal);
            ItemMetalObject itemMetalObject = TinkersReforgedItems.METALS.get(metal);

            tag(metal.getBlockItemTag()).add(blockMetalObject.asItem());
            tag(metal.getIngotTag()).add(itemMetalObject.getIngot());
            tag(metal.getNuggetTag()).add(itemMetalObject.getNugget());
            tag(metal.getPlateTag()).add(itemMetalObject.getPlate());
            tag(metal.getGearTag()).add(itemMetalObject.getGear());
            tag(metal.getDustTag()).add(itemMetalObject.getDust());

            if(metal.equals(Metal.YTTRIUM)) {
                BlockOverworldOreObject oreObject = TinkersReforgedBlocks.YTTRIUM_ORE;

                tag(metal.getRawBlockItemTag()).add(oreObject.getRawOreBlock().asItem());
                tag(metal.getRawItemTag()).add(oreObject.getRawItem());

                tag(metal.getOreBlockItem()).add(oreObject.get().asItem(), oreObject.getDeepslateOre().asItem());
                tag(Tags.Items.ORES).add(oreObject.get().asItem(), oreObject.getDeepslateOre().asItem());
            }
            else if(metal.equals(Metal.BARIUM)) {
                BlockOreObject oreObject = TinkersReforgedBlocks.BARIUM_ORE;

                tag(metal.getRawBlockItemTag()).add(oreObject.getRawOreBlock().asItem());
                tag(metal.getRawItemTag()).add(oreObject.getRawItem());

                tag(metal.getOreBlockItem()).add(oreObject.get().asItem());
                tag(Tags.Items.ORES).add(oreObject.get().asItem());
            }
            else if(metal.equals(Metal.THALLIUM)) {
                BlockOreObject oreObject = TinkersReforgedBlocks.THALLIUM_ORE;

                tag(metal.getRawBlockItemTag()).add(oreObject.getRawOreBlock().asItem());
                tag(metal.getRawItemTag()).add(oreObject.getRawItem());

                tag(metal.getOreBlockItem()).add(oreObject.get().asItem());
                tag(Tags.Items.ORES).add(oreObject.get().asItem());
            }
        }
    }
}
