package jgame.entities.common;

import jgame.containers.Position;
import jgame.containers.SizeDimensionsType;

public interface EntityModelType {
    SizeDimensionsType getSize();
    float getMovementSpeed();

    default int getWidth() {
        return getSize().getWidth();
    }

    default int getHeight() {
        return getSize().getHeight();
    }
}
