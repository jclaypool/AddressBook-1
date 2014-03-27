package edu.gustavus.MCS270.addressbook.client;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.core.java.util.Collections;

import edu.gustavus.MCS270.addressbook.shared.Contact;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class AddressBook implements EntryPoint {

	
	private final AddressBookServiceAsync addressBookService = GWT
			.create(AddressBookService.class);
	
	private final AddressBookView view = new AddressBookView();

	public void onModuleLoad() {
		view.setControl(this);
		
		view.viewWelcomePage();
		
	}
	public void handleTitleSearchRequest(String text) {
		System.out.println(text);
		
		addressBookService.getSearchResultsFromServer(text, new AsyncCallback<List<Contact>>(){

			@Override
			public void onFailure(Throwable caught) {
				System.out.println("Fail at search");
				
			}

			@Override
			public void onSuccess(List<Contact> result) {
				view.viewContactPage(result);
				
			}


			
		});
		
	}
	public void handleSortRequest(String nameOrZip) {
		// TODO Auto-generated method stub
		System.out.println(nameOrZip);
		
	}
	public void handleAddContact(Contact contact) {
		// TODO Auto-generated method stub
		
		addressBookService.submitContactToServer(contact, new AsyncCallback<String>(){

			@Override
			public void onFailure(Throwable caught) {
				System.out.println("FAIL!");
				
			}

			@Override
			public void onSuccess(String result) {
				System.out.println("success. awww yiss");
				
			}
			
		});
		System.out.println(contact.toString());
		
		
	}
	public void getContactsFromServer() {
		addressBookService.getContactsFromServer(new AsyncCallback<List<Contact>>(){

			@Override
			public void onFailure(Throwable caught) {
				System.out.println("Didnt get contacts");
				
			}

			@Override
			public void onSuccess(List<Contact> result) {
				System.out.print(result.toString());
				view.viewContactPage(result);
			}
		});
		
	}
	public void deleteContact(Contact contact) {
		addressBookService.deleteContactFromServer(contact, new AsyncCallback<String>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				System.out.println("FAIL at delete");
			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				System.out.println("Success");
				getContactsFromServer();
			}
			
		});
		
	}
	
	public void sort(String nameOrZip) {
		addressBookService.getSortedResultsFromServer(nameOrZip, new AsyncCallback<List<Contact>>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				System.out.println("FAilrue!");
			}

			@Override
			public void onSuccess(List<Contact> result) {
				// TODO Auto-generated method stub
				view.viewContactPage(result);
				
			}
			
		});
	}
}
