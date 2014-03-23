package edu.gustavus.MCS270.addressbook.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;

import edu.gustavus.MCS270.addressbook.shared.Contact;

public class AddressBookView {
	
	final PopupPanel searchPopup = new PopupPanel(false);
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
		
		
		HorizontalPanel hPanel = new HorizontalPanel();
		VerticalPanel vPanel = new VerticalPanel();
		
		
		//create a VIEW CONTACTS button
		Button viewContactsButton = new Button();
		viewContactsButton.setText("View Contacts");
		
		//create an ADD CONTACTS button (David is a nerd)
		Button addContactButton = new Button();
		addContactButton.setText("Add Contact");
		
		Button SearchButton = new Button();
		SearchButton.setText("Search");
		SearchButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				doContactSearch();
			}
	      });
		
		
		root.add(hPanel);
		hPanel.add(vPanel);
		vPanel.add(viewContactsButton);
		vPanel.add(addContactButton);
		
		
	}
	
	
	protected void doContactSearch() {		
		VerticalPanel content = new VerticalPanel();
		content.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		HorizontalPanel inputRow = new HorizontalPanel();
		Label searchTermLabel = new Label("Search Title Term: ");
		final TextBox searchTermTextBox = new TextBox();
		inputRow.add(searchTermLabel);
		inputRow.add(searchTermTextBox);
		
		HorizontalPanel btnRow = new HorizontalPanel();
		btnRow.setStyleName("search-button-row");
		Button cancelBtn = new Button("Cancel");
		cancelBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				searchPopup.hide();
			}
	      });
		Button searchBtn = new Button("Search");
		searchBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				control.handleTitleSearchRequest(searchTermTextBox.getText());
				searchPopup.hide();
			}
	      });
		btnRow.add(cancelBtn);
		btnRow.add(new Label(""));
		btnRow.add(searchBtn);
		
		content.add(inputRow);
		content.add(btnRow);
		searchPopup.setWidget(content);
		searchPopup.center();
	}
	
	private FormPanel makeAddContactForm(final Contact contact) {
		final FormPanel contactFormPanel = new FormPanel();
		VerticalPanel textFieldFormPanel = new VerticalPanel();
		textFieldFormPanel.addStyleName("submitPostVertPanel");
		contactFormPanel.add(textFieldFormPanel);
		
		// First Name Input 
		HorizontalPanel fNameRow = new HorizontalPanel();
		Label fNameLabel = new Label("First Name");
		final TextBox fNameTextbox = new TextBox();
		fNameRow.add(fNameLabel);
		fNameRow.add(fNameTextbox);
		textFieldFormPanel.add(fNameRow);
				
		// Last Name Input
		HorizontalPanel lNameRow = new HorizontalPanel();
		Label lNameLabel = new Label("Last Name");
		final TextBox lNameTextbox = new TextBox();
		lNameRow.add(lNameLabel);
		lNameRow.add(lNameTextbox);
		textFieldFormPanel.add(lNameRow);
				
		// Address input
		HorizontalPanel addressRow = new HorizontalPanel();
		Label addressLabel = new Label("Address");
		final TextBox addressTextbox = new TextBox();
		addressRow.add(addressLabel);
		addressRow.add(addressTextbox);
		textFieldFormPanel.add(addressRow);
				
		// City Input
		HorizontalPanel cityRow = new HorizontalPanel();
		Label cityLabel = new Label("City");
		final TextBox cityTextbox = new TextBox();
		cityRow.add(cityLabel);
		cityRow.add(cityTextbox);
		textFieldFormPanel.add(cityRow);
		
		// State Input
		HorizontalPanel stateRow = new HorizontalPanel();
		Label stateLabel = new Label("State");
		final TextBox stateTextbox = new TextBox();
		stateRow.add(stateLabel);
		stateRow.add(stateTextbox);
		textFieldFormPanel.add(stateRow);
				
		// Zip Input
		HorizontalPanel zipRow = new HorizontalPanel();
		Label zipLabel = new Label("ZIP Code");
		final TextBox zipTextbox = new TextBox();
		zipTextbox.setVisibleLength(6);
		zipRow.add(zipLabel);
		zipRow.add(zipTextbox);
		textFieldFormPanel.add(zipRow);
				
		// E-mail Input
		HorizontalPanel emailRow = new HorizontalPanel();
		Label emailLabel = new Label("E-mail");
		final TextBox emailTextbox = new TextBox();
		emailRow.add(emailLabel);
		emailRow.add(emailTextbox);
		textFieldFormPanel.add(emailRow);
		
		// Phone Number Input
		HorizontalPanel phoneNumberRow = new HorizontalPanel();
		Label phoneNumberLabel = new Label("Phone");
		final TextBox phoneNumberTextbox = new TextBox();
		phoneNumberRow.add(phoneNumberLabel);
		phoneNumberRow.add(phoneNumberTextbox);
		textFieldFormPanel.add(phoneNumberRow);
		
		if(contact!=null) {
			fNameTextbox.setText(contact.getFirstName());
			lNameTextbox.setText(contact.getLastName());
			addressTextbox.setText(contact.getAddress());
			cityTextbox.setText(contact.getCity());
			stateTextbox.setText(contact.getState());
			//zipTextbox.setText(contact.getZip());
			emailTextbox.setText(contact.getEmail());
			//phoneNumberTextbox.setText(contact.getPhoneNumber());
		}
		
		//Add to Address Book Button
		Button addContactButton;
		if(contact != null){
			addContactButton = new Button("Submit Contact Changes");
			addContactButton.setText("Submit Contact Changes");
		}	else {
			addContactButton = new Button("Add Contact to Address Book");
			addContactButton.setText("Add Contact to Address Book");
		}
		textFieldFormPanel.add(addContactButton);
		
	}
	
	
}
