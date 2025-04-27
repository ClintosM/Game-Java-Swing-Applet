import Collision.TileType;
import Collision.Wall;
import Entities.EntityManager;
import Entities.EntityType;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

// TODO: TileManager class to manage tiles

public class Game {
    public final boolean isRunning;
    private final GameFrame frame;

    private final EntityManager entityManager = new EntityManager(1);
    private final TileManager tileManager = new TileManager(20, 15);

    public Game(boolean isRunning, GameFrame frame) {
        this.isRunning = isRunning;
        this.frame = frame;
        setup();
    }

    public void update() {
        entityManager.getPlayer().update();
        for (EntityType enemy : entityManager.getEnemies()) {
            enemy.update();
        }
    }

    // MARK: - Calls to frame
    // TODO: - Add delegate to delegate communication with other objects

    private void setup() {

        addEntitiesToFrame();
        addTilesToFrame();
    }

    private void addEntitiesToFrame() {
        frame.addPlayer(entityManager.getPlayer());
        for (EntityType enemy : entityManager.getEnemies()) {
            frame.addEntity(enemy);
        }
    }

    private void addTilesToFrame() {
        frame.addTiles(tileManager.getTiles());
    }
}
