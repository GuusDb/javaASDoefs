package domein;

import java.security.SecureRandom;

public class Teerling {

    private int aantalVlakken;
    private final SecureRandom random;

    public static final int DEFAULT = 6;
    public static final int MIN_GRENS = 2;
    public static final int MAX_GRENS = 100000;
    
    public Teerling(int aantalVlakken) {
        setAantalVlakken(aantalVlakken);
        random = new SecureRandom();
    }

    public Teerling() {
        this(DEFAULT);
    }

    public int getAantalVlakken() {
        return aantalVlakken;
    }

    private void setAantalVlakken(int aantalVlakken) {

        if (aantalVlakken < MIN_GRENS || aantalVlakken > MAX_GRENS) {
            throw new IllegalArgumentException(
                    String.format("aantal vlakken moet liggen tussen %d en %d", MIN_GRENS, MAX_GRENS));
        }
        this.aantalVlakken = aantalVlakken;
    }

    public int gooi() {
        return random.nextInt(aantalVlakken) + 1;
    }

}
