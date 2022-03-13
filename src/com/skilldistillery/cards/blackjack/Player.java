package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;

public class Player {
	private BlackjackHand hand;
	private int balance;
	
	public Player() {
		this.hand = new BlackjackHand(); 
		this.balance = 2500;
	}
	

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}



	public BlackjackHand getHand() {
		return hand;
	}
	
	public void addToHand(Card card) {
		this.hand.addCard(card);
	}
	
	
}
