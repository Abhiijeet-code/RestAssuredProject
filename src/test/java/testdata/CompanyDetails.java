package testdata;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class CompanyDetails {
	
	@JsonPropertyOrder({
        "companyName",
        "street",
        "city",
        "state",
        "pincode",
        "bankAccounts",
        "employeelist"
})
	
	private String companyName;
	private String street;
	private String city;
	private String state; 
	private int pincode;
	private List<String> bankAccounts;
	private List<EmployeePOJO> employeelist;
	
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public List<String> getbankAccounts() {
		return bankAccounts;
	}
	public void setbankAccounts(List<String> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	public List<EmployeePOJO> getEmployeelist() {
		return employeelist;
	}
	public void setEmployeelist(List<EmployeePOJO> employeelist) {
		this.employeelist = employeelist;
	}

}
