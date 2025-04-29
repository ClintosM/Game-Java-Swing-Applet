package jgame.core;

import jgame.entities.common.EntityManager;
import jgame.entities.common.EntityType;
import jgame.world.TileManager;

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

    // TODO: - Add delegate to delegate communication with external objects

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
