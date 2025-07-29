package jgame.entities.player;

import jgame.containers.SizeDimensionsType;
import jgame.entities.common.EntityModelType;

public class PlayerModel implements EntityModelType {
    private final SizeDimensionsType size;
    private final float movementSpeed;

    public PlayerModel(SizeDimensionsType size,
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
