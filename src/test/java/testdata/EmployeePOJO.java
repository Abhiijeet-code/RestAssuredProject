package testdata;

public class EmployeePOJO {
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private boolean isMarried;
	private EmployeeAddress address;
	
	
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isMarried() {
		return isMarried;
	}
	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
	public EmployeeAddress getAddress() {
		return address;
	}
	public void setAddress(EmployeeAddress address) {
		this.address = address;
	}
}
