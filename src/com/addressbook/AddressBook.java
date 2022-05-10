package com.addressbook;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class AddressBook implements IAddressBook {

	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	String email;
	String name;
	int i;
	int flag;
	Long zip;
	Long phoneNumber;

	Set<Contacts> contacts;
	static Scanner sc;

	public AddressBook() {
		this.contacts = new HashSet<Contacts>();
	}

	Contacts contact = new Contacts(firstName, lastName,
			address, city, state, zip, phoneNumber, email);

	@Override
	public void addContact() {
		
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
				System.out.print("Enter the Last name : ");
				contact.setLastName(sc.next());
				System.out.print("Enter the city : ");
				contact.setCity(sc.next());
				System.out.print("Enter the State : ");
				contact.setState(sc.next());
				System.out.print("Enter the email id : ");
				contact.setEmail(sc.next());
				System.out.print("Enter the PinCode : ");
					contact.setZip(sc.nextLong());
				System.out
						.print("Enter the phoneNumber : ");
				contact.setPhoneNumber(sc.nextLong());
				contacts.add(contact);
				System.out.println(
						"Contact created successfully!!!!!\n");
			}

		}
	}

	@Override
	public void editContact() {

		@SuppressWarnings("resource")
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
		showContacts();

		Scanner sc = new Scanner(System.in);
		System.out.println(
				"\nEnter the firstName to delete the contact:");

		name = sc.nextLine();
//		boolean isContactFound = contacts.stream().anyMatch(
//				c -> c.getFirstName().equals(name));
		try {
			if (isContactFound(name)) {
				Contacts contact = contacts.stream().filter(
						c -> c.getFirstName().equals(name))
						.findFirst().get();
				System.out.println(
						"Are you sure you want to delete contact??\n Please type 'y' to confirm");
				String choice = sc.nextLine();
				if (choice.equalsIgnoreCase("y")) {
					contacts.remove(contact);
					System.out.println(
							"Contact Deleted Successfully");
				} else {
					System.out.println(
							"Deletion Cancelled by User.......\n ===Contact not deleted===");
				}
			} else {
				System.out.println(
						"Sorry...No contact found");
			}

		} catch (NullPointerException e) {
			System.out.println(
					"Invalid data entere please retry");
			AddressBookMain.showMainMenu(sc);
		}

	}

	@Override
	public void showContacts() {
		System.out.println(
				"<==============Printing Contacts==============>");
		if (contacts.isEmpty()) {
			System.out.println(
					"Your list is Empty....No contacts found");
		} else {
			for (Contacts list : contacts) {
				System.out.println(list);
			}
//			contacts.forEach(c -> {
//				System.out.print("firstName=" + c.firstName
//						+ ", lastName=" + c.lastName
//						+ ", city=" + c.city + ", state="
//						+ c.state + ", email=" + c.email
//						+ ", zip=" + c.zip
//						+ ", phoneNumber=" + c.phoneNumber
//						+ "]\n");
//			});
		}
	}

	public boolean isContactFound(String name) {
		@SuppressWarnings("unused")
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
	public void searchContactByCityorState() {
		
		@SuppressWarnings("unused")
		int flag = 0;
		int countCountacts = 0;
		sc = new Scanner(System.in);
		System.out.println(
				"Please enter the State or city to find the contacts");
		String search = sc.nextLine();

		boolean searchCity = contacts.stream()
				.anyMatch(cityOrState -> cityOrState
						.getCity().equalsIgnoreCase(search)
						|| cityOrState.getState()
								.equalsIgnoreCase(search));
		if (searchCity) {
			System.out.println(
					"Search successufull!!!!!\n The contact "
							+ search
							+ " is found in the AddressBook");
		}
		for (Contacts cityOrState : contacts) {
			if (cityOrState.getState()
					.equalsIgnoreCase(search)
					|| cityOrState.getCity()
							.equals(search)) {
				flag = 1;
				contacts.add(cityOrState);
				countCountacts++;
				System.out.println(cityOrState);
				System.out.println(
						"The number of contacts by city or state is "
								+ countCountacts);
			} else {
				System.out.println(
						" No records found with this city or state");
			}
		}

	}

	@Override
	public void viewContactByCtyorState() {
		if (contacts.isEmpty()) {
			System.out.println("No records found");
		} else {
			System.out.println(
					"Please enter the city or state name ");
			name = sc.nextLine();
			boolean isPersonFound = contacts.stream()
					.anyMatch(p -> p.getCity()
							.equalsIgnoreCase(name))
					|| contacts.stream()
							.anyMatch(p -> p.getState()
									.equalsIgnoreCase(
											name));
			for (Contacts cityOrState : contacts) {
				if (isPersonFound) {
					System.out.println("Showing contacts:");
					System.out.println(cityOrState);
				} else {
					System.out.println(
							"No person found in the city "
									+ name);
				}
			}
		}
	}

	@Override
	public void searchContact() {
		System.out.println(
				"Please select the type of search from below options \n1. Search contact by city or state\n2. view contact by city or state\n3. Exit search");
		int option = sc.nextInt();
		switch (option) {
		case 1:
			System.out.println(
					"<=============Search Contact by City or State=============>");
			searchContactByCityorState();
			break;
		case 2:
			System.out.println(
					"<=============View Contact by City or State=============>");
			viewContactByCtyorState();
			break;
		case 3:
			System.out.println(
					"You have exited the contact search");
			break;
		default:
			System.out.println(
					"You have entered an invalid key");
		}
	}

	@Override
	public void sortingMethod() {
		System.out.println(
				"Please select from below sortong options to continue \n1. Sort contacts by Name \t2. Sort contacts by city \t3. Sort contacts by state \t4. Sort contacts by Zip\\t5. Exit Sort");
		int option = sc.nextInt();
		switch (option) {
		case 1:
			System.out.println(
					"<=============Sort By Name=============>");
			sortByName(contacts);
			break;
		case 2:
			System.out.println(
					"<=============Sort By City=============>");
			sortByCity(contacts);
			break;
		case 3:
			System.out.println(
					"<=============Sort By State=============>");
			sortByState(contacts);
			break;
		case 4:
			System.out.println(
					"<=============Sort By zip=============>");
			sortByZip(contacts);
			break;

		case 5:
			System.out.println(
					"You have successfully Exited from Sorting method");
			break;
		}

	}

	public static void sortByName(Set<Contacts> contacts) {
		List<Contacts> sortedList = contacts.stream()
				.sorted((p1, p2) -> p1.firstName
						.compareTo(p2.firstName))
				.collect(Collectors.toList());
		for (Contacts sortList : sortedList) {
			System.out.println(sortList);
		}
	}

	public static void sortByCity(Set<Contacts> contacts) {
		List<Contacts> sortedList = contacts.stream()
				.sorted((p1, p2) -> p1.city
						.compareTo(p2.city))
				.collect(Collectors.toList());
		for (Contacts sortList : sortedList) {
			System.out.println(sortList);
		}
	}

	public static void sortByState(Set<Contacts> contacts) {
		List<Contacts> sortedList = contacts.stream()
				.sorted((p1, p2) -> p1.state
						.compareTo(p2.state))
				.collect(Collectors.toList());
		for (Contacts sortList : sortedList) {
			System.out.println(sortList);
		}
	}

	public static void sortByZip(Set<Contacts> contacts) {
		List<Contacts> sortedList = contacts.stream()
				.sorted((o1, o2) -> o1.zip
						.compareTo(o2.zip))
				.collect(Collectors.toList());
		for (Contacts sortList : sortedList)
			System.out.println(sortList);

	}

}
