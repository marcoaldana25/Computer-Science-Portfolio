/*
 * CS-320 Software Test Automation & QA
 * Project One
 * Marco Aldana
 * Date: 12/06/2020
 */

package contact;

public class Contact 
{
	private String ContactId;
	
	private String FirstName;
	
	private String LastName;
	
	private String PhoneNumber;
	
	private String Address;
	
	public Contact(
			String contactId,
			String firstName,
			String lastName,
			String phoneNumber,
			String address) 
	{
		ValidateContactId(contactId);
		ValidateFirstName(firstName);
		ValidateLastName(lastName);
		ValidatePhoneNumber(phoneNumber);
		ValidateAddress(address);
	}
	
	public String GetContactId() 
	{
		return this.ContactId;
	}
	
	public String GetFirstName() 
	{
		return this.FirstName;
	}
	
	public void SetFirstName(String firstName) 
	{
		ValidateFirstName(firstName);
	}
	
	public String GetLastName() 
	{
		return this.LastName;
	}
	
	public void SetLastName(String lastName) 
	{
		ValidateLastName(lastName);
	}
	
	public String GetPhoneNumber() 
	{
		return this.PhoneNumber;
	}
	
	public void SetPhoneNumber(String phoneNumber) 
	{
		ValidatePhoneNumber(phoneNumber);
	}
	
	public String GetAddress() 
	{
		return this.Address;
	}
	
	public void SetAddress(String address) 
	{
		ValidateAddress(address);
	}

	private void ValidateContactId(String contactId) 
	{
		if (IsNullOrEmpty(contactId)) 
		{
			throw new IllegalArgumentException("Contact Id cannot be null an empty string");
		}
		
		if (!IsStringValidLength(contactId, 10)) 
		{
			throw new IllegalArgumentException("Contact Id cannot exceed 10 characters.");
		}
		
		this.ContactId = contactId;
	}
	
	private void ValidateFirstName(String firstName) 
	{
		if (IsNullOrEmpty(firstName)) 
		{
			throw new IllegalArgumentException("First Name cannot be null an empty string");
		}
		
		if (!IsStringValidLength(firstName, 10)) 
		{
			throw new IllegalArgumentException("First Name cannot exceed 10 characters");
		}
		
		this.FirstName = firstName;
	}
	
	private void ValidateLastName(String lastName) 
	{
		if (IsNullOrEmpty(lastName)) 
		{
			throw new IllegalArgumentException("Last Name cannot be null an empty string");
		}
		
		if (!IsStringValidLength(lastName, 10)) 
		{
			throw new IllegalArgumentException("Last Name cannot exceed 10 characters");
		}
		
		this.LastName = lastName;
	}
	
	private void ValidatePhoneNumber(String phoneNumber) 
	{
		if (IsNullOrEmpty(phoneNumber)) 
		{
			throw new IllegalArgumentException("Phone Number cannot be null an empty string");
		}
		
		if (phoneNumber.length() != 10) 
		{
			throw new IllegalArgumentException("Phone Number must be exactly 10 digits");
		}
		
		this.PhoneNumber = phoneNumber;
	}
	
	private void ValidateAddress(String address) 
	{
		if (IsNullOrEmpty(address)) 
		{
			throw new IllegalArgumentException("Address cannot be null an empty string");
		}
		
		if (!IsStringValidLength(address, 30)) 
		{
			throw new IllegalArgumentException("Address cannot exceed 30 characters");
		}
		
		this.Address = address;
	}
	
	private boolean IsNullOrEmpty(String stringToValidate) 
	{
		if (stringToValidate == null) 
		{
			return true;
		}
		else if(stringToValidate.isEmpty()) 
		{
			return true;
		}
		
		return false;
	}
	
	private boolean IsStringValidLength(String stringToValidate, int maximumLength) 
	{
		int stringLength = stringToValidate.length();
		
		if (stringLength > maximumLength) 
		{
			return false;
		}
		
		return true;
	}
}
