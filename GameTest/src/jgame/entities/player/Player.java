package jgame.entities.player;

import jgame.collision.Collidable;
import jgame.collision.CollidableType;
import jgame.containers.SizeDimensionsType;
import jgame.containers.Vector;
import jgame.entities.common.EntityType;

import java.awt.*;
import java.awt.event.KeyListener;

public class Player implements EntityType {
    private final Vector vector;
    private final SizeDimensionsType size;
    private final PlayerController controller;
    private final CollidableType collidable;

    private PlayerState playerState = PlayerState.idle;

    private PlayerProperties playerProperties = new PlayerProperties();

    public Player(PlayerController controller, Vector vector, SizeDimensionsType size) {
        this.controller = controller;
        this.vector = vector;
        this.size = size;
        this.collidable = new Collidable(vector, size);
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(isColliding ? Color.GREEN : Color.BLUE);
        g.fillRect(
                (int) vector.getX(),
                (int) vector.getY(),
                size.getWidth(),
                size.getHeight()
        );
    }

    @Override
    public void update() {
        controller.update(this);
    }

    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
    }

    // MARK: - Getters

    private CollidableType currentCollidable = null;
    private boolean isColliding = false;

    public void checkForCollisions(CollidableType otherCollidable) {
        if (otherCollidable == null) return;

        boolean isCollidingNow = collidable.isColliding(otherCollidable);

        if (isCollidingNow) {
            currentCollidable = otherCollidable;
            isColliding = true;
        } else if (currentCollidable != null && !collidable.isColliding(currentCollidable)) {
            currentCollidable = null;
            isColliding = false;
        }
    }

    public PlayerProperties getPlayerProperties() {
        return playerProperties;
    }

    public KeyListener getKeyListener() {
        return (KeyListener) controller;
    }

    public Vector getVector() {
        return vector;
    }

    public SizeDimensionsType getSizeDimensions() {
        return size;
    }

    public PlayerState getPlayerState() {
        return playerState;
    }
}

