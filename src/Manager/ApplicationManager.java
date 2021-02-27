package Manager;

/*

    Project     project-engine
    Package     Manager    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2021-02-25

    DESCRIPTION
    
*/

import Singleton.Game;
import Utilities.GameInfo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Carlos Pomares
 */

public class ApplicationManager extends Application {

    private Stage stage;
    private GameInfo gameInfo;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        this.stage.setScene(Game.getSceneManager().getGameScene());
        this.stage.setTitle(String.format("%s",gameInfo.getTitle()));
        this.stage.setResizable(false);
        this.stage.show();
    }

    public Stage getStage(){
        return this.stage;
    }

    public void init(){
        // INFO RESEARCH
        this.gameInfo = Game.getGameInfo();
    }

    public void run(String[] args){
        launch(args);
    }

}
