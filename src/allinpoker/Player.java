package allinpoker;

public class Player {
	private int chips;
	private String username, avatarPath;
	private Hand hand;
	private final int STARTINGAMOUNT = 500;
        private boolean in, sittingOut;
       
	
	//Player constructor
	public Player(String username, String avatarPath) {
		this.username = username;
		this.avatarPath = avatarPath;
                chips = STARTINGAMOUNT;
                in = false;
                sittingOut = false;
	}
	
	public void setChips(int chips) {
		this.chips = chips;
	}
	
	public int getChips() {
		return chips;
	}
	
	public void setHand(Hand hand) { 
		this.hand = hand;
	}
	
	public Hand getHand() {
		return hand;
	}
        
        public String getName(){
            return username;
        }
        public void setName(String username){
            this.username = username;
        }
        
        public String getAvatar(){
            return avatarPath;
        }
        
        public void setAvatar(String avatarPath){
            this.avatarPath = avatarPath;
        }
        
        public boolean getIn(){
            return in;
        }
        
        public void setIn(boolean in){
            this.in = in;
        }
        
        public boolean getSittingOut(){
            return sittingOut;
        }
        
        public void setsittingIn(boolean sittingOut){
            this.sittingOut = sittingOut;
        }
        
        public void raise(int amount){
            chips -= amount;
            
        }
}
