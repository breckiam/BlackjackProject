package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.blackjack.Dealer;
import com.skilldistillery.cards.blackjack.Player;

public abstract class Hand {
	protected List<Card> cards;

	public Hand() {
		this.cards = new ArrayList<>();
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public void clear() {
		cards.clear();
	}

	public abstract int getHandValue();

	public String toString() {
		StringBuilder sb = new StringBuilder();
//		if (cards.equals(Player.class)) {
			for (Card card : cards) {
				sb.append(card);
				if (cards.get(cards.size() - 1) != card) {
					sb.append("  |  ");
				}
			}
//		} 
//		else if (cards.equals(Dealer.class)) {
//			sb.append(cards.get(0).toString());
//		}
		
		return sb.toString();

	}
}
