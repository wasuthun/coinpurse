package computer.PurseTest;

public class AbstractValuable implements Valuable
{ // announce attribute double value and String currency
	protected double value;
	protected String currency;

	/*
	 * constructer of AbstractValuable
	 * 
	 * @param value,currency
	 */
	public AbstractValuable(double value, String currency)
	{
		this.value = value;
		this.currency = currency;
	}

	/**
	 * 
	 * Compare two coin using other to compare.
	 * 
	 * 
	 * 
	 * @param other
	 * 
	 *            from user to compare.
	 * 
	 * @return Return result of comparison.
	 * 
	 */
	@Override
	public int compareTo(Valuable other)
	{
		if (other == null)
			return -1;
		if (this.currency.equalsIgnoreCase(other.getCurrency()))
		{
			return (int) Math.signum(this.value - other.getValue());
		}
		return this.currency.compareToIgnoreCase(other.getCurrency());
	}

	/**
	 * 
	 * Return this.currency of the coin.
	 * 
	 * 
	 * 
	 * @return this.currency of the coin.
	 * 
	 */
	@Override
	public String getCurrency()
	{

		return this.currency;
	}

	/**
	 * 
	 * Return this.value of the coin.
	 * 
	 * 
	 * 
	 * @return this.value of the coin.
	 * 
	 */
	@Override
	public double getValue()
	{
		return this.value;

	}

	/**
	 * 
	 * Method for check whether it is alike.
	 * 
	 * 
	 * 
	 * @param Object
	 * 
	 *            obj to check whether it is alike.
	 * 
	 */
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		if (obj.getClass() != this.getClass())
		{
			return false;
		}
		Valuable other = (Valuable) obj;
		return ((other.getValue() == this.value) && (other.getCurrency().equals(this.currency)));
	}

}
