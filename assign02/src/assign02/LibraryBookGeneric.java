package assign02;

import java.util.GregorianCalendar;


public class LibraryBookGeneric<Type> extends Book {

	private Type patron;
	private GregorianCalendar dueDate;

	public LibraryBookGeneric(long isbn, String authorSurname, String authorOtherName, String title) {
		super(isbn, authorSurname, authorOtherName, title);
		patron = null;
		dueDate = null;
	}

	public Type getPatron() {
		return patron;
	}

	public GregorianCalendar getDueDate() {
		return dueDate;
	}

	public void checkout(Type newPatron, GregorianCalendar newDueDate) {
		patron = newPatron;
		dueDate = newDueDate;
	}

	public void checkIn() {
		patron = null;
		dueDate = null;
	}
}
