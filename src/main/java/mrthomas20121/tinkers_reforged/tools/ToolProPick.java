package mrthomas20121.tinkers_reforged.tools;

import com.oitsjustjose.geolosys.Geolosys;
import com.oitsjustjose.geolosys.common.api.GeolosysAPI;
import com.oitsjustjose.geolosys.common.api.world.DepositMultiOre;
import com.oitsjustjose.geolosys.common.api.world.DepositStone;
import com.oitsjustjose.geolosys.common.api.world.IOre;
import com.oitsjustjose.geolosys.common.config.ModConfig;
import com.oitsjustjose.geolosys.common.items.ItemProPick;
import mrthomas20121.tinkers_reforged.modules.ModuleTools;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.AoeToolCore;
import slimeknights.tconstruct.library.tools.ToolNBT;
import com.oitsjustjose.geolosys.common.util.Utils;
import slimeknights.tconstruct.tools.TinkerTools;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ToolProPick extends AoeToolCore {

    public ToolProPick()
    {
        super(PartMaterialType.handle(TinkerTools.toolRod),
                PartMaterialType.head(ModuleTools.propickHead),
                PartMaterialType.extra(TinkerTools.binding));
    }

    @Override
    public float damagePotential() {
        return 0.9f;
    }

    @Override
    public double attackSpeed() {
        return 1.2f;
    }

    @Override
    protected ToolNBT buildTagData(List<Material> materials) {
        return buildDefaultTag(materials);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if (player.isSneaking()) {
            ItemStack stack = player.getHeldItem(hand);
            // If there's no stack compound make one and assume last state was ores
            if (stack.getTagCompound() == null) {
                stack.setTagCompound(new NBTTagCompound());
                stack.getTagCompound().setBoolean("stone", true);
            }
            // Swap boolean for compound state
            else {
                stack.getTagCompound().setBoolean("stone", !stack.getTagCompound().getBoolean("stone"));
            }

            boolean searchForStone = stack.getTagCompound().getBoolean("stone");

            if (searchForStone) {
                player.sendStatusMessage(new TextComponentTranslation("geolosys.pro_pick.tooltip.mode.stones"), true);
            } else {
                player.sendStatusMessage(new TextComponentTranslation("geolosys.pro_pick.tooltip.mode.ores"), true);
            }
        }
        return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(hand));
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
                                      EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (player.isSneaking()) {
            this.onItemRightClick(worldIn, player, hand);
        } else {
            this.attemptDamageItem(player, pos, hand, worldIn);
            // At surface or higher
            if (worldIn.isRemote) {
                player.swingArm(hand);
                return EnumActionResult.PASS;
            }

            ItemStack stack = player.getHeldItem(hand);

            // If there's no stack compound make one and assume last state was ores
            if (stack.getTagCompound() == null) {
                stack.setTagCompound(new NBTTagCompound());
                stack.getTagCompound().setBoolean("stone", false);
            }

            boolean searchForStone = stack.getTagCompound().getBoolean("stone");

            int seaLvl = worldIn.getSeaLevel();

            if (player.getPosition().getY() >= seaLvl) {
                if (searchForStone) {
                    prospectSurfaceStones(worldIn, pos, player);
                } else {
                    prospectSurfaceOres(worldIn, pos, player);
                }
            } else {
                int xStart;
                int xEnd;
                int yStart;
                int yEnd;
                int zStart;
                int zEnd;
                int confAmt = ModConfig.prospecting.proPickRange;
                int confDmt = ModConfig.prospecting.proPickDiameter;

                boolean oreFoundUnderground = false;

                switch (facing) {
                    case UP:
                        xStart = -(confDmt / 2);
                        xEnd = confDmt / 2;
                        yStart = -confAmt;
                        yEnd = 0;
                        zStart = -(confDmt / 2);
                        zEnd = (confDmt / 2);
                        oreFoundUnderground = prospectUnderground(player, worldIn, pos, facing, xStart, xEnd, yStart,
                                yEnd, zStart, zEnd);
                        break;
                    case DOWN:
                        xStart = -(confDmt / 2);
                        xEnd = confDmt / 2;
                        yStart = 0;
                        yEnd = confAmt;
                        zStart = -(confDmt / 2);
                        zEnd = confDmt / 2;
                        oreFoundUnderground = prospectUnderground(player, worldIn, pos, facing, xStart, xEnd, yStart,
                                yEnd, zStart, zEnd);
                        break;
                    case NORTH:
                        xStart = -(confDmt / 2);
                        xEnd = confDmt / 2;
                        yStart = -(confDmt / 2);
                        yEnd = confDmt / 2;
                        zStart = 0;
                        zEnd = confAmt;
                        oreFoundUnderground = prospectUnderground(player, worldIn, pos, facing, xStart, xEnd, yStart,
                                yEnd, zStart, zEnd);
                        break;
                    case SOUTH:
                        xStart = -(confDmt / 2);
                        xEnd = confDmt / 2;
                        yStart = -(confDmt / 2);
                        yEnd = confDmt / 2;
                        zStart = -confAmt;
                        zEnd = 0;
                        oreFoundUnderground = prospectUnderground(player, worldIn, pos, facing, xStart, xEnd, yStart,
                                yEnd, zStart, zEnd);
                        break;
                    case EAST:
                        xStart = -(confAmt);
                        xEnd = 0;
                        yStart = -(confDmt / 2);
                        yEnd = confDmt / 2;
                        zStart = -(confDmt / 2);
                        zEnd = confDmt / 2;
                        oreFoundUnderground = prospectUnderground(player, worldIn, pos, facing, xStart, xEnd, yStart,
                                yEnd, zStart, zEnd);
                        break;
                    case WEST:
                        xStart = 0;
                        xEnd = confAmt;
                        yStart = -(confDmt / 2);
                        yEnd = confDmt / 2;
                        zStart = -(confDmt / 2);
                        zEnd = confDmt / 2;
                        oreFoundUnderground = prospectUnderground(player, worldIn, pos, facing, xStart, xEnd, yStart,
                                yEnd, zStart, zEnd);
                        break;
                }
                // If right clicking yielded nothing, then find the ore in the chunk again
                if (!oreFoundUnderground) {
                    prospectSurfaceOres(worldIn, pos, player);
                }
            }
            player.swingArm(hand);
        }
        return EnumActionResult.SUCCESS;
    }

    public void attemptDamageItem(EntityPlayer player, BlockPos pos, EnumHand hand, World worldIn) {
        if (ModConfig.prospecting.enableProPickDamage && !player.capabilities.isCreativeMode) {
            if (player.getHeldItem(hand).getItem() instanceof ToolProPick) {
                if (player.getHeldItem(hand).getTagCompound() == null) {
                    player.getHeldItem(hand).setTagCompound(new NBTTagCompound());
                    player.getHeldItem(hand).getTagCompound().setInteger("damage",
                            ModConfig.prospecting.proPickDurability);
                }
                int prevDmg = player.getHeldItem(hand).getTagCompound().getInteger("damage");
                player.getHeldItem(hand).getTagCompound().setInteger("damage", (prevDmg - 1));
                if (player.getHeldItem(hand).getTagCompound().getInteger("damage") <= 0) {
                    player.setHeldItem(hand, ItemStack.EMPTY);
                    worldIn.playSound(player, pos, new SoundEvent(new ResourceLocation("entity.item.break")),
                            SoundCategory.PLAYERS, 1.0F, 0.85F);
                }
            }
        }
    }

    private boolean prospectSurfaceOres(World world, BlockPos pos, EntityPlayer player) {
        ChunkPos tempPos = new ChunkPos(pos);

        ModConfig.Prospecting.SURFACE_PROSPECTING_TYPE searchType = ModConfig.prospecting.surfaceProspectingResults;

        HashMap<IOre, HashSet<IBlockState>> foundMap = new HashMap<>();
        for (IOre ore : GeolosysAPI.oreBlocks) {
            if (ore instanceof DepositMultiOre) {
                foundMap.put((DepositMultiOre) ore, new HashSet<>());
            }
        }

        for (int x = tempPos.getXStart(); x <= tempPos.getXEnd(); x++) {
            for (int z = tempPos.getZStart(); z <= tempPos.getZEnd(); z++) {
                for (int y = 0; y < world.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z)).getY(); y++) {
                    IBlockState state = world.getBlockState(new BlockPos(x, y, z));

                    for (IOre ore : GeolosysAPI.oreBlocks) {
                        if (ore instanceof DepositMultiOre) {
                            DepositMultiOre multiOre = (DepositMultiOre) ore;
                            for (IBlockState multiOreState : (searchType == ModConfig.Prospecting.SURFACE_PROSPECTING_TYPE.OREBLOCKS
                                    ? multiOre.oreBlocks.keySet()
                                    : multiOre.sampleBlocks.keySet())) {
                                if (Utils.doStatesMatch(state, multiOreState)) {
                                    foundMap.get(ore).add(state);
                                    if (foundMap.get(ore).size() == multiOre.oreBlocks.keySet().size()) {
                                        Geolosys.proxy.sendProspectingMessage(player,
                                                multiOre.getFriendlyName(world, pos, player), null);
                                        return true;
                                    }
                                }
                            }
                        } else {
                            if (Utils.doStatesMatch(state,
                                    (searchType == ModConfig.Prospecting.SURFACE_PROSPECTING_TYPE.OREBLOCKS ? ore.getOre()
                                            : ore.getSample()))) {
                                Geolosys.proxy.sendProspectingMessage(player, Utils.blockStateToStack(ore.getOre()),
                                        null);
                                return true;
                            }
                        }
                    }
                    for (IBlockState state2 : GeolosysAPI.proPickExtras) {
                        if (Utils.doStatesMatch(state, state2)) {
                            Geolosys.proxy.sendProspectingMessage(player, Utils.blockStateToStack(state), null);
                            return true;
                        }
                    }
                }
            }
        }

        player.sendStatusMessage(new TextComponentTranslation("geolosys.pro_pick.tooltip.nonefound_surface"), true);
        return false;
    }

    private boolean prospectSurfaceStones(World world, BlockPos pos, EntityPlayer player) {
        ChunkPos tempPos = new ChunkPos(pos);

        for (int x = tempPos.getXStart(); x <= tempPos.getXEnd(); x++) {
            for (int z = tempPos.getZStart(); z <= tempPos.getZEnd(); z++) {
                for (int y = 0; y < world.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z)).getY(); y++) {
                    for (DepositStone s : GeolosysAPI.stones) {
                        if (Utils.doStatesMatch(s.getOre(), world.getBlockState(new BlockPos(x, y, z)))) {
                            Geolosys.proxy.sendProspectingMessage(player,
                                    Utils.blockStateToStack(world.getBlockState(new BlockPos(x, y, z))), null);
                            return true;
                        }
                    }
                }
            }
        }
        player.sendStatusMessage(new TextComponentTranslation("geolosys.pro_pick.tooltip.nonefound_stone_surface"),
                true);
        return false;

    }

    private boolean prospectUnderground(EntityPlayer player, World worldIn, BlockPos pos, EnumFacing facing, int xStart,
                                        int xEnd, int yStart, int yEnd, int zStart, int zEnd) {
        HashMap<IOre, HashSet<IBlockState>> foundMap = new HashMap<>();
        for (IOre ore : GeolosysAPI.oreBlocks) {
            if (ore instanceof DepositMultiOre) {
                foundMap.put((DepositMultiOre) ore, new HashSet<>());
            }
        }

        for (int x = xStart; x <= xEnd; x++) {
            for (int y = yStart; y <= yEnd; y++) {
                for (int z = zStart; z <= zEnd; z++) {
                    IBlockState state = worldIn.getBlockState(pos.add(x, y, z));
                    for (IOre ore : GeolosysAPI.oreBlocks) {
                        // Use the Use the foundMap with multiOres
                        if (ore instanceof DepositMultiOre) {
                            for (IBlockState tmpState : ((DepositMultiOre) ore).oreBlocks.keySet()) {
                                if (Utils.doStatesMatch(tmpState, state)) {
                                    foundMap.get(ore).add(state);
                                    if (foundMap.get(ore).size() == ((DepositMultiOre) ore).oreBlocks.keySet().size()) {
                                        Geolosys.proxy.sendProspectingMessage(player,
                                                ((DepositMultiOre) ore).getFriendlyName(worldIn, pos, player),
                                                facing.getOpposite());
                                        return true;
                                    }
                                }
                            }
                        }
                        // Just check the ore itself otherwise
                        else if (Utils.doStatesMatch(ore.getOre(), state)) {
                            Geolosys.proxy.sendProspectingMessage(player, Utils.blockStateToStack(ore.getOre()),
                                    facing.getOpposite());
                            return true;
                        }
                    }
                    // If we didn't find anything yet
                    for (IBlockState state2 : GeolosysAPI.proPickExtras) {
                        if (Utils.doStatesMatch(state2, state)) {
                            Geolosys.proxy.sendProspectingMessage(player, Utils.blockStateToStack(state),
                                    facing.getOpposite());
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
