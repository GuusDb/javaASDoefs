package domein;

import java.util.Map;
import java.util.stream.Collectors;

public class DomeinController {

    private final BierWinkel bierWinkel;

    public DomeinController() {
        bierWinkel = new BierWinkel();
    }
    public String opzettenBierPerNaam() {
        return overzichtToString(bierWinkel.opzettenOverzichtBierPerNaam());
    }

    public String opzettenAantalBierenPerSoort() {
        return overzichtToString(bierWinkel.opzettenAantalBierenPerSoort());
    }

    public String opzettenOverzichtBierenPerSoort() {
        return overzichtToString(bierWinkel.opzettenOverzichtBierenPerSoort());
    }



    //TODO na hoofdstuk generics 
    //--> generieke oplossing "overzichtToString" methode
    //
    public <k,v> String overzichtToString(Map<k,v> mapje) {
    	return mapje.entrySet().stream().map(e -> String.format("%s = %s", e.getKey(), e.getValue())).collect(Collectors.joining("\n"));
    }

}
