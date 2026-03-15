package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraftforge.event.entity.EntityTeleportEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.mantle.registration.deferred.AttributeDeferredRegister;
import slimeknights.tconstruct.TConstruct;

public class TinkersReforgedAttributes {

    public static final AttributeDeferredRegister ATTRIBUTES = new AttributeDeferredRegister(TinkersReforged.MOD_ID);

    public TinkersReforgedAttributes() {
        ATTRIBUTES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // reduce the damage taken from ender pearl
    public static final RegistryObject<Attribute> ENDER_PEARL_REDUCTION = ATTRIBUTES.registerPercent("player.ender_pearl_reduction", 0f, true);
}
