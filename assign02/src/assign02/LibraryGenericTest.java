package assign02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * For testing the LibraryGeneric class.
 *
 * @author CS 2420 course staff and ***PROGRAMMING PAIR: FILL IN YOUR NAMES***
 * @version ***FILL IN THE DATE***
 */
public class LibraryGenericTest {
	// library that uses names to identify patrons
	private LibraryGeneric<String> patronByNameLibrary;
	// library that uses phone numbers to identify patrons
	private LibraryGeneric<PhoneNumber> patronByPhoneLibrary;
	// an empty library
	private LibraryGeneric<Integer> emptyLibrary;

	@BeforeEach
	void setUp() throws Exception {
	    
	    	emptyLibrary = new LibraryGeneric<Integer>();
	    
		patronByNameLibrary = new LibraryGeneric<String>();
		patronByNameLibrary.add(9780374292799L, "Friedman", "Thomas L.", "The World is Flat");
		patronByNameLibrary.add(9780330351690L, "Krakauer", "Jon", "Into the Wild");
		patronByNameLibrary.add(9780446580342L, "Baldacci", "David", "Simple Genius");

		patronByPhoneLibrary = new LibraryGeneric<PhoneNumber>();
		patronByPhoneLibrary.add(9780374292799L, "Friedman", "Thomas L.", "The World is Flat");
		patronByPhoneLibrary.add(9780330351690L, "Krakauer", "Jon", "Into the Wild");
		patronByPhoneLibrary.add(9780446580342L, "Baldacci", "David", "Simple Genius");
	}

	// -------------------------------------------------------------------------
	// Provided tests
	// -------------------------------------------------------------------------

	@Test
	public void testNameCheckOut() {
		String patron = "Unique Patron Name";
		assertTrue(patronByNameLibrary.checkOut(9780330351690L, patron, 10, 1, 2024));
		assertTrue(patronByNameLibrary.checkOut(9780374292799L, patron, 10, 1, 2024));
	}

	@Test
	public void testNameLookup() {
		String patron = "Unique Patron Name";
		patronByNameLibrary.checkOut(9780330351690L, patron, 10, 1, 2024);
		patronByNameLibrary.checkOut(9780374292799L, patron, 10, 1, 2024);
		ArrayList<LibraryBookGeneric<String>> booksCheckedOut = patronByNameLibrary
				.lookup(new String("Unique Patron Name"));

		assertNotNull(booksCheckedOut);
		assertEquals(2, booksCheckedOut.size());
		assertTrue(booksCheckedOut.contains(new Book(9780330351690L, "Krakauer", "Jon", "Into the Wild")));
		assertTrue(booksCheckedOut.contains(new Book(9780374292799L, "Friedman", "Thomas L.", "The World is Flat")));
		assertEquals(patron, booksCheckedOut.get(0).getPatron());
		assertEquals(patron, booksCheckedOut.get(1).getPatron());
	}

	@Test
	public void testNameCheckIn() {
		String patron = "Unique Patron Name";
		patronByNameLibrary.checkOut(9780330351690L, patron, 10, 1, 2024);
		patronByNameLibrary.checkOut(9780374292799L, patron, 10, 1, 2024);
		assertTrue(patronByNameLibrary.checkIn(new String("Unique Patron Name")));
	}

	@Test
	public void testPhoneCheckOut() {
		PhoneNumber patron = new PhoneNumber("801.555.1234");
		assertTrue(patronByPhoneLibrary.checkOut(9780330351690L, patron, 10, 1, 2024));
		assertTrue(patronByPhoneLibrary.checkOut(9780374292799L, patron, 10, 1, 2024));
	}

