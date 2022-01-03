package domein;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import repository.SporterDao;
import repository.SporterDaoJpa;

public class SporterBeheerder {

	private SporterDao sporterDao;
	private Collection<Sporter> sportersLijst;

	// TODO OEF MAP extra attributen

	public SporterBeheerder() {
		sporterDao = new SporterDaoJpa();
		sportersLijst = sporterDao.findAll();
		// TODO OEF MAP
		// maakOverzichten();
	}

	public Collection<Sporter> getSportersLijst() {
		return Collections.unmodifiableCollection(sportersLijst);
	}

	// TODO OEF MAP extra methoden
//	public void maakOverzichten()
//	{
//		
//	}

	// VRAAG 6
	public Sporter geefEenSporterMetGegevenReductiebon(Reductiebon bon) {
		return sportersLijst.stream().filter(sporter -> sporter.getReductiebonLijst().contains(bon))
							  .findAny()
							  .orElse(null);
	}
	// EXTRA vraag1 bij opstartASDIproject
	public List<Reductiebon> geefAlleReductiebonnenMetKortingsPercentageX(List<Integer> kortingspercentage) {
		//flatmap maakt een stream van de gemappte dingen
		return sportersLijst.stream().map(Sporter::getReductiebonLijst).flatMap(Collection::stream)
									 .filter(bon -> kortingspercentage.contains(bon.getPercentage()))
									 .collect(Collectors.toList());
	}
	// EXTRA vraag2 bij opstartASDIproject
	public void verwijderAlleSportersMetReductiebonMetPercX(int perc) {
		sportersLijst.removeIf(s -> s.getReductiebonLijst().stream()
														   .filter(bon -> bon.getPercentage() == perc)
														   .count()!=0);
	}

	public String geefSportersPerLidnr() {
		throw new UnsupportedOperationException();
	}

	public String geefSportersPerAantalReductiebonnen() {
		throw new UnsupportedOperationException();
	}
	
	
	

	// OEF GENERICS
	// methode geefAlleSleutelsWaarden


}
