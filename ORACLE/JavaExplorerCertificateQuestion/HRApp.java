public class HRApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("HR App Starts");

		Employee emp1 = new Employee(1, "Ann", 1500);
		Employee emp2 = new Employee(2, "Jane", 2000);
		Employee emp3 = new Employee(3, "Dirk", 2200);
		Employee emp4 = new Employee(4, "Glies", 1800);
		Employee emp5 = new Employee(5, "Brien", 2500);
		Employee emp6 = new Employee(6, "Alex", 4000);
		Employee emp7 = new Employee(7, "Lieve", 6000);
		Employee emp8 = new Employee(8, "Dankun", 2000);
		Employee emp9 = new Employee(9, "Sylla", 2200);
		Employee emp10 = new Employee(10, "Jessica", 1800);
		Employee emp11 = new Employee(11, "Yale", 2220);

		Department dp1 = new Department("Department Education");
		dp1.addEmp(emp1);
		dp1.addEmp(emp2);
		dp1.addEmp(emp3);
		dp1.addEmp(emp4);
		dp1.addEmp(emp5);
		dp1.addEmp(emp6);
		dp1.addEmp(emp7);
		dp1.addEmp(emp8);
		dp1.addEmp(emp9);
		dp1.addEmp(emp10);
		dp1.addEmp(emp11);

		System.out.println(dp1);
		for (Employee emp : dp1.getEmployees()) {
			if (emp != null)
				System.out.println(emp);
		}

		System.out.println("Total Salary: " + dp1.totalSalary());

		System.out.println("Average Salary: " + dp1.averageSalary());

		System.out.println(dp1.getNumberOfEmployees());

		System.out.println(dp1.getEmpWithId(118));

	}

}
