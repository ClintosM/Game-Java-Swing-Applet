package jgame.collision;

import jgame.containers.Vector;

public interface CollidableType {

    boolean isColliding(CollidableType otherCollidable);

    Vector getVector();

}