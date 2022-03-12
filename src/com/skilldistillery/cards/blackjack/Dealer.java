package com.skilldistillery.cards.blackjack;


public class Dealer extends Player {
	private BlackjackHand hand;
	
	public Dealer() {
		hand = new BlackjackHand();
	}

	public BlackjackHand getHand() {
		return hand;
	}
	

	
}
