package com.jspiders.designpattern.creationalmain;

import com.jspiders.designpattern.creational.Contact;
import com.jspiders.designpattern.creational.ContactBuilder;

public class ContactMain {

	public static void main(String[] args) {
		Contact contact=new ContactBuilder().mobile(123456789).firstName("Minal").lastName("Kullarkar").buildContact();
		System.out.println(contact);
	}
}
