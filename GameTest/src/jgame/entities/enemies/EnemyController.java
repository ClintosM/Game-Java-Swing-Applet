package jgame.entities.enemies;

import jgame.containers.Vector;
import jgame.entities.common.EntityType;

import java.awt.*;

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
        Vector targetVector = entity.getVector();
        return enemy.getVector().absoluteDistance(targetVector);
    }

    private void handleState(Enemy enemy) {
        switch (enemy.properties.getState()) {
            case idle -> {
                //enemy.setBackground(Color.orange);
                checkDistanceToEntity(enemy);
            }
            case wander -> {
                // TODO: - Add wondering logic
            }
            case chase -> {
                //enemy.setBackground(Color.red);
                chaseEntity(enemy);
                checkDistanceToEntity(enemy);
            }
        }
    }

    private void chaseEntity(Enemy enemy) {
        if (enemy.properties.getState() != EnemyState.chase) return;

        Vector targetVector = entity.getVector();
        float dx = enemy.getVector().getNormalisedX(targetVector) * enemy.properties.getSpeed();
        float dy = enemy.getVector().getNormalisedY(targetVector) * enemy.properties.getSpeed();
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
