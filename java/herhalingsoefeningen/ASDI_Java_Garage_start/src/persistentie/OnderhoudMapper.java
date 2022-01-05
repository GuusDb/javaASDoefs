package persistentie;

import java.util.List;

import domein.Onderhoud;
import java.io.File;

public class OnderhoudMapper {

    private File naamBestand;

    public OnderhoudMapper(File naamBestand) {
        this.naamBestand = naamBestand;
    }
    
    public List<Onderhoud> geefOnderhoudVanAutos() {
 	//return new ObjectStreamManipulaties().leesObjecten(naamBestand); //uncomment
     return null; //comment
    }

}
