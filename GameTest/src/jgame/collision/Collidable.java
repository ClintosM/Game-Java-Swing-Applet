package jgame.collision;

import jgame.containers.Position;
import jgame.containers.SizeDimensionsType;

public class Collidable implements CollidableType {
    private final Position position;
    private final SizeDimensionsType size;

    public Collidable(Position position, SizeDimensionsType size) {
        this.position = position;
        this.size = size;
    }

    public boolean isColliding(CollidableType otherCollidable) {
        return checkIfXPositionsMeet(otherCollidable) && checkIfYPositionsMeet(otherCollidable);
    }

    // Horizontal Coordinate Calculations
    private boolean checkIfXPositionsMeet(CollidableType otherCollidable) {
        int selfLeft = (int) position.x();
        int selfRight = selfLeft + size.getWidth();

        int otherLeft = (int) otherCollidable.getPosition().x();
        int otherRight = otherLeft + otherCollidable.getSize().getWidth();

        return (selfRight >= otherLeft) && (otherRight >= selfLeft);
    }

    // Vertical Coordinate Calculations
    private boolean checkIfYPositionsMeet(CollidableType otherCollidable) {
        int selfTop = (int) position.y();
        int selfBottom = selfTop + size.getHeight();

        int otherTop = (int) otherCollidable.getPosition().y();
        int otherBottom = otherTop + otherCollidable.getSize().getHeight();

        return (selfBottom >= otherTop) && (otherBottom >= selfTop);
    }

    public Position getPosition() { return position; }

    public SizeDimensionsType getSize() { return size; }
}