	@Test
	public void testPhoneLookup() {
		PhoneNumber patron = new PhoneNumber("801.555.1234");
		patronByPhoneLibrary.checkOut(9780330351690L, patron, 10, 1, 2024);
		patronByPhoneLibrary.checkOut(9780374292799L, patron, 10, 1, 2024);
		ArrayList<LibraryBookGeneric<PhoneNumber>> booksCheckedOut = patronByPhoneLibrary
				.lookup(new PhoneNumber("801.555.1234"));

		assertNotNull(booksCheckedOut);
		assertEquals(2, booksCheckedOut.size());
		assertTrue(booksCheckedOut.contains(new Book(9780330351690L, "Krakauer", "Jon", "Into the Wild")));
		assertTrue(booksCheckedOut.contains(new Book(9780374292799L, "Friedman", "Thomas L.", "The World is Flat")));
		assertEquals(patron, booksCheckedOut.get(0).getPatron());
		assertEquals(patron, booksCheckedOut.get(1).getPatron());
	}

	@Test
	public void testPhoneCheckIn() {
		PhoneNumber patron = new PhoneNumber("801.555.1234");
		patronByPhoneLibrary.checkOut(9780330351690L, patron, 10, 1, 2024);
		patronByPhoneLibrary.checkOut(9780374292799L, patron, 10, 1, 2024);
		assertTrue(patronByPhoneLibrary.checkIn(new PhoneNumber("801.555.1234")));
	}

	// -------------------------------------------------------------------------
	// Student-supplied tests
	// -------------------------------------------------------------------------

	@Test
	public void testEmptyLookupISBN() {
		assertEquals(-1, emptyLibrary.lookup(12L));
	}

	@Test
	public void testEmptyLookupPatron() {
		ArrayList<LibraryBookGeneric<Integer>> booksCheckedOut = emptyLibrary.lookup((Integer)123);
		assertNotNull(booksCheckedOut);
		assertEquals(0, booksCheckedOut.size());
	}

	@Test
	public void testEmptyCheckOut() {
		assertFalse(emptyLibrary.checkOut(978037429279L, 123, 10, 1, 2024));
	}

	@Test
	public void testEmptyCheckInISBN() {
		assertFalse(emptyLibrary.checkIn(978037429279L));
	}

	@Test
	public void testEmptyCheckInPatron() {
		assertFalse(emptyLibrary.checkIn(123));
	}
	
	
	@Test
	public void testPatronByNameLibraryLookupPatron() {
	    	String patron = "John Doe";
	    	assertTrue(patronByNameLibrary.checkOut(9780374292799L, patron, 10, 1, 2024));
	    	assertTrue(patronByNameLibrary.checkOut(9780330351690L, patron, 10, 1, 2024));
	    	assertTrue(patronByNameLibrary.checkOut(9780446580342L, patron, 10, 1, 2024));
		ArrayList<LibraryBookGeneric<String>> booksCheckedOut = patronByNameLibrary.lookup(patron);
		
		assertEquals(3, booksCheckedOut.size());
		// Test books that were checked out to patron are same.
		assertEquals(new Book(9780374292799L, "Friedman", "Thomas L.", "The World is Flat"), booksCheckedOut.get(0));
		assertEquals(new Book(9780330351690L, "Krakauer", "Jon", "Into the Wild"), booksCheckedOut.get(1));
		assertEquals(new Book(9780446580342L, "Baldacci", "David", "Simple Genius"), booksCheckedOut.get(2));
		// Test list of books from lookup method were checked out by correct patron.
		assertEquals(patron, booksCheckedOut.get(0).getPatron());
		assertEquals(patron, booksCheckedOut.get(1).getPatron());
		assertEquals(patron, booksCheckedOut.get(2).getPatron());
	}
	
