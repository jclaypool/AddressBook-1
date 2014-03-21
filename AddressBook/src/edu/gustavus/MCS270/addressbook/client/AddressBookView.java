package edu.gustavus.MCS270.addressbook.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;

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
				doPostSearch();
			}
	      });
		
		
		root.add(hPanel);
		hPanel.add(vPanel);
		vPanel.add(viewContactsButton);
		vPanel.add(addContactButton);
		
		
	}
	
	
	protected void doPostSearch() {		
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
	
	
}
