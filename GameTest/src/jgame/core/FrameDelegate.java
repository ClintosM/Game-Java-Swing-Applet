package jgame.core;

import jgame.collision.TileType;
import jgame.entities.common.EntityType;
import jgame.entities.player.Player;

import java.awt.*;
import java.util.ArrayList;

public class FrameDelegate {
    public FrameDelegate() {
    }

    protected void addTiles(GameFrame frame, ArrayList<TileType> tiles) {
        for (TileType tile : tiles) {
            frame.add((Component) tile);
            frame.repaint();
        }
    }

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
