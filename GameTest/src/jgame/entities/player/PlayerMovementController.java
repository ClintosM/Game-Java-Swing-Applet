package jgame.entities.player;

import jgame.entities.common.EntityType;

import java.awt.event.KeyListener;
import java.util.Set;

public class PlayerMovementController {
    private PlayerInputHandler inputHandler;
    Set<Integer> keyEvents;

    private static final float ACCEL_RATE = 0.9f;
    private static final float DECEL_RATE = 0.2f;

    public PlayerMovementController(EntityType player, PlayerInputHandler inputHandler) {
        this.inputHandler = inputHandler;
        this.keyEvents = inputHandler.getKeyEvents();
    }

    private float applyAcceleration(float currentSpeed, float targetSpeed, float accelRate) {
        if (currentSpeed < targetSpeed) {
            currentSpeed += accelRate;
            if (currentSpeed > targetSpeed) currentSpeed = targetSpeed;
        } else if (currentSpeed > targetSpeed) {
            currentSpeed -= accelRate;
            if (currentSpeed < targetSpeed) currentSpeed = targetSpeed;
        }
        return currentSpeed;
    }


    private float applyDeceleration(float currentSpeed, float decelRate) {
        if (currentSpeed > 0) {
            currentSpeed -= decelRate;
            if (currentSpeed < 0) currentSpeed = 0;
        } else if (currentSpeed < 0) {
            currentSpeed += decelRate;
            if (currentSpeed > 0) currentSpeed = 0;
        }
        return currentSpeed;
    }

    private int normalizeMovementKey(int keyEvent) {
        return keyEvents.contains(keyEvent) ? 1 : 0;
    }

    private void horizontalMovementCheck(EntityType player) {
        int left = normalizeMovementKey(PlayerMovementControls.MOVE_LEFT);
        int right = normalizeMovementKey(PlayerMovementControls.MOVE_RIGHT);
        float maxSpeed = player.getMovementSpeed();

        if (left != right) {
            float target = (-left + right) * maxSpeed;
            float hspd = applyAcceleration(player.getHorizontalSpeed(), target, ACCEL_RATE);
            player.setHorizontalSpeed(hspd);
        } else {
            float hspd = applyDeceleration(player.getHorizontalSpeed(), DECEL_RATE);
            player.setHorizontalSpeed(hspd);
        }
    }

    private void verticalMovementCheck(EntityType player) {
        int up = normalizeMovementKey(PlayerMovementControls.MOVE_UP);
        int down = normalizeMovementKey(PlayerMovementControls.MOVE_DOWN);
        float maxSpeed = player.getMovementSpeed();

        if (up != down) {
            float target = (-up + down) * maxSpeed;
            float vspd = applyAcceleration(player.getVerticalSpeed(), target, ACCEL_RATE);
            player.setVerticalSpeed(vspd);
        } else {
            float vspd = applyDeceleration(player.getVerticalSpeed(), DECEL_RATE);
            player.setVerticalSpeed(vspd);
        }
    }


    protected void updatePosition(EntityType player) {
        keyEvents = inputHandler.getKeyEvents();
        horizontalMovementCheck(player);
        verticalMovementCheck(player);
        player.moveBy(player.getHorizontalSpeed(), player.getVerticalSpeed());
    }

    public KeyListener getKeyListener() {
        return (KeyListener) inputHandler;
    }
}
