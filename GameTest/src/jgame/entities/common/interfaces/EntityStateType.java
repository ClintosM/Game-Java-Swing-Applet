package jgame.entities.common.interfaces;

import jgame.collision.CollidableType;
import jgame.containers.Position;

public interface EntityStateType {
    public int getCurrentHealth();
    public float getXVelocity();
    public float getYVelocity();

    public Position getPosition();
    public float getX();
    public float getY();

    public void setXVelocity(float newVel);
    public void setYVelocity(float newVel);

    public void moveBy(float dx, float dy);
    public void moveTo(float x, float y);

    public CollidableType getCollidable();
}
