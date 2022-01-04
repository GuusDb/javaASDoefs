package domein;

public class GumballMachine {

	
			
		   
	private GumballMachineState currentState;
	private int count = 0;

	public GumballMachine(int numberGumballs) {
		this.count = numberGumballs;
		if (numberGumballs > 0) {
			toState(new NoQuarterState(this));
		} else {
			toState(new OutOfGumballsState(this));
		}
	}

	public String insertQuarter() {
		return currentState.insertQuarter();
	}

	public String ejectQuarter() {
		return currentState.ejectQuarter();
	}

	public String turnCrank() {
		String msg1 = currentState.turnCrank();
		String msg2 = currentState.dispense();
		return String.format("%s\n%s", msg1, msg2);
	}

	protected String releaseBall() {
		if (count != 0) {
			count--;
		}
		return "A gumball comes rolling out the slot...";
	}

	public int getCount() {
		return count;
	}

	public void refill(int count) {
		this.count = count;
		toState(new NoQuarterState(this));
	}

	protected void toState(GumballMachineState state) {
		currentState = state;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model");
		result.append(String.format("%nInventory: %d gumball", count));
		if (count != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append(String.format("Machine is %s %n", currentState));
		return result.toString();
	}

}
