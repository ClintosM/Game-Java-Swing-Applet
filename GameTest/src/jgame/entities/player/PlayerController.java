package jgame.entities.player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class PlayerController implements KeyListener {
    private final Set<Integer> keyEvents = new HashSet<Integer>();

    private final int up = KeyEvent.VK_W;
    private final int down = KeyEvent.VK_S;
    private final int left = KeyEvent.VK_A;
    private final int right = KeyEvent.VK_D;

    // Temp. Should be invoked externally from some kind of PlayerProperties class
    private final int playerSpeed = 4;

    public PlayerController() {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent key) {
        keyEvents.add(key.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent key) {
        keyEvents.remove(key.getKeyCode());
    }

    protected void update(Player player) {
        handleStates(player);
    }

    private void updatePosition(Player player) {
        if (keyEvents.contains(up)) updateVector(player, 0, -playerSpeed);
        if (keyEvents.contains(down)) updateVector(player, 0, playerSpeed);
        if (keyEvents.contains(left)) updateVector(player, -playerSpeed, 0);
        if (keyEvents.contains(right)) updateVector(player, playerSpeed, 0);
    }

    private void handleStates(Player player) {
        switch (player.getPlayerState()) {
            case idle -> {
                checkKeyEventsToUpdateState(player);
            }
            case moving -> {
                checkKeyEventsToUpdateState(player);
                updatePosition(player);
            }
        }
    }

    private void checkKeyEventsToUpdateState(Player player) {
        if (keyEvents.contains(up)
                || keyEvents.contains(down)
                || keyEvents.contains(left)
                || keyEvents.contains(right)) {
            player.setPlayerState(PlayerState.moving);
        } else {
            player.setPlayerState(PlayerState.idle);
        }
    }

    private void updateVector(Player player, float dx, float dy) {
        float newX = player.getVector().getX() + dx;
        float newY = player.getVector().getY() + dy;
        player.getVector().setVector(newX, newY);
    }
}
