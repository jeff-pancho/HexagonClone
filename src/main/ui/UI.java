/**
 * 
 */
package main.ui;

import javafx.scene.canvas.GraphicsContext;

/**
 * UI object to place in a screen or menu.
 * @author Jeff
 */
public abstract class UI {
    protected final GraphicsContext gc;
    protected double x;
    protected double y;
    
    /**
     * Assign the UI object its GraphicsContext.
     * @param gc
     */
    public UI(GraphicsContext gc) {
        this.gc = gc;
    }
    
    /**
     * Update the UI object.
     */
    public abstract void update();
    
    /**
     * Render the UI object.
     */
    public abstract void render();
    
}
