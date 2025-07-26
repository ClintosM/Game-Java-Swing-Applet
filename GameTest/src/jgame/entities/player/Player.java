package jgame.entities.player;

import jgame.collision.Collidable;
import jgame.collision.CollidableType;
import jgame.containers.SizeDimensionsType;
import jgame.containers.Vector;
import jgame.entities.common.EntityPropertiesType;
import jgame.entities.common.EntityType;

import java.awt.*;
import java.awt.event.KeyListener;

public class Player implements EntityType {
    private final PlayerController playerController;
    private final PlayerProperties playerProperties;
    private final CollidableType collidable;

    public Player(Vector vector,
                  SizeDimensionsType size) {
        this.playerController = new PlayerController(this);
        this.collidable = new Collidable(vector, size);
        this.playerProperties = new PlayerProperties(vector, size);
    }

    // TODO: - Create draw manager class for player
    @Override
    public void render(Graphics2D g) {
        g.setColor(isColliding ? Color.GREEN : Color.BLUE);
        g.fillRect(
                (int) playerProperties.getVector().getX(),
                (int) playerProperties.getVector().getY(),
                playerProperties.getSize().getWidth(),
                playerProperties.getSize().getHeight()
        );
    }

    @Override
    public void update() {
        playerController.update();
    }

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

    // MARK: - Getters

    public PlayerProperties getPlayerProperties() {
        return playerProperties;
    }

    public KeyListener getKeyListener() {
        return (KeyListener) playerController.getKeyListener();
    }

    public Vector getVector() {
        return playerProperties.getVector();
    }

    public SizeDimensionsType getSizeDimensions() {
        return playerProperties.getSize();
    }

    public EntityPropertiesType getProperties() {
        return playerProperties;
    }
}

