package com.addressbook;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args)
			throws IllegalArgumentException {

		System.out.println(
				"*************** Welcome to AddressBook ******************* ");
		HashMap<String, IAddressBook> addressBooks = new HashMap<String, IAddressBook>();

		IAddressBook familyAddressBook = new AddressBook();
		IAddressBook friendAddressBook = new AddressBook();
		IAddressBook businessAddressBook = new AddressBook();

		addressBooks.put("Family", familyAddressBook);
		addressBooks.put("Friend", friendAddressBook);
		addressBooks.put("Business", businessAddressBook);

		int option = 0;
		while (option != 7) {
			option = showMainMenu(sc);
			String inputAddressBook = "";
			if (option != 2) {
				sc = new Scanner(System.in);
				System.out.println(
						"**********Please enter the Addressbook name to save the contact to ******* ");
				System.out.println(
						"Family\nFriend\nBusiness");
				inputAddressBook = sc.nextLine();
			}
			try {
				IAddressBook ab = addressBooks
						.get(inputAddressBook);
				
				switch (option) {
				case 1:
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
					ab.editContact();
					break;
				case 4:
					ab.showContacts();
					break;
				case 5:
					ab.deleteContact();
					break;
				case 6:
					ab.searchContact();
					break;
				case 7:
					option = 5;
					System.out.println(
							"**Thankyou for using Addressbook**\n **Have a nice day**");
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
				"How would you like to continue???? \n*******Please select from the below options ***********\n 1.Add new contact \t 2.AddressBooks \t 3.Edit current contact \t 4.Print contacts \t 5.Delete contact\t 6.Exit");
		int option = sc.nextInt();
		return option;
	}
}