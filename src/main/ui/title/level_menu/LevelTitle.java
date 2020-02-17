package main.ui.title.level_menu;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.ui.title.Title;

/**
 * The Title found on the Level Menu.
 * @author Jeff
 */
public class LevelTitle extends Title {
    
    /**
     * Give the LevelTitle its image.
     * @param gc
     */
    public LevelTitle(GraphicsContext gc) {
        super(gc, new Image("file:./resources/title/level.png"));
    }

}
