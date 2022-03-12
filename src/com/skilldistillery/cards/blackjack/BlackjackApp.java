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
		hiddenDealerCards();

		if (eitherBlackJackOrBust(p1)) {
			return;
		}

		if (playerHitOrStay(p1)) {
			return;
		}
		
		while (dealer.getHand().getHandValue() < 17) {
			dealer.addToHand(deck.dealCard());
			if (eitherBlackJackOrBust(p1)) {
				return;
			}
		}
		
		playerCards(p1);
		dealerCards();
		
		if (p1.getHand().getHandValue() > dealer.getHand().getHandValue() ) {
			System.out.println("You WON!");
		} else {
			System.out.println("Dealer Won.");
		}

	}

	private boolean eitherBlackJackOrBust(Player p1) {

		BlackjackHand playerHand = p1.getHand();
		BlackjackHand dealerHand = dealer.getHand();
		Boolean blackJack = false;

		if (playerHand.isBlackJack() || dealerHand.isBust()) {
			if (p1.getHand().isBlackJack()) {
				System.out.println("BlackJack!");
			} else {
				System.out.println("Dealer BUSTED!");
			}
			System.out.println("You won");
			blackJack = true;
		} else if (dealerHand.isBlackJack() || playerHand.isBust()) {
			if(dealerHand.isBlackJack()) {
				System.out.println("Dealer BlackJack!");
			} else {
				System.out.println("You BUSTED! " + p1.getHand().getHandValue());
			}
			System.out.println("Dealer won");
			blackJack = true;
		}

		return blackJack;
	}

	private void playerCards(Player p1) {
		System.out.println("Your cards: ");
		System.out.println(p1.getHand());
		System.out.println("Card total: " + p1.getHand().getHandValue());
		System.out.println();
	}

	private void dealerCards() {
		System.out.println("Dealer cards: ");
		System.out.print(dealer.getHand());
		System.out.println("Dealer card total: " + dealer.getHand().getHandValue());
		System.out.println();
	}
	
	private void hiddenDealerCards() {
		System.out.print("Dealer cards: ");
		for (int i = 0; i < dealer.getHand().getCards().size(); i++) {
			if (i == 0) {
				System.out.print(dealer.getCard());
			}
			
			System.out.print(" 🂠 ");
		}
		System.out.println();
		System.out.println("Dealer card total: " + dealer.getHand().getFirstCardValue());
		System.out.println();
	}

	private boolean playerHitOrStay(Player p1) {
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
				return keepGoing;
			default:
				System.out.println("Please enter Hit or Stay... not " + choice);
			}
		}

		return keepGoing;

	}

}
