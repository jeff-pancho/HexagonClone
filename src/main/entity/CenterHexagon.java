package main.entity;

import javafx.scene.canvas.GraphicsContext;
import main.Entity;
import main.Game;

public class CenterHexagon extends Entity {
    private double[][] xPoints;
    private double[][] yPoints;
    private double size;
    private double dist;
    
    public CenterHexagon() {
        this.xPoints = new double[6][4];
        this.yPoints = new double[6][4];
        this.size = 5;
        this.dist = 50;
    }
    
    public void update() {
        
        for(int i = 0; i < xPoints.length; i++) {
            Polygon.generateSide(xPoints[i], yPoints[i], Game.dir + (Math.PI / 3 * i), dist, size);
        }
    }

    public void render(GraphicsContext gc) {
        for(int i = 0; i < 6; i++)
            gc.fillPolygon(xPoints[i], yPoints[i], xPoints[i].length);
    }
}
