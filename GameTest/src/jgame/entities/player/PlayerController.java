package jgame.entities.player;

import jgame.core.GameContext;
import jgame.entities.common.EntityControllerType;
import jgame.entities.common.EntityType;

import java.awt.event.KeyListener;

public class PlayerController implements EntityControllerType {
    private final EntityType player;
    private final PlayerMovementController movementController;

    public PlayerController(EntityType player, PlayerInputHandler inputHandler) {
        this.player = player;
        this.movementController = new PlayerMovementController(player, inputHandler);
    }

    public void update(GameContext gameContext) {
        movementController.updatePosition(player);
        player.checkCollisionState(gameContext.tiles);
    }

    public KeyListener getKeyListener() {
        return (KeyListener) movementController.getKeyListener();
    }
}
