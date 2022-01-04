package domein;

abstract class GumballMachineState {

    protected final GumballMachine gumballMachine;

    public GumballMachineState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public String insertQuarter() {
        return "You can't insert a quarter";
    }

    public String ejectQuarter() {
        return "You haven't inserted a quarter";
    }

    public String turnCrank() {
        return "You can't turn";
    }

    public String dispense() {
        return "You need to pay first";
    }

}
