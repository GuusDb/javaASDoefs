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
	//EXTRA vraag generics
    //private MyCollection<Reductiebon> myCollection; 

	public ReductiebonBeheerder() {
		reductiebonDao = new ReductiebonDaoJpa();
		reductiebonLijst = reductiebonDao.findAll();
		//myCollection = new MyCollection<>();
	}

	public ReductiebonBeheerder(List<Reductiebon> reductiebonLijst) {
		reductiebonDao = new ReductiebonDaoJpa();
		this.reductiebonLijst = reductiebonLijst;
		//myCollection = new MyCollection<>();
	}

	//EXTRA vraag generics	
	/*	
		public void storeBon(Reductiebon bon) {
			myCollection.addElement(bon);
		}
		public Reductiebon retrieveBon() {
			return myCollection.getElement();
		}
		public void addReeks   
		}
	*/
	
	public List<Reductiebon> getReductiebonLijst() {
		return Collections.unmodifiableList(reductiebonLijst);
	}

	// VRAAG1
	public List<String> geefReductiebonCodes(int percentage) {
		return reductiebonLijst.stream().filter(bon -> bon.getPercentage() > percentage)
				.map(Reductiebon::getReductiebonCode).collect(Collectors.toList());
	}

	// VRAAG2
	public void sorteerReductiebonnen() {
		reductiebonLijst.sort(Comparator.comparing(Reductiebon::getPercentage)
				.thenComparing(Comparator.comparing(Reductiebon::getReductiebonCode).reversed()));
	}

	// VRAAG3
	public double geefGemPercVanBonnenInToekomst()
	{
		return reductiebonLijst.stream().filter(bon -> bon.getEinddatum().isAfter(LocalDate.now())).
				mapToDouble(Reductiebon::getPercentage).average().getAsDouble();
	}

	// VRAAG4
	public List<LocalDate> geefUniekeEinddatums() {
	     return reductiebonLijst.stream().
                 map(Reductiebon::getEinddatum).
                 distinct().sorted().
                 collect(Collectors.toList()); 
	}
	
}
