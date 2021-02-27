package Events;

/*

    Project     project-engine
    Package     Events    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2021-02-27

    DESCRIPTION
    
*/

import javafx.scene.input.KeyCode;

import java.util.ArrayList;

/**
 * @author Carlos Pomares
 */

public interface KeyEvent {
    public void onKeyPressed(javafx.scene.input.KeyEvent event);
    public void onKeyReleased(javafx.scene.input.KeyEvent event);
    public void onKeyTyped(javafx.scene.input.KeyEvent event);
}
