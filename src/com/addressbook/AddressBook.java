package com.addressbook;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AddressBook implements IAddressBook {

	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	String email;
	String name;
	int i;
	long zip;
	long phoneNumber;

	Set<Contacts> contacts;
	static Scanner sc;

	public AddressBook() {
		this.contacts = new HashSet<Contacts>();
	}

	Contacts contact = new Contacts(firstName, lastName,
			address, city, state, zip, phoneNumber, email);

	@Override
	public void addContact() {

		System.out.println(
				"---------------------1. Add New contact ------------------------\n");
		sc = new Scanner(System.in);
		System.out.println(
				"Plese enter the number of contacts to add");
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
				System.out.println(
						"Please enter the details for the contact"
								+ i + "\n");
				System.out.print("Enter the First name : ");
				firstName = sc.next();
				if (checkDuplicate(firstName)) {
					System.out.println(
							"First Name already exists, please try with other name");
				} else {
					contact.setFirstName(firstName);
					System.out.print(
							"Enter the Last name : ");
					contact.setLastName(sc.next());
					System.out.print("Enter the city : ");
					contact.setCity(sc.next());
					System.out.print("Enter the State : ");
					contact.setState(sc.next());
					System.out
							.print("Enter the email id : ");
					contact.setEmail(sc.next());
					System.out
							.print("Enter the PinCode : ");
					try {
						contact.setZip(sc.nextLong());
					} catch (Exception e) {
						System.out.print(
								"Please only enter Numerical digits");
						System.out.print(
								"Please enter the PinCode again : ");
						contact.setZip(sc.nextLong());
					}
					System.out.print(
							"Enter the phoneNumber : ");
					try {
						contact.setPhoneNumber(
								sc.nextLong());
					} catch (Exception e) {
						System.out.print(
								"Please only enter Numerical digits");
						System.out.print(
								"Please enter the Phonenumber again : ");
						contact.setPhoneNumber(
								sc.nextLong());
					}
					contacts.add(contact);
					System.out.println(
							"Contact created successfully!!!!!\n");
				}
//			}

		}
	}

	@Override
	public void editContact() {

		System.out.println(
				"-----------------------2.Edit Contact--------------------------------------------\n");
		System.out.println(contacts);

		Scanner s = new Scanner(System.in);
		System.out.println(
				" \n Please enter the FirstName to edit");
		String name = s.nextLine();
//		boolean isContactFound = contacts.stream().anyMatch(
//				c -> c.getFirstName().equals(name));

		if (isContactFound(name)) {
			Contacts contact = contacts.stream().filter(
					c -> c.getFirstName().equals(name))
					.findFirst().get();
			System.out.print("Enter the First name : ");
			contact.setFirstName(s.next());
			System.out.print("Enter the Last name : ");
			contact.setLastName(s.next());
			System.out.print("Enter the city : ");
			contact.setCity(s.next());
			System.out.print("Enter the State name : ");
			contact.setState(s.next());
			System.out.print("Enter the email id : ");
			contact.setEmail(s.next());
			System.out.print("Enter the PinCode : ");
			contact.setZip(s.nextLong());
			System.out.print("Enter the phoneNumber : ");
			contact.setPhoneNumber(s.nextLong());
			System.out.print(
					"Contacts edited successfully \n");
		} else {
			System.out.print("No Contact found");
		}
		contacts.add(contact);
	}

	@Override
	public void deleteContact() {
		System.out.println(
				"-----------------------4.Delete Contact--------------------------------------------\n");
		showContacts();

		Scanner sc = new Scanner(System.in);
		System.out.println(
				"\nEnter the firstName to delete the contact:");

		name = sc.nextLine();
//		boolean isContactFound = contacts.stream().anyMatch(
//				c -> c.getFirstName().equals(name));

		if (isContactFound(name)) {
			Contacts contact = contacts.stream().filter(
					c -> c.getFirstName().equals(name))
					.findFirst().get();
			System.out.println(
					"Are you sure you want to delete contact??\n please type y to confirm");
			String choice = sc.nextLine();
			if (choice.equalsIgnoreCase("y")) {
				contacts.remove(contact);
				System.out.println(
						"Contact Deleted Successfully");
			} else {
				System.out.println("Contact not deleted");
			}
		} else {
			System.out.println("Sorry...No contact found");
		}
	}

	@Override
	public void showContacts() {
		System.out.println(
				"------------Printing Contacts--------------");
		if (contacts.isEmpty()) {
			System.out.println(
					"Your list is Empty....No contacts found");
		} else {
			// contacts.add(contact);
			contacts.forEach(c -> {
				System.out.print("firstName=" + c.firstName
						+ ", lastName=" + c.lastName
						+ ", address=" + c.address
						+ ", city=" + c.city + ", state="
						+ c.state + ", email=" + c.email
						+ ", zip=" + c.zip
						+ ", phoneNumber=" + c.phoneNumber
						+ "]\n");
			});
		}
	}

	public boolean isContactFound(String name) {
		boolean isContactFound = contacts.stream().anyMatch(
				c -> c.getFirstName().equals(name));
		return true;

	}

	public boolean checkDuplicate(String f1irstName) {
		int duplicate = contacts.stream()
				.anyMatch(d -> d.getFirstName()
						.equalsIgnoreCase(firstName)) ? 1
								: 0;
		return duplicate == 1;
	}

	@Override
	public void searchContact(Set<Contacts> contacts) {
		int flag = 0;
		sc = new Scanner(System.in);
		System.out.print(
				"Please enter the State or city to find the contacts");
		String search = sc.next();

		boolean searchCity = contacts.stream()
				.anyMatch(cityOrState -> cityOrState
						.getCity().equalsIgnoreCase(search)
						|| cityOrState.getState()
								.equalsIgnoreCase(search));
		if (searchCity) {
			System.out.println("the contact " + search
					+ " is found in the AddressBook");
		}
		for (Contacts cityOrState : contacts) {
			if (cityOrState.getState()
					.equalsIgnoreCase(search)
					|| cityOrState.getCity()
							.equals(search)) {
				flag = 1;
				contacts.add(cityOrState);
			} else {
				System.out.println(
						" No records found with this city or state");
			}
		}

	}
//	public void searchByStateOrCity(String name,Map<String, Set<Contacts>> contacts) {
//		sc = new Scanner(System.in);
//		System.out.print("Please enter the State or city to find the contacts");
//		name = sc.next();
//		boolean search = contacts.

	@Override
	public void searchContact() {
		// TODO Auto-generated method stub

	}
}
