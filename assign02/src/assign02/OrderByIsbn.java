package assign02;

import java.util.Comparator;

/**
 * Defines a custom comparison for library books, using ISBN.
 *
 * @author CS 2420 course staff
 * @version September 3, 2026
 */
public class OrderByIsbn<Type> implements Comparator<LibraryBookGeneric<Type>> {
	/**
	 * Compares two library books, using ISBN.
	 *
	 * @return positive integer if the first library book's ISBN is larger, negative
	 *         integer if the first library book's ISBN is smaller, 0 if the ISBNs
	 *         are the same
	 */
	@Override
	public int compare(LibraryBookGeneric<Type> firstBook, LibraryBookGeneric<Type> secondBook) {
		if (firstBook.getIsbn() < secondBook.getIsbn()) {
		    return -1;
		}
		if (firstBook.getIsbn() > secondBook.getIsbn()) {
		    return 1;
		}
		return 0;
	}
}