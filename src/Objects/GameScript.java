package Objects;

/*

    Project     project-engine
    Package     Objects    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2021-02-27

    DESCRIPTION
    
*/

import Events.KeyEvent;

/**
 * @author Carlos Pomares
 */

public abstract class GameScript implements MonoBehaviour, KeyEvent {

    protected GameEntity entity;

    public GameScript(GameEntity entity) {
        this.entity = entity;
    }

    @Override
    public void onKeyPressed(javafx.scene.input.KeyEvent event) {

    }

    @Override
    public void onKeyReleased(javafx.scene.input.KeyEvent event) {

    }

    @Override
    public void onKeyTyped(javafx.scene.input.KeyEvent event) {

    }

}
