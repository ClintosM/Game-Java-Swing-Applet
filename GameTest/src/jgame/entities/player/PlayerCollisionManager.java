package jgame.entities.player;

import jgame.collision.CollidableType;

public class PlayerCollisionManager {
    private CollidableType collidable;
    private CollidableType currentCollidable;

    private boolean isColliding = false;

    public PlayerCollisionManager(CollidableType collidable) {
        this.collidable = collidable;
    }

    public void checkForCollisions(CollidableType otherCollidable) {
        if (otherCollidable == null) return;

        boolean isCollidingNow = collidable.isColliding(otherCollidable);

        if (isCollidingNow) {
            currentCollidable = otherCollidable;
            isColliding = true;
            System.out.println("Is colliding!");
        } else if (currentCollidable != null && !collidable.isColliding(currentCollidable)) {
            currentCollidable = null;
            isColliding = false;
            System.out.println("NOT colliding!");
        }
    }

    public boolean checkIsColliding() {
       return isColliding;
    }
}
