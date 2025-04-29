package jgame.entities.common;

import jgame.collision.EntitySize;
import jgame.containers.Vector;
import jgame.entities.enemies.Enemy;
import jgame.entities.enemies.EnemyController;
import jgame.entities.enemies.EnemyProperties;
import jgame.entities.enemies.EnemyState;
import jgame.entities.player.Player;
import jgame.entities.player.PlayerController;

import java.util.ArrayList;
import java.util.Random;

public class EntityManager {
    // MARK: - Player Stuff
    private final PlayerController playerController = new PlayerController();
    private final Vector playerVector = new Vector(64, 64);
    private final EntitySize playerSize = new EntitySize(32, 32);
    private final EntityType player = new Player(playerController, playerVector, playerSize);

    // MARK: - Enemy Stuff
    private final ArrayList<EntityType> enemies;
    private final EnemyController enemyController;

    public EntityManager(int enemyCount) {
        this.enemyController = new EnemyController(player);
        this.enemies = createEnemies(enemyCount);
    }

    private ArrayList<EntityType> createEnemies(int enemyCount) {
        ArrayList<EntityType> enemyArrayList = new ArrayList<EntityType>();
        Random random = new Random();

        for (int i = 0; i < enemyCount; i++) {
            Enemy enemy = createEnemy(enemyController, getPlayer().getX() + 512, getPlayer().getY() + 512);
            enemyArrayList.add(enemy);
        }
        return enemyArrayList;
    }

    private Enemy createEnemy(EnemyController enemyController, int xPos, int yPos) {
        EnemyProperties enemyProperties = new EnemyProperties(4, 10, xPos, yPos, 32, EnemyState.idle, 250);
        return new Enemy(enemyController, enemyProperties);
    }

    public ArrayList<EntityType> getEnemies() {
        return enemies;
    }

    public Player getPlayer() {
        return (Player) player;
    }
}
