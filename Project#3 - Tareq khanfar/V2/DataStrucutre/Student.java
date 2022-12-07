package DataStrucutre;

public class Student {
	private String name;
	private int id;
	private char gender;
	private double avg;

	public Student(String name, int id, double avg, char gender) {
		super();
		this.name = name;
		this.id = id;
		this.gender = gender;
		this.avg = avg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	@Override
	public String toString() {
		return name + "/" + id + "/" + avg + "/" + gender;
	}

}
