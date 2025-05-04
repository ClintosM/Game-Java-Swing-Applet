package jgame.entities.common;

import jgame.containers.SizeDimensionsType;
import jgame.containers.Vector;

import java.awt.*;

public interface EntityType {
    public Vector getVector();

    public SizeDimensionsType getSizeDimensions();

    public void update();

    public void render(Graphics2D g);
}