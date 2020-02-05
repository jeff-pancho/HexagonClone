package main.entity;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import main.Deletable;
import main.Entity;
import main.Game;

public class Player extends Polygon implements Deletable {
    private double dir;
    private final double dist;
    private final double radius;
    private ArrayList<Entity> entityList;
    
    public Player(ArrayList<Entity> entityList) {
        super(3, 3);
        this.dir = 0;
        this.dist = 80;
        this.radius = 10;
        this.entityList = entityList;
    }

    public void update() {
        if(Game.rightDown)
            dir += Math.PI / 25;
        else if (Game.leftDown)
            dir -= Math.PI / 25;
        dir %= Math.PI * 2;
        // if going in a negative direction, wrap back to 2PI
        if(dir < 0)
            dir += Math.PI * 2;
        
        double xPos = (Game.WIDTH / 2) + (Math.cos(dir + Game.dir) * dist);
        double yPos = (Game.HEIGHT / 2) + (Math.sin(dir + Game.dir) * dist);
        Polygon.generatePolygon(xPos, yPos, xPoints, yPoints, dir + Game.dir
                , radius);
    }
    
    public boolean ifDelete() {
        for(Entity e : entityList) {
            if(e instanceof Side && collideWith((Side) e)) {
                System.out.println("Balls");
            }
        }
        return false;
    }
    
    private boolean collideWith(Side s) {
        // check if player is within the side's direction
        if(dir >= s.getDir() && dir <= s.getDir() + (Math.PI / 3)) {
            
        }
        return false;
    }
}
