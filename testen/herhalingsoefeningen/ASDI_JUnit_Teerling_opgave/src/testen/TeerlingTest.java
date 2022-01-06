package testen;

import static domein.Teerling.*;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Teerling;

class TeerlingTest {
	
	private Teerling teerling;
	private final int AANTAL = 100;
	
	public void before(int vlakken) {
		if (vlakken == DEFAULT) {
			teerling = new Teerling();
		}else {
			teerling = new Teerling(vlakken);
		}	
	}
	
	private static Stream<Integer> opsommingCorrecteWaarden(){
		return Stream.of(
					DEFAULT, MIN_GRENS, MAX_GRENS, 10, 20 ,30 , 40, 50 ,60 ,70
				);
	}

	@ParameterizedTest
	@MethodSource("opsommingCorrecteWaarden")
	public void maakteerlingCorrecteGegevens(int vlakken) {
		before(vlakken);
		assertEquals(vlakken, teerling.getAantalVlakken());
	}
	
	@ParameterizedTest
	@ValueSource(ints = { Integer.MIN_VALUE, -100, -4, -1, MIN_GRENS - 1, 0, MAX_GRENS + 1 })
	public void maakTeerling_foutieveGrootte_Exception(int grootte) {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Teerling(grootte);
		});
	}
	
	@ParameterizedTest
	@MethodSource("opsommingCorrecteWaarden")
	public void GooienMetCorrecteGrenzen(int vlakken) {
		before(vlakken);
		Set<Integer> worpen = new HashSet<>();
		for (int i = 0; i<vlakken*AANTAL;i++) {
			int worp = teerling.gooi();
			Assertions.assertTrue(worp >= 1 && worp <= teerling.getAantalVlakken());
			worpen.add(worp);
		}
		Assertions.assertTrue(worpen.size()==teerling.getAantalVlakken());
	}


}
