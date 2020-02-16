package main.screen;

import java.util.Stack;

import javafx.scene.canvas.GraphicsContext;
import main.input.Keyboard;

/**
 * Screen to be rendered in the game
 * @author Jeff
 */
public abstract class Screen {
    protected final GraphicsContext gc;
    protected final Keyboard kb;
    protected final Stack<Screen> screens;
    
    /**
     * Assigns a reference to the Screen's GraphicsContext, Keyboard, and Stack.
     * @param gc
     * @param kb
     * @param screens
     */
    public Screen(GraphicsContext gc, Keyboard kb, Stack<Screen> screens) {
        this.gc = gc;
        this.kb = kb;
        this.screens = screens;
    }
    
    /**
     * Update the screen and its contents.
     */
    public abstract void update();
    
    /**
     * Render the screen and its contents.
     */
    public abstract void render();
    
}
