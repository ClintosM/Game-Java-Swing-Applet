package Entities.Enemies;
import Containers.Vector;
import Entities.EntityType;

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
               checkDistanceToEntity(enemy);
           }
           case wander -> {
               // TODO: - Add wandering logic
           }
           case chase -> {
               chaseEntity(enemy);
               checkDistanceToEntity(enemy);
           }
       }
    }

    private void chaseEntity(Enemy enemy) {
        if (enemy.properties.state != EnemyState.chase) {
            return;
        }
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
        if (distance >= enemy.properties.sightRadius * 2) {
            // Temporary solution to state management. TODO: - Find way to make this dynamic...
            enemy.properties.state = EnemyState.idle;
        }
    }
}
