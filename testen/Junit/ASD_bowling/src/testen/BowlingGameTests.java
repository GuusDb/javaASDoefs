package testen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import domein.BowlingGame;

class BowlingGameTests {
	
	BowlingGame game;

	@BeforeEach
	public void before() {
		game = new BowlingGame();
	}
	
	@Test
	public void testAllZeros() {
		rollMany(20, 0);
		Assertions.assertEquals(0, game.score());
	}
	
	@Test
	public void testAllOnes() {
		rollMany(20, 1);
		Assertions.assertEquals(20, game.score());
	}
	
	private void rollMany(int n, int pins) {
		for (int i = 0 ; i<n; i++) {
			game.roll(pins);
		}
	}
	
	@ParameterizedTest
	@CsvSource({"0,0","1,20"})
	public void testSameNmberOfPins(int number, int expected) {
		rollMany(20, number);
		Assertions.assertEquals(expected, game.score());
	}
	
	@Test
	public void testOneSpare() {
		rollSpare();
		game.roll(3);
		rollMany(17, 0);
		assertEquals(16, game.score());
	}
	
	@Test
	public void testOneStrike() {
		rollStrike();
		game.roll(3);
		game.roll(4);
		rollMany(16, 0);
		Assertions.assertEquals(24, game.score());
	}
	
	public void rollSpare() {
		game.roll(5);
		game.roll(5);
	}
	
	public void rollStrike() {
		game.roll(10);
	}
	
	@Test
	public void testAllStrikes() {
		for (int i =0;i<12;i++) {
			rollStrike();
		}
		Assertions.assertEquals(300,game.score());
	}
	
	@Test
	public void testAllSpares() {
		for (int i = 0;i<10;i++) {
			rollSpare();
		}
		game.roll(5);
		Assertions.assertEquals(150, game.score());
	}
	
	@Test
	public void testScenario() {
		int[] pins = {1,4,4,5,6,4,5,5,10,0,1,7,3,6,4,10,2,8,6};
		for (int i = 0;i<pins.length;i++) {
			game.roll(pins[i]);
		}
		assertEquals(133,game.score());
	}
	

}
