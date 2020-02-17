package main.ui.title.main_menu;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.ui.title.Title;

/**
 * The Title found on the Main Menu.
 * @author Jeff
 */
public class MainTitle extends Title {
    
    /**
     * Give the MainTitle its image.
     * @param gc
     */
    public MainTitle(GraphicsContext gc) {
        super(gc, new Image("file:./resources/title/menu-title.png"));
    }

}
