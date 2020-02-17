package main.ui.button.main_menu;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.ui.button.Button;

/**
 * Quit Button that takes exits the application.
 * @author Jeff
 */
public class QuitButton extends Button {
    
    /**
     * Sets up the Quit Button.
     * @param gc
     */
    public QuitButton(GraphicsContext gc, double[] menuDir) {
        super(gc, new Image("file:./resources/button/main-menu/quit.png"), menuDir);
    }
     
}
