package jgame.entities.enemies;

import jgame.collision.CollidableType;
import jgame.containers.Position;
import jgame.containers.SizeDimensionsType;
import jgame.core.render.interfaces.EntityRenderable;
import jgame.entities.common.interfaces.EntityDrawManagerType;
import jgame.entities.common.interfaces.EntityModelType;
import jgame.entities.common.interfaces.EntityStateType;
import jgame.entities.common.interfaces.EntityType;

import java.awt.*;

public final class Enemy implements EntityType, EntityRenderable {
    private final EntityModelType model;
    private final EntityStateType state;
    private final EntityDrawManagerType drawManager;

    private final float MOVEMENT_SPEED = 3.4f;
    private final float SIGHT_RADIUS = 256.0f;

    private EnemyStatus status = EnemyStatus.idle;

    public Enemy(Position position,
                 SizeDimensionsType size) {
        this.model = new EnemyModel(size, MOVEMENT_SPEED);
        this.state = new EnemyState(position, size);
        this.drawManager = new EnemyDrawManager();
    }

    public void render(Graphics2D g) {
        drawManager.render(
                g,
                state.getPosition(),
                model.getSize(),
                Color.RED
        );
    }

    // MARK: - Getters

    public SizeDimensionsType getSize() {
        return model.getSize();
    }

    public CollidableType getCollidable() { return state.getCollidable(); }

    public float getMovementSpeed() { return model.getMovementSpeed(); }

    public float getXVelocity() { return state.getXVelocity(); }

    public float getYVelocity() { return state.getYVelocity(); }

    public Position getPosition() { return state.getPosition(); }

    public float getSightRadius() { return SIGHT_RADIUS; }

    public EnemyStatus getStatus() { return status; }

    // MARK: - Operations

    public void setXVelocity(float newVel) { state.setXVelocity(newVel); }

    public void setYVelocity(float newVel) { state.setYVelocity(newVel); }

    public void moveBy(float dx, float dy) { state.moveBy(dx, dy); }

    @Override
    public void moveTo(float x, float y) { state.moveTo(x, y); }

    public void setStatus(EnemyStatus newStatus) { status = newStatus; }
}