package jgame.core;

import jgame.collision.TileType;
import jgame.entities.player.Player;
import jgame.entities.common.EntityType;

import javax.swing.*;
import java.util.ArrayList;

public class GameFrame extends JFrame {
    private final String TITLE = "JGame Test";
    private final FrameDelegate delegate;

    public GameFrame(FrameDelegate delegate) {
        this.delegate = delegate;
        this.setTitle(TITLE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void addTiles(ArrayList<TileType> tiles) {
        delegate.addTiles(this, tiles);
    }

    public void addEntity(EntityType entity) {
        delegate.addEntity(this, entity);
    }

    public void removeEntity(EntityType entity) {
        delegate.removeEntity(this, entity);
    }

    public void addPlayer(Player player) {
        delegate.addPlayer(this, player);
    }
}
