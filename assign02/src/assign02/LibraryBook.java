package assign02;

import java.util.GregorianCalendar;

public class LibraryBook extends Book {

	private int patron;
	private GregorianCalendar dueDate;

	public LibraryBook(long isbn, String authorSurname, String authorOtherName, String title) {
		super(isbn, authorSurname, authorOtherName, title);
		patron = -1;
		dueDate = null;
	}

	public int getPatron() {
		return patron;
	}

	public GregorianCalendar getDueDate() {
		return dueDate;
	}

	public void checkout(int newPatron, GregorianCalendar newDueDate) {
		patron = newPatron;
		dueDate = newDueDate;
	}

	public void checkin() {
		patron = -1;
		dueDate = null;
	}

}
