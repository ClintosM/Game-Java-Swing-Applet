import Collision.TileType;
import Collision.Wall;
import Entities.*;
import Entities.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameFrame extends JFrame {
    private final String TITLE = "Test Game";
    private final int WIDTH = 1920;
    private final int HEIGHT = WIDTH / 16 * 9;

    private final FrameDelegate delegate;

    public GameFrame(FrameDelegate delegate) {
        this.delegate = delegate;
        this.setTitle(TITLE);
        this.setSize(WIDTH, HEIGHT);
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
