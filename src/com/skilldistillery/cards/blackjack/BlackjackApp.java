package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

public class BlackjackApp {
	private Scanner kb = new Scanner(System.in);
	private Dealer dealer = new Dealer();
	private Player p1 = new Player();
	private int bet = 0;

	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		app.start();
		app.exitMessage();

		app.kb.close();
	}

	private void start() {
		dealer.getDeck().shuffleDeck();
		boolean keepGoing = true;
		// TEST to show cards in deck and deck size
//		System.out.println(dealer.getDeck().getCardsFromDeck());
//		System.out.println("Deck size: " + dealer.getDeck().getCardsFromDeck().size());

		while (keepGoing && p1.getBalance() > 0) {
			p1.getHand().clear();
			dealer.getHand().clear();
			dealer.getHiddenHand().clear();
			bet = 0;

			while (keepGoing && bet == 0) {
				System.out.println();
				System.out.println("---------------NEW GAME---------------");
				System.out.println();
				System.out.println("Balance: $" + p1.getBalance());
				System.out.println("How much would you like to bet? (Enter \"quit\" to quit)");
				System.out.println("Bet amount: ");
				String choice = kb.next();

				if (choice.equalsIgnoreCase("quit")) {
					System.out.println("Goodbye :)");
					return;
				}
				try {
					bet = Integer.parseInt(choice);
					if (bet > p1.getBalance()) {
						throw new NumberFormatException();
					}

				} catch (NumberFormatException e) {
					System.err.println("Must enter numer, that number must be <= your blance");
				}
				kb.nextLine();
			}

			p1.setBalance((p1.getBalance() - bet));

			for (int i = 0; i < 2; i++) {
				p1.addToHand(dealer.getDeck().dealCard());
				dealer.addToHand(dealer.getDeck().dealCard());
			}

			dealer.addToHiddenHand(dealer.getCard());

			playerCards();
			hiddenDealerCards();

			if (eitherBlackJackOrBust()) {
				continue;
			}

			if (playerHitOrStay()) {
				continue;
			}

			while (dealer.getHand().getHandValue() < 17) {
				dealer.addToHand(dealer.getDeck().dealCard());
				if (eitherBlackJackOrBust()) {
					continue;
				}
			}

			playerCards();
			dealerCards();

			if (p1.getHand().getHandValue() > dealer.getHand().getHandValue()) {
				System.out.println("You WON! $" + bet);
				p1.setBalance((p1.getBalance() + (bet * 2)));
			} else if (p1.getHand().getHandValue() == dealer.getHand().getHandValue()) {
				p1.setBalance((p1.getBalance() + bet));
				System.out.println("Tied, orignial bet still retained");
			} else {
				System.out.println("Dealer Won, you lost $" + bet);
			}

		}
		

	}
	

	private boolean eitherBlackJackOrBust() {

		BlackjackHand playerHand = p1.getHand();
		BlackjackHand dealerHand = dealer.getHand();
		Boolean blackJack = false;

		if (p1.getHand().isBlackJack() || dealer.getHand().isBust()) {
			playerCards();
			dealerCards();
			if (p1.getHand().isBlackJack()) {
				System.out.println("BlackJack!");
			} else {
				System.out.println("Dealer BUSTED!");
			}
			System.out.println("You won + $" + bet);
			p1.setBalance((p1.getBalance() + (bet * 2)));
			blackJack = true;
		} else if (dealerHand.isBlackJack() || playerHand.isBust()) {
			dealerCards();
			if (dealerHand.isBlackJack()) {
				System.out.println("Dealer BlackJack!");
			} else {
				System.out.println("You BUSTED! " + p1.getHand().getHandValue());
			}
			System.out.println("Dealer won, you lost $" + bet);
			blackJack = true;
		}

		return blackJack;
	}

	private void playerCards() {
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
		System.out.println("Dealer cards: ");
		for (int i = 0; i < (dealer.getHand().getCards().size() - 1); i++) {

			if (i == 0) {
				System.out.print(dealer.getHiddenHand());
			}
			System.out.print(" 🂠 ");
			if (i == (dealer.getHand().getCards().size() - 2)) {
				System.out.print(" + " + (i + 1) + " hidden card");
			}

		}
		System.out.println();
		System.out.println("Dealer card total: " + dealer.getHand().getFirstCardValue());
		System.out.println();
	}

	private boolean playerHitOrStay() {
		boolean keepGoing = false;

		while (!keepGoing) {
			System.out.println("Hit or stay?");
			String choice = kb.next().toLowerCase();

			switch (choice) {
			case "hit":
				p1.addToHand(dealer.getDeck().dealCard());
				playerCards();
				keepGoing = eitherBlackJackOrBust();
				break;
			case "stay":
				return keepGoing;
			default:
				System.out.println("Please enter Hit or Stay... not " + choice);
			}
		}

		return keepGoing;

	}

	private void exitMessage() {
		System.out.println("Thanks for plaing with us!");
		if (p1.getBalance() == 0) {
			System.out.println("So sorry you lost all of your money :(");
		} else if (p1.getBalance() > 2500) {
			System.out.println("Nice you left with $" + (p1.getBalance() - 2500) + " extra!");
			System.out.println("Congrats!! See you next time :)");
		}else {
			System.out.println("Eh, at least you still walked away with $" +p1.getBalance());
		}
		
	}
}
