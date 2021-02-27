package Physics;

/*

    Project     project-engine
    Package     Physics    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2021-02-27

    DESCRIPTION
    
*/

import Objects.GameEntity;

/**
 * @author Carlos Pomares
 */

public class Collider {

    private double minX,minY,maxX,maxY;

    public Collider(double minX, double minY, double maxX, double maxY){
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public double getMinX() {
        return minX;
    }

    public double getMinY() {
        return minY;
    }

    public double getMaxX() {
        return maxX;
    }

    public double getMaxY() {
        return maxY;
    }

    public void setMinX(double minX) {
        this.minX = minX;
    }

    public void setMinY(double minY) {
        this.minY = minY;
    }

    public void setMaxX(double maxX) {
        this.maxX = maxX;
    }

    public void setMaxY(double maxY) {
        this.maxY = maxY;
    }

    // TODO
    public boolean intersects(Collider collider){
        return false;
    }

    // TODO
    public static boolean collision(GameEntity v, GameEntity v1){
        return false;
    }

}
