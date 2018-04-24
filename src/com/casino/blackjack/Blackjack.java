package com.casino.blackjack;

import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Player currentPlayer = new Player();
		Deck currentDeck = new Deck();
		Game newgame = new Game(currentPlayer, currentDeck);
		while (currentPlayer.checkBal()) {
			System.out.println("===============NEW GAME=====================");
			System.out.println("Your current Balane is : " + currentPlayer.balance);
			System.out.println("Do you want to play a new game\n1. Yes\n2. No\n");
			int choice = sc.nextInt();
			if (choice == 2) {
				break;
			}

			// Accept Bet
			// Loop till value not greater than $1
			int betAmount = 0;
			do {
				System.out.println("Enter the amount you want to Bet (Minimum $1) and less than your current Balance");
				betAmount = sc.nextInt();
			} while (betAmount < 1 || betAmount > currentPlayer.balance);

			newgame.startGame(betAmount);
		}
		System.out.println("It's sad to see you leave :(");
		sc.close();
	}

}
