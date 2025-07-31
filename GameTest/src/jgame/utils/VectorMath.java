package jgame.utils;

import jgame.containers.Position;

public abstract class VectorMath {
    private VectorMath() { }

    public static float getNormalisedX(Position positionA, Position positionB) {
        float xDiff = positionB.x() - positionA.x();
        return xDiff / signedDistance(positionA, positionB);
    }

    public static float getNormalisedY(Position positionA, Position positionB) {
        float yDiff = positionB.y() - positionA.y();
        return yDiff / signedDistance(positionA, positionB);
    }

    public static float absoluteDistance(Position positionA, Position positionB) {
        float xDiff = Math.abs(positionA.x() - positionB.x());
        float yDiff = Math.abs(positionA.y() - positionB.y());
        float aSquared = xDiff * xDiff;
        float bSquared = yDiff * yDiff;

        return ((float) Math.sqrt(aSquared + bSquared));
    }

    public static float signedDistance(Position positionA, Position positionB) {
        float xDiff = positionA.x() - positionB.x();
        float yDiff = positionA.y() - positionB.y();
        float aSquared = xDiff * xDiff;
        float bSquared = yDiff * yDiff;

        return ((float) Math.sqrt(aSquared + bSquared));
    }
}
