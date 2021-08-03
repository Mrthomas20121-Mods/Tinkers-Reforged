package mrthomas20121.tinkers_reforged.tools;

import epicsquid.roots.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
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
        // why copy the mod item onItemUse when I can just call it?
        return ModItems.diamond_knife.onItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);
    }
}
