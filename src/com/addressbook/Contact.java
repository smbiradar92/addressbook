package com.addressbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Contact {

	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	String email;
	long zip;
	long phoneNumber;

	List<AddressBook> list = new ArrayList<AddressBook>();

	AddressBook contact = new AddressBook(firstName,
			lastName, address, city, state, phoneNumber,
			zip, email);
	Scanner sc = new Scanner(System.in);

	public void addnewContact() {
		System.out.println(
				"---------------------1. Add New contact ------------------------\n");
		Iterator<AddressBook> iter = list.iterator();

		System.out.println(
				"Plese enter the number of contacts to add");
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			if (i <= N) {
				System.out.println(
						"Please enter the details below:\n");

				System.out
						.println("Enter the First name : ");
				String firstName = sc.next();

				System.out
						.println("Enter the last name : ");
				String lastName = sc.next();

				System.out.println("Enter your Address : ");
				String address = sc.next();

				System.out.println("Enter your city : ");
				String city = sc.next();

				System.out.println("Enter your State : ");
				String state = sc.next();

				System.out
						.println("Enter your e-Mail ID : ");
				String email = sc.next();

				System.out
						.println("Enter your Zip code : ");
				long zip = sc.nextLong();

				System.out.println(
						"Enter your contact number : ");
				long phoneNumber = sc.nextLong();

				list.add(new AddressBook(firstName,
						lastName, address, city, state,
						phoneNumber, zip, email));

				System.out.println(
						"Contact created successfully\n");
			}
			printContact();

		}
	}

	public List<AddressBook> printContact() {
		System.out.println(
				"-----------------------Print Contact--------------------------------------------\n");

		if (list.isEmpty()) {
			System.out.println("No Records FOUND!!!");
		} else {
			for (AddressBook contact : list) {
				System.out.println(contact);
			}
		}
		return list;
	}

	public void editContact() {

		System.out.println(
				"-----------------------2.Edit Contact--------------------------------------------\n");

		System.out.println(
				"Please enter the details as follow : ");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		boolean check = false;
		String newName = sc.next();
		ListIterator<AddressBook> iter = list
				.listIterator();
		try {
			contact = iter.next();
			if (newName.equalsIgnoreCase(
					contact.getFirstName())) {
				System.out
						.println("Enter New firstName : ");
				String firstName = sc.next();
				contact.setFirstName(firstName);

				System.out.println("Enter New lastName : ");
				String lastName = sc.next();
				contact.setLastName(lastName);

				System.out.println("Enter address : ");
				String address = sc.next();
				contact.setAddress(address);

				System.out.println("Enter city : ");
				String city = sc.next();
				contact.setCity(city);

				System.out.println("Enter state : ");
				String state = sc.next();
				contact.setState(state);

				System.out.println("Enter email id : ");
				String email = sc.next();
				contact.setEmail(email);

				System.out.println("Enter zip code : ");
				long zip = sc.nextLong();
				contact.setZip(zip);

				System.out.println("Enter phoneNumber : ");
				long phoneNumber = sc.nextLong();
				contact.setPhoneNumber(phoneNumber);
				iter.set(new AddressBook(firstName,
						lastName, address, city, state, zip,
						phoneNumber, email));
				check = true;
				System.out.println(
						"contacts edited successfully\n");
			} else {
				System.out
						.println("contact not found!!!!\n");
			}

//			sc.close();
			printContact();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteContact() {
		System.out.println(
				"-----------------------4.Delete Contact--------------------------------------------\n");

		System.out.println(
				"Enter the firstName to delete the contact");
		Scanner sc = new Scanner(System.in);
		boolean check = false;
		String existingFname = sc.nextLine();
		Iterator<AddressBook> iter = list.iterator();
		contact = iter.next();
		if (existingFname
				.equalsIgnoreCase(contact.getFirstName())) {
			iter.remove();
			check = true;
			System.out.println(
					"contact " + contact.getFirstName()
							+ " deleted successfully");

		} else {
			System.out.println("No record found for :"
					+ existingFname);
		}
		printContact();
	}
//		sc.close();
}
