package DataStrucutre;

public class Department {
	private String DepName;
	private String fileName;
	public HashTable table = new HashTable(1);

	public Department() {
	}

	public Department(String depName, String fileName) {
		super();
		DepName = depName;
		this.fileName = fileName;
	}

	public String getDepName() {
		return DepName;
	}

	public void setDepName(String depName) {
		DepName = depName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		String str = "";
		str += "\n Department Name : " + this.getDepName();
		str += "\n Dep File Name  :  " + this.getFileName();

		str += "\n############################################################################\n";
		return str;
	}

	public String info() {
		return DepName + "/" + fileName;
	}

}
