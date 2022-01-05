package domein;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import repository.SporterDao;
import repository.SporterDaoJpa;

public class SporterBeheerder {

	private SporterDao sporterDao;
	private Collection<Sporter> sportersLijst;
	
	Map<Integer, Sporter> sportersPerLidNummer;
	Map<Integer, List<Sporter>> sportersPerAantalReductieBonnen;

	// TODO OEF MAP extra attributen

	public SporterBeheerder() {
		sporterDao = new SporterDaoJpa();
		sportersLijst = sporterDao.findAll();
		// TODO OEF MAP
		maakOverzichten();
	}

	public Collection<Sporter> getSportersLijst() {
		return Collections.unmodifiableCollection(sportersLijst);
	}
	
	public Sporter geefSporter(int sportersLidNr) {
		return sportersPerLidNummer.get(sportersLidNr);
	}
	
	public List<Sporter> geefSportersMetEvenveelReductieBonnen(Sporter sporter) {
		// TODO Auto-generated method stub
		return sportersPerAantalReductieBonnen.get(sporter.getReductiebonLijst().size());
	}

	// TODO OEF MAP extra methoden
	public void maakOverzichten()
	{
		sportersPerLidNummer = sportersLijst.stream().collect(Collectors.toMap(Sporter::getLidNr, Function.identity()));
		sportersPerAantalReductieBonnen = sportersLijst.stream().collect(Collectors.groupingBy(spoerter -> spoerter.getReductiebonLijst().size()));
	}

	// VRAAG 6
	public Sporter geefEenSporterMetGegevenReductiebon(Reductiebon bon) {
		return sportersLijst.stream().filter(sporter -> sporter.getReductiebonLijst().contains(bon)).findAny()
				.orElse(null);
	}

	// EXTRA vraag1
	public List<Reductiebon> geefAlleReductiebonnenMetKortingsPercentageX(List<Integer> kortingspercentage) {
		return sportersLijst.stream().map(Sporter::getReductiebonLijst).flatMap(Collection::stream)
				.filter(bon -> kortingspercentage.contains(bon.getPercentage())).collect(Collectors.toList());
	}

	// EXTRA vraag2
	public void verwijderAlleSportersMetReductiebonMetPercX(int perc) {
		sportersLijst.removeIf(
				s -> s.getReductiebonLijst().stream().filter(bon -> bon.getPercentage() == perc).count() != 0);
	}

	public String geefSportersPerLidnr() {
		return geefAlleSleutelWaarden(sportersPerLidNummer);
	}

	public String geefSportersPerAantalReductiebonnen() {
		return geefAlleSleutelWaarden(sportersPerAantalReductieBonnen);		
	}

	// OEF GENERICS
	// methode geefAlleSleutelsWaarden
	public <k,v> String geefAlleSleutelWaarden(Map<k,v> eenMap) {
		Map<k,v> gesorteerdeMap = new TreeMap<>(eenMap);
		return gesorteerdeMap.entrySet().stream().map(entry -> String.format("%s: %s%n", entry.getKey(),entry.getValue())).collect(Collectors.joining());
	}


}
