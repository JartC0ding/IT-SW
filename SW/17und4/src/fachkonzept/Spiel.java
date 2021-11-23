package fachkonzept;

public class Spiel 
{
	private int punktesumme;
	
	public Spiel()
	{
		this.punktesumme = 0;
	}
	
	public boolean hatVerloren()
	{
		return this.punktesumme > 21;
	}
	
	public int liesPunktesumme()
	{
		return this.punktesumme;
	}

	public int zieheKarte()
	{
		Karte k = new Karte();
		int wert = k.liesWert();
		this.punktesumme += wert;
		return wert;
	}
}
