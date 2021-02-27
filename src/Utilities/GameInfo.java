package Utilities;

/*

    Project     project-engine
    Package     Utilities    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2021-02-25

    DESCRIPTION
    
*/

import Singleton.Game;

/**
 * @author Carlos Pomares
 */

public class GameInfo {

    // GAME METADATA
    private String title;
    private String version;
    private String author;

    public GameInfo(){
        this.title = "Project Engine";
        this.version = "0.0.1";
        this.author = "Carlos Pomares";
    }

    public GameInfo(String title){
        this.title = title;
    }

    public GameInfo(String title,String version){
        this.title = title;
        this.version = version;
    }

    private GameInfo(String title, String version, String author){
        this.title = title;
        this.version = version;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getVersion() {
        return version;
    }

    public String getAuthor() {
        return author;
    }
    
}
