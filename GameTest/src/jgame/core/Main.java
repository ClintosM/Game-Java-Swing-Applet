package jgame.core;

import jgame.entities.common.EntityType;
import jgame.entities.enemies.EnemyController;
import jgame.entities.player.PlayerController;
import jgame.entities.player.PlayerInputHandler;
import jgame.world.TileManager;
import jgame.world.maps.MapEntities;
import jgame.world.maps.MapsManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello JGame");
        GameCanvas canvas = new GameCanvas();
        GameFrame frame = new GameFrame(canvas);

        MapEntities entities = createEntities();
        EnemyController enemyController = setupEnemyController(entities.player());
        PlayerController playerController = setupPlayerController(entities.player());
        TileManager tileManager = new TileManager(entities.tiles());

        GameWorld gameWorld = new GameWorld(
                entities.player(),
                entities.enemies(),
                playerController,
                enemyController,
                tileManager
        );

        canvas.addKeyListener(gameWorld.getKeyListener());
        frame.setVisible(true);
        canvas.requestFocusInWindow();
        new Thread(new Render(gameWorld, canvas)).start();
    }

    private static MapEntities createEntities() {
        MapsManager mapsManager = new MapsManager(List.of("map1"));
        return mapsManager.buildEntitiesFromMap("map1");
    }

    private static EnemyController setupEnemyController(EntityType playerTarget) {
        EnemyController enemyController = new EnemyController();
        enemyController.setEntity(playerTarget);
        return enemyController;
    }

    private static PlayerController setupPlayerController(EntityType player) {
        PlayerInputHandler inputHandler = new PlayerInputHandler();
        PlayerController playerController = new PlayerController(player, inputHandler);
        return playerController;
    }
}