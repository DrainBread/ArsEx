package com.arsex.api.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Lib {
    public static Minecraft mc() {
        return Minecraft.getInstance();
    }

    public static boolean isPlayer(Entity entity) {
        return entity instanceof PlayerEntity;
    }

    public static PlayerEntity getPlayerEntity(Entity entity) {
        if (entity instanceof PlayerEntity)
            return (PlayerEntity)entity;
        return null;
    }

    public static boolean isClient(PlayerEntity player) {
        return player.getCommandSenderWorld().isClientSide();
    }

    public static World getWorld(PlayerEntity player) {
        return player.getCommandSenderWorld();
    }

    public static boolean isClient(World world) {
        return world.isClientSide();
    }

    public static PlayerEntity getPlayer() {
        return (PlayerEntity)(mc()).player;
    }
    /*
    public static void firework(World world, ItemStack itemstack, PlayerEntity player) {
        FireworkRocketEntity entityfireworkrocket = new FireworkRocketEntity(world, itemstack, (LivingEntity)player);
        entityfireworkrocket.func_70107_b((player.func_213303_ch()).field_72450_a, (player.func_213303_ch()).field_72448_b, (player.func_213303_ch()).field_72449_c);
        entityfireworkrocket.func_199701_a_(entityfireworkrocket.func_184543_l());
    }
    */
}