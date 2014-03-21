package edu.gustavus.MCS270.addressbook.shared;

import java.io.Serializable;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class Contact implements Serializable {
		private static final long serialVersionUID = 1L;
		@PrimaryKey
		// Need to define the key this way so that a Seller can be passed
		// as data through RPC services.   
		// See https://developers.google.com/appengine/docs/java/datastore/jdo/creatinggettinganddeletingdata#Keys
		@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
		@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
		
		
		private String id;
		@Persistent
		private String firstName;
		@Persistent
		private String lastName;
		@Persistent
		private String address;
		@Persistent
		private String city;
		@Persistent
		private String state;
		@Persistent
		private int zip;
		@Persistent
		private String email;
		@Persistent
		private int phoneNumber;
		
		
		public Contact() {}

		public Contact(String fName, String lName, String a, String c,
						String s, int z, String e, int phone) {
			
			firstName = fName;
			lastName = lName;
			address = a;
			city = c;
			state = s;
			zip = z;
			email = e;
			phoneNumber = phone;
			
		}
			
			public String getFirstName() {
				return firstName;
			}
			public void setFirstName(String fName) {
				firstName = fName;
			}
			public String getLastName() {
				return lastName;
			}
			public void setLastName(String lName) {
				lastName = lName;
			}
			public String getAddress() {
				return address;
			}
			public void setAddress(String a) {
				address = a; 
			}
			public String getState() {
				return state;
			}
			public void setState(String s) {
				state = s;
			}
			public int getZip() {
				return zip;
			}
			public void setZip(int z) {
				zip = z;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String e) {
				email = e;
			}
			public int getPhoneNumber() {
				return phoneNumber;
			}
			public void setPhoneNumber(int phone) {
				phoneNumber = phone;
			}
			
}
