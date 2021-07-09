public class Employee {

	private int iD;
	private String name;
	private double salary;

	public Employee() {

	}

	public Employee(int iD, String name, double salary) {
//		super();
		this.iD = iD;
		this.name = name;
		this.salary = salary;
	}

	public int getID() {
		return iD;
	}

	public void setID(int iD) {
		this.iD = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Employee: " + iD + " " + name + " " + salary;
	}

}
