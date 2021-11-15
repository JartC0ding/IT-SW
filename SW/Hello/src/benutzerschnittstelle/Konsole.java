package benutzerschnittstelle;

import java.util.Scanner;

public class Konsole 
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// struct -> dtype name = new  ClassObj
		Scanner eingabe = new Scanner(System.in);
		eingabe.useDelimiter("\n");
		
		System.out.println("Name: ");
		String name;
		name = eingabe.next();
		
		System.out.println("Hello " + name);
		System.out.println("Wie geht's dir, " + name + "?");
		
		String gefuehl;
		gefuehl = eingabe.next();
		
		System.out.println("Dir geht es also " + gefuehl);
		eingabe.close();
	
	}
}
