package testen;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.MyStack;
import exceptions.EmptyListException;

public class TestStackGeneriek {

	private MyStack<String> woordenStack;
	private MyStack<Double> decGetallenStack;

	@BeforeEach
	public void before() {
		woordenStack = new MyStack<>("woordenStack");
		decGetallenStack = new MyStack<>("decimaleGetallenStack");
	}

	//----------------------------------------------------------------------------
	// STAP2
	/*@Test
	public void woordenToevoegenVerwijderen() 
	{
		woordenStack.push("lekker");
		woordenStack.push("zijn");
		woordenStack.push("wafels");

		Assertions.assertEquals("wafels", woordenStack.pop());
		Assertions.assertFalse(woordenStack.isEmpty());
		Assertions.assertEquals("zijn", woordenStack.pop());
		Assertions.assertFalse(woordenStack.isEmpty());

		Assertions.assertEquals("lekker", woordenStack.pop());
		Assertions.assertTrue(woordenStack.isEmpty());
	}

	@Test
	public void decGetallenToevoegenVerwijderen() 
	{
		decGetallenStack.push(12.5);
		decGetallenStack.push(24.3);
		decGetallenStack.push(30.5);
		decGetallenStack.push(40.5);

		Assertions.assertEquals(40.5, decGetallenStack.pop(), 0.0);
		Assertions.assertFalse(decGetallenStack.isEmpty());
		Assertions.assertEquals(30.5, decGetallenStack.pop(), 0.0);
		Assertions.assertFalse(decGetallenStack.isEmpty());
		Assertions.assertEquals(24.3, decGetallenStack.pop(), 0.0);
		Assertions.assertFalse(decGetallenStack.isEmpty());

		Assertions.assertEquals(12.5, decGetallenStack.pop(), 0.0);
		Assertions.assertTrue(decGetallenStack.isEmpty());
	}*/

	/*
	@Test
	public void toevoegenVerwijderenTesten()
	{
		String[] woorden = {"lekker", "zijn", "wafels"};
		Double[] decGetallen = {12.5, 24.3, 30.5, 40.5};
		itemsToevoegenVerwijderen(woordenStack, woorden);
		itemsToevoegenVerwijderen(decGetallenStack, decGetallen);
	}*/

	//public void itemsToevoegenVerwijderen(MyStack myStack,     items){

	//----------------------------------------------------------------------------
	
	@Test
	public void stackLeeg() {
		Assertions.assertTrue(woordenStack.isEmpty());
	}

	@Test
	public void woordenToevoegen() {
		woordenStack.push("lekker");
		woordenStack.push("zijn");
		woordenStack.push("wafels");
		Assertions.assertFalse(woordenStack.isEmpty());
	}

	@Test
	public void woordenDoorElkaarToevoegenVerwijderen() {
		woordenStack.push("lekker");
		woordenStack.push("zijn");

		Assertions.assertEquals("zijn", woordenStack.pop());
		woordenStack.push("wafels");

		Assertions.assertEquals("wafels", woordenStack.pop());
		Assertions.assertEquals("lekker", woordenStack.pop());
		Assertions.assertTrue(woordenStack.isEmpty());
	}

	@Test
	public void woordenVerwijderen() {
		woordenStack.push("lekker");
		woordenStack.push("zijn");
		woordenStack.push("wafels");
		Assertions.assertFalse(woordenStack.isEmpty());
		Assertions.assertEquals("wafels", woordenStack.pop());
		Assertions.assertEquals("zijn", woordenStack.pop());
		Assertions.assertEquals("lekker", woordenStack.pop());
		Assertions.assertTrue(woordenStack.isEmpty());
	}

	@Test
	public void legeStackElementVerwijderen() {
		Assertions.assertThrows(EmptyListException.class, () -> {
			woordenStack.pop();
		});
	}

	@Test
	public void toonStack() {
		woordenStack.push("lekker");
		woordenStack.push("zijn");
		woordenStack.push("wafels");
		String zin = woordenStack.toString().replaceAll("\\s+", " ").trim();
		Assertions.assertEquals("The woordenStack is: wafels zijn lekker", zin);
	}

	@Test
	public void toonLegeStack() {
		String zin = woordenStack.toString().replaceAll("\\s+", " ").trim();
		Assertions.assertEquals("woordenStack is empty", zin);
	}
}
