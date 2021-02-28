package Objects;

/*

    Project     project-engine
    Package     Objects    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2021-02-27

    DESCRIPTION
    
*/

/**
 * @author Carlos Pomares
 */

public class Vector2D implements Vector {

    private double minX, minY;
    private double maxX,maxY;
    private double posX, posY;
    private int z = 0;

    @Override
    public double getMinX() {
        return minX;
    }

    @Override
    public double getMinY() {
        return minY;
    }

    @Override
    public double getMaxX() {
        return maxX;
    }

    @Override
    public double getMaxY() {
        return maxY;
    }

    @Override
    public double getPosX() {
        return posX;
    }

    @Override
    public double getPosY() {
        return posY;
    }

    @Override
    public int getZ() {
        return z;
    }

    public void setSize(double v, double v1){
        setMaxX(v);
        setMaxY(v1);
    }

    @Override
    public void setMinX(double v) {
        minX = getPosX();
    }

    @Override
    public void setMinY(double v) {
        minY = getPosY();
    }

    @Override
    public void setMaxX(double maxX) {
        this.maxX = maxX;
    }

    @Override
    public void setMaxY(double maxY) {
        this.maxY = maxY;
    }

    @Override
    public void setPosX(double posX) {
        this.posX = posX;
    }

    @Override
    public void setPosY(double posY) {
        this.posY = posY;
    }

    @Override
    public void setZ(int v) {
        z = v;
    }

}
