package domein;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class MyCollection <E extends Reductiebon>{
	Queue<E> wachtrij;
	
	public MyCollection() {
		wachtrij = new LinkedList<>();
	}
	
	public E getElement() {
		return wachtrij.peek();
	}
	
	public void addElement(E element) {
		wachtrij.add(element);
	}
	
	public void addReeks(Collection<E> reeks) {
		reeks.forEach(value -> wachtrij.add(value));
	}
	
	public double AverageList() {
		double avg = 0.0;
		int counter = 0;
		for (E e: wachtrij) {
			avg += e.getPercentage();
			counter += 1;
		}
		
		return avg/counter;
	}
}
