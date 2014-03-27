package edu.gustavus.MCS270.addressbook.server;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.gustavus.MCS270.addressbook.client.AddressBook;
import edu.gustavus.MCS270.addressbook.client.AddressBookService;
import edu.gustavus.MCS270.addressbook.shared.Contact;

public class AddressBookServiceImpl extends RemoteServiceServlet implements
		AddressBookService {

	@Override
	public String submitContactToServer(Contact contact) {
		AddressBookModel.storeContact(contact);
		return null;
	}

	@Override
	public List<Contact> getContactsFromServer() {
		return AddressBookModel.getContacts();
	}

	@Override
	public String deleteContactFromServer(Contact contact) {
		AddressBookModel.deleteContact(contact);
		return null;
	}

	@Override
	public List<Contact> getSearchResultsFromServer(String search) {
		
		return AddressBookModel.getMatchedData(search);
	}

	@Override
	public List<Contact> getSortedResultsFromServer(String typeOfSort) {
		return AddressBookModel.getSortedData(typeOfSort);
	}

}
