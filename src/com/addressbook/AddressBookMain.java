package com.addressbook;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args)
			throws IllegalArgumentException {

		System.out.println(
				"<================== Welcome to AddressBook ==================> ");
		HashMap<String, IAddressBook> addressBooks = new HashMap<String, IAddressBook>();

		IAddressBook familyAddressBook = new AddressBook();
		IAddressBook friendAddressBook = new AddressBook();
		IAddressBook businessAddressBook = new AddressBook();

		addressBooks.put("family", familyAddressBook);
		addressBooks.put("friend", friendAddressBook);
		addressBooks.put("business", businessAddressBook);

		int option = 0;
		while (option != 8) {
			option = showMainMenu(sc);
			String inputAddressBook = "".toLowerCase();
			if (option != 2) {
				sc = new Scanner(System.in);
				System.out.println(
						"<================== Please enter the Addressbook name to continue ==================> ");
				System.out.println(
						"family\nfriend\nbusiness");
				inputAddressBook = sc.nextLine();
			}
			try {

				IAddressBook ab = addressBooks
						.get(inputAddressBook);

				switch (option) {
				case 1:
					System.out.println(
							"<============ Add Contacts=============>");
					ab.addContact();
					break;

				case 2:
					addressBooks
							.forEach((key, addressBook) -> {
								System.out.println(
										"------------" + key
												+ "------------");
								addressBook.showContacts();
							});
					break;

				case 3:
					System.out.println(
							"<============ Edit Contacts=============>");
					ab.editContact();
					break;
				case 4:
					System.out.println(
							"<============ Showing Contacts=============>");
					ab.showContacts();
					break;
				case 5:
					System.out.println(
							"<============ Delete Contacts=============>");
					ab.deleteContact();
					break;
				case 6:
					System.out.println(
							"<============ Search Contacts=============>");
					ab.searchContact();
					break;
				case 7:
					System.out.println(
							"<============ Sorting Contacts=============>");
					ab.sortingMethod();

				case 8:
					option = 8;
					System.out.println(
							"<=========Thankyou for using Addressbook=========>\n <=========Have a nice day===========>");
					break;

				default:
					throw new IllegalArgumentException(
							"Invalid option selected");
				}
			} catch (NullPointerException e) {
				System.out.println(
						"Address book is not found with "
								+ inputAddressBook
								+ " name.");
			}

		}
		sc.close();
	}

	public static int showMainMenu(Scanner sc) {
		System.out.println(
				"\n		How would you like to continue??? \n <=========Please select from the below options ===========>\n "
						+ "| 1.Add new contact \t 2.AddressBooks \t 3.Edit contact \t 4.Print contacts |\n | 5.Delete contact\t 6. Search contacts \t"
						+ " 7. Sort contacts \t 8.Exit \t  |");
		int option = sc.nextInt();
		return option;
	}
}