package ui;

import java.util.Scanner;

import domein.SportclubController;

public class ConsoleApplicatie {
	private SportclubController sportClubController;

	public ConsoleApplicatie(SportclubController sportClubController) {
		this.sportClubController = sportClubController;
		start();
	}

	private void start() {
		
		//TODO uncomment OEF MAP
		
		Scanner input = new Scanner(System.in);
		System.out.println("\nGeef het id van sporter : ");
		int sporterLidNr = input.nextInt();		
		System.out.printf("%nalle sporters met gelijk aantal reductiebonnen als lidNummer %s : %s%n", 
				sporterLidNr , sportClubController.geefSportersMetEvenveelReductiebonnen(sporterLidNr));
		
		
		//TODO uncomment OEF GENERICS
		/*
		System.out.println("\nOverzicht sporters per lidnummer:\n" + sportClubController.geefSportersPerLidnr());
		System.out.println("\nOverzicht sporters per aantal reductiebonnen\n"
				+ sportClubController.geefSportersPerAantalReductiebonnen());
		System.out.println("\nOverzicht sporters:\n" + sportClubController.geefSporters());
		*/
		
	}

}
