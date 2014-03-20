package edu.gustavus.MCS270.addressbook.client;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class AddressBookView {
	private AddressBook control;
	
	public AddressBookView(){}

	public AddressBook getControl() {
		return control;
	}

	public void setControl(AddressBook control) {
		this.control = control;
	}

	public void viewWelcomePage() {
		// TODO Auto-generated method stub
		createMenuButtons();
	}

	private void createMenuButtons() {
		RootPanel root = RootPanel.get();
		
		VerticalPanel vPanel = new VerticalPanel();
		
		Button viewContactsButton = new Button();
		viewContactsButton.setText("View Contacts");
		
		Button addContactButton = new Button();
		addContactButton.setText("Add Contact");
		
		root.add(vPanel);
		vPanel.add(viewContactsButton);
		vPanel.add(addContactButton);
		
		
	}
	
	
}
