/*
 * CS-320 Software Test Automation & QA
 * Project One
 * Marco Aldana
 * Date: 12/06/2020
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import contact.Contact;

import contact.ContactService;

import org.junit.jupiter.api.Test;

public class ContactServiceTest 
{
	@Test
	void AddContact_ValidContact_NoExistingEntries_ShouldAddSuccessfully() 
	{
		Contact contactToAdd = new Contact("12345", "Marco", "Aldana", "1234567890", "123 Address Way");
		
		ContactService contactService = new ContactService();
		
		// Assert that the add was successful and returns true.
		assertTrue(contactService.AddContact(contactToAdd));
	}
	
	@Test
	void AddContact_ValidContact_ExistingEntriesPresent_ShouldAddSuccessfully() 
	{
		Contact initialContact = new Contact("12345", "Marco", "Aldana", "1234567890", "123 Address Way");
		Contact secondContact = new Contact("98765", "Baby", "Yoda", "9876543210", "Space Somewhere");
		
		ContactService contactService = new ContactService();
		
		// Assert Initial Add is successful
		assertTrue(contactService.AddContact(initialContact));
		
		// Assert second contact with unique ContactId is successful
		assertTrue(contactService.AddContact(secondContact));
	}
	
	@Test 
	void AddContact_InvalidSecondContact_NotUniqueId_ShouldThrowIllegalArgumentException()
	{
		Contact initialContact = new Contact("12345", "Marco", "Aldana", "1234567890", "123 Address Way");
		ContactService contactService = new ContactService();
		
		contactService.AddContact(initialContact);
		
		assertThrows(IllegalArgumentException.class, () -> {
			Contact invalidContact = new Contact("12345", "Baby", "Yoda", "9876543210", "Space Somewhere");
			
			contactService.AddContact(invalidContact);
		});
	}
	
	@Test
	void UpdateContact_ContactIdExistsInAllContacts_ShouldUpdateAndReturnContactSuccessfully() 
	{
		// Add Initial Contact
		Contact contactToAdd = new Contact("12345", "Marco", "Aldana", "1234567890", "123 Address Way");
		
		ContactService contactService = new ContactService();
		
		contactService.AddContact(contactToAdd);
		
		// New Contact with Existing ContactId
		Contact contactToUpdate = new Contact("12345", "Baby", "Yoda", "9876543210", "Space Somewhere");
		
		Contact updatedContact = contactService.UpdateContact(contactToUpdate);
		
		assertNotNull(updatedContact);
		
		// Assert that updated contact's properties match intended updated values.
		assertTrue(updatedContact.GetContactId() == contactToUpdate.GetContactId());
		assertTrue(updatedContact.GetFirstName() == contactToUpdate.GetFirstName());
		assertTrue(updatedContact.GetLastName() == contactToUpdate.GetLastName());
		assertTrue(updatedContact.GetPhoneNumber() == contactToUpdate.GetPhoneNumber());
		assertTrue(updatedContact.GetAddress() == contactToUpdate.GetAddress());
	}
	
	@Test
	void UpdateContact_NoContactIdFound_ShouldThrowIllegalArgumentException()
	{
		// Add Initial Contact
		Contact contactToAdd = new Contact("12345", "Marco", "Aldana", "1234567890", "123 Address Way");
		
		ContactService contactService = new ContactService();
		
		contactService.AddContact(contactToAdd);
		
		// New Contact with Unique ContactId
		Contact contactToUpdate = new Contact("98765", "Baby", "Yoda", "9876543210", "Space Somewhere");
		
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.UpdateContact(contactToUpdate);
		});
	}
	
	@Test
	void DeleteContact_ContactIdExistsInAllContacts_ShouldRemoveAndReturnTrue()
	{
		// Add Initial Contact
		Contact contactToAdd = new Contact("12345", "Marco", "Aldana", "1234567890", "123 Address Way");
		
		ContactService contactService = new ContactService();
		
		contactService.AddContact(contactToAdd);
		
		assertTrue(contactService.DeleteContact("12345"));
	}
	
	@Test
	void DeleteContact_ContactIdDoesNotExist_ShouldReturnFalse() 
	{
		// Add Initial Contact
		Contact contactToAdd = new Contact("12345", "Marco", "Aldana", "1234567890", "123 Address Way");
		
		ContactService contactService = new ContactService();
		
		contactService.AddContact(contactToAdd);
		
		assertFalse(contactService.DeleteContact("54321"));
	}
	
	@Test 
	void DeleteContact_ContactIdIsNull_ShouldThrowIllegalArgumentException() 
	{
		assertThrows(IllegalArgumentException.class, () -> {
			ContactService contactService = new ContactService();
			
			contactService.DeleteContact(null);
		});
	}
	
	@Test
	void DeleteContact_ContactIdIsEmptyString_ShouldThrowIllegalArgumentException()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			ContactService contactService = new ContactService();
			
			contactService.DeleteContact("");
		});
	}
	
}
