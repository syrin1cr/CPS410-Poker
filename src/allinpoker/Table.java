package allinpoker;

import java.util.LinkedList;
import java.util.List;

public class Table {

    private final int tableID;
    private int AICount, playerCount, currentBet, currentPot;
    private String tableName;
    private boolean status;
    private List<Player> players = new LinkedList<>();
    private Deck deck;
	
	
    public Table(int tableID, String tableName, boolean offline) {
        this.tableID = tableID;
	this.tableName = tableName;
        currentBet=0;
        currentPot=0;
		
        if(offline){
        //add ai
            addPlayer(StartScreenController.self);
            addPlayer(new Player("Jeff","1.png"));
            addPlayer(new Player("Greg", "4.png"));
            addPlayer(new Player("Bob","5.png"));
            
            deal();
        }
        else{
             //add info from lobby
                }
	}
	
	public void addPlayer(Player player) {
		this.players.add(player);
		playerCount++;
	}
	
	public void removePlayer(Player player) {
		this.players.remove(player);
		playerCount--;
	}
	
	public void addAI() {
		//TODO
		AICount++;
	}
	
	public void removeAI() {
		//TODO
		AICount--;
	}
	
	public int getTableID () {
		return tableID;
	}
	
	public int getPlayerCount () {
		return playerCount;
	}
	
	public int getAICount () {
		return AICount;
	}
	
	public List<Player> getPlayers () {
		return this.players;
	}
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getSeats() {
		return playerCount + "/8";
	}
        
        public int getBet(){
            return currentBet;
        }
        
        public void setBet(int currentBet){
            this.currentBet = currentBet;
        }
        
        public int getPot(){
            return currentPot;
        }
        
        public void setPot(int currentPot){
            this.currentPot = currentPot;
        }
	
	public void deal(){
            deck = new Deck();
            
            for(Player p : players){
                p.setHand(new Hand(deck.nextCard(), deck.nextCard()));
            }
            
        }
}
