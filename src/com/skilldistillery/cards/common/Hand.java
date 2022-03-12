package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand  {
	protected List<Card> cards = new ArrayList<>();
	
	public Hand() {	
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
		
		for (Card card : cards) {
			sb.append(card);
			if (cards.get(cards.size()-1) != card) {
			sb.append("  |  ");
			}
		}
		
		return sb.toString();
	}
}
