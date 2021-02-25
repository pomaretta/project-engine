package Singleton;

/*

    Project     project-engine
    Package     Singleton    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2021-02-25

    DESCRIPTION
    
*/

import Manager.ApplicationManager;
import Manager.SceneManager;
import Utilities.GameInfo;
import javafx.stage.Stage;

/**
 * @author Carlos Pomares
 */

public class Game {

    private static String[] args;

    private static GameInfo gameInfo;
    private static ApplicationManager applicationManager;
    private static SceneManager sceneManager;
    private static Game game;

    private Game(){
        applicationManager = new ApplicationManager();
        sceneManager = new SceneManager();
        gameInfo = new GameInfo();
    }

    public static SceneManager getSceneManager(){
        return sceneManager;
    }

    public static ApplicationManager getApplicationManager(){
        return applicationManager;
    }

    public static void init(String[] initArgs){
        game = new Game();
        args = initArgs;
    }

    public static void setGameInfo(GameInfo v){
        gameInfo = v;
    }

    public static GameInfo getGameInfo(){
        return gameInfo;
    }

    public static void start() throws Exception {
        applicationManager.run(args);
    }

}
