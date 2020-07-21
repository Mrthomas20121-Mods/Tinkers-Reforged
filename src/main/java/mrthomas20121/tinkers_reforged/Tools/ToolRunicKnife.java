package com.mrthomas20121.tinkers_reforged.Tools;

import epicsquid.mysticallib.util.ItemUtil;
import epicsquid.roots.config.MossConfig;
import epicsquid.roots.init.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.Category;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.SwordCore;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.tools.TinkerTools;

import javax.annotation.Nonnull;
import java.util.List;

public class ToolRunicKnife extends SwordCore {

    public ToolRunicKnife() {
        super(PartMaterialType.handle(TinkerTools.toolRod),
                PartMaterialType.head(TinkerTools.knifeBlade),
                PartMaterialType.extra(TinkerTools.binding));
        this.addCategory(Category.WEAPON);
    }

    @Override
    public ToolNBT buildTagData(List<Material> materials) {
        ToolNBT data = buildDefaultTag(materials);

        data.attack += 0f;
        data.durability *= 1.4f;

        return data;
    }
    @Override
    public float damagePotential() {
        return 1f;
    }

    public double attackSpeed() {
        return 2d;
    }

    @Override
    @Nonnull
    public EnumActionResult onItemUse(@Nonnull EntityPlayer player, @Nonnull World world, @Nonnull BlockPos pos, @Nonnull EnumHand hand, @Nonnull EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (hand == EnumHand.MAIN_HAND) {
            if (!MossConfig.getBlacklistDimensions().contains(world.provider.getDimension())) {
                // Used to get terramoss from a block of cobble. This can also be done using runic shears.
                IBlockState state = world.getBlockState(pos);
                IBlockState result = MossConfig.scrapeResult(state);
                if (result != null) {
                    if (!world.isRemote) {
                        world.setBlockState(pos, result);
                        world.scheduleBlockUpdate(pos, result.getBlock(), 1, result.getBlock().tickRate(world));
                        ItemUtil.spawnItem(world, player.getPosition().add(0, 1, 0), new ItemStack(ModItems.terra_moss));
                        if (!player.capabilities.isCreativeMode) {
                            player.getHeldItem(hand).damageItem(1, player);
                        }
                    }
                    world.playSound(player, pos, SoundEvents.ENTITY_SHEEP_SHEAR, SoundCategory.BLOCKS, 1f, 1f);
                }
            }
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.PASS;
    }
}
