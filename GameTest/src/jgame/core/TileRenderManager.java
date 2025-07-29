package jgame.core;

import java.awt.*;
import java.util.ArrayList;

public class TileRenderManager {
    ArrayList<TileRenderable> tileRenderables;

    public TileRenderManager(ArrayList<TileRenderable> tileRenderables) {
       this.tileRenderables = tileRenderables;
    }

    public void render(Graphics2D g) {
        for (TileRenderable tile : tileRenderables) {
            tile.render(g);
        }
    }
}
