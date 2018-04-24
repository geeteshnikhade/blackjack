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

	}

}
