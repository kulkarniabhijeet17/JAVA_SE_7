public abstract class BaseEmployee {
	private int employeeId;
	private String firstName, lastName;

	public String getFullName(String firstName, String lastName) {
		return firstName + " " + lastName;
	}

	public int getSalary() {
		return 0;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}