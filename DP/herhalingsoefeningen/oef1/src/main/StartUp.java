package main;

import javax.swing.text.View;

import domein.Kader;
import domein.SchuifBalk;
import domein.TextView;
import domein.Venster;

public class StartUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextView vw = new SchuifBalk(new SchuifBalk(new Kader(new Venster())));
		System.out.println(vw.getView());
	}

}
