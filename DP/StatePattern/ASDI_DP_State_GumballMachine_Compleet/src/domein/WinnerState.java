package domein;

class WinnerState extends GumballMachineState {

    public WinnerState(GumballMachine gumballMachine) {
        super(gumballMachine);
    }

    @Override
    public String dispense() {
        String msg = "YOU'RE A WINNER! You get two gumballs for your quarter\n";
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() == 0) {
            msg += "\nOops, out of gumballs!";
            gumballMachine.toState(new OutOfGumballsState(gumballMachine));
        } else {
            msg += gumballMachine.releaseBall();
            if (gumballMachine.getCount() > 0) {
                gumballMachine.toState(new NoQuarterState(gumballMachine));
            } else {
                gumballMachine.toState(new OutOfGumballsState(gumballMachine));
            }
        }
        return msg;
    }

    @Override
    public String toString() {
        return "despensing two gumballs for your quarter, because YOU'RE A WINNER!";
    }
}
