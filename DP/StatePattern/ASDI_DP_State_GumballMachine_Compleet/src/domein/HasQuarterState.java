package domein;

import java.security.SecureRandom;

class HasQuarterState extends GumballMachineState {

    private SecureRandom randomWinner = new SecureRandom();

    public HasQuarterState(GumballMachine gumballMachine) {
        super(gumballMachine);
    }

    @Override
    public String ejectQuarter() {
        gumballMachine.toState(new NoQuarterState(gumballMachine));
        return "Quarter returned";
    }

    @Override
    public String turnCrank() {
       int winner = randomWinner.nextInt(10);
        if ((winner == 0) && (gumballMachine.getCount() > 1)) {
            gumballMachine.toState(new WinnerState(gumballMachine));
        } else {
            gumballMachine.toState(new SoldState(gumballMachine));
        }
        return "You turned...";
    }

    @Override
    public String toString() {
        return "waiting for turn of crank";
    }
}
