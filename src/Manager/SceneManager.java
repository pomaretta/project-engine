package Manager;

/*

    Project     project-engine
    Package     Manager    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2021-02-25

    DESCRIPTION
    
*/

import Objects.GameScene;
import Objects.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Carlos Pomares
 */

public class SceneManager {

    private double prefWidth = 1280, prefHeigth = 720;

    private javafx.scene.Scene gameScene;
    private VBox gameRoot;
    private Collection<Scene> scenes;
    private GameScene currentScene;

    public SceneManager(){
        gameRoot = new VBox();

        // DEFAULT SIZE
        gameRoot.setPrefSize(this.prefWidth,this.prefHeigth);

        scenes = new ArrayList<>();
        gameScene = new javafx.scene.Scene(gameRoot);
        currentScene = null;
    }

    public boolean setSize(double width, double height){
        setPrefWidth(width);
        setPrefHeigth(height);
        applyResize();
        return gameRoot.getPrefWidth() == width && gameRoot.getPrefHeight() == height;
    }

    public void setPrefWidth(double v){
        this.prefWidth = v;
        applyResize();
    }

    public void setPrefHeigth(double v){
        this.prefHeigth = v;
        applyResize();
    }

    private void applyResize(){
        gameRoot.setPrefWidth(this.prefWidth);
        gameRoot.setPrefHeight(this.prefHeigth);
    }

    public boolean registerScene(GameScene gameScene){
        return this.scenes.add(gameScene);
    }

    public javafx.scene.Scene getGameScene() {
        return gameScene;
    }

    public Collection<Scene> getScenes() {
        return scenes;
    }

    public GameScene getCurrentScene() {
        return currentScene;
    }

    public boolean setCurrentScene(GameScene gameScene){
        this.currentScene = gameScene;
        return this.currentScene.equals(gameScene);
    }

    private void loadScene(){
        this.gameRoot.getChildren().clear();
        this.gameRoot.getChildren().add(this.currentScene.getCanvas());
        this.currentScene.setSize(gameRoot.getPrefWidth(), gameRoot.getPrefHeight());
        this.currentScene.run();
    }

    public static void changeScene(SceneManager manager, GameScene scene){
        assert scene != null;
        if(manager.currentScene != null){
            manager.currentScene.stop();
        }
        manager.setCurrentScene(scene);
        manager.loadScene();
    }

}
