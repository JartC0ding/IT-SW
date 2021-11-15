package benutzerschnittstelle;
import fachkonzept.Trinker;
import fachkonzept.Getraenk;

import java.lang.NumberFormatException;
import java.util.Scanner;
import java.lang.IllegalArgumentException;

public class Konsole 
{

	public static void main(String[] args) {
		// Var definition
		Scanner eingabe = new Scanner(System.in);
		char geschlecht;
		int koerpergewicht;
		int MengeMl;
		double alkoholgehaltPrz;
		
		// Main thread
		System.out.println(" Promillerechner\n-----------------");
		System.out.println("Daten zum Trinker");
		// geschlecht Eingabe
		while (true)
		{
			System.out.println("Geschl\0echt: (m/w)\n");
			try 
			{
				String eingb = eingabe.nextLine();
				geschlecht = eingb.charAt(0);
				if (geschlecht == 'm' || geschlecht == 'w')
				{
					break;
				}
				else
				{
					throw new IllegalArgumentException(eingb);
				}
			}
			catch (IllegalArgumentException e)
			{
				System.out.println("m or w expected! Got: " + e.getMessage());
			}
		}
		// Koerpergewicht
		while (true)
		{
			System.out.println("Körpergewicht [kg]:");
			try
			{
				String eingb = eingabe.nextLine();
				koerpergewicht = Integer.parseInt(eingb);
				if (koerpergewicht == 0)
				{
					throw new NumberFormatException();
				}
				else
				{
					break;
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Der eingegebene Wert ist keine Ganzzahl!\n");
			}
		}
		
		System.out.println("\nDaten zum Getränk:");
		// MengeMl
		while (true)
		{
			System.out.println("Menge [ml]");
			try
			{
				String eingb = eingabe.nextLine();
				MengeMl = Integer.parseInt(eingb);
				if (MengeMl == 0)
				{
					throw new NumberFormatException();
				}
				else
				{
					break;
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Der eingegebene Wert ist keine Ganzzahl!\n");
			}
		}
		// Prozent
		while (true)
		{
			System.out.println("Alkoholgehallt [Vol.-%]:");
			try
			{
				String eingb = eingabe.nextLine();
				alkoholgehaltPrz = Double.parseDouble(eingb);
				if (alkoholgehaltPrz == 0)
				{
					throw new NumberFormatException();
				}
				else
				{
					break;
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Der eingegebene Wert ist keine Fließkommazahl! Bitte '.' statt ',' verwenden");
			}
		}
		
		// Hauptberechnung
		Getraenk getraenk = new Getraenk(alkoholgehaltPrz, MengeMl);
		Trinker trinker   = new Trinker(geschlecht, koerpergewicht, getraenk);
		System.out.println("\nErgebnis\nBlutalkhohlkonzentration:\n" + trinker.berechneBlutalkoholgehaltPromille() + "Promille");
	}
}
