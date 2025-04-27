package Entities;

import Containers.Vector;
import Entities.Enemies.Enemy;
import Entities.Enemies.EnemyController;
import Entities.Enemies.EnemyProperties;
import Entities.Enemies.EnemyState;
import Entities.Player.Player;
import Entities.Player.PlayerController;

import java.util.ArrayList;
import java.util.Random;

public class EntityManager {
    // MARK: - Player Stuff
    // Prepare for basic multiplayer functionality? This would need to be an arraylist if that's the case...
    private final EntityType player = new Player(new PlayerController(), new Vector(64, 64));

    // MARK: - Enemy Stuff
    private ArrayList<EntityType> enemies;
    private EnemyController enemyController;

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
        EnemyProperties enemyProperties = new EnemyProperties(4, 10, xPos, yPos, EnemyState.idle, 250);
        return new Enemy(enemyController, enemyProperties);
    }

    public ArrayList<EntityType> getEnemies() {
        return enemies;
    }

    public Player getPlayer() {
        return (Player) player;
    }
}
