package main.collision;

import java.util.ArrayList;
import javafx.geometry.Point2D;

import main.collision.Scalar;
import main.entity.Polygon;
import main.Entity;

public class CollisionManager {
    private Entity ent;
    
    public CollisionManager(Entity ent) {
        this.ent = ent;
    }
    
    public boolean detectSideCollision(Polygon p2) {
        Polygon p1 = (Polygon) ent;
        // check if entity is within the side's direction
        if(p1.getDir() >= p2.getDir()
                && p1.getDir() <= p2.getDir() + (Math.PI / 3)) {
            return detectPolyCollision(p1, p2);
        }
        return false;
    }
    
    public boolean detectPolyCollision(Polygon p1, Polygon p2) {
        ArrayList<Point2D> axes = new ArrayList<Point2D>();
        addAxes(axes, p1);
        addAxes(axes, p2);
        
        // if the scalar projections don't overlap, immediately stop
        for(Point2D axis : axes) {
            Scalar s1 = Scalar.project(p1, axis);
            Scalar s2 = Scalar.project(p2, axis);
            if(!s1.ifOverlap(s2))
                return false;
        }
        return true;
    }
    
    private void addAxes(ArrayList<Point2D> axes, Polygon p) {
        for(int i = 0; i < p.getSides(); i++) {
            Point2D ptStart = new Point2D(p.getXPoints()[i]
                    , p.getYPoints()[i]);
            Point2D ptEnd = new Point2D(p.getXPoints()[(i + 1) % p.getSides()]
                    , p.getYPoints()[(i + 1) % p.getSides()]);
            axes.add(perpVector(vector(ptStart, ptEnd)));
        }
    }
    
    private Point2D vector(Point2D pt1, Point2D pt2) {
        return pt1.subtract(pt2).normalize();
    }
    
    private Point2D perpVector(Point2D vector) {
        return new Point2D(-vector.getY(), vector.getX()).normalize();
    }
}
