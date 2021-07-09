public class Department extends Employee {

	private static int counter = 0;

	private String departmentName;

	public Department(String departmentName) {

		this.departmentName = departmentName;

	}

	private Employee[] department = new Employee[10];

	public void addEmp(Employee newEmployee) {
		if (counter >= 0 && counter < 10) {
			department[counter] = newEmployee;
			counter++;
			// System.out.println(counter);
		} else {
			System.out.println("Department is full!");
		}
	}

	public int getNumberOfEmployees() {
		return counter;
	}

	public Employee[] getEmployees() {
		// if(counter == 10)
		return department;

	}

	public Employee getEmpWithId(int id) {
		for (Employee emp : department) {
			if (emp != null) {
				if (emp.getID() == id) {
					return emp;
				}
			}
		}
		return null;
	}

	public double totalSalary() {
		double totalSalary = 0.0;

		for (Employee emp : department) {

			totalSalary += (emp != null) ? emp.getSalary() : 0.0;
		}

		return totalSalary;
	}

	public double averageSalary() {

		return totalSalary() / counter;

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Department: " + departmentName;
	}

}
