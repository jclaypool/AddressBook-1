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
	
	
	
	public static List<Contact> getMatchedData(String searchTerm){
		PersistenceManager pm = pmf.getPersistenceManager();
		
		
		// searches for matches with contact id
		Query idQuery = pm.newQuery(Contact.class);
		idQuery.setFilter("this.id == searchTerm");
		idQuery.declareParameters("String searchTerm");
		
		List<Contact> contacts = (List<Contact>) idQuery.execute(searchTerm);
		
		//searches for matches with contact firstname
		Query firstNameQuery = pm.newQuery(Contact.class);
		firstNameQuery.setFilter("this.firstName == searchTerm");
		firstNameQuery.declareParameters("String searchTerm");
		List<Contact> firstNameContacts = (List<Contact>) firstNameQuery.execute(searchTerm);
		contacts.addAll(firstNameContacts);
		
		//searches for matches with contact last name
		Query lastNameQuery = pm.newQuery(Contact.class);
		lastNameQuery.setFilter("this.lastName == searchTerm");
		lastNameQuery.declareParameters("String searchTerm");
		List<Contact> lastNameContacts = (List<Contact>) lastNameQuery.execute(searchTerm);
		contacts.addAll(lastNameContacts);
		
		//searches for matches with contact address	
		Query addressQuery = pm.newQuery(Contact.class);
		addressQuery.setFilter("this.address == searchTerm");
		addressQuery.declareParameters("String searchTerm");
		List<Contact> addressContacts = (List<Contact>) addressQuery.execute(searchTerm);
		contacts.addAll(addressContacts);
		
		//searches for matches with contact city		
		Query cityQuery = pm.newQuery(Contact.class);
		cityQuery.setFilter("this.city == searchTerm");
		cityQuery.declareParameters("String searchTerm");
		List<Contact> cityContacts = (List<Contact>) cityQuery.execute(searchTerm);
		contacts.addAll(cityContacts);
		
		//searches for matches with contact state
		Query stateQuery = pm.newQuery(Contact.class);
		stateQuery.setFilter("this.state == searchTerm");
		stateQuery.declareParameters("String searchTerm");
		List<Contact> stateContacts = (List<Contact>) stateQuery.execute(searchTerm);
		contacts.addAll(stateContacts);
		
		//searches for matches with contact zip
		Query zipQuery = pm.newQuery(Contact.class);
		zipQuery.setFilter("this.zip == searchTerm");
		zipQuery.declareParameters("String searchTerm");
		List<Contact> zipContacts = (List<Contact>) zipQuery.execute(searchTerm);
		contacts.addAll(zipContacts);
		
		
		//searches for matches with contact email
		Query emailQuery = pm.newQuery(Contact.class);
		emailQuery.setFilter("this.email == searchTerm");
		emailQuery.declareParameters("String searchTerm");
		List<Contact> emailContacts = (List<Contact>) emailQuery.execute(searchTerm);
		contacts.addAll(emailContacts);
		
		//searches for matches with contact phoneNumber
		Query phoneNumberQuery = pm.newQuery(Contact.class);
		phoneNumberQuery.setFilter("this.phoneNumber == searchTerm");
		phoneNumberQuery.declareParameters("String searchTerm");
		List<Contact> phoneNumberContacts = (List<Contact>) phoneNumberQuery.execute(searchTerm);
		contacts.addAll(phoneNumberContacts);
		
		return new ArrayList<Contact>(contacts);
	}
	
	public static List<Contact> LastNameSort(){
		return null;
	}
	
	
}
