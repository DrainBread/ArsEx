package com.arsex.mod.events;

import com.github.clevernucleus.playerex.api.ExAPI;
import com.github.clevernucleus.playerex.api.attribute.PlayerAttributes;
import com.hollingsworth.arsnouveau.api.event.SpellModifierEvent;
import com.hollingsworth.arsnouveau.api.event.ManaRegenCalcEvent;
import com.hollingsworth.arsnouveau.api.event.MaxManaCalcEvent;
import com.hollingsworth.arsnouveau.api.spell.SpellContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlayerExArsEvents {

    private static final Logger LOGGER = LogManager.getLogger();

    @SubscribeEvent
    public void arsManaPoolForExEvent(MaxManaCalcEvent event){
        LivingEntity caster = event.getEntityLiving();

        if (caster instanceof PlayerEntity){
            ExAPI.playerAttributes((PlayerEntity) caster).ifPresent(a -> {
                double intelligence = a.get((PlayerEntity) caster, PlayerAttributes.INTELLIGENCE);
                int maxMp = (int)(event.getMax() + (ArsExConfig.MANA_PER_INTELLIGENCE.get()).doubleValue() * intelligence);
                event.setMax(maxMp);
            });
        }
    }

    @SubscribeEvent
    public void arsManaRegenForExEvent(ManaRegenCalcEvent event){
        LivingEntity caster = event.getEntityLiving();

        if (caster instanceof PlayerEntity){
            ExAPI.playerAttributes((PlayerEntity) caster).ifPresent(a -> {
                double intelligence = a.get((PlayerEntity) caster, PlayerAttributes.INTELLIGENCE);
                double regen = event.getRegen() + (ArsExConfig.REGEN_PER_INTELLIGENCE.get()).doubleValue() * intelligence;
                event.setRegen(regen);
            });
        }
    }

    @SubscribeEvent
    public void arsMagicDamageForExEvent(SpellModifierEvent event) {
        SpellContext context = event.spellContext;
        LivingEntity caster = context.getCaster();

        if (caster instanceof PlayerEntity) {
            ExAPI.playerAttributes((PlayerEntity) caster).ifPresent(a -> {
                double intelligence = a.get((PlayerEntity) caster, PlayerAttributes.INTELLIGENCE);

                // Damage Modifier
                event.builder.addDamageModifier(((Double) ArsExConfig.DAMAGE_BONUS_PER_INTELLIGENCE.get()).doubleValue() * intelligence);

                // Amplification
                event.builder.addAmplification(((Double) ArsExConfig.AMPLIFICATION_PER_INTELLIGENCE.get()).doubleValue() * intelligence);

                // Duration
                event.builder.addDurationModifier(((Double) ArsExConfig.DURATION_PER_INTELLIGENCE.get()).doubleValue() * intelligence);
            });
        }
    }
}

