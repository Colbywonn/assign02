package assign02;

import java.util.GregorianCalendar;

/**
 * Represents a library book, an extension of Book, which adds fields for
 * patrons and due dates. The ID of the patron is generic.
 *
 * @author Colby Miller, and Todd Sorensen
 * @version September 10, 2026
 */
public class LibraryBookGeneric<Type> extends Book {

    private Type patron;
    private GregorianCalendar dueDate;

    /**
     * Constructs a LibraryBookGeneric using the given ISBN, author names, and book
     * title. Sets the patron ID and due date to null.
     *
     * @param isbn            - ISBN number of the book
     * @param authorSurname   - last name of the author of the book
     * @param authorOtherName - given name of the author of the book
     * @param title           - title of the book
     */
    public LibraryBookGeneric(long isbn, String authorSurname, String authorOtherName, String title) {
	super(isbn, authorSurname, authorOtherName, title);
	patron = null;
	dueDate = null;
    }

    /**
     * A method that returns the current patron of the book. Null is a book in the
     * library.
     *
     * @return the ID of a patron
     */
    public Type getPatron() {
	return patron;
    }

    /**
     * A method that returns the due date of a checked out book.
     *
     * @return GregorianCalendar object representing the due date of the book
     */
    public GregorianCalendar getDueDate() {
	return dueDate;
    }

    /**
     * Updates the contents of the LibraryBook object by checking out the book to a
     * new patron.
     *
     * @param newPatron  - the patron that is checking out the book
     * @param newDueDate - the date that the book must be returned by
     */
    public void checkout(Type newPatron, GregorianCalendar newDueDate) {
	patron = newPatron;
	dueDate = newDueDate;
    }

    /**
     * Sets the library book's patron ID and the due date to null, representing
     * removing the book from circulation.
     */
    public void checkIn() {
	patron = null;
	dueDate = null;
    }
}
