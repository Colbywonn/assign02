package assign02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * For testing the Library class.
 *
 * @author CS 2420 course staff, Colby Miller, and Todd Sorensen 
 * @version ***FILL IN THE DATE***
 */
public class LibraryTest {
	private Library emptyLibrary, tinyLibrary, smallLibrary;

	@BeforeEach
	void setUp() throws Exception {
		emptyLibrary = new Library();

		tinyLibrary = new Library();
		tinyLibrary.add(9780374292799L, "Friedman", "Thomas L.", "The World is Flat");
		tinyLibrary.add(9780330351690L, "Krakauer", "Jon", "Into the Wild");
		tinyLibrary.add(9780446580342L, "Baldacci", "David", "Simple Genius");

		smallLibrary = new Library();
		smallLibrary.addAll("src/assign02/Mushroom_Publishing.txt");
	}

	// -------------------------------------------------------------------------
	// Provided tests
	// -------------------------------------------------------------------------

	@Test
	public void testEmptyLookupISBN() {
		assertEquals(-1, emptyLibrary.lookup(978037429279L));
	}

	@Test
	public void testEmptyLookupPatron() {
		ArrayList<LibraryBook> booksCheckedOut = emptyLibrary.lookup(123);
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
	public void testTinyLibraryLookupISBN() {
		assertEquals(-1, tinyLibrary.lookup(9780330351690L));
	}

	@Test
	public void testTinyLibraryLookupPatron() {
		tinyLibrary.checkOut(9780330351690L, 123, 10, 1, 2024);
		ArrayList<LibraryBook> booksCheckedOut = tinyLibrary.lookup(123);

		assertNotNull(booksCheckedOut);
		assertEquals(1, booksCheckedOut.size());
		assertEquals(new Book(9780330351690L, "Krakauer", "Jon", "Into the Wild"), booksCheckedOut.get(0));
		assertEquals(123, booksCheckedOut.get(0).getPatron());
	}

	@Test
	public void testTinyLibraryCheckOut() {
		assertTrue(tinyLibrary.checkOut(9780330351690L, 123, 10, 1, 2024));
	}

	@Test
	public void testTinyLibraryCheckInISBN() {
		tinyLibrary.checkOut(9780330351690L, 123, 10, 1, 2024);
		assertTrue(tinyLibrary.checkIn(9780330351690L));
	}

	@Test
	public void testTinyLibraryCheckInPatron() {
		assertFalse(tinyLibrary.checkIn(123));
	}

	// -------------------------------------------------------------------------
	// Student-supplied tests
	// -------------------------------------------------------------------------

	@Test
	public void testSmallLibraryLookupPatron() {
	    	assertTrue(smallLibrary.checkOut(9781843190004L, 123, 10, 1, 2024)); // Line 1 in Mushroom_Publishing.txt
	    	assertTrue(smallLibrary.checkOut(9781843190479L, 123, 10, 1, 2024)); // Line 11
	    	assertTrue(smallLibrary.checkOut(9781843193319L, 123, 10, 1, 2024)); // Line 23
		ArrayList<LibraryBook> booksCheckedOut = smallLibrary.lookup(123);

		assertNotNull(booksCheckedOut);
		assertEquals(3, booksCheckedOut.size());
		assertEquals(new Book(9781843190004L, "Caldecott", "Moyra", "Weapons of the Wolfhound"), booksCheckedOut.get(0));
		assertEquals(new Book(9781843190479L, "Burns", "Anthony J D", "Demogorgon Rising"), booksCheckedOut.get(1));
		assertEquals(new Book(9781843193319L, "Akers", "Alan Burt", "Transit to Scorpio"), booksCheckedOut.get(2));
		assertEquals(123, booksCheckedOut.get(0).getPatron());
		assertEquals(123, booksCheckedOut.get(1).getPatron());
		assertEquals(123, booksCheckedOut.get(2).getPatron());
	}
}