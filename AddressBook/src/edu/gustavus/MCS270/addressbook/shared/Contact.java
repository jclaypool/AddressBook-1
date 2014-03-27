package edu.gustavus.MCS270.addressbook.shared;

import java.io.Serializable;
import java.util.Comparator;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Contact implements Serializable, Comparable<Contact> {
	private static final long serialVersionUID = 5539539987489885476L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;

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
	private String zip;
	@Persistent
	private String email;
	@Persistent
	private String phoneNumber;

	public Contact() {
	}

	public Contact(String fName, String lName, String a, String c, String s,
			String z, String e, String phone) {

		firstName = fName;
		lastName = lName;
		address = a;
		city = c;
		state = s;
		zip = z;
		email = e;
		phoneNumber = phone;

	}

	@Override
	// public int compareTo(Contact other) {
	// // TODO Auto-generated method stub
	// return lastName.compareTo(other.lastName);
	// }
	public String toString() {

		return firstName + " " + lastName + "\n" + address + "\n" + city + ", "
				+ state + " " + zip + "\n" + email + "\n" + phoneNumber;

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

	public String getCity() {
		return city;
	}

	public void setCity(String c) {
		city = c;
	}

	public String getState() {
		return state;
	}

	public void setState(String s) {
		state = s;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String z) {
		zip = z;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String e) {
		email = e;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phone) {
		phoneNumber = phone;
	}

	public Long getID() {
		// TODO Auto-generated method stub
		return id;
	}
	
	
	public boolean doesMatch(String searchTerm){
		if(((((((((this.firstName.contains(searchTerm)) || (this.lastName.contains(searchTerm)) )
				|| (this.address.contains(searchTerm))) || (this.city.contains(searchTerm))) || 
				(this.zip.contains(searchTerm))) || (this.phoneNumber.contains(searchTerm))) || 
				(this.state.contains(searchTerm))) || (this.email.contains(searchTerm)))){
			System.out.println("something something broken arms");
			return true;

		}
		else{
			return false;
		}
	}
		

	@Override
	public int compareTo(Contact other) {
		// TODO Auto-generated method stub
		return lastName.compareTo(other.lastName);
	}

	public static Comparator<Contact> compareByLastName = new Comparator<Contact>() {
		public int compare(Contact one, Contact other) {
			return one.lastName.compareTo(other.lastName);
		}
	};

	public static Comparator<Contact> compareByZip = new Comparator<Contact>() {
		public int compare(Contact one, Contact other) {
			String stringZipOne = String.valueOf(one.zip);
			String stringZipOther = String.valueOf(other.zip);
			return stringZipOne.compareTo(stringZipOther);
		}
	};

}
