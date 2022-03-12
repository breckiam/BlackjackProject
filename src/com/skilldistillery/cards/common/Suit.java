package com.skilldistillery.cards.common;

public enum Suit {
	SPADES('\u2660'), HEARTS('\u2661') , DIAMONDS('\u2662'), CLUBS('\u2663');
	
	private char name;

	Suit(char name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name + "";
	}
	
	public char getName() {
		return name;
	}
	
}
