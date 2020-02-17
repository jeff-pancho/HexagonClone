package main.ui.button.level_menu;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.ui.button.Button;

/**
 * Medium Button that takes the user to the medium level.
 * @author Jeff
 */
public class MediumButton extends Button {
    
    /**
     * Sets up the Medium Button.
     * @param gc
     */
    public MediumButton(GraphicsContext gc, double[] menuDir) {
        super(gc, new Image("file:./resources/button/level-menu/medium.png"), menuDir);
    }
     
}