	@Test
	public void testPatronByPhoneLibraryLookupPatron() {
	    	PhoneNumber patron = new PhoneNumber("801.555.1234");
	    	assertTrue(patronByPhoneLibrary.checkOut(9781843190004L, patron, 10, 1, 2024)); // Line 1 in Mushroom_Publishing.txt
	    	assertTrue(patronByPhoneLibrary.checkOut(9781843190479L, patron, 10, 1, 2024)); // Line 11
	    	assertTrue(patronByPhoneLibrary.checkOut(9781843193319L, patron, 10, 1, 2024)); // Line 23
		ArrayList<LibraryBookGeneric<PhoneNumber>> booksCheckedOut = patronByPhoneLibrary.lookup(patron);
		
		assertEquals(3, booksCheckedOut.size());
		// Test books that were checked out to patron are same.
		assertEquals(new Book(9781843190004L, "Caldecott", "Moyra", "Weapons of the Wolfhound"), booksCheckedOut.get(0));
		assertEquals(new Book(9781843190479L, "Burns", "Anthony J D", "Demogorgon Rising"), booksCheckedOut.get(1));
		assertEquals(new Book(9781843193319L, "Akers", "Alan Burt", "Transit to Scorpio"), booksCheckedOut.get(2));
		// Test list of books from lookup method were checked out by correct patron.
		assertEquals(patron, booksCheckedOut.get(0).getPatron());
		assertEquals(patron, booksCheckedOut.get(1).getPatron());
		assertEquals(patron, booksCheckedOut.get(2).getPatron());
	}
	
	@Test
	public void testLookupPatronDoesNotExist() {
	    	String patron = "Jane Doe";
	    	assertTrue(patronByNameLibrary.checkOut(9781843190004L, patron, 10, 1, 2024)); // Line 1 in Mushroom_Publishing.txt
	    	assertTrue(patronByNameLibrary.checkOut(9781843190479L, patron, 10, 1, 2024)); // Line 11
	    	assertTrue(patronByNameLibrary.checkOut(9781843193319L, patron, 10, 1, 2024)); // Line 23
		ArrayList<LibraryBookGeneric<String>> booksCheckedOut = patronByNameLibrary.lookup("Jeff");
		assertNotNull(booksCheckedOut);
		assertEquals(0, booksCheckedOut.size());
		
	}
	
	@Test
	public void testCheckOutWhenIsbnDoesNotExist() {
	    assertFalse(patronByNameLibrary.checkOut(9780765326355L, "Johnny English", 9, 7, 2026));
	}
	
	@Test
	public void testCheckInCheckOut() {
	    PhoneNumber patron = new PhoneNumber("385-385-3855");
	    PhoneNumber patron2 = new PhoneNumber("801-801-8011");
	    assertTrue(patronByPhoneLibrary.checkOut(9781843190004L, patron, 10, 1, 2024));
	    assertFalse(patronByPhoneLibrary.checkOut(9781843190004L, patron2, 10, 1, 2024));
	    patronByPhoneLibrary.checkIn(9781843190004L);
	    assertTrue(patronByPhoneLibrary.lookup(9781843190004L) == null);
	    assertTrue(patronByPhoneLibrary.checkOut(9781843190004L, patron, 10, 1, 2024));
	}
	
	@Test
	public void testCheckOutNull() {
	    assertTrue(patronByNameLibrary.checkOut(9781843190004L, "Eleven from Stranger Things", 10, 1, 2024));
	    assertFalse(patronByNameLibrary.checkOut(9781843190004L, null, 10, 15, 2024));
	}
	
	@Test
	public void testCheckInSingleBook() {
	    PhoneNumber patron = new PhoneNumber("385-385-3855");
	    patronByPhoneLibrary.checkOut(9781843190004L, patron, 10, 1, 2024);
	    patronByPhoneLibrary.checkOut(9781843190479L, patron, 10, 1, 2024);
	    patronByPhoneLibrary.checkIn(9781843190004L);
	    assertTrue(patronByPhoneLibrary.lookup(9781843190004L) == null);
	    assertTrue(patronByPhoneLibrary.lookup(9781843190479L) == patron); 
	}
	
	@Test
	public void testCheckInAllBooks() {
	    String patron = "Gandalf the Grey";
	    patronByNameLibrary.checkOut(9781843190004L, patron, 10, 1, 2024);
	    patronByNameLibrary.checkOut(9781843190479L, patron, 10, 1, 2024);
	    patronByNameLibrary.checkIn(patron);
	    assertTrue(patronByNameLibrary.lookup(9781843190004L) == null);
	    assertTrue(patronByNameLibrary.lookup(9781843190479L) == null); 
	}
	
	@Test
	public void testCheckInNegativeOne() {
	    assertTrue(patronByNameLibrary.checkIn(null));
	}
	
	//TODO: Sorting stuff, too.
}