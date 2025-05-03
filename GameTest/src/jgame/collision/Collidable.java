package jgame.collision;

import jgame.containers.SizeDimensions;
import jgame.containers.SizeDimensionsType;
import jgame.containers.Vector;

public class Collidable implements CollidableType {

    private final Vector vector;
    private final SizeDimensionsType size;

    public Collidable(Vector vector, SizeDimensionsType size) {
        this.vector = vector;
        this.size = size;
    }

    @Override
    public boolean isColliding(CollidableType otherCollidable) {
        return checkIfXPositionsMeet(otherCollidable) && checkIfYPositionsMeet(otherCollidable);
    }

    // X Coordinate Calculations
    private boolean checkIfXPositionsMeet(CollidableType otherCollidable) {
        int selfXLeading = (int) getVector().getX();
        int selfXTrailing = (int) getVector().getX() + getSize().getWidth();

        int otherXLeading = (int) otherCollidable.getVector().getX();
        int otherXTrailing = (int) otherCollidable.getVector().getX() + otherCollidable.getSize().getWidth();

        return (selfXTrailing >= otherXLeading) && (otherXTrailing >= selfXLeading);
    }

    // Y Coordinate Calculations
    private boolean checkIfYPositionsMeet(CollidableType otherCollidable) {
        int selfYTop = (int) getVector().getY();
        int selfYBottom = (int) getVector().getY() + getSize().getHeight();

        int otherYTop = (int) otherCollidable.getVector().getY();
        int otherYBottom = (int) otherCollidable.getVector().getY() + otherCollidable.getSize().getHeight();

        return (selfYBottom >= otherYTop) && (otherYBottom >= selfYTop);
    }

    @Override
    public Vector getVector() {
        return vector;
    }

    public SizeDimensionsType getSize() {
        return size;
    }
}
