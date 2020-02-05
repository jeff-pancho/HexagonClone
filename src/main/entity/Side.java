package main.entity;

import main.Deletable;
import main.Game;

public class Side extends Polygon implements Deletable {
    private double size;
    private double dist;
    private int side;
    
    public Side(int side, double size) {
        super(4, 4);
        // starting distance should always be beyond the screen
        this.dist = 800;
        this.size = size;
        this.side = side;
        this.dir = (Math.PI / 3) * side;
    }
    
    public void update() {
        dist -= 6;
        Polygon.generateSide(xPoints, yPoints, Game.dir + dir, dist, size);
    }
    
    public boolean ifDelete() {
        return dist <= 40;
    }
    
    public double getDir() {
        return this.dir;
    }
}
