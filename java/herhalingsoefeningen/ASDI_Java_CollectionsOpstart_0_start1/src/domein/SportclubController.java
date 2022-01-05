package domein;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SportclubController {

	private SporterBeheerder sporterBeheerder;

	public SportclubController() {
		sporterBeheerder = new SporterBeheerder();
	}
//TODO uncomment OEF GENERICS
//	public String geefSportersPerLidnr() {
//		return sporterBeheerder.geefSportersPerLidnr();
//	}
//
//	public String geefSportersPerAantalReductiebonnen() {
//		return sporterBeheerder.geefSportersPerAantalReductiebonnen();
//	}

	public java.lang.String geefSportersPerLidnr() {
		return sporterBeheerder.geefSportersPerLidnr();
	}

	public java.lang.String geefSportersPerAantalReductiebonnen() {
		return sporterBeheerder.geefSportersPerAantalReductiebonnen();
	}

	public java.lang.String geefSporters() {
		return geefGesorteerdeCollectie(sporterBeheerder.getSportersLijst());
	}

	public String geefSportersMetEvenveelReductiebonnen(int sporterLidNr) {
		Sporter sporter = sporterBeheerder.geefSporter(sporterLidNr);
		if(sporter == null) {
			return "ongekend lidnummer";
		}		
		List<Sporter> sporters = sporterBeheerder.geefSportersMetEvenveelReductieBonnen(sporter);		
		if (sporters.isEmpty()) {
			return "geen sporters met gelijk aantal kortingsbonnen";
		}		
		return sporters.stream().map(Sporter::getNaam)
								.collect(Collectors.joining("-"));
	}


	//TODO OEF GENERICS....
	public <E extends Comparable<E>> String geefGesorteerdeCollectie(Collection<E> collectie) {
		return collectie.stream().sorted()
								 .map(E::toString)
								 .collect(Collectors.joining("\n"));
	}
}
