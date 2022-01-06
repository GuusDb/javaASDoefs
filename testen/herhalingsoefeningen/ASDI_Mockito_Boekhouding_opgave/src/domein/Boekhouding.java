package domein;

public class Boekhouding {
  
    public static final double BELASTINGSCHAAL_0 = 0.5;
    public static final double BELASTINGSCHAAL_1 = 1.25;
    
    private FactuurMap factuurMap;
   
    public Boekhouding(FactuurMap factuurmap) {
    	this.factuurMap = factuurmap;
    }
    
    public Aangifte genereerAangifte(String ondernemingsNummer) {
    	
    	if(ondernemingsNummer==null||ondernemingsNummer.isBlank()) {
    		throw new IllegalArgumentException("ondernemingsnummer is verplicht in te vullen");
    	}
    	
    	
        if (!ondernemingsNummer.matches("BE\\d{10}")) {
            throw new IllegalArgumentException("Verkeerd formaat ondernemingsnummer");
        }

        //FactuurMap factuurMap = new FactuurMap();

        double[] factuurOverzicht = factuurMap.geefBedragen(ondernemingsNummer);

        return new Aangifte(berekenBelastingSchaal(factuurOverzicht), factuurOverzicht);
    }

    /*Op basis van de som van alle bedragen:
    [0, 200,0[ => BELASTINGSCHAAL_0
    200,0 of hoger => BELASTINGSCHAAL_1
     */
    private double berekenBelastingSchaal(double[] factuurOverzicht) {

        double totaalBedrag = 0;
        for (double bedrag : factuurOverzicht) {
            totaalBedrag += bedrag;
        }

        if (totaalBedrag < 200.0) {
            return BELASTINGSCHAAL_0;
        }
        return BELASTINGSCHAAL_1;
    }
}
