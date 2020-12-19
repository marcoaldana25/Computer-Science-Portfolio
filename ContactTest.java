/*
 * CS-320 Software Test Automation & QA
 * Project One
 * Marco Aldana
 * Date: 12/06/2020
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import contact.Contact;

import org.junit.jupiter.api.Test;

class ContactTest 
{
	@Test
	void testValidContact() 
	{
		Contact contact = new Contact("12345", "Marco", "Aldana", "1234567890", "123 Address Way");
		
		assertTrue(contact.GetContactId().equals("12345"));
		assertTrue(contact.GetFirstName().equals("Marco"));
		assertTrue(contact.GetLastName().equals("Aldana"));
		assertTrue(contact.GetPhoneNumber().equals("1234567890"));
		assertTrue(contact.GetAddress().equals("123 Address Way"));
	}

	@Test
	void testContact_NullContactId_ShouldThrowIllegalArgumentException() 
	{
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Marco", "Aldana", "1234567890", "123 Address Way");	
		});
	}
	
	@Test
	void testContact_EmptyStringContactId_ShouldThrowIllegalArgumentException()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("", "Marco", "Aldana", "1234567890", "123 Address Way");
		});
	}
	
	@Test
	void testContact_ContactIdExceeds10Characters_ShouldThrowIllegalArgumentException() 
	{
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678911", "Marco", "Aldana", "1234567890", "123 Address Way");	
		});
	}
	
	@Test
	void testContact_NullFirstName_ShouldThrowIllegalArgumentException() 
	{
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", null, "Aldana", "1234567890", "123 Address Way");	
		});
	}
	
	@Test
	void testContact_EmptyStringFirstName_ShouldThrowIllegalArgumentException()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "", "Aldana", "1234567890", "123 Address Way");
		});
	}
	
	@Test
	void testContact_FirstNameExceeds10Characters_ShouldThrowIllegalArgumentException() 
	{
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "MarcoMarcoA", "Aldana", "1234567890", "123 Address Way");	
		});
	}
	
	@Test
	void testContact_LastNameNull_ShouldThrowIllegalArgumentException() 
	{
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Marco", null, "1234567890", "123 Address Way");	
		});
	}
	
	@Test
	void testContact_EmptyStringLastName_ShouldThrowIllegalArgumentException()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Marco", "", "1234567890", "123 Address Way");
		});
	}
	
	@Test
	void testContact_LastNameExceeds10Characters_ShouldThrowIllegalArgumentException() 
	{
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Marco", "AldanaAldana", "1234567890", "123 Address Way");	
		});
	}
	
	@Test
	void testContact_PhoneNumberNull_ShouldThrowIllegalArgumentException() 
	{
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Marco", "Aldana", null, "123 Address Way");
		});
	}
	
	@Test
	void testContact_EmptyStringPhoneNumber_ShouldThrowIllegalArgumentException()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Marco", "Aldana", "", "123 Address Way");
		});
	}
	
	@Test
	void testContact_PhoneNumberBelow10Digits_ShouldThrowIllegalArgumentException() 
	{
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Marco", "Aldana", "123456789", "123 Address Way");
		});
	}
	
	@Test
	void testContact_PhoneNumberAbove10Digits_ShouldThrowIllegalArgumentException() 
	{
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Marco", "Aldana", "12345678911", "123 Address Way");
		});
	}
	
	
	@Test
	void testContact_AddressNull_ShouldThrowIllegalArgumentException() 
	{
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Marco", "Aldana", "1234567890", null);
		});
	}
	
	@Test
	void testContact_EmptyStringAddress_ShouldThorowIllegalArgumentException() 
	{
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Marco", "Aldana", "1234567890", "");
		});
	}
	
	@Test
	void testContact_AddressExceeds30Characters_ShouldThrowIllegalArgumentException() 
	{
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"12345",
					"Marco",
					"Aldana",
					"1234567890",
					"There are way too many charactrers in this string to be considered a valid address");
		});
	}
}
