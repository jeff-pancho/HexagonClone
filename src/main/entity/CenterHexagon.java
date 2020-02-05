package main.entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.Entity;
import main.Game;

public class CenterHexagon extends Entity {
    private double[][] xPoints;
    private double[][] yPoints;
    private double[] innerXPoints;
    private double[] innerYPoints;
    private double size;
    private double dist;
    
    public CenterHexagon() {
        this.xPoints = new double[6][4];
        this.yPoints = new double[6][4];
        this.innerXPoints = new double[6];
        this.innerYPoints = new double[6];
        this.size = 5;
        this.dist = 50;
    }
    
    public void update() {
        Polygon.generatePolygon(Game.CENTER_X, Game.CENTER_Y, innerXPoints, innerYPoints
                , Game.dir, dist);
        for(int i = 0; i < xPoints.length; i++) {
            Polygon.generateSide(xPoints[i], yPoints[i], Game.dir + (Math.PI / 3 * i), dist, size);
        }
    }

    public void render(GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        gc.fillPolygon(innerXPoints, innerYPoints, innerXPoints.length);
        gc.setFill(Color.BLACK);
        for(int i = 0; i < 6; i++)
            gc.fillPolygon(xPoints[i], yPoints[i], xPoints[i].length);
    }
}
