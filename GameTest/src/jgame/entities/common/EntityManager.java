package jgame.entities.common;

import jgame.entities.enemies.EnemyController;
import jgame.entities.player.Player;
import jgame.entities.player.PlayerController;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {
    // MARK: - Player Stuff
    private final PlayerController playerController = new PlayerController();
    private final EntityType player;

    // MARK: - Enemy Stuff
    private final ArrayList<EntityType> enemies;
    private EnemyController enemyController;

    public EntityManager(ArrayList<EntityType> enemies, EntityType player) {
        this.enemies = enemies;
        this.player = player;
    }

    public ArrayList<EntityType> getEnemies() {
        return enemies;
    }

    public Player getPlayer() {
        return (Player) player;
    }

    public void setEnemyController(EnemyController enemyController) {
        this.enemyController = enemyController;
    }

    public EnemyController getEnemyController() {
        return enemyController;
    }

    public void render(Graphics2D g) {
        player.render(g);
        for (EntityType enemy : enemies) {
            enemy.render(g);
        }
    }
}
