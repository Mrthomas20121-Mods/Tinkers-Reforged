package mrthomas20121.tinkers_reforged;

import net.minecraftforge.common.ForgeConfigSpec;

public class TinkersReforgedConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final CommonConfig COMMON = new CommonConfig(BUILDER);
    public static final ForgeConfigSpec config = BUILDER.build();

    public static class CommonConfig {

        public OreConfig bauxiteOre;
        public OreConfig kepuOre;
        public ForgeConfigSpec.ConfigValue<Float> adaptingModifierCap;

        CommonConfig(ForgeConfigSpec.Builder builder) {
            builder.comment("Bauxite Ore Worldgen").push("bauxite_ore");
            bauxiteOre = new BauxiteOreConfig(builder);
            builder.pop();
            builder.comment("Kepu Ore Worldgen").push("kepu_ore");
            kepuOre = new KepuOreConfig(builder);

            builder.push("modifiers");

            adaptingModifierCap = builder.comment("Default Modifier Cap for adapting").define("adaptingModifierCap", 10f);
        }
    }

    public static class OreConfig {
        public ForgeConfigSpec.BooleanValue enabled;
        public ForgeConfigSpec.IntValue minY;
        public ForgeConfigSpec.IntValue maxY;
        public ForgeConfigSpec.IntValue count;
        public ForgeConfigSpec.IntValue size;

        public OreConfig(ForgeConfigSpec.Builder builder) {
        }

        public boolean isEnabled() {
            return enabled.get();
        }

        public int getCount() {
            return count.get();
        }

        public int getSize() {
            return size.get();
        }

        public int getMaxY() {
            return maxY.get();
        }

        public int getMinY() {
            return minY.get();
        }
    }

    public static class BauxiteOreConfig extends OreConfig {

        public BauxiteOreConfig(ForgeConfigSpec.Builder builder) {
            super(builder);
            this.enabled = builder.comment("Enable/Disable Bauxite ore").define("bauxiteOreEnabled", true);
            this.minY = builder.comment("Min Y level").defineInRange("minY", -60, -60, 256);
            this.maxY = builder.comment("Max Y Level").defineInRange("maxY", 120, -60, 256);
            this.count = builder.comment("Ore vein count").defineInRange("veinCount", 80, 1, 100);
            this.size = builder.comment("Ore vein size").defineInRange("veinSize", 4, 1, 10);
        }
    }

    public static class KepuOreConfig extends OreConfig {

        public KepuOreConfig(ForgeConfigSpec.Builder builder) {
            super(builder);
            this.enabled = builder.comment("Enable/Disable Kepu ore").define("kepuOreEnabled", true);
            this.minY = builder.comment("Min Y level").defineInRange("minY", -20, -60, 256);
            this.maxY = builder.comment("Max Y Level").defineInRange("maxY", 100, -60, 256);
            this.count = builder.comment("Ore vein count").defineInRange("veinCount", 20, 1, 40);
            this.size = builder.comment("Ore vein size").defineInRange("veinSize", 3, 1, 40);
        }
    }
}
