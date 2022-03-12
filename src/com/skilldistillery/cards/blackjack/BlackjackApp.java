package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;

public class BlackjackApp {
	private Scanner kb = new Scanner(System.in);
	private Deck deck = new Deck();

	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		app.start();

		app.kb.close();
	}

	private void start() {
		Player p1 = new Player();
		Dealer dealer = new Dealer();
		deck.shuffleDeck();

		for (int i = 0; i < 2; i++) {
			p1.addToHand(deck.dealCard());
			dealer.addToHand(deck.dealCard());
		}
		
		System.out.println("Your cards: ");
		System.out.println(p1.getHand());
		
		if (eitherBlackJack(p1, dealer)) {
			return;
		} else if (eitherBust(p1, dealer)) {
			return;
		}
		

	}
	
	private boolean eitherBlackJack(Player p1, Dealer dealer) {
		
		BlackjackHand playerHand = p1.getHand();
		BlackjackHand dealerHand = dealer.getHand();
		Boolean blackJack = false;
		
		if (playerHand.isBlackJack()) {
			System.out.println("You won");
			blackJack =  true;
		} else if (dealerHand.isBlackJack()) {
			System.out.println("Dealer won");
		}
		
		return blackJack;
	}

	private boolean eitherBust(Player p1, Dealer dealer) {
		
		BlackjackHand playerHand = p1.getHand();
		BlackjackHand dealerHand = dealer.getHand();
		Boolean blackJack = false;
		
		if (playerHand.isBust()) {
			System.out.println("Dealer won");
			blackJack =  true;
		} else if (dealerHand.isBust()) {
			System.out.println("You won");
		}
		
		return blackJack;
	}
}
