package main;

import domein.Geweer;
import domein.Held;
import domein.Mes;

public class Start {

	public static void main(String[] args) {

		Held jasper = new Held();
		jasper.valAan();
		jasper.setWapen(new Geweer());
		jasper.valAan();
		jasper.setWapen(new Mes());
		jasper.valAan();

	}

}
