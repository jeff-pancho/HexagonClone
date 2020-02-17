package main.ui.title;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.Game;
import main.ui.UI;

/**
 * The Title UI of a Menu.
 * @author Jeff
 */
public abstract class Title extends UI {
    protected final Image img;
    protected double width;
    protected double height;
    
    /**
     * Initialize the Title, assigning it a reference to the game's
     * GraphicsContext and assigning it an image.
     * @param gc
     * @param img
     */
    public Title(GraphicsContext gc, Image img) {
        super(gc);
        this.img = img;
        this.width = img.getWidth();
        this.height = img.getHeight();
        this.x = Game.CENTER_X - width / 2;
        this.y = 100;
        
    }
    
    /**
     * Update the Title.
     */
    @Override
    public void update() {
        // TODO: Think of something to update for Title
    }
    
    /**
     * Render the Title with its Image.
     */
    @Override
    public void render() {
        gc.drawImage(img, x, y);
    }

}
