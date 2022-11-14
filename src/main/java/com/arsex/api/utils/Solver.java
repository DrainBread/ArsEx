package com.arsex.api.utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.entity.Entity;

public class Solver {
    public static float normalize(float value, float min, float max) {
        return (value - min) / (max - min);
    }

    public static boolean doEvery(Entity entity, double seconds) {
        return (entity.tickCount % (int)(seconds * 20.0D) == 0);
    }

    public static boolean doEvery(int Value, double seconds) {
        return (Value % (int)(seconds * 20.0D) == 0);
    }

    public static int percentOf(double value, double max) {
        return (int)(value / max) * 100;
    }

    public static int asTicks(double seconds) {
        return (int)(seconds * 20.0D);
    }

    public static double asSeconds(int ticks) {
        return ticks / 20.0D;
    }

    public static boolean rangeCheck(double value, double range_min, double range_max) {
        return (value >= range_min && value <= range_max);
    }

    public static int randInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static float randFloat(float min, float max) {
        Random r = new Random();
        return min + r.nextFloat() * (max - min);
    }

    public static double randDouble(double min, double max) {
        Random r = new Random();
        return min + r.nextDouble() * (max - min);
    }

    public static double randRange(double value) {
        Random r = new Random();
        return -value + r.nextDouble() * (value - -value);
    }

    public static boolean chance(int chance) {
        return (randInt(1, 100) <= chance);
    }
}