package domein;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import persistentie.PersistentieController;

public class BierWinkel {

    private final List<Bier> bieren;
    private PersistentieController pc = new PersistentieController();

    public BierWinkel() {
        bieren = pc.inlezenBieren("bieren.txt");
    }
    
    //TODO type Map aanvullen
    public Map<String, Bier> opzettenOverzichtBierPerNaam() {
    	//TODO
    	
    	return bieren.stream().collect(Collectors.toMap(Bier::getNaam, Function.identity()));
    }
    

    //TODO type Map aanvullen
    public Map<String, List<Bier>> opzettenOverzichtBierenPerSoort() {
       //TODO
    	
    	return bieren.stream().collect(Collectors.groupingBy(Bier::getSoort,TreeMap::new,Collectors.toList()));
    }

    public Map<String, Long> opzettenAantalBierenPerSoort() {
      //TODO
    	
    	return bieren.stream().collect(Collectors.groupingBy(Bier::getSoort,TreeMap::new,Collectors.counting()));
    }

}
