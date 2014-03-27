package edu.gustavus.MCS270.addressbook.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.gustavus.MCS270.addressbook.shared.Contact;


@RemoteServiceRelativePath("submitcontact") 
public interface AddressBookService extends RemoteService {
	public String submitContactToServer(Contact contact);
	public List<Contact> getContactsFromServer();
	public String deleteContactFromServer(Contact contact);
	public List<Contact> getSearchResultsFromServer(String search);
	public List<Contact> getSortedResultsFromServer(String typeOfSort);
}
