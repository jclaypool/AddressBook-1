package edu.gustavus.MCS270.addressbook.client;

import com.google.gwt.core.client.EntryPoint;

import edu.gustavus.MCS270.addressbook.shared.Contact;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class AddressBook implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	
	
	private final AddressBookView view = new AddressBookView();
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		view.setControl(AddressBook.this);
		
		view.viewWelcomePage();
		
	}
	public void handleTitleSearchRequest(String text) {
		System.out.println(text);
		
		//waiting for the Tucker-tron to build ViewContactService (working on sorting)
		
	}
	public void handleSortRequest(String nameOrZip) {
		// TODO Auto-generated method stub
		System.out.println(nameOrZip);
		
	}
	public void handleAddContact(Contact contact) {
		// TODO Auto-generated method stub
		
		
		
	}
}
