package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;

public class Dealer extends Player {
	private BlackjackHand hand = new BlackjackHand();
	
	public Dealer() {
		 
	}

	public BlackjackHand getHand() {
		return hand;
	}
	
	public void addToHand(Card card) {
		this.hand.addCard(card);
	}
	
//	public String toString() {
//		StringBuilder sb = new StringBuilder();
//		 
//			for (Card card : hand.getCards()) {
//				sb.append(card);
//				sb.append("  |  ");
//			}
//
//		return sb.toString();
//
//	}

	
}
