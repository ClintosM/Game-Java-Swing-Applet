package jgame.collision;

import jgame.containers.SizeDimensionsType;
import jgame.containers.Vector;

public interface CollidableType {

    boolean isColliding(CollidableType otherCollidable);

    Vector getVector();

    SizeDimensionsType getSize();
}