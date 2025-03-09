package Entities.Player;
import Containers.Vector;
import Entities.EntityType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class Player extends JPanel implements EntityType {
    private final Vector vector;
    private final PlayerController controller;

    public Player(PlayerController controller, Vector vector) {
        this.controller = controller;
        this.vector = vector;
        setProperties();
    }

    private void setProperties() {
        setSize(64, 64);
        setBackground(Color.BLUE);
        setLocation((int)vector.getX(), (int)vector.getY());
        setVisible(true);
    }

    public KeyListener getKeyListener() {
        return (KeyListener) controller;
    }

    public void moveTo(float dx, float dy) {
        float newX = vector.getX() + dx;
        float newY = vector.getY() + dy;
        vector.setVector(newX, newY);
        setLocation((int)vector.getX(), (int)vector.getY());
    }

    public Vector getVector() {
        return this.vector;
    }

    @Override
    public void update() {
        controller.update(this);
    }
}

