package Objects;

/*

    Project     project-engine
    Package     Objects    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2021-02-25

    DESCRIPTION
    
*/

import Physics.Collider;
import Physics.Collider2D;
import Singleton.Game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

/**
 * @author Carlos Pomares
 */

public abstract class GameEntity implements Entity, Collider2D {

    // POSITION
    protected Vector2D vector2D;

    // SCRIPTS
    protected Collection<GameScript> scripts;

    // GAMESCENE BINDED
    private GameScene gameScene;

    public GameEntity(){
        scripts = new ArrayList<>();
        vector2D = new Vector2D();
        for(GameScript script : scripts){
            script.start();
        }
    }

    public void bindScene(GameScene gameScene){
        this.gameScene = gameScene;
    }

    protected abstract void start();

    public void addScript(GameScript script){
        scripts.add(script);
    }

    public Collection<GameScript> getScripts() {
        return scripts;
    }

    public GameScene getGameScene() {
        return gameScene;
    }

    @Override
    public Vector2D getVector2D() {
        return this.vector2D;
    }

    @Override
    public void render(GraphicsContext g) {
        for(GameScript script : scripts){
            script.update();
        }
    }

    @Override
    public Collider getCollider() {
        return null;
    }
}
