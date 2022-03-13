package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Dealer extends Player {
	private BlackjackHand hand = new BlackjackHand();
	private BlackjackHand hiddenHand = new BlackjackHand();
	private Deck deckOfCards = new Deck();
	
	public Dealer() {
		this.deckOfCards.addAnotherDeck(new Deck());
		this.deckOfCards.addAnotherDeck(new Deck());
	}

	public BlackjackHand getHand() {
		return hand;
	}
	
	public BlackjackHand getHiddenHand() {
		return hiddenHand;
	}
	
	public Deck getDeck() {
		return deckOfCards;
	}
	
	public Card getCard() {
		return hand.getCards().get(0);
	}
	
	public void addToHand(Card card) {
		this.hand.addCard(card);
	}
	
	public void addToHiddenHand(Card card) {
		this.hiddenHand.addCard(card);
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
