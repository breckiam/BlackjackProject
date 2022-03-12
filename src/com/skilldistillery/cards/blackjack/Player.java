package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;

public class Player {
	private BlackjackHand hand;
	
	public Player() {
		this.hand = new BlackjackHand(); 
	}

	public BlackjackHand getHand() {
		return hand;
	}
	
	public void addToHand(Card card) {
		this.hand.addCard(card);
	}
	
	
}
