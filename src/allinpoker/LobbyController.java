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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Kaleyta
 */
public class LobbyController implements Initializable {

    @FXML
    private Label lobbyHeader;
    @FXML
    private TableView<Table> tvTable;
    @FXML 
    private TableColumn<Table, Integer> cID;
    @FXML 
    private TableColumn<Table, String> cName, cSeats;
 
    private final String FXMLPATH = "Lobby.fxml";
    ObservableList<Table> tableList = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cID.setCellValueFactory(new PropertyValueFactory<>("tableID"));
        cName.setCellValueFactory(new PropertyValueFactory<>("tableName"));
        cSeats.setCellValueFactory(new PropertyValueFactory<>("seats"));
        
        loadTables();
    }    
    
    public Parent getFXML(){
        try{
            return FXMLLoader.load(getClass().getResource(FXMLPATH));
        }catch (Exception ex){
            Logger.getLogger(AllInPoker.class.getName()).log(Level.SEVERE, null, ex);  
        }
        return null;
    }
    
    private void loadTables(){
    	tableList = getTables();
    	tvTable.setItems(tableList);
    }

    @FXML
    private void backtoStart(){
        try{
            Stage stage = (Stage) lobbyHeader.getScene().getWindow();
            StartScreenController startScreen = new StartScreenController();
            stage.setScene(new Scene(startScreen.getFXML()));
        }catch (Exception ex){
            Logger.getLogger(AllInPoker.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    
    @FXML
    private void createOnlineGame(){
        
        try{
            Stage stage = (Stage) lobbyHeader.getScene().getWindow();
            GameScreenController gameScreen = new GameScreenController();
            gameScreen.setReturn(true);
            GameScreenController.setTable(new Table(1, "Random Name", true));
            stage.setScene(new Scene(gameScreen.getFXML()));
        }catch (Exception ex){
            Logger.getLogger(AllInPoker.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    
    @FXML
    private void refresh(){
        loadTables();
    }

    @FXML
    private void joinGame(){
        Table table = tvTable.getSelectionModel().getSelectedItem();
    
        if(table != null){
            System.out.println(table.getTableName());
            try{
                Stage stage = (Stage) lobbyHeader.getScene().getWindow();
                GameScreenController gameScreen = new GameScreenController();
                gameScreen.setReturn(true);
                stage.setScene(new Scene(gameScreen.getFXML()));
            }catch (Exception ex){
                Logger.getLogger(AllInPoker.class.getName()).log(Level.SEVERE, null, ex);  
            }
        }
        
        
    }
    
    private void loadAvatars(){
        
    }
    
    
    private ObservableList<Table> getTables(){
    	
    	//load from existing data structure, this just serves as demo
        ObservableList<Table> tables = FXCollections.observableArrayList();
        tables.add(new Table(1,"SOME", false));
        tables.add(new Table(2,"Random", false));
        tables.add(new Table(3,"SHIT", false));
        tables.add(new Table(4,"TESTING", false));
        
        return tables;
    }

}
