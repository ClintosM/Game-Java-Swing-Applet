package jgame.entities.player;

import jgame.collision.CollidableType;
import jgame.containers.Position;
import jgame.containers.SizeDimensionsType;
import jgame.core.render.interfaces.EntityRenderable;
import jgame.entities.common.interfaces.EntityDrawManagerType;
import jgame.entities.common.interfaces.EntityModelType;
import jgame.entities.common.interfaces.EntityStateType;
import jgame.entities.common.interfaces.EntityType;

import java.awt.*;

public final class Player implements EntityType, EntityRenderable {
    private final EntityModelType model;
    private final EntityStateType state;
    private final EntityDrawManagerType drawManager;

    private final float MOVEMENT_SPEED = 4.0f;

    public Player(Position position,
                  SizeDimensionsType size) {
        this.model = new PlayerModel(size, MOVEMENT_SPEED);
        this.state = new PlayerState(position, size);
        this.drawManager = new PlayerDrawManager();
    }

    public void render(Graphics2D g) {
        drawManager.render(
                g,
                state.getPosition(),
                model.getSize(),
                Color.BLUE
        );
    }

    // MARK: - Getters

    public SizeDimensionsType getSize() { return model.getSize(); }

    public float getMovementSpeed() { return model.getMovementSpeed(); }

    public CollidableType getCollidable() { return state.getCollidable(); }

    public float getXVelocity() { return state.getXVelocity(); }

    public float getYVelocity() { return state.getYVelocity(); }

    public Position getPosition() { return state.getPosition(); }

    public float getX() { return state.getX(); }

    public float getY() { return state.getY(); }

    // MARK: - Operations

    public void setXVelocity(float newVel) { state.setXVelocity(newVel); }

    public void setYVelocity(float newVel) { state.setYVelocity(newVel); }

    public void moveBy(float dx, float dy) { state.moveBy(dx, dy); }

    public void moveTo(float x, float y) { state.moveTo(x, y); }
}

