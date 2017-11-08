package allinpoker;

public class Hand {
	int rating;
	Card[] cards = new Card[2];
	
        Hand(Card card1, Card card2){
            cards[0] = card1;
            cards[1] = card2;
        }
        
        
        
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Card[] getCards() {
		return cards;
	}
	public void setCards(Card[] cards) {
		this.cards = cards;
	}

}
