/*
 * CS-320 Software Test Automation & QA
 * Project One
 * Marco Aldana
 * Date: 12/06/2020
 */

package contact;

import java.util.ArrayList;

public class ContactService 
{
	private ArrayList<Contact> AllContacts;
	
	public ContactService() 
	{
		AllContacts = new ArrayList<Contact>();
	}
	
	public boolean AddContact(Contact contactToAdd) 
	{
		// If no contacts are present, valid contact is safe to add without further checking.
		if (AllContacts.isEmpty()) 
		{
			AllContacts.add(contactToAdd);
			return true;
		}
		
		// If elements are present, ensure the contactToAdd has a unique ContactID
		for (Contact contact : AllContacts) 
		{
			if (contact.GetContactId() == contactToAdd.GetContactId()) 
			{
				throw new IllegalArgumentException("Cannot add a new contact with an existing ContactId.");
			}
		}
				
		// At this point, All existing contacts should have been checked and the contact to add should have a unique ContactId.
		AllContacts.add(contactToAdd);
		return true;
	}
	
	public Contact UpdateContact(Contact contactToUpdate) 
	{	
		for (Contact contact : AllContacts)
		{
			if (contact.GetContactId() == contactToUpdate.GetContactId()) 
			{
				contact.SetFirstName(contactToUpdate.GetFirstName());
				contact.SetLastName(contactToUpdate.GetLastName());
				contact.SetPhoneNumber(contactToUpdate.GetPhoneNumber());
				contact.SetAddress(contactToUpdate.GetAddress());
			
				return contact;
			}
		}
		
		// if No Contact Id was found, unable to update contact since no record exists.
		throw new IllegalArgumentException("No contact ID was found with ContactID: " + contactToUpdate.GetContactId());
	}
	
	public boolean DeleteContact(String contactId) 
	{
		if (contactId == null || contactId.isEmpty()) 
		{
			throw new IllegalArgumentException("ContactId cannot be null or empty");
		}
		
		// Returns true if the contact was successfully removed. Returns false if nothing is removed.
		return AllContacts.removeIf(contact -> contact.GetContactId().equals(contactId));
	}
}
