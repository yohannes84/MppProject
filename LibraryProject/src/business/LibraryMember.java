package business;

import java.io.Serializable;
import java.time.LocalDate;


import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

final public class LibraryMember extends Person implements Serializable {
	private String memberId;
	private CheckoutRecord checkoutRecord;
	
	public LibraryMember(String memberId, String fname, String lname, String tel,Address add) {
		super(fname,lname, tel, add);
		this.memberId = memberId;
		checkoutRecord = new CheckoutRecord();

	}

	public void checkout(BookCopy bookCopy , LocalDate todayDate , LocalDate updatedCheckoutLength){
		bookCopy.setVisibilityToFalse();
		CheckoutEntries checkoutEntries = CheckoutEntries.createEntry(bookCopy , todayDate , updatedCheckoutLength);
		checkoutRecord.addEntry(checkoutEntries);
	}

	
	public String getMemberId() {
		return memberId;
	}

	public CheckoutRecord getCheckoutRecord() {
		return checkoutRecord;
	}

	
	
	@Override
	public String toString() {
		return "Member Info: " + "ID: " + memberId + ", name: " + getFirstName() + " " + getLastName() + 
				", " + getTelephone() + " " + getAddress();
	}

	private static final long serialVersionUID = -2226197306790714013L;
}
