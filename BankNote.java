package computer.PurseTest;

public class BankNote implements Valuable
{
	private double value;
	private String currency;
	private long serialNumber;
	private static long nextserialNumber = 1000000;
	private static String nextcurrency="Bath";
	public BankNote(double value){
		this.value=value;
		this.currency=nextcurrency;
		this.serialNumber=nextserialNumber++;
		
	}

	public BankNote(double value, String currency)
	{
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextserialNumber;
	}

	@Override
	public String getCurrency()
	{

		return this.currency;
	}

	@Override
	public double getValue()
	{

		return this.value;
	}

	public long getSerial()
	{
		return this.serialNumber;
	}

	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		if (!obj.getClass().equals(this.getClass()))
		{
			return false;
		}
		BankNote other = (BankNote) obj;
		return ((other.getCurrency().equals(this.getCurrency())) && (other.getValue() == this.getValue()));
	}
public String toString(){
	return this.value+"-"+this.currency+" note ["+this.serialNumber+"]";
}

@Override
public int compareTo(Valuable p){
	return (int)Math.signum(this.value-p.getValue());
}
	
}
