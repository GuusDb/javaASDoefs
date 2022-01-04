import domein.GumballMachine;

public class StartUp {

    public static void main(String[] args) {
        
        GumballMachine gumballMachine = new GumballMachine(5);

        System.out.println(gumballMachine);

        System.out.println(gumballMachine.turnCrank());
        
        System.out.println(gumballMachine.insertQuarter());
        System.out.println(gumballMachine.turnCrank());

        System.out.println(gumballMachine);
        
        System.out.println(gumballMachine.insertQuarter());
        System.out.println(gumballMachine.turnCrank());
        System.out.println(gumballMachine.insertQuarter());
        System.out.println(gumballMachine.turnCrank());

        System.out.println(gumballMachine);
    }
}