package jgame.entities.common;

import jgame.containers.Position;

public interface EntityStateType {
    public int getCurrentHealth();
    public float getHorizontalSpeed();
    public float getVerticalSpeed();

    public Position getPosition();
    public float getX();
    public float getY();

    public void setHorizontalSpeed(float newSpd);
    public void setVerticalSpeed(float newSpd);

    public void moveBy(float dx, float dy);
}
