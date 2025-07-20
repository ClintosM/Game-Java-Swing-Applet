package jgame.entities.enemies;

import jgame.containers.SizeDimensionsType;
import jgame.containers.Vector;
import jgame.entities.common.EntityType;

import java.awt.*;

public class Enemy implements EntityType {
    private final EnemyController controller;
    final EnemyProperties properties;

    public Enemy(EnemyController controller, EnemyProperties properties) {
        this.controller = controller;
        this.properties = properties;
    }

    @Override
    public void render(Graphics2D g) {
        drawEnemy(g);
    }

    private void drawEnemy(Graphics2D g) {
        int xPos = (int) getVector().getX();
        int yPos = (int) getVector().getY();
        int width = getSizeDimensions().getWidth();
        int height = getSizeDimensions().getHeight();

        Color bodyColor = properties.getState() == EnemyState.idle ? Color.ORANGE : Color.RED;
        properties.setColor(bodyColor);

        g.setColor(properties.getColor());
        g.fillRect(xPos, yPos, width, height);
    }

    // MARK: - Public Methods

    public void moveTo(float dx, float dy) {
        float newX = properties.getVector().getX() + dx;
        float newY = properties.getVector().getY() + dy;
        properties.getVector().setVector(newX, newY);
    }

    @Override
    public Vector getVector() {
        return properties.getVector();
    }

    @Override
    public SizeDimensionsType getSizeDimensions() {
        return properties.getSize();
    }

    @Override
    public void update() {
        controller.update(this);
    }
}