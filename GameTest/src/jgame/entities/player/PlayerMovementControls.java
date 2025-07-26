package jgame.entities.player;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public abstract class PlayerMovementControls {
    public static int MOVE_UP = KeyEvent.VK_W;
    public static int MOVE_DOWN = KeyEvent.VK_S;
    public static int MOVE_LEFT = KeyEvent.VK_A;
    public static int MOVE_RIGHT = KeyEvent.VK_D;

    public static Set<Integer> movementKeyBinds = new HashSet<>();

    static {
       movementKeyBinds.add(MOVE_UP);
       movementKeyBinds.add(MOVE_DOWN);
       movementKeyBinds.add(MOVE_LEFT);
       movementKeyBinds.add(MOVE_RIGHT);
    };
}
