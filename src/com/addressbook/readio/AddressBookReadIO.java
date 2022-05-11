package com.addressbook.readio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.addressbook.Contacts;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AddressBookReadIO {

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
	static String path = "E:/Eclipse Workspace/AddressBook/JsonFiles/AddressBook.json";

	List<Contacts> contactList;

	Contacts contact = new Contacts(firstName, lastName,
			address, city, state, zip, phoneNumber, email);

	public AddressBookReadIO() {

		contactList = new ArrayList<>();
	}

	enum IOStream {

		JSON_File_Name(path);

		final String fileName;

		private IOStream(String fileName) {
			this.fileName = fileName;
			
		}

		public String getConstant() {
			return fileName;
		}
	}

	private void readJsonFile() {

		try {
			List<String> lines = Files.readAllLines(
					Paths.get(path),
					StandardCharsets.UTF_8);
			lines.forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createFileandAddContacts() {
		AddressBookReadIO addressbook = new AddressBookReadIO();
		File file = new File(
				IOStream.JSON_File_Name.getConstant());
		try {
			if (file.createNewFile()) {
				System.out.println(
						"New file is added Succefully");
				addressbook.addContact();
			} else {
				System.out.println(
						"Adding data to an existing file...");
				addressbook.addContact();
			}
			System.out.println("Reading JSON Data");
			readJsonFile();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	private void writeJsonFile() {

		Gson gson = new GsonBuilder().setPrettyPrinting()
				.create();
		String jsonString = gson.toJson(contactList);
		System.out.println("Json data : " + jsonString);
		try {
			FileWriter writer = new FileWriter(
					IOStream.JSON_File_Name.getConstant(),
					true);
			writer.write(jsonString);
			writer.close();
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

		System.out.println("Writing data to JSON");
		writeJsonFile();
		System.out.println(
				"Contact created and added successfully!!!!!\n");
	}

	public static int showMenu() {

		System.out.println(
				"Please select an option from below\n 1.Add Contact\t 2 Show Contact\t 3.Exit");
		sc = new Scanner(System.in);
		int option = sc.nextInt();
		return option;
	}

	public static void main(String[] args) {

		System.out.println(
				"<============= Welcome to AddressBook ================>");
		AddressBookReadIO getValues = new AddressBookReadIO();
		int option = 0;
		while (option != 3) {
			option = showMenu();
			switch (option) {
			case 1:
				System.out.println(
						"<============= Add Contacts ================>");
				getValues.createFileandAddContacts();
				break;
			case 2:
				System.out.println(
						"<=============  Print Contacts ================>");
				getValues.readJsonFile();
				break;
			case 3:
				System.out.println(
						"<=============Exiting AddressBook ================>");
				break;
			default:
				throw new IllegalArgumentException(
						"Unexpected value: " + option);
			}
		}

	}
}
