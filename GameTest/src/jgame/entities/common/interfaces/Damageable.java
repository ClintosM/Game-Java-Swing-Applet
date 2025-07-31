package jgame.entities.common.interfaces;

import jgame.utils.MathUtils;

public class Damageable implements DamageableType {
    private final int maxHealth;
    private int currentHealth;

    public Damageable(int initialHealth) {
        this.maxHealth = initialHealth;
        this.currentHealth = maxHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int health) {
        currentHealth = MathUtils.clamp(health, 0, maxHealth);
    }
}
