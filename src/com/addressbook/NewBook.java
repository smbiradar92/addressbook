package com.addressbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class NewBook extends AddressBookMain {

	List<NewBook> newbook = new ArrayList<NewBook>();
	static String addbook;

	public void newAddressBook() {

		Iterator<NewBook> newBook = newbook.iterator();
		Scanner s = new Scanner(System.in);
		System.out.println(
				"enter the number Addressbook to store");
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			if (i <= n) {
				System.out.println(
						"Enter the name of first Address Book");
				addbook = s.next();
				showMainMenu();
				printBook();
			}
		}
	}
	public List<NewBook> printBook() {
		System.out.println(
				"-----------------------Print AddressBook--------------------------------------------\n");

		if (newbook.isEmpty()) {
			System.out.println("No Records FOUND!!!");
		} else {
			for (NewBook newBook : newbook) {
				System.out.println(newbook);
			}
		}
		return newbook;
	}

	@Override
	public String toString() {
		return "NewBook [newbook=" + newbook + ", addbook="
				+ addbook + "]";
	}

}
