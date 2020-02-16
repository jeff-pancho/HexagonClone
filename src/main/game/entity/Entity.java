package main.game.entity;

import javafx.scene.canvas.GraphicsContext;

/**
 * Entity that can be interacted with ingame.
 * @author Jeff
 */
public abstract class Entity {
    protected GraphicsContext gc;
    
    /**
     * Assign the Entity a reference to the game's GraphicsContext
     * @param gc
     */
    public Entity(GraphicsContext gc) {
        this.gc = gc;
    }
    
    /**
     * Update the Entity.
     */
    public abstract void update();
    
    /**
     * Render the Entity using its GraphicsContext.
     */
    public abstract void render();
}
