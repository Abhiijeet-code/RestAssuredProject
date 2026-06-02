package in.at.test;

import com.github.javafaker.Faker;

public class FakeDataGenerator {

	public static void main(String args[]) {
		Faker fakedata = new Faker();
		String name = fakedata.name().fullName();
		String firstName = fakedata.name().firstName();
		String lastName = fakedata.name().lastName();

		String email = fakedata.internet().safeEmailAddress();
		String password = fakedata.internet().password();

		String phoneNumber = fakedata.phoneNumber().cellPhone();
		
		System.out.println(name);
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(email);
		System.out.println(password);
		System.out.println(phoneNumber);


	}

}
