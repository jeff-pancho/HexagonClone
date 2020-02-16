package main.screen;

import java.util.Stack;

import javafx.scene.canvas.GraphicsContext;
import main.input.Keyboard;

/**
 * Game Screen that appears when the player chooses a level.
 * @author Jeff
 */
public class GameScreen extends Screen {
    
    /**
     * Initialize the GameScreen.
     * @param gc
     * @param kb
     * @param screens
     */
    public GameScreen(GraphicsContext gc, Keyboard kb, Stack<Screen> screens) {
        super(gc, kb, screens);
        
    }
    
    /**
     * Update the GameScreen and its contents.
     */
    @Override
    public void update() {
        
    }

    /**
     * Render the GameScreen and its contents using its GraphicsContext.
     */
    @Override
    public void render() {
        
    }

}
