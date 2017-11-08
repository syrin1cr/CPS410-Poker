/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allinpoker;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Kaleyta
 */
public class AllInPoker extends Application {
    
    private Stage stage;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        try{
            
            stage = primaryStage;           
            stage.setTitle("All-In Poker");
            stage.setResizable(false);
            gotoStartScreen();
            stage.show();
            
        }catch(Exception ex){
            Logger.getLogger(AllInPoker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private void gotoStartScreen(){
        try{
            StartScreenController startScreen = new StartScreenController();
            stage.setScene(new Scene(startScreen.getFXML()));
        }catch (Exception ex){
            Logger.getLogger(AllInPoker.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    protected void gotoLobby(){
        try{
            LobbyController lobby = new LobbyController();
            stage.setScene(new Scene(lobby.getFXML()));
        }catch (Exception ex){
            Logger.getLogger(AllInPoker.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    

}
