package com.skilldistillery.cards.blackjack;

import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Hand;

public class BlackjackHand extends Hand {
	
	public BlackjackHand() {
		
	}
	
	public List<Card> getCards() {
		return this.cards;
	}
	
	public int getCardsSize() {
		return this.cards.size();
	}
	
	public int getHandValue() {
		int total = 0;
		
		for (Card card : cards) {
			total += card.getValue();
		}
		return total;
	}
	
	public boolean isBlackJack() {
		int total = getHandValue();

		Boolean isTotalTwentyOne = false;
		
		if (total == 21) {
		isTotalTwentyOne = true;
		}
		
		return isTotalTwentyOne;
	}
	
	public boolean isBust() {
		int total = getHandValue();

		Boolean overTwentyOne = false;
		
		if (total > 21) {
			overTwentyOne = true;
		}
		
		return overTwentyOne;
		
	}
	


	

}
