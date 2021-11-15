package benutzerschnittstelle;

import fachkonzept.Person;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Konsole 
{
	public static void main(String[] args) 
	{
		int gewicht;
		double groesse;
		
		Scanner eingabe = new Scanner(System.in);
		// Check ob das groesse valid ist
		while (true)
		{
			System.out.println("BMI-Rechner\n-------");
			try
			{
				System.out.println("Gewicht: \n");
				gewicht = eingabe.nextInt();
				break;
			}
			catch (InputMismatchException e)
			{
				System.out.println("Error: Make sure to use a int");
			}
		}
		
		// Check ob die gewicht valid ist
		while (true)
		{
			try
			{
				System.out.println("Größe: \n");
				groesse = eingabe.nextDouble();
				break;
			}
			catch (InputMismatchException e1)
			{
				System.out.println("Make sure to use a float and a ',' instead of a '.'!");
			}
		}
		eingabe.close();
		// Berechnen und ausgeben
		Person Mensch = new Person(gewicht, groesse);
		//Konishiki.setzeDaten(gewicht, groesse);
		System.out.println("\nBMI: " + Mensch.berechenBMI() + " " + Mensch.ermittleGewichtsklasse());
	}
}
