package Entities;

import Containers.Vector;

public class EnemyController {
    EntityType entity;

    public EnemyController(EntityType entity) {
        this.entity = entity;
    }

    protected void update(Enemy enemy) {
        Vector targetVector = entity.getVector();
        float distance = enemy.vector.absoluteDistance(targetVector);

        if (distance < 250) {
            enemy.isFollowing = true;
        }
        if (distance >= 400) {
            enemy.isFollowing = false;
        }

        if (enemy.isFollowing) {
            float dx = enemy.vector.getNormalisedX(targetVector) * 4;
            float dy = enemy.vector.getNormalisedY(targetVector) * 4;
            enemy.moveTo(dx, dy);
        }
    }

//    private float normalizedX(Enemy enemy) {
//        float xDiff = entity.getxPos() - enemy.getxPos();
//        float yDiff = entity.getyPos() - enemy.getyPos();
//        float aSquared = xDiff * xDiff;
//        float bSquared = yDiff * yDiff;
//
//        // C Squared = Sqrt of A squared + B squared.
//        float c = (float) Math.sqrt(aSquared + bSquared);
//        return xDiff / c;
//    }
//
//    private float normalizedY(Enemy enemy) {
//        float xDiff = entity.getxPos() - enemy.getxPos();
//        float yDiff = entity.getyPos() - enemy.getyPos();
//        float aSquared = xDiff * xDiff;
//        float bSquared = yDiff * yDiff;
//
//        // C Squared = Sqrt of A squared + B squared.
//        float c = (float) Math.sqrt(aSquared + bSquared);
//        return yDiff / c;
//    }
//
//    private float distanceToEntity(Enemy enemy) {
//        float xDiff = Math.abs(enemy.getxPos() - entity.getxPos());
//        float yDiff = Math.abs(enemy.getyPos() - entity.getyPos());
//        float aSquared = xDiff * xDiff;
//        float bSquared = yDiff * yDiff;
//
//        // C Squared = Sqrt of A squared + B squared.
//        return ((int) Math.sqrt(aSquared + bSquared));
//    }
}