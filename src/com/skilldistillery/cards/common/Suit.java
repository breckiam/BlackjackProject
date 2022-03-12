package com.skilldistillery.cards.common;

public enum Suit {
	SPADES("Spades"), HEARTS("Hearts") , DIAMONDS("Diamonds"), CLUBS("clubs");
	
	private String name;

	Suit(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	public String getName() {
		return name;
	}
	
}
