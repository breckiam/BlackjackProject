package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;


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
		String[] cardAscii = { "╔═══════╗ ", "║       ║ ", "║       ║ ", "║       ║ ", "║       ║ ", "║       ║ ",
				"╚═══════╝ " };

		for (int i = 0; i < cardAscii.length; i++) {
			for (int j = 0; j < cards.size(); j++) {
				if (i == 1) {
					cardAscii[i] = "║ " + cards.get(j) + "   ║ ";
				}
					else if (i == 3) {
					cardAscii[i] = "║   " + cards.get(j).getName() + "   ║ ";
				}
					else if (i == 5) {
					cardAscii[i] = "║    " + cards.get(j) + "║ ";
				}
				sb.append(cardAscii[i]);
				if (j == (cards.size() - 1)) {
					sb.append("\n");
				}
			}
		}
		

		return sb.toString();
	}


}
