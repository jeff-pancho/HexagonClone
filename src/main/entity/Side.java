package main.entity;

import javafx.scene.paint.Color;
import main.Game;

public class Side extends Polygon implements Deletable {
    private double size;
    private double dist;
    
    public Side(int side, double dist, double size, Color color) {
        super(4);
        // starting distance should always be beyond the screen
        this.dist = dist;
        this.size = size;
        this.dir = (Math.PI / 3) * side;
        this.color = color;
    }
    
    public void update() {
        dist -= 6;
        Polygon.generateSide(xPoints, yPoints, Game.dir + dir, dist, size);
    }
    
    public boolean ifDelete() {
        return dist <= 20;
    }
    
    public double getDir() {
        return this.dir;
    }
    
    public double getDist() {
        return this.dist;
    }
}
