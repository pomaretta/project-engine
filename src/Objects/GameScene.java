package Objects;

/*

    Project     project-engine
    Package     Objects    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2021-02-25

    DESCRIPTION
    
*/

import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Carlos Pomares
 */

public abstract class GameScene implements Scene {

    // OBJECTS
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private Collection<GameEntity> entities;

    public GameScene(){
        this.canvas = new Canvas();
        this.graphicsContext = this.canvas.getGraphicsContext2D();
        this.entities = new ArrayList<>();
    }

    // ENTITIES
    protected GameEntity takeEntity(GameEntity entity){
        for (Iterator<GameEntity> iter = this.entities.iterator(); iter.hasNext(); ) {
            GameEntity gameEntity = iter.next();
            if(gameEntity == entity){
                this.entities.remove(entity);
                return gameEntity;
            }
        }
        return null;
    }
    protected void addEntity(GameEntity entity){
        this.entities.add(entity);
    }
    protected Collection getEntities(){
        return this.entities;
    }

    // RENDERING
    protected GraphicsContext getGraphicsContext(){
        return this.graphicsContext;
    }
    protected abstract void render(GraphicsContext gc);

    public boolean setSize(double width, double height){
        this.canvas.setWidth(width);
        this.canvas.setHeight(height);
        return this.canvas.getHeight() == height && this.canvas.getWidth() == width;
    }
    public Canvas getCanvas(){
        return this.canvas;
    }

    @Override
    public void run() {
        render(getGraphicsContext());
    }
}
