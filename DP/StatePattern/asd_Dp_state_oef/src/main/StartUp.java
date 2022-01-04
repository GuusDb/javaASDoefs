package main;

import domein.File;

public class StartUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File();
		
		System.out.println(file.toString());
		System.out.println(file.aanpassen());
		System.out.println(file.toString());
		System.out.println(file.save());
		System.out.println(file.toString());
	}

}
