package jgame.entities.common;

import jgame.containers.SizeDimensionsType;
import jgame.containers.Vector;

import java.awt.*;

// The requirement of something to be considered an Entity in this project must satisfy the following requirements:
// - Has vector-defined positioning in 2D space
// - Has an explicitly defined size
// - Can have its properties updated as part of the game-loop
// - Can be rendered

public interface EntityType {
    public Vector getVector();

    public SizeDimensionsType getSizeDimensions();

    public void update();

    public void render(Graphics2D g);
}