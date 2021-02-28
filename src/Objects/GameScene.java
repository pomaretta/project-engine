package Objects;

/*

    Project     project-engine
    Package     Objects    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2021-02-25

    DESCRIPTION
    
*/

import Singleton.Game;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;

import java.awt.event.KeyEvent;
import java.util.*;

/**
 * @author Carlos Pomares
 */

public abstract class GameScene implements Scene {

    // OBJECTS
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private ArrayList<GameEntity> entities;
    protected AnimationTimer gameTimer;

    // POSITIONING
    private double minX,minY,maxX,maxY;

    public GameScene(){
        this.canvas = new Canvas();
        this.graphicsContext = this.canvas.getGraphicsContext2D();
        this.entities = new ArrayList<>();

        // POSITIONING
        this.minX = 0;
        this.minY = 0;
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
        entity.bindScene(this);
    }
    public ArrayList<GameEntity> getEntities(){
        return this.entities;
    }

    // RENDERING
    protected GraphicsContext getGraphicsContext(){
        return this.graphicsContext;
    }
    protected AnimationTimer getGameTimer() {
        return gameTimer;
    }

    // POSITIONING
    public boolean setSize(double width, double height){
        this.canvas.setWidth(width);
        this.canvas.setHeight(height);
        this.maxX = canvas.getBoundsInParent().getMaxX();
        this.maxY = canvas.getBoundsInParent().getMaxY();
        return this.canvas.getHeight() == height && this.canvas.getWidth() == width;
    }
    public Canvas getCanvas(){
        return this.canvas;
    }
    public double getMinX() {
        return minX;
    }
    public double getMinY() {
        return minY;
    }
    public double getMaxX() {
        return maxX;
    }
    public double getMaxY() {
        return maxY;
    }

    protected abstract void init();

    @Override
    public void run() {
        init();
        for(GameEntity entity : entities){
            entity.start();
        }
        entities.sort((left, right) -> left.getVector2D().getZ() - right.getVector2D().getZ());
        update();
    }

    protected void render(GraphicsContext gc, long time){
        gc.clearRect(0,0,getCanvas().getWidth(),getCanvas().getHeight());
        for(GameEntity entity : entities){
            entity.render(gc);
        }
    }

    private void update(){
        long startTime = System.nanoTime();
        this.gameTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                long time = (l - startTime) / 1000000000;
                update(time);
                render(getGraphicsContext(),time);
            }
        };
        gameTimer.start();
    }

    protected abstract void update(long time);

    public void stop(){
        gameTimer.stop();
    }

}
