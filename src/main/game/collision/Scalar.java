package main.game.collision;

import javafx.geometry.Point2D;
import main.game.entity.Polygon;

/**
 * A scalar value involved in vector calculation.
 * More specifically, used in collision detection with two polygons.
 * @author Jeff
 */
public class Scalar {
    private double min;
    private double max;
    
    /**
     * Create the scalar with the specified values.
     * @param min minimum value
     * @param max maximum value
     */
    public Scalar(double min, double max) {
        this.min = min;
        this.max = max;
    }
    
    /**
     * Compare with another Scalar to check if they are overlapping
     * @param s other scalar
     * @return if overlapping
     */
    public boolean isOverlapping(Scalar s) {
        return min < s.max && max > s.min;
    }
    
    /**
     * Compare with the inputted min and max values to check
     * if the Scalar overlaps with them.
     * @param min
     * @param max
     * @return if overlapping
     */
    public boolean isOverlapping(double min, double max) {
        return this.min < max && this.max > min;
    }
    
    /**
     * Projects a polygon against a 2D axis, returning a Scalar.
     * @param p
     * @param axis
     * @return scalar projection of Polygon
     */
    public static Scalar project(Polygon p, Point2D axis) {
        double dotProducts[] = new double[p.getNumPoints()];
        for (int i = 0; i < p.getNumPoints(); i++) {
             // For each point of the polygon, project it against the axis
            Point2D point = new Point2D(p.getXPoints()[i], p.getYPoints()[i]);
            dotProducts[i] = point.dotProduct(axis);
        }
        return new Scalar(min(dotProducts), max(dotProducts));
    }
    
    /**
     * Takes an array of doubles and returns the smallest value.
     * @param nums
     * @return smallest number in the array
     */
    private static double min(double[] nums) {
        double min = nums[0];
        for(int i = 1; i < nums.length; i++)
            if(nums[i] < min)
                min = nums[i];
        return min;
    }
    
    /**
     * Takes an array of doubles and returns the largest value.
     * @param nums
     * @return largest number in the array
     */
    private static double max(double[] nums) {
        double max = nums[0];
        for(int i = 1; i < nums.length; i++)
            if(nums[i] > max)
                max = nums[i];
        return max;
    }

}
