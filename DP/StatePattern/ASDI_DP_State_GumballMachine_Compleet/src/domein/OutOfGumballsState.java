package domein;

class OutOfGumballsState extends GumballMachineState {

    public OutOfGumballsState(GumballMachine gumballMachine) {
        super(gumballMachine);
    }

    @Override
    public String toString() {
        return "sold out";
    }
}
