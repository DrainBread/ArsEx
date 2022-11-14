package com.arsex.api.utils;

import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class Aterna {
    public static void translateAndSay(PlayerEntity caster, String msg) {
        caster.sendMessage((ITextComponent)new TranslationTextComponent(msg), caster.getUUID());
    }

    public static void translateAndSay(PlayerEntity caster, String msg, Object... args) {
        caster.sendMessage((ITextComponent)new TranslationTextComponent(msg, args), caster.getUUID());
    }

    public static void translateAndSay(PlayerEntity caster, String msg, boolean inBar) {
        caster.displayClientMessage((ITextComponent)new TranslationTextComponent(msg), inBar);
    }

    public static void translateAndSay(PlayerEntity caster, boolean inBar, String msg, Object... args) {
        caster.displayClientMessage((ITextComponent)new TranslationTextComponent(msg, args), inBar);
    }

    public static String translate(String msg) {
        return I18n.get(msg, new Object[0]);
    }

    public static ITextComponent translation(String msg) {
        return (ITextComponent)new TranslationTextComponent(msg);
    }

    public static String capitalize(@Nullable String msg) {
        if (msg != null)
            return msg.substring(0, 1).toUpperCase() + msg.substring(1);
        return "";
    }

    public static String capitalize(@Nullable String msg, String replace) {
        if (msg != null)
            return msg.substring(0, 1).toUpperCase() + msg.substring(1);
        return replace;
    }

    public static void messageBar(PlayerEntity caster, ITextComponent msg) {
        caster.displayClientMessage(msg, true);
    }

    public static void messageChat(PlayerEntity caster, ITextComponent message) {
        caster.displayClientMessage(message, false);
    }

    public static void messageBar(PlayerEntity caster, String message) {
        caster.displayClientMessage((ITextComponent)new StringTextComponent(message), true);
    }

    public static void messageBar(PlayerEntity caster, String... message) {
        for (String s : message)
            caster.displayClientMessage((ITextComponent)new StringTextComponent(s), true);
    }

    public static void messageChat(PlayerEntity caster, String message) {
        caster.displayClientMessage((ITextComponent)new StringTextComponent(message), false);
    }

    public static void messageChat(PlayerEntity caster, String... message) {
        for (String s : message)
            caster.displayClientMessage((ITextComponent)new StringTextComponent(s), false);
    }

    public static void message(PlayerEntity caster, String message) {
        caster.sendMessage((ITextComponent)new StringTextComponent(message), caster.getUUID());
    }

    public static void playSound(PlayerEntity player, SoundEvent sound) {
        player.playSound(sound, 0.7F, 1.0F);
    }

    public static void playSound(SoundEvent sound) {
        if ((Minecraft.getInstance()).player != null)
            (Minecraft.getInstance()).player.playSound(sound, 0.7F, 1.0F);
    }

    public static void playSound(SoundEvent sound, float volume) {
        if ((Minecraft.getInstance()).player != null)
            (Minecraft.getInstance()).player.playSound(sound, volume, 1.0F);
    }

    public static void playSound(SoundEvent sound, float volume, float pitch) {
        if ((Minecraft.getInstance()).player != null)
            (Minecraft.getInstance()).player.playSound(sound, volume, pitch);
    }
}
