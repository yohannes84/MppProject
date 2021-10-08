package business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.User;

public class SystemController implements ControllerInterface {
	public static Auth currentAuth = null;
	
	public void login(String id, String password) throws LoginException {
		DataAccess da = new DataAccessFacade();
		HashMap<String, User> map = da.readUserMap();
		if(!map.containsKey(id)) {
			throw new LoginException("ID " + id + " not found");
		}
		String passwordFound = map.get(id).getPassword();
		if(!passwordFound.equals(password)) {
			throw new LoginException("Password incorrect");
		}
		currentAuth = map.get(id).getAuthorization();
	}
	@Override
	public List<String> allMemberIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readMemberMap().keySet());
		return retval;
	}
	
	@Override
	public List<String> allBookIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readBooksMap().keySet());
		return retval;
	}

	public boolean addLibraryMember(String memberId, String fname, String lname, String tel,String street, String city, String state, String zip) {
		DataAccess da = new DataAccessFacade();
		Address address = new Address(street,city,state,zip);
		da.saveNewMember(new LibraryMember(memberId , fname , lname , tel , address ));

		return true;
	}

	public boolean checkoutBook(String memberId , String isbn) {
		DataAccess da = new DataAccessFacade();
		LibraryMember member = da.searchMember(memberId);
		Book book = da.searchBook(isbn);
		if(book == null || !book.isAvailable()){
			return false;
		}
		if(member == null ){
			return false;
		}
		BookCopy bookCopy = book.getNextAvailableCopy();
		int checkoutLength = book.getMaxCheckoutLength();
		member.checkout(bookCopy , LocalDate.now() , LocalDate.now().plusDays(checkoutLength));
		da.saveMember(member);
		da.saveBook(book);
		da.readMemberMap();
		da.readBooksMap();


		return true;
	}

	public boolean addCopyOfExistingBook(String isbn) {
		DataAccess da = new DataAccessFacade();

		 Book book = da.searchBook(isbn);
		 System.out.println("I got the book"+ book);
		 if(book == null) return false;
		 book.addCopy();
		 da.saveBook(book);
		return true;
	}


}
