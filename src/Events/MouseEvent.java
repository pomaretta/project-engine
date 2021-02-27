package Events;

/*

    Project     project-engine
    Package     Events    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2021-02-27

    DESCRIPTION
    
*/

/**
 * @author Carlos Pomares
 */

public interface MouseEvent {
    public void onMouseClick(javafx.scene.input.MouseEvent event);
    public void onMouseEntered(javafx.scene.input.MouseEvent event);
    public void onMouseExit(javafx.scene.input.MouseEvent event);
    public void onMousePressed(javafx.scene.input.MouseEvent event);
    public void onMouseReleased(javafx.scene.input.MouseEvent event);
}
