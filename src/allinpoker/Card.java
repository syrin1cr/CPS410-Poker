package allinpoker;

import javafx.scene.image.Image;



public class Card {
	private int suit;	/* 1 is Spade
	 			 * 2 is Clubs
	 			 * 3 is Diamonds
	 			 * 4 is Hearts
	 			 */
	private int value; /* 1 is Ace
				* 2-10 are respective values
				* 11 is Jack
				* 12 is Queen
				* 13 is King
				*/
	private Image cardImage;
	
	public Card(int suit, int value){
		this.suit = suit;
		this.value = value;
		findCardImage();
	}
	
	public int getSuit() {
		return suit;
	}
	public void setSuit(int suit) {
		this.suit = suit;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Image getCardImage() {
		return cardImage;
	}
	private void findCardImage() {
            String path;
            path = "/res/" + (this.suit * this.value) + ".png";
            cardImage = new Image(path);
	}
	
}
