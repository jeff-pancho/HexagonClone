package main.ui.button.level_menu;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.ui.button.Button;

/**
 * Easy Button that takes the user to the easy level.
 * @author Jeff
 */
public class EasyButton extends Button {
    
    /**
     * Sets up the Easy Button.
     * @param gc
     */
    public EasyButton(GraphicsContext gc, double[] menuDir) {
        super(gc, new Image("file:./resources/button/level-menu/easy.png"), menuDir);
    }
     
}
