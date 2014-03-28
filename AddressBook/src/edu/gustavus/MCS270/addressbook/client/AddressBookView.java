package edu.gustavus.MCS270.addressbook.client;

import java.util.List;

import javax.jdo.annotations.Persistent;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
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
		RootPanel root = RootPanel.get();
		root.clear();
		HorizontalPanel vPanel = createMenuButtons();
		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.add(vPanel);
		root.add(hPanel);
	}

	
	public void viewContactPage(List<Contact> contacts){
		RootPanel root = RootPanel.get();
		root.clear();
		HorizontalPanel hPanel = createMenuButtons();
		
		VerticalPanel vPanel = new VerticalPanel();
		
		HorizontalPanel sortPanel = new HorizontalPanel();

		Button name = new Button();
		name.setText("Sort Name");
		name.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				control.sort("name");
				
			}
			
		});
		
		
		sortPanel.add(name);
		Button zip = new Button();
		zip.setText("Sort Zip");
		zip.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				control.sort("zip");
				
			}
			
		});
		
		
		vPanel.add(sortPanel);
		sortPanel.add(zip);
		for(Contact c: contacts){
			vPanel.add(contactRow(c));
		}
		hPanel.add(vPanel);
		
		root.add(hPanel);

	}
	
	public HorizontalPanel contactRow(final Contact contact){
		
		HorizontalPanel hPanel = new HorizontalPanel();
		Label name = new Label();
		name.setText(contact.getFirstName() + " " + contact.getLastName());
		hPanel.add(name);
		
		Label zip = new Label();
		zip.setText(contact.getZip());
		hPanel.add(zip);
		
		Button info = new Button();
		info.setText("More Info");
		info.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				
				moreInfoMessage(contact);
			}
			
		});
		hPanel.add(info);
		
		Button delete = new Button();
		delete.setText("Delete");
		delete.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				control.deleteContact(contact);
				
			}
			
		});
		hPanel.add(delete);
		hPanel.setWidth("400px");
		hPanel.setSpacing(20);
		return hPanel;
	}
	public void moreInfoMessage(Contact contact) {
		Window.alert(contact.toString());
	}
	
	private HorizontalPanel createMenuButtons() {
		
		VerticalPanel vPanel = new VerticalPanel();
		
		
		//create a VIEW CONTACTS button
		Button viewContactsButton = new Button();
		viewContactsButton.setText("View Contacts");
		viewContactsButton.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				control.getContactsFromServer();
				
			}
			
		});
		
		
		
		//create an ADD CONTACTS button (David is a nerd)
		Button addContactButton = new Button();
		addContactButton.setText("Add Contact");
		addContactButton.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				viewAddContactPage();
				
			}
			
		});
		
		
		Button searchButton = new Button();
		searchButton.setText("Search");
		searchButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				doContactSearch();
			}
	      });
		
		Button sortButton = new Button();
		sortButton.setText("sort");
		searchButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				doContactSearch();
			}
	      });
		
		

		vPanel.add(searchButton);
		vPanel.add(viewContactsButton);
		vPanel.add(addContactButton);
		
		vPanel.setSpacing(5);
		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.add(vPanel);
		return hPanel;
		
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
	
	private void viewAddContactPage(){
		RootPanel root = RootPanel.get();
		root.clear();
		HorizontalPanel vPanel = createMenuButtons();
		vPanel.add(makeAddContactPanel(null));
		root.add(vPanel);
	}
	
	
	private HorizontalPanel makeAddContactPanel(final Contact contact) {
		final HorizontalPanel contactPanel = new HorizontalPanel();
		VerticalPanel textFieldFormPanel = new VerticalPanel();
		textFieldFormPanel.addStyleName("submitPostVertPanel");
		contactPanel.add(textFieldFormPanel);
		
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
		addContactButton = new Button("Add Contact to Address Book");
		addContactButton.setText("Add Contact to Address Book");
		
		addContactButton.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				
				
				
				Contact contact = new Contact();
				
				String fName = fNameTextbox.getText();
				String lName = lNameTextbox.getText();
				String address = addressTextbox.getText();
				String city = cityTextbox.getText();
				String state = stateTextbox.getText();
				String zip = zipTextbox.getText();
				String email = emailTextbox.getText();
				String phone = phoneNumberTextbox.getText();
				
				contact.setFirstName(fName);
				contact.setLastName(lName);
				contact.setAddress(address);
				contact.setCity(city);
				contact.setState(state);
				contact.setZip(zip);
				contact.setEmail(email);
				contact.setPhoneNumber(phone);
				
				
				if(fName.equals(""))
					contact.setFirstName("Tucker");
				if(lName.equals(""))
					contact.setLastName("Saude");
				if(address.equals(""))
					contact.setAddress("800 West College Ave");
				if(city.equals(""))
					contact.setCity("St. Peter");
				if(state.equals(""))
					contact.setState("MN");
				if(zip.equals(""))
					contact.setZip("55303");
				if(email.equals(""))
					contact.setEmail("tsaude@gustavus.edu");
				if(phone.equals(""))
					contact.setPhoneNumber("763-203-2712");
				
				
				
				control.handleAddContact(contact);
				
			}
			
		});
		
		
		textFieldFormPanel.add(addContactButton);
		
		
		return contactPanel;
		
	}
	
	
}
