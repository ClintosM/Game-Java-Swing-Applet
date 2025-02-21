package Entities;
import Containers.Vector;

import javax.swing.*;
import java.awt.*;

public class Enemy extends JPanel implements EntityType {
    public Vector vector;
    private final EnemyController controller;

    boolean isFollowing;

    public Enemy(EnemyController controller, float startX, float startY) {
        this.controller = controller;
        this.vector = new Vector(startX, startY);
        setProperties();
    }

    private void setProperties() {
        setSize(64, 64);
        setBackground(Color.RED);
        setLocation((int) vector.getX(), (int) vector.getY());
        setVisible(true);
    }

    protected void moveTo(float dx, float dy) {
        vector.setX(vector.getX() + dx);
        vector.setY(vector.getY() + dy);
        setLocation( ((int)vector.getX()), ((int)vector.getY()));
    }

    @Override
    public Vector getVector() {
        return vector;
    }

    @Override
    public void update() {
        controller.update(this);
    }
}
