package domein;

import exceptions.EmptyListException;
import java.util.Iterator;

public class MyListIterable implements Iterable<String> {
    
    private Node  firstNode;
    private Node lastNode;
    private String nameList;

    public MyListIterable() {
        this("List");
    }

    public MyListIterable (String name) {
        nameList = name;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

 @Override
    public String toString() {
        if (isEmpty()) {
            return nameList + " is empty";
        }

        StringBuilder buffer = new StringBuilder();
        buffer.append("The ").append(nameList).append(" is: ");

        this.forEach(elem -> buffer.append(elem).append(" "));
        return buffer.toString();
    }

    public void insertAtFront(String data) {
        Node aNode = new Node(data);
        if (isEmpty()) {
            firstNode = lastNode = aNode;
        } else {
            aNode.setNext(firstNode);
            firstNode = aNode;
        }
    }

    public void insertAtBack(String data) {
        Node aNode = new Node(data);
        if (isEmpty()) {
            firstNode = lastNode = aNode;
        } else {
            lastNode.setNext(aNode);
            lastNode = lastNode.getNext();
        }
    }

    public String removeFromFront() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException(nameList);
        }

        String removedItem = firstNode.getData();
        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else {
            firstNode = firstNode.getNext();
        }

        return removedItem;
    }

    @Override
    public Iterator<String> iterator() {
        return new MyIterator();
    }
   
    private class MyIterator implements Iterator<String> {
        
        private Node nextToFetch = firstNode;

        @Override
        public boolean hasNext() {
        	return nextToFetch != null;
        }

        @Override
        public String next() {
            String data = nextToFetch.getData();
            nextToFetch = nextToFetch.getNext();
            return data; 
        }
    }

}