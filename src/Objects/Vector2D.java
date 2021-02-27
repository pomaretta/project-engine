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

    private double x,y;
    private int z = 0;

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public int getZ() {
        return z;
    }

    @Override
    public void setX(double v) {
        x = v;
    }

    @Override
    public void setY(double v) {
        y = v;
    }

    @Override
    public void setZ(int v) {
        z = v;
    }

}
