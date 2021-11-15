package fachkonzept;

public class Person
{
	private int gewicht;
	private double groesse;
	
	// Constructor
	public Person(int pGewicht, double pGroesse) 
	{
		this.gewicht = pGewicht < 0 ? -pGewicht : pGewicht;
		this.groesse = pGroesse < 0 ? -pGroesse : pGroesse;
	}
	
	public double berechenBMI()
	{
		return this.gewicht / (this.groesse*this.groesse);
	}
	
	/*
	public void setzeDaten(int pGewicht, double pGroesse)
	{
		// falls pGewicht und pGroesse gültig sind
		this.gewicht = pGewicht;
		this.groesse = pGroesse;
	}
	*/
	
	public String ermittleGewichtsklasse()
	{
		double bmi = this.berechenBMI();
		if (bmi < 18.5)
		{
			return "(Untergewicht)";
		}
		else if (bmi >=18.5 && bmi < 25)
		{
			return "(Normalgewicht)";
		}
		else if (bmi >=25 && bmi < 30)
		{
			return "(Übergewicht)";
		}
		else
		{
			return "(Adipositas)";
		}
	}
}
