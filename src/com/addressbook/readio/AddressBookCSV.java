package com.addressbook.readio;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.addressbook.Contacts;
import com.opencsv.CSVWriter;

public class AddressBookCSV {

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

	static Scanner sc;
	static String path = "E:/Eclipse Workspace/AddressBook/CSVFiles/AddressBook.CSV";
	static String[] header = { "FirstName", "LastName",
			"Address", "City", "State", "Zipcode",
			"PhoneNo", "Email" };

	List<Contacts> contactList;

	Contacts contact = new Contacts(firstName, lastName,
			address, city, state, zip, phoneNumber, email);

	public AddressBookCSV() {
		contactList = new ArrayList<>();
	}

	enum IOStream {
		CSV_File_Name(path);

		final String fileName;

		IOStream(String fileName) {
			this.fileName = fileName;
		}

		public String getConstant() {
			return fileName;
		}
	}

	private void readCSVFile() {
		Path csvpath = Paths.get(path);
		try {
			Reader reader = Files
					.newBufferedReader(csvpath);
			Files.readAllLines(csvpath)
					.forEach(System.out::println);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void readCsvFile() {

		Path csvpath = Paths.get(path);
		try {
			Files.readAllLines(csvpath)
					.forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createFileandAddContacts() {
		AddressBookCSV addressBook = new AddressBookCSV();
		File file = new File(path);
		addressBook.addContact();
		CSVWriter csv;
		try {
			csv = new CSVWriter(new FileWriter(path));
			csv.writeNext(header);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addContact() {

		System.out.print("Enter the First name : ");
		contact.setFirstName(sc.next());
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
		System.out.print("Enter the phoneNumber : ");
		contact.setPhoneNumber(sc.nextLong());
		contactList.add(contact);

		System.out.println("Writing data to csv");

		System.out.println(
				"Contact created and added successfully!!!!!\n");
	}

	public static void main(String[] args) {
		AddressBookCSV addressbook = new AddressBookCSV();
		addressbook.createFileandAddContacts();
		addressbook.readCsvFile();
	}

}