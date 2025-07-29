package jgame.entities.enemies;

import jgame.collision.TileType;
import jgame.containers.Position;
import jgame.containers.SizeDimensionsType;
import jgame.core.EntityRenderable;
import jgame.entities.common.EntityDrawManagerType;
import jgame.entities.common.EntityModelType;
import jgame.entities.common.EntityStateType;
import jgame.entities.common.EntityType;

import java.awt.*;
import java.util.ArrayList;

public class Enemy implements EntityType, EntityRenderable {
    private final EntityModelType model;
    private final EntityStateType state;
    private final EntityDrawManagerType drawManager;

    private final float MOVEMENT_SPEED = 2.0f;
    private final float SIGHT_RADIUS = 256.0f;

    private EnemyStatus status = EnemyStatus.idle;

    public Enemy(Position position,
                 SizeDimensionsType size) {
        this.model = new EnemyModel(size, MOVEMENT_SPEED);
        this.state = new EnemyState(position);
        this.drawManager = new EnemyDrawManager();
    }

    public void render(Graphics2D g) {
        drawManager.render(g, state.getPosition(), model.getSize(), Color.RED);
    }

    // MARK: - Getters

    public boolean isColliding() {
        return false;
    }

    public SizeDimensionsType getSize() {
        return model.getSize();
    }

    public float getMovementSpeed() {
        return model.getMovementSpeed();
    }

    public float getHorizontalSpeed() {
        return state.getHorizontalSpeed();
    }

    public float getVerticalSpeed() {
        return state.getHorizontalSpeed();
    }

    public void setHorizontalSpeed(float newSpd) {
        state.setVerticalSpeed(newSpd);
    }

    public void setVerticalSpeed(float newSpd) {
        state.setHorizontalSpeed(newSpd);
    }

    public Position getPosition() {
        return state.getPosition();
    }

    public float getSightRadius() {
        return SIGHT_RADIUS;
    }

    public EnemyStatus getStatus() {
        return status;
    }

    // MARK: - Operations

    public void moveBy(float dx, float dy) {
        state.moveBy(dx, dy);
    }

    @Override
    public void checkCollisionState(ArrayList<TileType> tiles) {
        // TODO: - Add collision checks for enemy
    }

    public void setStatus(EnemyStatus newStatus) {
        status = newStatus;
    }
}