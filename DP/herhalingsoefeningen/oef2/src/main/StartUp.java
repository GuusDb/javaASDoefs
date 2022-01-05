package main;

import domein.Body;
import domein.Chassise;
import domein.Garage;
import domein.SteeringWheel;
import domein.Wheel;

public class StartUp {
	public static void main(String[] args) {
		Wheel wiel = new Wheel("Tesla wiel");
		Chassise chasis = new Chassise("ne rode chassise");
		SteeringWheel stuur = new SteeringWheel("tesla stuur");
		Body body = new Body("tis ne groene bowdie");
		
		Garage garage = new Garage(body, wiel, stuur, chasis);
		
		System.out.println(garage.assemble());
	}

}
