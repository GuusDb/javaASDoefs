package testen;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import domein.Aangifte;
import domein.Boekhouding;
import domein.FactuurMap;

import static domein.Boekhouding.*;

@ExtendWith(MockitoExtension.class)
class BoekhoudingTest {
	@Mock
	private FactuurMap factuurMap;
	@InjectMocks
	private Boekhouding boekhouding;
	
	private static Stream<Arguments> opsommingGeldigeWaarden(){
		return Stream.of(//gevallen van [3]
					Arguments.of(new double[] {18.78,30.25,29.99},BELASTINGSCHAAL_0),//gewoon
					Arguments.of(new double[] {0,0,0},BELASTINGSCHAAL_0),//minimum BS0
					Arguments.of(new double[] {20.0,150.0,29.99},BELASTINGSCHAAL_0),//maximum BS0
					Arguments.of(new double[] {150.0,50.0,0.0},BELASTINGSCHAAL_1),//minimum BS1
					Arguments.of(new double[] {250.0,1000.0,29.99},BELASTINGSCHAAL_1),//gewoon BS1
									//gevallen van [2]
					Arguments.of(new double[] {18.78,29.99},BELASTINGSCHAAL_0),//gewoon
					Arguments.of(new double[] {0,0},BELASTINGSCHAAL_0),//minimum BS0
					Arguments.of(new double[] {170.0,29.99},BELASTINGSCHAAL_0),//maximum BS0
					Arguments.of(new double[] {150.0,50.0},BELASTINGSCHAAL_1),//minimum BS1
					Arguments.of(new double[] {150.55,80.88},BELASTINGSCHAAL_1)//gewoon BS1
					
				);
	}

//Vraag 1
	@ParameterizedTest
	@MethodSource("opsommingGeldigeWaarden")
	public void geldigeWaarden(double[] bedragen, double belastingSchaal) {
		String onderneming = "BE0123456789";
		
		//mock trainen
		Mockito.when(factuurMap.geefBedragen(onderneming)).thenReturn(bedragen);
		
		//gedrag aanroepen en assertion
		Aangifte aangifte = boekhouding.genereerAangifte(onderneming);
		Assertions.assertEquals(belastingSchaal, aangifte.getBelastingSchaal());
		Assertions.assertArrayEquals(bedragen, aangifte.getBedragen());
		
		//verify
		Mockito.verify(factuurMap).geefBedragen(onderneming);
		
	}

//vraag 2
		@ParameterizedTest
		@NullAndEmptySource
		@ValueSource(strings= {"BE012345678","000123456789","abc456789","NL0123456789","be0123456789",
				"BE-123456789","   "})
		public void ongeldigeWaarden(String onderneming) {
			Assertions.assertThrows(IllegalArgumentException.class, ()-> boekhouding.genereerAangifte(onderneming));
		}
		
		@ParameterizedTest
		@ValueSource(strings = {"BE0123456789","BE0000000000","BE9999999999","BE2516378459"})
		public void geldigWaarden(String onderneming) {
			Assertions.assertDoesNotThrow(()-> {
				Mockito.when(factuurMap.geefBedragen(onderneming)).thenReturn(new double[] {10.0,20.0});
				boekhouding.genereerAangifte(onderneming);
			});
		}
	
}


//aangifte genereerAangefite(String ondernemingsnummer)
/*
welke data?
--> para String NVT
MOCK --> double[]
het resultaat  Double(belastingschaal)

*/

