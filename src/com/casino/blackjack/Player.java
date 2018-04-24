package com.casino.blackjack;

class Player {
	int balance = 0;

	public Player() {
		balance = 100;
	}

	public boolean withdraw(int amount) {
		if (checkBal(amount)) {
			balance = balance - amount;
			return true;
		}
		return false;
	}

	public void deposit(int amount) {
		balance = balance + amount;
	}

	public boolean checkBal() {
		if (balance > 0) {
			return true;
		}
		return false;
	}

	public boolean checkBal(int amount) {
		if (balance >= amount) {
			return true;
		}
		return false;
	};

}
