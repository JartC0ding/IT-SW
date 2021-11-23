package fachkonzept;

import java.util.concurrent.ThreadLocalRandom;

public class Karte 
{
	private int wert;
	
	public Karte()
	{
		this.wert = ThreadLocalRandom.current().nextInt(2, 12);
	}
	
	public int liesWert()
	{
		return this.wert;
	}
}
