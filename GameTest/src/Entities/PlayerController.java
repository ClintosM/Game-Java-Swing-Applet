package Entities;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class PlayerController implements KeyListener {
    private final Set<Integer> keyEvents = new HashSet<Integer>();

    public PlayerController() { }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        keyEvents.add(key);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        keyEvents.remove(key);
    }

    protected void update(Player player) {
        int up = KeyEvent.VK_W;
        int down = KeyEvent.VK_S;
        int left = KeyEvent.VK_A;
        int right = KeyEvent.VK_D;

        if (keyEvents.contains(up)) player.moveTo(0, -4);
        if (keyEvents.contains(down)) player.moveTo(0, 4);
        if (keyEvents.contains(left)) player.moveTo(-4, 0);
        if (keyEvents.contains(right)) player.moveTo(4, 0);
    }
}
