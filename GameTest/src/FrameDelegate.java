import Entities.EntityType;
import Entities.Player.Player;

import java.awt.*;

public class FrameDelegate {
    public FrameDelegate() { }

    protected void addEntity(GameFrame frame, EntityType entity) {
        frame.add((Component) entity);
        frame.repaint();
    }

    protected void removeEntity(GameFrame frame, EntityType entity) {
        frame.remove((Component) entity);
    }

    protected void addPlayer(GameFrame frame, Player player) {
        frame.add((Component) player);
        frame.addKeyListener(player.getKeyListener());
    }
 }
