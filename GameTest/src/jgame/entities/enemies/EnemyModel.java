package jgame.entities.enemies;

import jgame.containers.SizeDimensionsType;
import jgame.entities.common.interfaces.EntityModelType;

public class EnemyModel implements EntityModelType {
    private final SizeDimensionsType size;
    private final float movementSpeed;

    public EnemyModel(SizeDimensionsType size,
                      float movementSpeed) {
        this.size = size;
        this.movementSpeed = movementSpeed;
    }

    public SizeDimensionsType getSize() {
        return size;
    }

    public float getMovementSpeed() {
        return movementSpeed;
    }
}