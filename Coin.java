 package computer.PurseTest;


/**
 * a coin with a monetary value and currency
 * 
 * @author Wasuthun wanaphongthipakorn
 */

public class Coin implements Comparable<Coin>
{
	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	private double value;
	/** The currency, of course. */
	private String currency;

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 *            is the value of coin
	 * @param currency
	 *            is constant
	 */
	public Coin(double value)
	{
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
	}

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 *            is the value of coin
	 * @param currency
	 *            is the currency of coin
	 */
	public Coin(double value, String currency)
	{
		this.value = value;
		this.currency = currency;
	}

	/**

	 * Return the currency of this coin.

	 * 

	 * @return this coin {@code currency}

	 */
	public double getValue()
	{
		return this.value;
	}

/*
 * Return the currency of this coin.
 * 
 * @return currency of this coin */
	public String getCurrency()
	{
		return this.currency;
	}

	/**

	 * Test whether two coins has the same value and  currency.

	 * 

	 * @param obj

	 *            is the coin to compare

	 * @return true if it has same value and currency, false

	 *         otherwise

	 */
	public boolean equals(Object obj)
	{

		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Coin other = (Coin) obj;
		return other.getValue()==this.value;

	}
	/**

	 * Compare this coin with another coin. Return -1 if this coin has less

	 * value than the comparing coin, 0 if it is equal, and 1 if this coin has a

	 * greater value.

	 * 

	 * @param p

	 *            is the Coin object to compare

	 * @return 1 if this coin has greater value<br>

	 *         0 if both have same value<br>

	 *         -1 if this coin has lesser value

	 */
public int compareTo(Coin p){
	return (int)Math.signum(this.value-p.value);
}
 /*
  * Return a String describe the coin value curreny
  * 
  * @return string that describes the coin
  * */
	public String toString()
	{
		return this.value+" "+this.currency;
	}

	

		
		

	
}

