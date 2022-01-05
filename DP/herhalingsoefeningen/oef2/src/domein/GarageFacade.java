package domein;

public class GarageFacade {
	
	private Body body;
	private Wheel wheel;
	private SteeringWheel stuur;
	private Chassise chassise;
	
	
	
	public GarageFacade(Body body, Wheel wheel, SteeringWheel stuur, Chassise chassise) {
		super();
		this.body = body;
		this.wheel = wheel;
		this.stuur = stuur;
		this.chassise = chassise;
	}



	public String assemble() {
		return String.format("De auto bevat nu %s %s %s %s", body.getBody(),wheel.getWheel(),stuur.getsteeringWheel(),chassise.getChasis());
	}

}
