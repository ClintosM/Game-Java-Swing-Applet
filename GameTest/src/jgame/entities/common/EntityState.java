package jgame.entities.common;

import jgame.collision.Collidable;
import jgame.collision.CollidableType;
import jgame.containers.Position;
import jgame.containers.SizeDimensionsType;
import jgame.entities.common.interfaces.Damageable;
import jgame.entities.common.interfaces.DamageableType;
import jgame.entities.common.interfaces.EntityStateType;

public abstract class EntityState implements EntityStateType {

    private final int MAX_HEALTH = 100;

    private final Position position;
    private final CollidableType collidable;
    private final DamageableType damageable;

    private float xVel;
    private float yVel;

    public EntityState(Position initialPosition, SizeDimensionsType size) {
        this.position = initialPosition;
        this.collidable = new Collidable(position, size);
        this.damageable = new Damageable(MAX_HEALTH);

        this.xVel = 0;
        this.yVel = 0;
    }

    // MARK: - Getters

    public int getCurrentHealth() { return damageable.getCurrentHealth(); }

    public Position getPosition() { return position; }

    public float getX() { return position.x(); }

    public float getY() { return position.y(); }

    public float getXVelocity() { return xVel; }

    public float getYVelocity() { return yVel; }

    public CollidableType getCollidable() { return collidable; }

    // MARK: - Operators

    public void setXVelocity(float newVel) { this.xVel = newVel; }

    public void setYVelocity(float newVel) { this.yVel = newVel; }

    public void moveBy(float dx, float dy) {
        float newX = position.x() + dx;
        float newY = position.y() + dy;
        position.set(newX, newY);
    }

    public void moveTo(float x, float y) {
        position.set(x, y);
    }
}
