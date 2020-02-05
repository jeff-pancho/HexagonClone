package main.entity;

import javafx.scene.canvas.GraphicsContext;
import main.Deletable;
import main.Entity;
import main.Game;

public class Side extends Entity implements Deletable {
    private double[] xPoints;
    private double[] yPoints;
    private double size;
    private double dist;
    private double dir;
    private int side;
    
    public Side(int side, double size) {
        // starting distance should always be beyond the screen
        this.dist = 800;
        this.size = size;
        this.side = side;
        this.xPoints = new double[4];
        this.yPoints = new double[4];
        this.dir = (Math.PI / 3) * side;
    }
    
    public void update() {
        dist -= 5;
        generateSide(xPoints, yPoints, Game.dir + dir, dist, size);
    }
    
    public static void generateSide(double xPt[], double yPt[]
            , double dir, double dist, double size) {
        
        double pointDir;
        double pointDist;
        
        for(int i = 0; i < xPt.length; i++) {
            pointDir = i >= 2 ?
                    dir + (Math.PI / 3)
                    : dir;
            pointDist = i == 1 || i == 2 ?
                    dist + size
                    : dist;
            xPt[i] = (Game.WIDTH / 2) 
                    + (Math.cos(pointDir) * pointDist);
            yPt[i] = (Game.HEIGHT / 2) 
                    + (Math.sin(pointDir) * pointDist);
        }
    }
    
    public void render(GraphicsContext gc) {
        gc.fillPolygon(xPoints, yPoints, xPoints.length);
    }
    
    public boolean ifDelete() {
        return dist <= 40;
    }
    
    public double getDir() {
        return this.dir;
    }
}
