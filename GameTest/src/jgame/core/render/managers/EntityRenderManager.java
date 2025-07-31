package jgame.core.render.managers;

import jgame.core.render.interfaces.EntityRenderable;

import java.awt.*;
import java.util.ArrayList;

public class EntityRenderManager {
    private ArrayList<EntityRenderable> entityRenderables;

    public EntityRenderManager(ArrayList<EntityRenderable> entityRenderables) {
        this.entityRenderables = entityRenderables;
    }

    public void render(Graphics2D g) {
        for (EntityRenderable entityRenderable : entityRenderables) {
            entityRenderable.render(g);
        }
    }
}
