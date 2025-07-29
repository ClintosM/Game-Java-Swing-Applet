package jgame.entities.player;

import jgame.containers.Position;
import jgame.entities.common.EntityStateType;

public class PlayerState implements EntityStateType {
    private final Position position;
    private float hspd;
    private float vspd;
    private int health;

    public PlayerState(Position initialPosition) {
        this.position = initialPosition;
        this.hspd = 0;
        this.vspd = 0;
        this.health = 100;
    }

    // MARK: - Getters

    public float getHorizontalSpeed() {
        return hspd;
    }

    public float getVerticalSpeed() {
        return vspd;
    }

    public Position getPosition() {
        return position;
    }

    public float getX() {
        return position.x();
    }

    public float getY() {
        return position.y();
    }

    public int getCurrentHealth() {
        return health;
    }

    // MARK: - Operators

    public void setHorizontalSpeed(float newHspd) {
        this.hspd = newHspd;
    }

    public void setVerticalSpeed(float newVspd) {
        this.vspd = newVspd;
    }

    public void moveBy(float dx, float dy) {
        float newX = position.x() + dx;
        float newY = position.y() + dy;
        position.set(newX, newY);
    }
}
