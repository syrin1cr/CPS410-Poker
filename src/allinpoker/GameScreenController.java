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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kaleyta
 */

public class GameScreenController implements Initializable {

    @FXML
    private TextField tfChatInput, tfRaiseAmount;
    @FXML
    private TextArea taChatBox;
    @FXML
    private VBox p1, p2, p3, p4, p5, p6, p7, p8;
    @FXML
    private AnchorPane c1, c2, c3, c4, c5, c6,c7, c8;
    
    
    private final String FXMLPATH = "GameScreen.fxml";
    
    private static boolean dest = false;
    private static Table table;
    
    private Label tempLabel;
    private ImageView tempImage;
    private String tempName, tempAvatarPath, tempCards;
    private int tempChips;
    private boolean tempIn;
    private Card tempC1, tempC2;
    
    private ObservableList<VBox> playerUI = FXCollections.observableArrayList();
    private ObservableList<AnchorPane> playerCards = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tfRaiseAmount.textProperty().addListener((observable, oldString, newString) -> 
        {
            if(!newString.matches("[0-9]*")){
                tfRaiseAmount.setText(oldString);
            }
        });
        
       playerUI.addAll(p1, p2, p3, p4, p5, p6, p7, p8);
       playerCards.addAll(c1, c2, c3, c4, c5, c6, c7, c8); 
        updatePlayers();
            
    }  
    
    //Returns Parent with desired FXML path
    public Parent getFXML(){
        try{
            return FXMLLoader.load(getClass().getResource(FXMLPATH));
        }catch (Exception ex){
            Logger.getLogger(AllInPoker.class.getName()).log(Level.SEVERE, null, ex);  
        }
        return null;
    }
    
    //Action Handler called by btnSitOut
    @FXML
    private void sitOut(){
        
    }
    
    //Action Handler called by btnLeaveTable
    @FXML
    private void leaveTable(){
        //prompt if user is sure they wish to leave
        
        try{
            Stage stage = (Stage)tfChatInput.getScene().getWindow();
            if(dest){
                LobbyController lobby = new LobbyController();
                stage.setScene(new Scene(lobby.getFXML()));
            }
            //else
            else{
                StartScreenController startScreen = new StartScreenController();
                stage.setScene(new Scene(startScreen.getFXML()));
            }
                
        }catch (Exception ex){
            Logger.getLogger(AllInPoker.class.getName()).log(Level.SEVERE, null, ex);  
        }
        
    }
    
    
    //Action Handler called by btnFold
    @FXML
    private void fold(){
        
    }
    
    //Action Handler called by btnRaise
    @FXML
    private void raise(){
        int amount;
        if(!(tfRaiseAmount.getText().isEmpty())){
            amount = Integer.parseInt(tfRaiseAmount.getText()) + table.getBet();
            if(amount < StartScreenController.self.getChips())
                StartScreenController.self.raise(amount);
        }
        tfRaiseAmount.setText("");
    }
    
    //Action Handler called by btnCheck 
    @FXML
    private void check(){
        //end turn
    }
    
    //Action Handler called by btnCall
    @FXML
    private void call(){
        //player bet = table.getBet()
        //end turn
    }
    
    //Action Handler for tfChatInput
    @FXML
    private void sendMessage(){
        
        if(!(tfChatInput.getText().isEmpty())){
            //send message
            System.out.println(tfChatInput.getText());
        }
        tfChatInput.setText("");
    }
   
    private void addCard(int card, int place){
        
    }
    
    //Loads all players who are at the table
    private void updatePlayers(){
        tempName = "";
        tempChips = 0;
        tempAvatarPath = "";
        tempIn = false;
        for(int x=0; x<table.getPlayerCount(); x++){
            if(table.getPlayers().get(x) != null){
                tempName = table.getPlayers().get(x).getName();
                tempChips = table.getPlayers().get(x).getChips();
                tempAvatarPath = table.getPlayers().get(x).getAvatar();
                tempIn = table.getPlayers().get(x).getIn();
                
                playerUI.get(x).getChildren().forEach((Node n) -> {
                   if(n != null){
                    if(n.getStyleClass().contains("pName")){
                        tempLabel = (Label) n;
                        tempLabel.setText(tempName);
                    }
                    else if(n.getStyleClass().contains("pChips")){
                        tempLabel = (Label) n;
                        tempLabel.setText("$"+tempChips);
                    }
                    else if(n.getStyleClass().contains("pAvatar")){
                        try{
                            tempImage = (ImageView) n;
                            tempImage.setImage(new Image(tempAvatarPath));
                        }catch(Exception ex){
                            Logger.getLogger(AllInPoker.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                   }
               });   
          }   
        } 
        updateCardStatus();
    }
    
    private void updateCardStatus(){
        
        //if(hand isnt over)
         for(int x=0; x<table.getPlayerCount(); x++){
            if(table.getPlayers().get(x) != null){
               tempC1= table.getPlayers().get(x).getHand().getCards()[0];
               tempC2= table.getPlayers().get(x).getHand().getCards()[1];
              
                playerCards.get(x).getChildren().forEach((Node n) -> {
                    if(n.getStyleClass().contains("card1")){
                        tempImage = (ImageView) n;
                        tempImage.setImage(tempC1.getCardImage());
                    }
                    else if(n.getStyleClass().contains("card2")){
                        tempImage = (ImageView) n;
                        tempImage.setImage(tempC2.getCardImage());
                        
                    }
                });
            }
        }
    }
        
    
    //determine player's avaialble actions and show them accordingly
    private void updateButtons(){
        //if not players turn make buttons invisible
        //else if table.getBet() > 0 if so show call button
        // else show check button
    }
    
    
    
    public void setReturn(boolean dest){
        GameScreenController.dest = dest;
    }
    
    public static void setTable(Table table){
        GameScreenController.table = table;
    }

    
}
