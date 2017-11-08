/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allinpoker;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Kaleyta
 */
public class StartScreenController implements Initializable {

    @FXML
    private Label lblUsernameStatus;
    @FXML
    private Label lblConnectionStatus;
    @FXML
    private TextField tfUsername;
    
    private final String FXMLPATH = "StartScreen.fxml";
    public static Player self;
    private String username, avatarPath;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lblUsernameStatus.setVisible(false);
        lblConnectionStatus.setVisible(false);
        avatarPath = "1.png";
        
    }    
    
    public Parent getFXML(){
        try{
            return FXMLLoader.load(getClass().getResource(FXMLPATH));
        }catch (Exception ex){
            Logger.getLogger(AllInPoker.class.getName()).log(Level.SEVERE, null, ex);  
        }
        return null;
    }
    
    @FXML
    private boolean checkUsername(){
        username = tfUsername.getText();
        
        lblUsernameStatus.setVisible(true);

        //check username agaisnt those used
        //if successful
        if(!username.equals("")){
            lblUsernameStatus.setStyle("-fx-text-fill: #00D800");
            lblUsernameStatus.setText("Username is Available");
            return true;
        }
        else{
            lblUsernameStatus.setStyle("-fx-text-fill: #E50000");
            lblUsernameStatus.setText("Username is Invalid");
        }
        return false;
    }
    
    @FXML
    private void connectToLobby(){
        //if connection made
        if(checkUsername()){ 
            //if connection
            try{
               
                    createSelf();
                    Stage stage = (Stage) lblUsernameStatus.getScene().getWindow();
                    //try to connect
                    //change to lobby scene
                    LobbyController lobby = new LobbyController();
                    stage.setScene(new Scene(lobby.getFXML()));
                

            }catch (Exception ex){
                Logger.getLogger(AllInPoker.class.getName()).log(Level.SEVERE, null, ex);  
            }
            //else connection
            lblConnectionStatus.setVisible(true);
            lblConnectionStatus.setStyle("-fx-text-fill: #E50000");
            lblConnectionStatus.setText("Unable to Conenct");
        }
        
        
        
    }
    
    @FXML
    private void startOfflineGame(){
        if (checkUsername()){
            createSelf();
            try{
                Stage stage = (Stage) lblUsernameStatus.getScene().getWindow();
                GameScreenController gameScreen = new GameScreenController();
                gameScreen.setReturn(false);
                GameScreenController.setTable(new Table(1, "Random Name", true));
                stage.setScene(new Scene(gameScreen.getFXML()));
            }catch (Exception ex){
                Logger.getLogger(AllInPoker.class.getName()).log(Level.SEVERE, null, ex);  
           }
        }
    }
    
    @FXML
    private void openSettings(){
        
    }
    
    @FXML
    private void exitGame(){
    
        
    }
    
    private void createSelf(){
        self = new Player(tfUsername.getText(), avatarPath);
    }
    
    
}
