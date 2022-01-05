package domein;

public class Garage {
	
	private GarageFacade facade;
	
	public Garage(Body body, Wheel wheel, SteeringWheel stuur, Chassise chassise) {
		facade = new GarageFacade(body,wheel,stuur,chassise);
	}
	
	public String assemble() {
		return facade.assemble();
	}
}
