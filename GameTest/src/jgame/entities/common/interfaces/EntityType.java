package jgame.entities.common.interfaces;

import jgame.collision.CollidableType;
import jgame.containers.Position;
import jgame.containers.SizeDimensionsType;

public interface EntityType {
    public SizeDimensionsType getSize();
    public CollidableType getCollidable();

    public Position getPosition();
    public float getMovementSpeed();

    public float getXVelocity();
    public float getYVelocity();
    public void setXVelocity(float newVel);
    public void setYVelocity(float newVel);

    public void moveBy(float dx, float dy);
    public void moveTo(float x, float y);
}