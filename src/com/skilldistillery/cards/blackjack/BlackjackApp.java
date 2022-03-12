package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;

public class BlackjackApp {
	private Scanner kb = new Scanner(System.in);
	private Deck deck = new Deck();
	private Dealer dealer = new Dealer();

	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		app.start();

		app.kb.close();
	}

	private void start() {
		Player p1 = new Player();
		deck.shuffleDeck();

		for (int i = 0; i < 2; i++) {
			p1.addToHand(deck.dealCard());
			dealer.addToHand(deck.dealCard());
		}

		playerCards(p1);
		dealerCards();

		if (eitherBlackJackOrBust(p1)) {
			if (p1.getHand().getHandValue() > 21) {
				System.out.println("BUSTED! " + p1.getHand().getHandValue());
				return;
			} else {
				System.out.println("BLACKJACK!");
				return;
			}
		}

		playerHitOrStay(p1);

	}

	private boolean eitherBlackJackOrBust(Player p1) {

		BlackjackHand playerHand = p1.getHand();
		BlackjackHand dealerHand = dealer.getHand();
		Boolean blackJack = false;

		if (playerHand.isBlackJack() || dealerHand.isBust()) {
			System.out.println("You won");
			blackJack = true;
		} else if (dealerHand.isBlackJack() || playerHand.isBust()) {
			System.out.println("Dealer won");
			blackJack = true;
		}

		return blackJack;
	}

	private void playerCards(Player p1) {
		System.out.print("Your cards: ");
		System.out.println(p1.getHand());
		System.out.println("Card total: " + p1.getHand().getHandValue());
		System.out.println();
	}

	private void dealerCards() {
		System.out.print("Dealer cards: ");
		System.out.println(dealer.getHand());
		System.out.println("Dealer card total: " + dealer.getHand().getHandValue());
		System.out.println();
	}

	private void playerHitOrStay(Player p1) {
		boolean keepGoing = false;

		while (!keepGoing) {
			System.out.println("Hit or stay?");
			String choice = kb.next().toLowerCase();

			switch (choice) {
			case "hit":
				p1.addToHand(deck.dealCard());
				playerCards(p1);
				keepGoing = eitherBlackJackOrBust(p1);
				break;
			case "stay":
				return;
			default:
				System.out.println("Please enter Hit or Stay... not " + choice);
			}
		}

		if (p1.getHand().getHandValue() > 21) {
			System.out.println("BUSTED! " + p1.getHand().getHandValue());
		} else {
			System.out.println("BLACKJACK!");
		}

	}

}
