package jgame.entities.player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class PlayerInputHandler implements KeyListener {

    private final Set<Integer> keyEvents = new HashSet<Integer>();

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent key) {
        int keyCode = key.getKeyCode();

        // Key checks
        checkMovementKeys(keyCode);
        // ....
    }

    @Override
    public void keyReleased(KeyEvent key) {
        keyEvents.remove(key.getKeyCode());
    }

    public Set<Integer> getKeyEvents() {
        return keyEvents;
    }

    private void checkMovementKeys(int keyCode) {
        if (PlayerMovementControls.movementKeyBinds.contains(keyCode)) {
            keyEvents.add(keyCode);
        }
    }
}
