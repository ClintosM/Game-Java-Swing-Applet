package jgame.entities.enemies;

import jgame.containers.Position;
import jgame.containers.VectorMath;
import jgame.core.GameContext;
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

    public void update(Enemy enemy, GameContext gameContext) {
        handleState(enemy);
    }

    private float getDistanceFromEntity(EntityType enemy) {
        Position targetVector = entity.getPosition();
        return VectorMath.absoluteDistance(enemy.getPosition(), entity.getPosition());
    }

    private void handleState(Enemy enemy) {
        switch (enemy.getStatus()) {
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

    private void chaseEntity(EntityType enemy) {
        //if (enemy.properties.getState() != EnemyState.chase) return;

        Position targetPos = entity.getPosition();
        float dx = VectorMath.getNormalisedX(enemy.getPosition(), targetPos)
                 * enemy.getMovementSpeed();
        float dy = VectorMath.getNormalisedY(enemy.getPosition(), targetPos)
                * enemy.getMovementSpeed();
        enemy.moveBy(dx, dy);
    }

    private void checkDistanceToEntity(Enemy enemy) {
        float distance = getDistanceFromEntity(enemy);

        if (distance < enemy.getSightRadius()) {
            enemy.setStatus(EnemyStatus.chase);
        }

        if (distance >= enemy.getSightRadius() * 1.25) {
            enemy.setStatus(EnemyStatus.idle);
        }
    }
}
