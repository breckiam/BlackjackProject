package com.skilldistillery.cards.common;

import java.util.Objects;

public class Card {
	private Suit suit;
	private Rank rank;

	public Card(Suit suit, Rank rank) {
		this.rank = rank;
		this.suit = suit;
	}

	public String toString() {
		String rankInt = "";
		for (int i = 0; i < Rank.values().length; i++) {
			if (i <= 8) {
				rankInt =  this.rank.getValue() + "";
			} else if (i == 9) {
				rankInt =  this.rank.getValue() + "" ;
				
			} else if (this.rank == Rank.ACE) {
				rankInt = "A" + "";
			} else if (this.rank == Rank.QUEEN) {
				rankInt = "Q" + "";
			} else if (this.rank == Rank.KING) {
				rankInt = "K" + "";
			} else if (this.rank == Rank.JACK) {
				rankInt = "J"+ "";
			}
		}
		if (this.rank == Rank.TEN) {
			return rankInt + suit;
			
		} else {
			return rankInt + suit + " ";
		}
	}

	public int getValue() {
		return this.rank.getValue();
	}
	
	public char getName() {
		return suit.getName();
	}

	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return rank == other.rank && suit == other.suit;
	}

}
