package domein;

public abstract class FileReader {
	
	private String description = "niks gebeurd";
	
	public String getDescription() {
        return description;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

}
