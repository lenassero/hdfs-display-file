package cs.bigdata.Tutorial2;

public class Tree {
	
	private String year;
	private String height;
	
	public Tree(String year, String height) {
		super();
		this.year = year;
		this.height = height;
	}
	
	public void printTree() {
		System.out.println("Year: " + this.year + ", " + "Height: " + this.height);
	}
	
	public String toString() {
		return "Year: " + this.year + ", " + "Height: " + this.height;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}
	
	}