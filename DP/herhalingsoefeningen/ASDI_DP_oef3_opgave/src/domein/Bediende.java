package domein;

public class Bediende implements Statuut{
    
    private double maandwedde;

    public Bediende(double maandwedde) {
        this.maandwedde = maandwedde;
    }
    
    @Override
    public double geefJaarInkomst() {
        return maandwedde*12;
    }

    
    
    
}
