package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deckOfCards;
	
	public Deck() {
		deckOfCards = new ArrayList<>();
		
		for(Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				deckOfCards.add(new Card(suit, rank));
			}
		}
	}
	
	public int deckSize() {
		return deckOfCards.size();
	}
	
	public Card removeCard() {
		return deckOfCards.remove(0);
	}
	
	public void shuffleDeck() {
		Collections.shuffle(deckOfCards);
	}
}
