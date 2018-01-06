package cs.bigdata.Tutorial2;

public class Station {
	
	private String usafCode;
	private String name;
	private String countryID;
	private String elevation;
	
	public Station(String usafCode, String name, String countryID,
			String elevation) {
		super();
		this.usafCode = usafCode;
		this.name = name;
		this.countryID = countryID;
		this.elevation = elevation;
	}
	
	@Override
	public String toString() {
		return "USAF_code: " + usafCode + ", Name: " + name
				+ ", Country_ID: " + countryID + ", Elevation: " + elevation;
	}

	
	

}
