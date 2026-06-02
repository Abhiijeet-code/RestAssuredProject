package testdata;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonInclude(JsonInclude.Include.NON_EMPTY)
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_ABSENT)

@JsonIgnoreProperties(value = {"age","gender"})
public class EmployeeJsonInclude {
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private boolean isMarried;
	private String[] hobbies;
	
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	//@JsonIgnore
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private List<String> degree;
	
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
	
	public List<String> getDegree()
	{
		return degree;
	}
	public void setDegree(List<String> degree)
	{
		this.degree = degree;
	}
}
