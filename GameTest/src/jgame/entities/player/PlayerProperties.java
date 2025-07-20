package jgame.entities.player;

public class PlayerProperties {
    private final float maxSpd = 4;
    private float currentSpd;

    private final float accel = 1;
    private final float deccel = 1;

    public PlayerProperties() {
        this.currentSpd = 0.1f;
    }

    protected float getCurrentSpd() {
        return currentSpd;
    }

    protected void increaseCurrentSpd(float amountIncrease) {
        if (currentSpd < maxSpd) {
            currentSpd += amountIncrease;
        }
    }

    protected void decreaseCurrentSpd(float amountDecrease) {
        if (currentSpd > 0) {
            currentSpd -= amountDecrease;
        }

        if (currentSpd < 0) {
            currentSpd = 0;
        }
    }

    protected float getMaxSpd() {
        return currentSpd;
    }
}