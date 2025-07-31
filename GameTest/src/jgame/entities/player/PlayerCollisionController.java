package jgame.entities.player;

import jgame.collision.CollidableType;
import jgame.entities.common.interfaces.EntityType;

public class PlayerCollisionController {
    private EntityType player;
    private CollidableType currentCollidable;

    private float previousX;
    private float previousY;

    public PlayerCollisionController(EntityType player) {
        this.player = player;
    }

    public void checkCollisionsAgainst(CollidableType candidate) {
        if (candidate == null) return;

        CollidableType playerCollidable = player.getCollidable();
        boolean shouldCollideWithCandidate = playerCollidable.isColliding(candidate);

        if (shouldCollideWithCandidate) {
            currentCollidable = candidate;
            redirectPlayer();
            System.out.println("Is colliding!");
        } else if (currentCollidable != null && !playerCollidable.isColliding(currentCollidable)) {
            currentCollidable = null;
            System.out.println("NOT colliding!");
        }
    }

    private void redirectPlayer() {

    }
}
