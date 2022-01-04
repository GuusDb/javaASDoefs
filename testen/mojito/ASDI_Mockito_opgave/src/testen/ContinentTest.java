package testen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import domein.ContinentService;
import persistentie.PersistentieController;

@ExtendWith(MockitoExtension.class)
class ContinentTest {

	@Mock
	private PersistentieController persDummy;
	
	@InjectMocks
	private ContinentService continent;
	
	@ParameterizedTest
	@ValueSource(strings= {"north-america"})
	public void negatiefoverschot(String c) {
		Mockito.when(persDummy.findAantalBewoners(c)).thenReturn(10000L);
		Mockito.when(persDummy.findGeboortecijfers(c)).thenReturn(400L);
		Mockito.when(persDummy.findSterfteCijfer(c)).thenReturn(6000L);
		
		Assertions.assertEquals(-560.0, continent.geefGeboorteOverschot(c));
		Mockito.verify(persDummy).findAantalBewoners(c);
		Mockito.verify(persDummy).findGeboortecijfers(c);
		Mockito.verify(persDummy).findSterfteCijfer(c);
		
	}
	
	@ParameterizedTest
	@ValueSource(strings= {"Europe"})
	public void positiefOverschot(String c) {
		Mockito.when(persDummy.findAantalBewoners(c)).thenReturn(16405399L);
		Mockito.when(persDummy.findGeboortecijfers(c)).thenReturn(184634L);
		Mockito.when(persDummy.findSterfteCijfer(c)).thenReturn(135136L);
		
		assertEquals(3.0, continent.geefGeboorteOverschot(c),0.1);
		Mockito.verify(persDummy).findAantalBewoners(c);
		Mockito.verify(persDummy).findGeboortecijfers(c);
		Mockito.verify(persDummy).findSterfteCijfer(c);
	}

}
