package mrthomas20121.tinkers_reforged;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class TinkersReforgedConfig {

    public static final CommonConfig COMMON;
    public static final ForgeConfigSpec config;

    static {
        final Pair<CommonConfig, ForgeConfigSpec> pair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        COMMON = pair.getLeft();
        config = pair.getRight();
    }

    public static class CommonConfig {

        public final ForgeConfigSpec.ConfigValue<Float> adaptingModifierCap;
        public final OreConfig bauxiteOre;
        public final OreConfig kepuOre;
        public final OreConfig epidoteOre;
        public final OreConfig hureauliteOre;
        public final OreConfig redBerylOre;

        CommonConfig(ForgeConfigSpec.Builder builder) {
            adaptingModifierCap = builder.comment("Default Modifier Cap for adapting").define("adaptingModifierCap", 10f);
            builder.comment("Bauxite Ore Worldgen").push("bauxite_ore");
            bauxiteOre = new BauxiteOreConfig(builder);
            builder.pop();
            builder.comment("Kepu Ore Worldgen").push("kepu_ore");
            kepuOre = new KepuOreConfig(builder);
            builder.pop();
            builder.comment("Epidote Ore Worldgen").push("epidote_ore");
            epidoteOre = new EpidoteOreConfig(builder);
            builder.pop();
            builder.comment("Hureaulite Ore Worldgen").push("hureaulite_ore");
            hureauliteOre = new HureauliteOreConfig(builder);
            builder.pop();
            builder.comment("Red Beryl Ore Worldgen").push("red_beryl_ore");
            redBerylOre = new RedBerylOreConfig(builder);
            builder.pop();
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
            this.enabled = builder.worldRestart().comment("Enable/Disable Bauxite ore").define("bauxiteOreEnabled", true);
            this.minY = builder.comment("Min Y level").defineInRange("minY", -60, -60, 256);
            this.maxY = builder.comment("Max Y Level").defineInRange("maxY", 120, -60, 256);
            this.count = builder.comment("Ore vein count").defineInRange("veinCount", 50, 1, 100);
            this.size = builder.comment("Ore vein size").defineInRange("veinSize", 4, 1, 10);
        }
    }

    public static class KepuOreConfig extends OreConfig {

        public KepuOreConfig(ForgeConfigSpec.Builder builder) {
            super(builder);
            this.enabled = builder.worldRestart().comment("Enable/Disable Kepu ore").define("kepuOreEnabled", true);
            this.minY = builder.comment("Min Y level").defineInRange("minY", -20, -60, 256);
            this.maxY = builder.comment("Max Y Level").defineInRange("maxY", 100, -60, 256);
            this.count = builder.comment("Ore vein count").defineInRange("veinCount", 20, 1, 40);
            this.size = builder.comment("Ore vein size").defineInRange("veinSize", 3, 1, 40);
        }
    }

    public static class EpidoteOreConfig extends OreConfig {

        public EpidoteOreConfig(ForgeConfigSpec.Builder builder) {
            super(builder);
            this.enabled = builder.worldRestart().comment("Enable/Disable Epidote ore").define("epidoteOreEnabled", true);
            this.minY = builder.comment("Min Y level").defineInRange("minY", -60, -60, 256);
            this.maxY = builder.comment("Max Y Level").defineInRange("maxY", 5, -60, 5);
            this.count = builder.comment("Ore vein count").defineInRange("veinCount", 20, 1, 40);
            this.size = builder.comment("Ore vein size").defineInRange("veinSize", 4, 1, 40);
        }
    }

    public static class HureauliteOreConfig extends OreConfig {

        public HureauliteOreConfig(ForgeConfigSpec.Builder builder) {
            super(builder);
            this.enabled = builder.worldRestart().comment("Enable/Disable Hureaulite ore").define("hureauliteOreEnabled", true);
            this.minY = builder.comment("Min Y level").defineInRange("minY", -60, -80, 0);
            this.maxY = builder.comment("Max Y Level").defineInRange("maxY", 5, -60, 5);
            this.count = builder.comment("Ore vein count").defineInRange("veinCount", 20, 1, 40);
            this.size = builder.comment("Ore vein size").defineInRange("veinSize", 4, 1, 40);
        }
    }

    public static class RedBerylOreConfig extends OreConfig {

        public RedBerylOreConfig(ForgeConfigSpec.Builder builder) {
            super(builder);
            this.enabled = builder.comment("Enable/Disable Red Beryl ore").define("redBerylOreEnabled", true);
            this.minY = builder.comment("Min Y level").defineInRange("minY", -40, -60, 256);
            this.maxY = builder.comment("Max Y Level").defineInRange("maxY", 60, -60, 256);
            this.count = builder.comment("Ore vein count").defineInRange("veinCount", 40, 1, 100);
            this.size = builder.comment("Ore vein size").defineInRange("veinSize", 5, 1, 10);
        }
    }
}
