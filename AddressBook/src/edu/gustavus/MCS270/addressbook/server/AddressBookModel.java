package edu.gustavus.MCS270.addressbook.server;


import java.util.ArrayList;
import java.util.List;

import edu.gustavus.MCS270.addressbook.server.PMF;
import edu.gustavus.MCS270.addressbook.shared.Contact;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

public class AddressBookModel {
	static final PersistenceManagerFactory pmf = PMF.get();
	
	
	
	public static List<Contact> getContacts(){
		return null;
	}
	
	
}
