package com.arsex.api.utils;

import java.util.Collection;
import javax.annotation.Nullable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class Alchemy {
    public static void apply(LivingEntity entity, Effect effect, int duration, int multiplier) {
        entity.addEffect(new EffectInstance(effect, duration, multiplier));
    }

    public static void apply(LivingEntity entity, Effect effect, int duration) {
        entity.addEffect(new EffectInstance(effect, duration, 0));
    }

    public static void apply(LivingEntity entity, Effect effect) {
        entity.addEffect(new EffectInstance(effect, Solver.asTicks(6.0D), 0));
    }

    @Nullable
    public static Effect getEffect(ResourceLocation key) {
        return (Effect)ForgeRegistries.POTIONS.getValue(key);
    }

    public static void clearBad(LivingEntity entity, Collection<EffectInstance> effect) {
        for (EffectInstance ef : effect) {
            if (!ef.getEffect().isBeneficial() && ef.getAmplifier() <= 0)
                entity.removeEffect(ef.getEffect());
        }
    }
}
