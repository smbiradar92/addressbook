package com.addressbook;

public class AddressBookMain {

		public static void main(String[] args) {
			System.out.println("Welcome to Address Book");
			
			Contact con = new Contact();
			con.createContact();
			con.addnewContact();
			con.printContact();
			con.editContact();
			con.deleteContact();			
		}
		
	}

