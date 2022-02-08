package mrthomas20121.tinkers_reforged.datagen;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialRenderInfoProvider;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;

import javax.annotation.Nonnull;

public class ReforgedRenderInfo extends AbstractMaterialRenderInfoProvider {

    public ReforgedRenderInfo(DataGenerator gen, AbstractMaterialSpriteProvider spriteProvider) {
        super(gen, spriteProvider);
    }

    @Override
    protected void addMaterialRenderInfo() {

    }

    @Nonnull
    @Override
    public String getName() {
        return "Tinkers Reforged Render info provider!";
    }
}
