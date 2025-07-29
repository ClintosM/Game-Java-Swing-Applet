package jgame.collision;

import jgame.containers.Position;
import jgame.containers.SizeDimensionsType;

public interface CollidableType {

    boolean isColliding(CollidableType otherCollidable);

    Position getPosition();

    SizeDimensionsType getSize();
}