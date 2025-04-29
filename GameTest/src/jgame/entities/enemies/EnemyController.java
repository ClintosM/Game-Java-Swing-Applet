package jgame.entities.enemies;

import jgame.containers.Vector;
import jgame.entities.common.EntityType;

import java.awt.*;

public class EnemyController {
    EntityType entity;

    public EnemyController(EntityType entity) {
        this.entity = entity;
    }

    protected void update(Enemy enemy) {
        handleState(enemy);
    }

    private float getDistanceFromEntity(Enemy enemy) {
        Vector targetVector = entity.getVector();
        return enemy.properties.vector.absoluteDistance(targetVector);
    }

    private void handleState(Enemy enemy) {
        switch (enemy.properties.state) {
            case idle -> {
                enemy.setBackground(Color.orange);
                checkDistanceToEntity(enemy);
            }
            case wander -> {
                // TODO: - Add wondering logic
            }
            case chase -> {
                enemy.setBackground(Color.red);
                chaseEntity(enemy);
                checkDistanceToEntity(enemy);
            }
        }
    }

    private void chaseEntity(Enemy enemy) {
        if (enemy.properties.state != EnemyState.chase) return;

        Vector targetVector = entity.getVector();
        float dx = enemy.properties.vector.getNormalisedX(targetVector) * 3;
        float dy = enemy.properties.vector.getNormalisedY(targetVector) * 3;
        enemy.moveTo(dx, dy);
    }

    private void checkDistanceToEntity(Enemy enemy) {
        float distance = getDistanceFromEntity(enemy);

        if (distance < enemy.properties.sightRadius) {
            enemy.properties.state = EnemyState.chase;
        }

        if (distance >= enemy.properties.sightRadius * 1.25) {
            enemy.properties.state = EnemyState.idle;
        }
    }
}
