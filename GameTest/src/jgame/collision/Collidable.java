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

    @Override
    public boolean isColliding(CollidableType otherCollidable) {
        return checkIfXPositionsMeet(otherCollidable) && checkIfYPositionsMeet(otherCollidable);
    }

    // X Coordinate Calculations
    private boolean checkIfXPositionsMeet(CollidableType otherCollidable) {
        int selfXLeading = (int) getPosition().x();
        int selfXTrailing = (int) getPosition().x() + getSize().getWidth();

        int otherXLeading = (int) otherCollidable.getPosition().x();
        int otherXTrailing = (int) otherCollidable.getPosition().x() + otherCollidable.getSize().getWidth();

        return (selfXTrailing >= otherXLeading) && (otherXTrailing >= selfXLeading);
    }

    // Y Coordinate Calculations
    private boolean checkIfYPositionsMeet(CollidableType otherCollidable) {
        int selfYTop = (int) getPosition().y();
        int selfYBottom = (int) getPosition().y() + getSize().getHeight();

        int otherYTop = (int) otherCollidable.getPosition().y();
        int otherYBottom = (int) otherCollidable.getPosition().y() + otherCollidable.getSize().getHeight();

        return (selfYBottom >= otherYTop) && (otherYBottom >= selfYTop);
    }

    public Position getPosition() {
        return position;
    }

    public SizeDimensionsType getSize() {
        return size;
    }
}
