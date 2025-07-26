package jgame.entities.player;

import jgame.entities.common.EntityType;

import java.awt.event.KeyListener;

public class PlayerController {
    private Player player;
    private PlayerMovementController movementController;

    public PlayerController(Player player) {
        this.player = player;
        this.movementController = new PlayerMovementController();
    }

    protected void update() {
        handleStates();
    }

    private void handleStates() {
        movementController.updatePosition(player);
    }

    public KeyListener getKeyListener() {
        return (KeyListener) movementController.getKeyListener();
    }
}
