package com.addressbook;

import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {

		System.out.println("Welcome to Address Book");
		Contact con = new Contact();
//		showMainMenu();
		NewBook book = new NewBook();
		book.newAddressBook();
	}

	public static void showMainMenu() {
		System.out.println(
				"Please select from the below options:\n 1.Add new contact \n 2.Delete contact \n 3.print current contact \n 4. Exit \n 5.Reselect options");
		Contact con = new Contact();
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		switch (option) {
		case 1:
			con.addnewContact();
			break;
		case 2:
			con.deleteContact();
			break;
		case 3:
			con.printContact();
			break;
		case 4:
			System.out
					.println("you can exit....\n Thankyou");
			break;
		case 5:
			showMainMenu();
			break;
		}
	}
}
