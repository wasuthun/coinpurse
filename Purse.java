package computer.PurseTest;



import java.util.ArrayList;

import java.util.Collections;

import java.util.List;



/**

 * A coin purse contains coins. You can insert coins, withdraw money, check the

 * balance, and check if the purse is full. When you withdraw money, the coin

 * purse decides which coins to remove.

 * 

 * @author Wasuthun Wanaphongthipakorn

 *

 */

public class Purse {

	// Selection of objects in the purse.

	private List<Coin> money;

	/**

	 * Capacity is maximum number of coin the purse can contain. Capacity is set

	 * when the purse is builded and cannot be adjusted.

	 */

	private int capacity;



	/**

	 * Create an empty purse with a given capacity.

	 * 

	 * @param capacity

	 *            is the maximum number of coins that purse can contain

	 */

	public Purse(int capacity) {

		this.capacity = capacity;

		this.money = new ArrayList<>();

	}



	/**

	 * Count and return the amount of coins in the purse. This is the amount of

	 * coin, not their value.

	 * 

	 * @return the amount of coins in the Purse

	 */

	public int count() {

		return money.size();

	}



	/**

	 * Get the total value of all coins in the purse.

	 * 

	 * @return the total value of coins in the purse.

	 */



	public double getBalance() {

		double balance = 0;

		for (Coin c : this.money) {

			balance += c.getValue();

		}

		return balance;

	}



	/**

	 * Return the capacity of the coin purse.

	 * 

	 * @return the capacity

	 */

	public int getCapacity() {

		return capacity;

	}



	/**

	 * Test if the purse is full. The purse is full if amount of coins in

	 * purse equals or greater than the purse capacity.

	 * 

	 * @return true if purse is full, false otherwise

	 */

	public boolean isFull() {

		return money.size() >= capacity;

	}



	/**

	 * Insert a coin into the purse. The coin is only added if the purse has

	 * space for it and the coin has positive value. No worthless coins!

	 * 

	 * @param coin

	 *            is a Coin object to insert into purse

	 * @return true if coin inserted, false if can't insert

	 */

	public boolean insert(Coin coin) {

		if (coin.getValue() <= 0)

			return false;

		if (!isFull()) {

			this.money.add(coin);

			Collections.sort(this.money);

			return true;

		}

		return false;

	}



	/**

	 * Withdraw the requested amount of money. Return an array of Coins

	 * withdrawn from purse, or return null if cannot withdraw the amount

	 * requested.

	 * 

	 * @param amount

	 *            is the amount to withdraw

	 * @return array of Coin objects for money withdrawn, or null if cannot

	 *         withdraw requested amount.

	 */

	public Coin[] withdraw(double amount) {

		List<Coin> templist = new ArrayList<>();

		for (int i = this.money.size() - 1; i >= 0; i--) {

			Coin c = this.money.get(i);

			if (c.getValue() <= amount) {

				amount = amount - c.getValue();

				templist.add(c);

			}

		}

		if (amount == 0) {

			for (Coin tempc : templist) {

				this.money.remove(tempc);

			}

			Coin[] withdraw = new Coin[templist.size()];

			templist.toArray(withdraw);

			return withdraw;

		}

		return null;

	}



	

	 // Return a string description of the purse contents.

	 

	@Override

	public String toString() {

		return this.money.size() + " coins with value " + this.getBalance();

	}



}