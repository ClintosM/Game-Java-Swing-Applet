package jgame.entities.common.interfaces;

import jgame.containers.Position;
import jgame.containers.SizeDimensionsType;

import java.awt.*;

public interface EntityDrawManagerType {
    default void render(
            Graphics2D g,
            Position pos,
            SizeDimensionsType size,
            Color color) {
        g.setColor(color);
        g.fillRect(
                (int) pos.x(),
                (int) pos.y(),
                size.getWidth(),
                size.getHeight()
        );
    }
}
