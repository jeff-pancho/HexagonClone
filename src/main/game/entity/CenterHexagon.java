package main.game.entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.Game;

/**
 * The hexagon at the center of the window.
 * @author Jeff
 */
public class CenterHexagon extends Polygon {
    private double strokeSize;
    private double radius;
    
    /**
     * Initialize the CenterHexagon, assigning a reference to
     * the game's GraphicsContext.
     * @param gc
     * @param gameDir
     */
    public CenterHexagon(GraphicsContext gc, double[] gameDir) {
        super(gc, 6, gameDir);
        this.strokeSize = 5;
        this.radius = 50;
    }
    
    /**
     * Update the points of the CenterHexagon.
     */
    @Override
    public void update() {
        final double offsetDir = dir + gameDir[0];
        Polygon.generatePolygon(Game.CENTER_X, Game.CENTER_Y, xPoints, yPoints, offsetDir, radius);
    }
    
    /**
     * Render the CenterHexagon.
     */
    @Override
    public void render() {
        // Render the inner Hexagon.
        gc.setFill(Color.WHITE);
        render(true);
        
        // Render the border of the Hexagon.
        gc.setLineWidth(strokeSize);
        gc.setStroke(Color.BLACK);
        render(false);
    }

}
