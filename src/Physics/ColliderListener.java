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
import java.util.ArrayList;

/**
 * @author Carlos Pomares
 */

public interface ColliderListener {
    public void checkCollisions(ArrayList<GameEntity> entities);
}
