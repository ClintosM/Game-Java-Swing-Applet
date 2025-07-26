package jgame.entities.player;

import jgame.entities.common.EntityType;
import jgame.entities.player.states.PlayerState;

import java.awt.event.KeyListener;
import java.security.Key;
import java.util.Set;

public class PlayerMovementController {
    private PlayerInputHandler inputHandler;

    // private PlayerState playerState;

    public PlayerMovementController() {
        this.inputHandler = new PlayerInputHandler();
    }

    protected void updatePosition(Player player) {
        float playerSpeed = player.getProperties().getCurrentSpd();
        Set<Integer> keyEvents = inputHandler.getKeyEvents();
        if (keyEvents.contains(PlayerMovementControls.MOVE_UP)) updateVector(player, 0, -playerSpeed);
        if (keyEvents.contains(PlayerMovementControls.MOVE_DOWN)) updateVector(player, 0, playerSpeed);
        if (keyEvents.contains(PlayerMovementControls.MOVE_LEFT)) updateVector(player, -playerSpeed, 0);
        if (keyEvents.contains(PlayerMovementControls.MOVE_RIGHT)) updateVector(player, playerSpeed, 0);
    }

    private void updateVector(EntityType player, float dx, float dy) {
        float newX = player.getProperties().getVector().getX() + dx;
        float newY = player.getProperties().getVector().getY() + dy;
        player.getProperties().getVector().setVector(newX, newY);
    }

    public KeyListener getKeyListener() {
        return (KeyListener) inputHandler;
    }
}
