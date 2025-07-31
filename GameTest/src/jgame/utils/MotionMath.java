package jgame.utils;

public abstract class MotionMath {

    private MotionMath() { }

    public static float applyAcceleration(float currentSpeed, float maxSpeed, float accelRate) {
        if (currentSpeed < maxSpeed) {
            currentSpeed += accelRate;
            if (currentSpeed > maxSpeed) currentSpeed = maxSpeed;
        } else if (currentSpeed > maxSpeed) {
            currentSpeed -= accelRate;
            if (currentSpeed < maxSpeed) currentSpeed = maxSpeed;
        }
        return currentSpeed;
    }

    public static float applyDeceleration(float currentSpeed, float decelRate) {
        if (currentSpeed > 0) {
            currentSpeed -= decelRate;
            if (currentSpeed < 0) currentSpeed = 0;
        } else if (currentSpeed < 0) {
            currentSpeed += decelRate;
            if (currentSpeed > 0) currentSpeed = 0;
        }
        return currentSpeed;
    }
}
