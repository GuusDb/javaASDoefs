package ui;

import java.util.*;
import java.util.stream.Collectors;

class CollectionOperaties {
    
    //methode verwijderOpLetter
    //-------------------------
	public static void verwijderOpLetter(List<String> list,char letter) {
		list.removeIf(el -> el.startsWith(String.valueOf(letter)));
	}

    //methode verwijderSequence
    //-------------------------
	public static void verwijderSequence(List<String> list, String woord) {
		 	int first = list.indexOf(woord);
	        int last = list.lastIndexOf(woord);
	        list.subList(first, last + 1).clear();
	}
	
	//uitbreiding opgave Fruit   addOrdered
	//-------------------------------------
    public static boolean addOrdered(List<String> list, String s) {
        int index = Collections.binarySearch(list, s);
        if (index >= 0) {
            list.add(index * -1 - 1, s);
            return false;
        } else return true;
    }
}

public class OefFruit_opgave {

    public static void main(String args[]) {
        String kist[][] = {{"appel", "peer", "citroen", "kiwi", "perzik"},
        {"banaan", "mango", "citroen", "kiwi", "zespri", "pruim"},
        {"peche", "lichi", "kriek", "kers", "papaya"}};

        List<String> list;
        String mand[];

//Voeg de verschillende kisten samen in een ArrayList list.
//--------------------------------------------------------
        list = Arrays.stream(kist).flatMap(Arrays::stream).collect(Collectors.toList());

        CollectionOperaties.verwijderOpLetter(list, 'p');
        System.out.println("na verwijder letter ('p') :  " + list + "\n");

        CollectionOperaties.verwijderSequence(list, "kiwi");
        System.out.println("na verwijder sequence (kiwi) : " + list + "\n");

//Plaats het resultaat terug in een array mand en sorteer die oplopend.
//---------------------------------------------------------------------
     mand = list.toArray(new String[0]);
     Arrays.sort(mand);

//Geef de inhoud van de array "mand" terug
//----------------------------------------
     System.out.println(mand.toString());

    }
}
