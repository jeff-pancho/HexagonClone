package main.ui.button.main_menu;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.ui.button.Button;

/**
 * Play Button that takes the user to the Level Menu.
 * @author Jeff
 */
public class PlayButton extends Button {
    
    /**
     * Sets up the Play Button.
     * @param gc
     */
    public PlayButton(GraphicsContext gc) {
        super(gc, new Image("file:./resources/button/main-menu/play.png"));
    }
     
}
