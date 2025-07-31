package jgame.utils;

public abstract class MathUtils {

    private MathUtils() { }

    public static int clamp(int value, int min, int max) {
        return Math.min(Math.max(min, value), max);
    }
}
