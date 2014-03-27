package edu.gustavus.MCS270.addressbook.server;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.gustavus.MCS270.addressbook.server.PMF;
import edu.gustavus.MCS270.addressbook.shared.Contact;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

public class AddressBookModel {
	static final PersistenceManagerFactory pmf = PMF.get();
	
	
	
	public static List<Contact> getContacts(){
		PersistenceManager pm = pmf.getPersistenceManager();
		Query query = pm.newQuery(Contact.class);
		List<Contact> contacts = (List<Contact>)query.execute();
		
		return new ArrayList<Contact>(contacts);
	}
	
	
	public static List<Contact> LastNameSort(){
		return null;
	}



	public static void storeContact(Contact contact) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.makePersistent(contact);
	}



	public static void deleteContact(Contact contact) {
		PersistenceManager pm = pmf.getPersistenceManager();
		try{
			pm.currentTransaction().begin();
			
			pm.deletePersistent(pm.getObjectById(Contact.class, contact.getID()));
			pm.currentTransaction().commit();
		}finally{
			if(pm.currentTransaction().isActive()){
				pm.currentTransaction().rollback();
			}if(!pm.isClosed()){
				pm.close();
			}
		}
		
	}
	
	
	public static List<Contact> getMatchedData(String searchTerm){
		List<Contact> contacts = getContacts();
		List<Contact> successfulSearch = new ArrayList<Contact>();
		for (Contact entry: contacts){
			if(entry.doesMatch(searchTerm)){
				successfulSearch.add(entry);
			}	
		}		
		return successfulSearch;
		
		
	}


	public static List<Contact> getSortedData(String typeOfSort) {
		// TODO Auto-generated method stub
		if (typeOfSort.equals("name")){
			List<Contact> contacts = getContacts();
			Collections.sort(contacts, Contact.compareByLastName);
			return contacts;
		}
		else{
			List<Contact> contacts = getContacts();
			Collections.sort(contacts, Contact.compareByZip);
			return contacts;
		}
	}
	
	
}
