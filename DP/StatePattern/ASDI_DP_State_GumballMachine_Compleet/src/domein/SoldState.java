package domein;

class SoldState extends GumballMachineState {

    public SoldState(GumballMachine gumballMachine) {
        super(gumballMachine);
    }

    @Override
    public String dispense() {
        String msg = gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.toState(new NoQuarterState(gumballMachine));
        } else {
            msg = String.format("%s\n%s", msg, "Oops, out of gumballs!");
            gumballMachine.toState(new OutOfGumballsState(gumballMachine));
        }
        return msg;
    }

    @Override
    public String toString() {
        return "dispensing a gumball";
    }
}
