package com.casino.blackjack;

import java.util.Scanner;

import com.casino.blackjack.Deck;
import com.casino.blackjack.Player;

class Game {
	int playerTotal = 0;
	int dealerTotal = 0;
	int dealFoldCard = 0;
	Player player;
	Deck deck;
	String[] foldedCard;

	public Game(Player player, Deck deck) {
		this.player = player;
		this.deck = deck;
	}

	// public static final String suit[] = new String[] { "Spade", "Diamonds",
	// "Hearts", "Clubs" };
	// public static final String card[] = new String[] { "A", "2", "3", "4", "5",
	// "6", "7", "8", "9", "10", "Jack",
	// "Queen", "King" };

	public void startGame(int betAmount) {
		playerTotal = 0;
		dealerTotal = 0;
		dealFoldCard = 0;
		foldedCard = null;
		String card[];
		Scanner sc = new Scanner(System.in);
		
		// Player 1st card
		if (player.checkBal()) {
			card = deck.selectCard();
			playerTotal += deck.getCardValue(card[1]);
			System.out.println("Your Card is : " + card[0] + " " + card[1]);
			// player.withdraw(1);
		}

		// Dealer folded card
		card = deck.selectCard();
		foldedCard = card;
		if (!foldedCard[1].equals("A"))
			dealFoldCard = deck.getCardValue(card[1]);
		System.out.println("Dealer withdrew a folded card");

		// Player 2nd card
		if (player.checkBal()) {
			card = deck.selectCard();
			playerTotal += deck.getCardValue(card[1]);
			System.out.println("Your Card is : " + card[0] + " " + card[1]);
			// player.withdraw(1);
		}

		// Dealer 2nd card
		card = deck.selectCard();
		if (!card[1].equals("A")) {
			dealerTotal += deck.getCardValue(card[1]);
			System.out.println("Dealer's card is : " + card[0] + " " + card[1]);
		} else {
			dealerTotal = 11;
			System.out.println("Dealer's card is : " + card[0] + " " + card[1]);
		}

		// Loop till Player stays
		// int playerChoice;
		while (true) {
			System.out.println("Press 1 to Hit and 2 to Stay");
			int choice = sc.nextInt();
			if (choice != 1 && choice != 2) {
				continue;
			}
			if (choice == 2)
				break;
			if (player.checkBal()) {
				card = deck.selectCard();
				playerTotal += deck.getCardValue(card[1]);
				System.out.println("Your Card is:" + card[0] + " " + card[1]);
				// player.withdraw(1);
				if (playerTotal > 21) {
					System.out.println("Player Busted, Dealer WINS!!");
					player.withdraw(betAmount);
					return;
				}
			}
		}

		// Open Dealers folded card
		System.out.println("Dealer's folded card is : " + foldedCard[0] + " " + foldedCard[1]);
		if (foldedCard[1].equals("A")) {
			if (dealerTotal + 11 > playerTotal) {
				dealerTotal += 11;
			} else {
				dealerTotal++;
			}
		} else {
			dealerTotal += dealFoldCard;
		}

		// Dealer busted, player won
		if (dealerTotal > 21) {
			System.out.println("Dealer Busted, You WIN!!");
			player.deposit(betAmount);
			return;

		}

		// Add cards for Dealer
		while (dealerTotal <= 17) {
			card = deck.selectCard();
			if (!card[1].equals("A")) {
				dealerTotal += deck.getCardValue(card[1]);
			} else {
				if (dealerTotal + 11 < 21) {
					dealerTotal += 11;
				} else {
					dealerTotal++;
				}
			}
			System.out.println("Dealer's card is : " + card[0] + " " + card[1]);
		}

		System.out.println("Dealer stays");

		// Dealer busted, player won
		if (dealerTotal > 21) {
			System.out.println("Dealer Busted, You WIN!!");
			player.deposit(betAmount);
			return;
		}

		// Player Won
		if (playerTotal > dealerTotal) {
			System.out.println("You WIN!!");
			player.deposit(betAmount);
			return;
		}

		// Dealer Won
		if (playerTotal < dealerTotal) {
			System.out.println("Dealer WINS!!");
			player.withdraw(betAmount);
			return;
		}

		// Draw
		if (playerTotal == dealerTotal) {
			System.out.println("Its a DRAW!!");
			return;
		}
	}

}
