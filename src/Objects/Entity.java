package Objects;

/*

    Project     project-engine
    Package     Objects    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2021-02-25

    DESCRIPTION
    
*/

import javafx.scene.canvas.GraphicsContext;

/**
 * @author Carlos Pomares
 */

public interface Entity {
    public Vector2D getVector2D();
    public void render(GraphicsContext g);
}
