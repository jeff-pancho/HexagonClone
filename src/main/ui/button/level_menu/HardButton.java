package main.ui.button.level_menu;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.ui.button.Button;

/**
 * Hard Button that takes the user to the hard level.
 * @author Jeff
 */
public class HardButton extends Button {
    
    /**
     * Sets up the Hard Button.
     * @param gc
     */
    public HardButton(GraphicsContext gc, double[] menuDir) {
        super(gc, new Image("file:./resources/button/level-menu/hard.png"), menuDir);
    }
     
}
