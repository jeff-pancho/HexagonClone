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
    private final double centerX;
    private final double centerY;
    
    /**
     * Initialize the CenterHexagon, assigning a reference to
     * the game's GraphicsContext and direction.
     * @param gc
     * @param centerX
     * @param centerY
     * @param radius
     * @param gameDir
     */
    public CenterHexagon(GraphicsContext gc, double centerX, double centerY, double radius, double[] gameDir) {
        super(gc, 6, gameDir);
        this.strokeSize = 5;
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
    }
    
    /**
     * Update the points of the CenterHexagon.
     */
    @Override
    public void update() {
        final double offsetDir = dir + gameDir[0];
        Polygon.generatePolygon(centerX, centerY, xPoints, yPoints, offsetDir, radius);
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
