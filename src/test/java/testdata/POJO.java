package testdata;

public class POJO {

	public static void main(String []args)
	{
		Person person = new Person("abhijeet","patil",26);
		
		System.out.println(person.getFirstName());
		System.out.println(person.getLastName());
		System.out.println(person.getAge());
		
	}
}
