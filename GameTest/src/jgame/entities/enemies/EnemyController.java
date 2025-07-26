package jgame.entities.enemies;

import jgame.containers.Vector;
import jgame.entities.common.EntityType;

public class EnemyController {
    EntityType entity;

    public EnemyController() {
    }

    public void setEntity(EntityType entity) {
        this.entity = entity;
    }

    private EntityType getEntity() {
        return entity;
    }

    protected void update(Enemy enemy) {
        handleState(enemy);
    }

    private float getDistanceFromEntity(Enemy enemy) {
        Vector targetVector = entity.getProperties().getVector();
        return enemy.getProperties().getVector().absoluteDistance(targetVector);
    }

    private void handleState(Enemy enemy) {
        switch (enemy.properties.getState()) {
            case idle -> {
                checkDistanceToEntity(enemy);
            }
            case wander -> {
                // TODO: - Add wondering logic
            }
            case chase -> {
                chaseEntity(enemy);
                checkDistanceToEntity(enemy);
            }
        }
    }

    private void chaseEntity(Enemy enemy) {
        if (enemy.properties.getState() != EnemyState.chase) return;

        Vector targetVector = entity.getProperties().getVector();
        float dx = enemy.properties.getVector().getNormalisedX(targetVector)
                 * enemy.properties.getCurrentSpd();
        float dy = enemy.properties.getVector().getNormalisedY(targetVector)
                 * enemy.properties.getCurrentSpd();
        enemy.moveTo(dx, dy);
    }

    private void checkDistanceToEntity(Enemy enemy) {
        float distance = getDistanceFromEntity(enemy);

        if (distance < enemy.properties.getSightRadius()) {
            enemy.properties.state = EnemyState.chase;
        }

        if (distance >= enemy.properties.getSightRadius() * 1.25) {
            enemy.properties.state = EnemyState.idle;
        }
    }
}
