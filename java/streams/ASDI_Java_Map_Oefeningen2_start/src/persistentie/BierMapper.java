package persistentie;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import domein.Bier;

public class BierMapper {

    public List<Bier> inlezenBieren(String naamBestand) {
        //TODO
    	List<Bier> bieren = new ArrayList<>();
    	
    	String naam, soort, brouwerij;
    	double alcoholgehalte, beoordeling;
    	
    	/*try(
    		Scanner scanner = new Scanner(new File(naamBestand))){
    			while(scanner.hasNext()) {
    				naam = scanner.next();
    				soort = scanner.next();
    				alcoholgehalte = scanner.nextDouble();
    				beoordeling = scanner.nextDouble();
    				brouwerij = scanner.nextLine().trim();
    				bieren.add(new Bier(naam,soort,alcoholgehalte,beoordeling,brouwerij));
    		}
    	}*/
    	
    	try(Stream<String> stream = Files.lines(Paths.get(naamBestand))){
    		stream.forEach(regel ->{
    			Scanner scanner = new Scanner(regel);
    			bieren.add(new Bier(scanner.next(),scanner.next(),scanner.nextDouble(),scanner.nextDouble(),
    					scanner.nextLine().trim()));
    		});
    	}
    	catch(IOException ex) {
    		Logger.getLogger(BierMapper.class.getName()).log(Level.SEVERE,null,ex);;
    	}
    	
    	return bieren;
    	
    }
    
}
