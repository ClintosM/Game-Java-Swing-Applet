package jgame.entities.player;

import jgame.utils.MotionMath;
import jgame.entities.common.interfaces.EntityType;

import java.awt.event.KeyListener;

public class PlayerMovementController {
    private final PlayerInputHandler inputHandler;
    private final EntityType player;

    private final float ACCEL_RATE = 0.9f;
    private final float DECEL_RATE = 0.2f;
    private final float maxSpeed;

    public PlayerMovementController(EntityType player, PlayerInputHandler inputHandler) {
        this.player = player;
        this.inputHandler = inputHandler;
        this.maxSpeed = player.getMovementSpeed();
    }

    private int normalizeMovementKey(int keyEvent) {
        return inputHandler.getKeyEvents().contains(keyEvent) ? 1 : 0;
    }

    private void horizontalMovementCheck() {
        int left = normalizeMovementKey(PlayerMovementControls.MOVE_LEFT);
        int right = normalizeMovementKey(PlayerMovementControls.MOVE_RIGHT);

        if (left != right) {
            float target = (-left + right) * maxSpeed;
            float xVel = MotionMath.applyAcceleration(player.getXVelocity(), target, ACCEL_RATE);
            player.setXVelocity(xVel);
        } else {
            float xVel = MotionMath.applyDeceleration(player.getXVelocity(), DECEL_RATE);
            player.setXVelocity(xVel);
        }
    }

    private void verticalMovementCheck() {
        int up = normalizeMovementKey(PlayerMovementControls.MOVE_UP);
        int down = normalizeMovementKey(PlayerMovementControls.MOVE_DOWN);

        if (up != down) {
            float target = (-up + down) * maxSpeed;
            float yVel = MotionMath.applyAcceleration(player.getYVelocity(), target, ACCEL_RATE);
            player.setYVelocity(yVel);
        } else {
            float yVel = MotionMath.applyDeceleration(player.getYVelocity(), DECEL_RATE);
            player.setYVelocity(yVel);
        }
    }

    protected void update() {
        horizontalMovementCheck();
        verticalMovementCheck();
        translatePlayer();
    }

    private void translatePlayer() {
        float xVel = player.getXVelocity();
        float yVel = player.getYVelocity();
        player.moveBy(xVel, yVel);
    }

    public KeyListener getKeyListener() { return (KeyListener) inputHandler; }
}
