package com.addressbook;

import java.util.Scanner;

public class InputUtil {

	private final static Scanner sc = new Scanner(System.in);  
	
	AddressBook data;
	
	public InputUtil() {
	
		data = new AddressBook();
	}
	public static int getIntValue() {
		return sc.nextInt();
	}
	
	public static long getLongValue() {
		return sc.nextLong();
	}

	public static String getStringValue() {
		return sc.next();
	}

}
