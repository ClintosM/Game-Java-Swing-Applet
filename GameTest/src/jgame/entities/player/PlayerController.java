package jgame.entities.player;

import jgame.collision.TileType;
import jgame.core.game.GameContext;
import jgame.entities.common.interfaces.EntityControllerType;
import jgame.entities.common.interfaces.EntityType;

import java.awt.event.KeyListener;
import java.util.ArrayList;

public final class PlayerController implements EntityControllerType {
    private final EntityType player;
    private final PlayerMovementController movementController;
    private final PlayerCollisionController collisionController;

    public PlayerController(EntityType player, PlayerInputHandler inputHandler) {
        this.player = player;
        this.movementController = new PlayerMovementController(player, inputHandler);
        this.collisionController = new PlayerCollisionController(player);
    }

    public void update(GameContext gameContext) {
        movementController.update();
        collisionUpdates(gameContext);
    }

    private void collisionUpdates(GameContext gameContext) {
        ArrayList<TileType> tiles = gameContext.getTiles();
        for (TileType tile : tiles) {
            collisionController.checkCollisionsAgainst(tile.getCollidable());
        }
    }

    public KeyListener getKeyListener() {
        return (KeyListener) movementController.getKeyListener();
    }
}
