package testen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domein.PerfectGetal;

class PerfectGetalTest {
	
	PerfectGetal pg;

	@BeforeEach
	void beforeEach() {
		pg = new PerfectGetal();
	}
	
	@ParameterizedTest
	@ValueSource(ints = {6,28,496,8128})
	public void testPerfecteGetallenJuist(int getal) {
		Assertions.assertTrue(pg.isPerfect(getal));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {0,1,3,9,8,1568,4})
	public void testFouteGetallen(int getal) {
		Assertions.assertFalse(pg.isPerfect(getal));
	}

}
