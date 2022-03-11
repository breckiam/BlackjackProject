package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Hand;

public class BlackjackHand extends Hand {
	
	public BlackjackHand() {
		
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
