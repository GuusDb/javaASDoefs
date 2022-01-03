package domein;

public class MyStack {

    private MyListIterable list;

    public MyStack() {
        this("Stack");
    }

    public MyStack(String name) {
        list = new MyListIterable(name);
    }

    public void push(String data) {
        list.insertAtFront(data);
    }

    public String pop() {
        return list.removeFromFront();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return list.toString();
    }

}
