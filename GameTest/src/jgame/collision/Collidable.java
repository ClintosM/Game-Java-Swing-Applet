package jgame.collision;

import jgame.containers.Vector;

public class Collidable implements CollidableType {

    private final Vector vector;

    public Collidable(Vector vector) {
        this.vector = vector;
    }

    @Override
    public boolean isColliding(CollidableType otherCollidable) {
        //boolean xPosition = vector.getX();//
        return true;
    }

    @Override
    public Vector getVector() {
        return vector;
    }
}
