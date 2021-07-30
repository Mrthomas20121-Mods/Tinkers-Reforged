package mrthomas20121.tinkers_reforged.trait;

import mrthomas20121.tinkers_reforged.library.trait.ReforgedTrait;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import org.lwjgl.input.Keyboard;

import java.util.List;

/**
 * TraitCaptureBall.java
 * @author mrthomas20121
 * Trait Effect - Allow you to capture a mob by rightclicking an entity
 */
public class TraitCaptureBall extends ReforgedTrait {

    private final static String key = "entity_data";
    private final static String entity_name = "id";

    public TraitCaptureBall() {
        super("ref_capture_ball", 0x0);
    }

    @Override
    public void onTooltip(ItemStack tool, EntityPlayer player, List<String> toolTip) {
        if(this.isToolWithTrait(tool)) {
            if(tool.hasTagCompound()) {
                NBTTagCompound tag = tool.getTagCompound();
                if(tag.hasKey(key) && (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))) {
                    NBTTagCompound entity_data = tag.getCompoundTag(key);
                    String name = entity_data.getString(entity_name);
                    toolTip.add(2, new TextComponentString(TextFormatting.AQUA+String.format("Captured entity : %s", EntityList.getTranslationName(new ResourceLocation(name)))).getFormattedText());
                }
            }
        }
    }

    @Override
    public void onEntityRightClick(ItemStack tool, World world, EntityPlayer player, BlockPos pos, Entity target, EnumHand hand) {
        if(tool.hasTagCompound()) {
            NBTTagCompound itemTag = tool.getTagCompound();
            if(itemTag != null) {
                if(itemTag.hasKey(key)) {
                    // do nothing
                }
                else {
                    itemTag.setTag(key, target.serializeNBT());
                    if(!world.isRemote) {
                        ((WorldServer) world).spawnParticle(EnumParticleTypes.TOTEM, pos.getX() + 0.5, pos.getY() + 0.2, pos.getZ() + 0.5, 2, 0, 0, 0, 0.0, 0);
                    }
                    world.removeEntity(target);
                }
            }
        }
    }

    @Override
    public void onBlockRightClick(ItemStack tool, World world, EntityPlayer player, BlockPos pos, EnumHand hand) {
        BlockPos airPos = pos.up();
        if(tool.hasTagCompound()) {
            NBTTagCompound itemTag = tool.getTagCompound();
            if(itemTag != null) {
                if(itemTag.hasKey(key)) {
                    NBTTagCompound entity_tag = itemTag.getCompoundTag(key);
                    Entity entity = EntityList.createEntityFromNBT(entity_tag, world);
                    if(entity != null && world.isAirBlock(airPos)) {
                        entity.setPosition(airPos.getX(), airPos.getY(), airPos.getZ());
                        if(!world.isRemote) {
                            world.spawnEntity(entity);
                            ((WorldServer) world).spawnParticle(EnumParticleTypes.TOTEM, pos.getX() + 0.5, pos.getY() + 0.2, pos.getZ() + 0.5, 2, 0, 0, 0, 0.0, 0);
                        }
                        itemTag.removeTag(key);
                    }
                }
            }
        }
    }
}
