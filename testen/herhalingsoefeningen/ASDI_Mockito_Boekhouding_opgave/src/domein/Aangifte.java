package domein;

public class Aangifte {

    private double[] bedragen;
    private double belastingSchaal;

    Aangifte(double belastingSchaal, double[] bedragen) {
        setBedragen(bedragen);
        setBelastingSchaal(belastingSchaal);
    }

    public double[] getBedragen() {
        return bedragen;
    }

    private void setBedragen(double[] bedragen) {
        this.bedragen = bedragen;
    }

    public double getBelastingSchaal() {
        return belastingSchaal;
    }

    private void setBelastingSchaal(double belastingSchaal) {
        this.belastingSchaal = belastingSchaal;
    }

}
