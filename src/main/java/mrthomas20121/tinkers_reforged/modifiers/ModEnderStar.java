package mrthomas20121.tinkers_reforged.modifiers;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import slimeknights.tconstruct.library.modifiers.IModifier;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.modifiers.ModifierTrait;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.tools.modifiers.ModLuck;

public class ModEnderStar extends ModifierTrait {
    public ModEnderStar()
    {
        super("ender_star", 0xB84C67);
        addAspects(ModifierAspect.weaponOnly, new ModifierAspect.SingleAspect(this));
    }
    @Override
    public void apply(ItemStack stack) {
        super.apply(stack);
    }

    @Override
    public void blockHarvestDrops(ItemStack tool, BlockEvent.HarvestDropsEvent event) {
        if(this.isToolWithTrait(tool))
        {
            event.setDropChance(1f);
        }
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit) {
        if(!target.isEntityAlive())
        {
            World world = player.getEntityWorld();
            int chance = world.rand.nextInt(100);
            if(chance <=50)
            {
                ItemStack handItem = player.getHeldItemMainhand();
                NonNullList<IModifier> modifiers = TinkerUtil.getModifiers(handItem);
                int amount = 0;
                for(IModifier mod: modifiers)
                {
                    if(mod instanceof ModLuck)
                    {
                        ModLuck modifier = (ModLuck)mod;
                        amount = modifier.getLuckLevel(handItem);
                    }
                }
                target.entityDropItem(new ItemStack(Items.SKULL, 1+amount, 1), 0);
            }
        }
    }

}
