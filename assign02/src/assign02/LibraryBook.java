package assign02;

import java.util.GregorianCalendar;

/**
 * Represents a library book, an extension of book, which adds fields for
 * patrons and due dates.
 *
 * @author Colby Miller & Todd Sorensen
 * @version September 7, 2026
 */
public class LibraryBook extends Book {

    private int patron;
    private GregorianCalendar dueDate;

    /**
     * Constructor for LibraryBook. Supers the ISBN, author surname, author first name and title from the Book class.
     * Adds parameters patron and DueDate which represent who currently has the book and when it is due
     * 
     * @param isbn
     * @param authorSurname
     * @param authorOtherName
     * @param title
     */
    public LibraryBook(long isbn, String authorSurname, String authorOtherName, String title) {
	super(isbn, authorSurname, authorOtherName, title);
	patron = -1;
	dueDate = null;
    }

    /**
     * A method that returns the current patron of the book. -1 is a book in the library.
     * 
     * @return patron - an int representing the ID number of a patron.
     */
    public int getPatron() {
	return patron;
    }

    /**
     * A method that returns the due date of a checked out book.
     * 
     * @return dueDate - a GregorianCalendar object representing the due date of the
     *         book.
     */
    public GregorianCalendar getDueDate() {
	return dueDate;
    }

    /**
     * Updates the contents of the LibraryBook object by checking out the book to a
     * new patron.
     * 
     * @param newPatron  - The patron that is checking out the book
     * @param newDueDate - The date that the book must be returned by.
     */
    public void checkout(int newPatron, GregorianCalendar newDueDate) {
	patron = newPatron;
	dueDate = newDueDate;
    }

    /**
     * Sets the library book's patron to -1 and the due date to null, representing
     * removing the book from circulation.
     */
    public void checkIn() {
	patron = -1;
	dueDate = null;
    }

}
