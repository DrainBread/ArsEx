package com.arsex.mod.events;

import net.minecraftforge.common.ForgeConfigSpec;

public class ArsExConfig {
    public static ForgeConfigSpec COMMON_CONFIG;

    public static ForgeConfigSpec.DoubleValue DAMAGE_BONUS_PER_INTELLIGENCE;

    public static ForgeConfigSpec.DoubleValue AMPLIFICATION_PER_INTELLIGENCE;

    public static ForgeConfigSpec.DoubleValue DURATION_PER_INTELLIGENCE;

    public static ForgeConfigSpec.DoubleValue REGEN_PER_INTELLIGENCE;

    public static ForgeConfigSpec.DoubleValue MANA_PER_INTELLIGENCE;

    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
        COMMON_BUILDER.comment("General settings").push("general");
        DAMAGE_BONUS_PER_INTELLIGENCE = COMMON_BUILDER.comment("Damage bonus per intelligence").defineInRange("damage_modifier", 0.2D, 0.0D, Double.MAX_VALUE);
        AMPLIFICATION_PER_INTELLIGENCE = COMMON_BUILDER.comment("Amplification per intelligence").defineInRange("amplify_modifier", 0.1D, 0.0D, Double.MAX_VALUE);
        DURATION_PER_INTELLIGENCE = COMMON_BUILDER.comment("Duration per intelligence").defineInRange("duration_modifier", 0.25D, 0.0D, Double.MAX_VALUE);
        REGEN_PER_INTELLIGENCE = COMMON_BUILDER.comment("Mana Regen per Intelligence").defineInRange("mana_regen_modifier", 0.2D, 0.0D, Double.MAX_VALUE);
        MANA_PER_INTELLIGENCE = COMMON_BUILDER.comment("Max Mana per Intelligence").defineInRange("mana_pool_modifier", 10.0D, 0.0D, Double.MAX_VALUE);
        COMMON_BUILDER.pop();
        COMMON_CONFIG = COMMON_BUILDER.build();
    }
}
