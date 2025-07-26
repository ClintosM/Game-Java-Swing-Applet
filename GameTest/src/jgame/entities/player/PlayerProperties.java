package jgame.entities.player;

import jgame.containers.SizeDimensionsType;
import jgame.containers.Vector;
import jgame.entities.common.EntityPropertiesType;

public class PlayerProperties implements EntityPropertiesType {
    private final Vector vector;
    private final SizeDimensionsType size;

    private final float maxSpd = 4;
    private final float currentSpd;

    public PlayerProperties(Vector vector, SizeDimensionsType size) {
        this.currentSpd = maxSpd;
        this.vector = vector;
        this.size = size;
    }

    public float getCurrentSpd() {
        return currentSpd;
    }

    public Vector getVector() {
        return vector;
    }

    public SizeDimensionsType getSize() {
        return size;
    }

    public float getMaxSpd() {
        return currentSpd;
    }
}