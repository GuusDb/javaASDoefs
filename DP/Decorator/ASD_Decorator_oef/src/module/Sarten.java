package module;

import domein.Encrypted;
import domein.FileReader;
import domein.PDF;
import domein.Zipped;

public class Sarten {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr = new Zipped(new Encrypted(new Zipped(new Zipped(new PDF()))));
		System.out.println(fr.getDescription());
				
				
	}

}
