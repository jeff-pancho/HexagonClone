package main.entity;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import main.Deletable;
import main.Entity;
import main.Game;
import main.collision.CollisionManager;

public class Player extends Polygon implements Deletable {
    private final double dist;
    private final double radius;
    private ArrayList<Entity> entityList;
    
    public Player(ArrayList<Entity> entityList, Color color) {
        super(3);
        this.dir = 0;
        this.dist = 80;
        this.radius = 10;
        this.entityList = entityList;
        this.color = color;
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
        
        double xPos = Game.CENTER_X + (Math.cos(dir + Game.dir) * dist);
        double yPos = Game.CENTER_Y + (Math.sin(dir + Game.dir) * dist);
        Polygon.generatePolygon(xPos, yPos, xPoints, yPoints, dir + Game.dir
                , radius);
    }
    
    public boolean ifDelete() {
        CollisionManager c = new CollisionManager(this);
        for(Entity e : entityList) {
            if(e instanceof Side && c.detectSideCollision((Polygon) e)) {
                return true;
            }
        }
        return false;
    }
}
