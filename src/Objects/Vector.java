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

public interface Vector {
    public double getMinX();
    public double getMinY();
    public double getMaxX();
    public double getMaxY();
    public double getPosX();
    public double getPosY();
    public int getZ();
    public void setMinX(double v);
    public void setMinY(double v);
    public void setMaxX(double v);
    public void setMaxY(double v);
    public void setPosX(double v);
    public void setPosY(double v);
    public void setZ(int v);
}
