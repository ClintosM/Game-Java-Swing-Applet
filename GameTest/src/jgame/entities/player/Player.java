package jgame.entities.player;

import jgame.collision.Collidable;
import jgame.collision.CollidableType;
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

public class Player implements EntityType, EntityRenderable {
    private final EntityModelType model;
    private final EntityStateType state;
    private final EntityDrawManagerType drawManager;
    private final PlayerCollisionManager collisionManager;

    private final float MOVEMENT_SPEED = 4.0f;

    public Player(Position position,
                  SizeDimensionsType size) {
        this.model = new PlayerModel(size, MOVEMENT_SPEED);
        this.state = new PlayerState(position);
        this.drawManager = new PlayerDrawManager();

        CollidableType collidable = new Collidable(position, size);
        this.collisionManager = new PlayerCollisionManager(collidable);
    }

    public void render(Graphics2D g) {
        Color color = collisionManager.checkIsColliding() ? Color.GREEN : Color.BLUE;
        drawManager.render(
                g,
                state.getPosition(),
                model.getSize(),
                color
        );
    }

    public void checkCollisionState(ArrayList<TileType> tiles) {
        for (TileType tile : tiles) {
            collisionManager.checkForCollisions(tile.getCollidable());
        }
    }

    // MARK: - Getters

    public boolean isColliding() {
        return collisionManager.checkIsColliding();
    }

    public float getMovementSpeed() {
        return model.getMovementSpeed();
    }

    public SizeDimensionsType getSize() {
        return model.getSize();
    }

    public float getHorizontalSpeed() {
        return state.getHorizontalSpeed();
    }

    public float getVerticalSpeed() {
        return state.getVerticalSpeed();
    }

    public Position getPosition() {
        return state.getPosition();
    }

    public float getX() {
        return state.getX();
    }

    public float getY() {
        return state.getY();
    }

    // MARK: - Operations

    public void setHorizontalSpeed(float newHspd) {
        state.setHorizontalSpeed(newHspd);
    }

    public void setVerticalSpeed(float newVspd) {
        state.setVerticalSpeed(newVspd);
    }

    public void moveBy(float dx, float dy) {
        state.moveBy(dx, dy);
    }
}

