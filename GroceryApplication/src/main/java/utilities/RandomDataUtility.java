package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	
	Faker f= new Faker();
	
	public String randomUserName()
	{
		return f.name().username();// generate random usernames
	}
	
	public String randomPsw()
	{
		return f.internet().password();// generate random psws
		
	}
	
	public String randomFullName()
	{
		return f.name().fullName();
		
	}
	
	public String randomEmailid()
	{
		return f.internet().emailAddress();
	}

}
