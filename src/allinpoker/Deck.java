package allinpoker;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

public class Deck {
	List<Card> cards = new LinkedList<Card>();
	//Card[] cards = new Card[52];
	int topCard;
	
	public Deck () {
		for(int x=1; x<5; x++)
                    for(int y=1; y<14; y++)
                    cards.add(new Card(x,y));
                shuffle();
	}
	
	public void shuffle() {
		this.topCard = 0;
		Collections.shuffle(cards);
	}
	
	public Card nextCard() {
		int currentInd = topCard;
		this.topCard++;
		return cards.get(currentInd);
	}
}
