package edu.gustavus.MCS270.addressbook.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.gustavus.MCS270.addressbook.shared.Contact;

public interface AddressBookServiceAsync {

	void submitContactToServer(Contact contact, AsyncCallback<String> callback);

	void getContactsFromServer(AsyncCallback<List<Contact>> callback);

	void deleteContactFromServer(Contact contact, AsyncCallback<String> callback);

	void getSearchResultsFromServer(String search,
			AsyncCallback<List<Contact>> callback);

	void getSortedResultsFromServer(String typeOfSort,
			AsyncCallback<List<Contact>> callback);

}
