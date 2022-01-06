package domein;

public class PerfectGetal {

	public boolean isPerfect(int getal) {
		if (getal < 0)
			throw new IllegalArgumentException("Getal mag niet negatief zijn");

		if (getal == 0 || getal == 1) {
			return false;
		}

		return (getal == somVanDelers(getal));
	}

	private int somVanDelers(int getal) {
		int som = 0;
		
		for (int i = 1; i <= getal / 2; i++)
			if (getal % i == 0)
				som += i;
		
		return som;
	}

}
