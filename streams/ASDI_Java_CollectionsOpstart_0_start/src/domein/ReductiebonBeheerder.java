package domein;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import repository.ReductiebonDao;
import repository.ReductiebonDaoJpa;

public class ReductiebonBeheerder {

	private ReductiebonDao reductiebonDao;
	private List<Reductiebon> reductiebonLijst;

	public ReductiebonBeheerder() {
		reductiebonDao = new ReductiebonDaoJpa();
		reductiebonLijst = reductiebonDao.findAll();
	}

	public List<Reductiebon> getReductiebonLijst() {
		return Collections.unmodifiableList(reductiebonLijst);
	}

	// VRAAG1
	public List<String> geefReductiebonCodes(int percentage) {
		return reductiebonLijst.stream().filter(bon -> bon.getPercentage()>percentage).map(Reductiebon::getReductiebonCode).collect(Collectors.toList());

	}

	// VRAAG2
	public void sorteerReductiebonnen() {
		/*reductiebonLijst.stream().sorted(Comparator.comparing(Reductiebon::getPercentage).reversed()
												.thenComparing(Reductiebon::getReductiebonCode))
												.collect(Collectors.toList());*/
		Collections.sort(reductiebonLijst,Comparator.comparing(Reductiebon::getPercentage).reversed().thenComparing(Reductiebon::getReductiebonCode));
		
	}

	// VRAAG3
	public double geefGemPercVanBonnenInToekomst() {
		
		return reductiebonLijst.stream().filter(r -> r.getEinddatum().isAfter(LocalDate.now()))
								.mapToDouble(Reductiebon::getPercentage)
								 .average()
								 .getAsDouble();
	}

	// VRAAG4
	public List<LocalDate> geefUniekeEinddatums() {
		
		return reductiebonLijst.stream().map(Reductiebon::getEinddatum)
								.distinct()
								.sorted()
								.collect(Collectors.toList());

	}

}
