package benutzerschnittstelle;

import java.util.Scanner;
import fachkonzept.Spiel;

public class Konsole 
{

	public static void main(String[] args) 
	{
		Scanner eingabe = new Scanner(System.in);
		Spiel spiel = new Spiel();
		System.out.println("Ziehen sie Karten, aber bleiben Sie unter 22 Punkten!\nDie Karten haben zwischen 2 und 11 Punkten.\n");
		char current_n = 'j';
		
		while (current_n == 'j' && !spiel.hatVerloren())
		{
			int karte_wert = spiel.zieheKarte();
			System.out.println("Karte: "+karte_wert+" Punkte.");
			System.out.println("Weitere Karte (j/n)?");
		
			while (true)
			{
				String eing = eingabe.nextLine();
				current_n = eing.charAt(0);
				if (current_n == 'j' || current_n == 'n')
				{
					break;
				}
				System.out.println("Illegale Eingabe!\n");
			}
		}
		eingabe.close();
		if (current_n == 'n')
		{
			System.out.println("Sie haben mit "+spiel.liesPunktesumme()+" Punkten beendet.");
		}
		else
		{
			System.out.println("VERLOREN! Sie haben "+spiel.liesPunktesumme()+" Punkte!");
		}
	}
}
