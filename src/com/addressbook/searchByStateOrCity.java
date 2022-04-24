package com.addressbook;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class searchByStateOrCity extends AddressBookMain {
	
	Set<Contacts> searchContact;
	static Scanner sc;
	
	public searchByStateOrCity(Set<Contacts> contact) {
		this.searchContact = new HashSet<Contacts>();
	}

	
}
