package main.ui.button;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.Game;
import main.ui.UI;

/**
 * Orbiting Button to select things from a menu.
 * @author Jeff
 */
public abstract class Button extends UI {
    protected final Image img;
    protected double width;
    protected double height;
    /**
     * Since buttons orbit around a certain point, we need its direction
     * from the center.
     */
    protected double dir;
    /** Boolean that states whether or not the Button is being switched. */
    protected boolean switching;
    
    
    /**
     * Initialize Button.
     * @param gc
     */
    public Button(GraphicsContext gc, Image img) {
        super(gc);
        
        this.switching = false;
        this.img = img;
        this.width = img.getWidth();
        this.height = img.getHeight();
        
        // Put the button past the window to hide it.
        x = -300;
        y = -300;
    }
    
    /**
     * Update the button and its position.
     */
    @Override
    public void update() {
        final double centerX = Game.CENTER_X - width / 2;
        final double centerY = Game.HEIGHT - height / 2;
        final double dist = 200;
        final double targetDir = 3 * Math.PI / 2;
        
        x = centerX + Math.cos(dir) * dist;
        y = centerY + Math.sin(dir) * dist;
        
        // While switching, if it reaches its target position, set it to off.
        if (switching
                && Math.abs(x - (centerX + Math.cos(targetDir) * dist)) <= 1
                && Math.abs(y - (centerY + Math.sin(targetDir) * dist)) <= 1)
            switching = false;
    }
    
    /**
     * Render the button.
     */
    @Override
    public void render() {
        gc.drawImage(img, x, y);
    }
    
    /**
     * Return if it's switching positions.
     * @return switching
     */
    public boolean isSwitching() {
        return this.switching;
    }

    /**
     * Sets if it's switching positions.
     * @param switching
     */
    public void setSwitching(boolean switching) {
        this.switching = switching;
    }
    
    /**
     * Set the direction of the Button.
     * @param dir
     */
    public void setDir(double dir) {
        this.dir = dir;
    }
    
}
