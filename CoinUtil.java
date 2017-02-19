package computer.PurseTest;



import java.util.ArrayList;

import java.util.Collections;

import java.util.Comparator;

import java.util.HashMap;

import java.util.Iterator;

import java.util.List;

import java.util.Map;



/**

 * Some Coin utility methods for practice using Lists and Comparator.

 * 

 * @author Wasuthun Wanaphongthipakorn

 * 

 * 

 */

public class CoinUtil {

	/**

	 * Method that examines all the coins in a List and returns only the coins

	 * that have a currency that matches the parameter value.

	 * 

	 * @param list

	 *            is a List of Coin objects. This list is not adjusted.

	 * @param currency

	 *            is the currency we want. right not be null.

	 * @return a new List holding only the elements from list that have

	 *         the desired currency.

	 */

	public static List<Valuable> filterByCurrency(List<Valuable> list, String currency) {

		List<Valuable> filteredCoins = new ArrayList<>();

		for (Valuable c : list) {

			if (c.getCurrency().equals(currency)) {

				filteredCoins.add(c);

			}

		}

		return filteredCoins;

	}



	/**

	 * Method to sort a list of coins by currency. On return, the list (coins)

	 * which ordered by currency.

	 * 

	 * @param coin

	 *            is a List of Coin objects we want to sort.

	 */



	public static void sortByCurrency(List<Valuable> coin) {

		Collections.sort(coin, new Comparator<Valuable>() {

			@Override

			public int compare(Valuable p1, Valuable p2) {

				return p1.getCurrency().compareToIgnoreCase(p2.getCurrency());

			}

		});

	}



	/**

	 * Sum coins by currency and print the sum for each currency. Print one line

	 * for the sum of each currency.

	 * 

	 * @param coin

	 *            is the List of Coin objects to find the sum

	 */

	public static void sumByCurrency(List<Valuable> coin) {

		Map<String, Double> map = new HashMap<>();

		for (Valuable c : coin) {

			map.put(c.getCurrency(), map.getOrDefault(c.getCurrency(), 0.0) + c.getValue());

		}

		for (String currency : map.keySet()) {

			System.out.println(map.get(currency) + " " + currency);

		}



		// sortByCurrency(coins);

		// if (coins.isEmpty())

		// return;

		// String currentCurr = coins.get(0).getCurrency();

		// double sum = 0;

		// for (Coin c : coins) {

		// if ((!c.getCurrency().equals(currentCurr))) {

		// System.out.println(new Coin(sum, currentCurr));

		// sum = 0;

		// currentCurr = c.getCurrency();

		// }

		// sum += c.getValue();

		// }

		// System.out.println(new Coin(sum, currentCurr));

	}



	/**

	 * This method contains some code to test the above methods.

	 * 

	 * @param args
	 
	 */



	public static void main(String[] args) {

		String currency = "Rupee";

		System.out.println("Filter coin by currency of " + currency);

		List<Valuable> coin = makeInternationalCoins();

		int size = coin.size();

		System.out.print(" Input: ");

		printList(coin, " ");

		List<Valuable> rupees = filterByCurrency(coin, currency);

		System.out.print("Result: ");

		printList(rupees, " ");

		if (coin.size() != size)

			System.out.println("Error: you changed the original list.");



		System.out.println("\nSort coins by currency");

		coin = makeInternationalCoins();

		System.out.print(" Input: ");

		printList(coin, " ");

		sortByCurrency(coin);

		System.out.print("Result: ");

		printList(coin, " ");



		System.out.println("\nSum coin by currency");

		coin = makeInternationalCoins();

		System.out.print("coin= ");

		printList(coin, " ");

		sumByCurrency(coin);



	}



	// Make a list of coins containing different currencies.

	public static List<Valuable> makeInternationalCoins() {

		List<Valuable> money = new ArrayList<Valuable>();

		money.addAll(makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0));

		money.addAll(makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0));

		money.addAll(makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0));

		// randomize the elements

		Collections.shuffle(money);

		return money;

	}



	// Make a list of coins using given values.

	public static List<Valuable> makeCoins(String currency, double... values) {

		List<Valuable> list = new ArrayList<Valuable>();

		for (double value : values)

			list.add(new Coin(value, currency));

		return list;

	}



	// Print the list on the console, on one line.

	public static void printList(List items, String separator) {

		Iterator iter = items.iterator();

		while (iter.hasNext()) {

			System.out.print(iter.next());

			if (iter.hasNext())

				System.out.print(separator);



		}

		System.out.println(); // end the line

	}

}
