package jgame.entities.common;

import java.util.ArrayList;

public class EntityManager {
    private final ArrayList<EntityType> enemies;
    private final EntityType player;

    public EntityManager(ArrayList<EntityType> enemies, EntityType player) {
        this.enemies = enemies;
        this.player = player;
    }

    public ArrayList<EntityType> getAllEntities() {
        ArrayList<EntityType> allEntities = new ArrayList<>(getEnemies());
        allEntities.add(player);
        return allEntities;
    }

    public ArrayList<EntityType> getEnemies() {
        return enemies;
    }

    public EntityType getPlayer() {
        return player;
    }
}
