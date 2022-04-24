package com.addressbook;

import java.util.Set;

public interface IAddressBook {

	void addContact();

	void showContacts();

	void editContact();

	void deleteContact();

	void searchContact();

	void searchContact(Set<Contacts> contacts);

	
}
