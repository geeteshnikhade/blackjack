package com.casino.blackjack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class Deck {
	public static final String suit[] = new String[] { "Spade", "Diamonds", "Hearts", "Clubs" };
	public static final String card[] = new String[] { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack",
			"Queen", "King" };
	static Map<Integer, ArrayList<String>> cardDeck = new HashMap<Integer, ArrayList<String>>();

	public static Map<Integer, ArrayList<String>> initializeBlackJack() {

		ArrayList<String> cards = new ArrayList<String>();

		for (int i = 0; i < card.length; i++) {
			cards.add(card[i]);
		}

		cardDeck.put(0, cards);
		cardDeck.put(1, new ArrayList<>(cards));
		cardDeck.put(2, new ArrayList<>(cards));
		cardDeck.put(3, new ArrayList<>(cards));
		return cardDeck;
	}

	String[] selectCard() {
		if (cardDeck.isEmpty()) {
			initializeBlackJack();
		}
		// Random suit and card selection
		int randomNumber = new Random().nextInt(cardDeck.keySet().size());
		ArrayList<String> selectedCardDeck = cardDeck.get(randomNumber);
		String cardSelected = selectedCardDeck.get(new Random().nextInt(selectedCardDeck.size()));

		// check if updated in map
		selectedCardDeck.remove(cardSelected);
		if (selectedCardDeck.isEmpty()) {
			cardDeck.remove(randomNumber);
		}

		// Selected suit and card
		String[] randomSelectedCard = new String[2];
		randomSelectedCard[0] = suit[randomNumber];
		randomSelectedCard[1] = cardSelected;
		return randomSelectedCard;

	}

	int getCardValue(String card) {
		if (card.equals("King") || card.equals("Queen") || card.equals("Jack")) {
			return 10;
		}
		return Integer.parseInt(card);
	}

}
