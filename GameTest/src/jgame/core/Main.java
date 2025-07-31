package jgame.core;

import jgame.core.cache.EntityCache;
import jgame.core.game.GameCanvas;
import jgame.core.game.GameFrame;
import jgame.core.game.GameWorld;
import jgame.core.render.Render;
import jgame.entities.common.interfaces.EntityType;
import jgame.entities.enemies.EnemyController;
import jgame.entities.player.PlayerController;
import jgame.entities.player.PlayerInputHandler;
import jgame.core.cache.TileCache;
import jgame.world.maps.MapObjects;
import jgame.world.maps.MapsManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello JGame");
        GameCanvas canvas = new GameCanvas();
        GameFrame frame = new GameFrame(canvas);

        MapObjects mapObjects = createMapObjects();

        EnemyController enemyController = setupEnemyController(mapObjects.player());
        PlayerController playerController = setupPlayerController(mapObjects.player());

        TileCache tileCache = new TileCache(mapObjects.tiles());
        EntityCache entityCache = new EntityCache(mapObjects.enemies(), mapObjects.player());

        GameWorld gameWorld = new GameWorld(
                entityCache,
                tileCache,
                playerController,
                enemyController
        );

        canvas.addKeyListener(gameWorld.getKeyListener());
        frame.setVisible(true);
        canvas.requestFocusInWindow();
        new Thread(new Render(gameWorld, canvas)).start();
    }

    private static MapObjects createMapObjects() {
        MapsManager mapsManager = new MapsManager(List.of("map2"));
        return mapsManager.buildObjectsFromMap("map2");
    }

    private static EnemyController setupEnemyController(EntityType playerTarget) {
        EnemyController enemyController = new EnemyController();
        enemyController.setEntity(playerTarget);
        return enemyController;
    }

    private static PlayerController setupPlayerController(EntityType player) {
        PlayerInputHandler inputHandler = new PlayerInputHandler();
        return new PlayerController(player, inputHandler);
    }
}