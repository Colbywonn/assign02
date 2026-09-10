package assign02;

import java.util.Comparator;

/**
 * Defines a custom comparison for library books, using due dates.
 *
 * @author Colby Miller & Todd Sorensen
 * @version September 10, 2026
 */
public class OrderByDueDate<Type> implements Comparator<LibraryBookGeneric<Type>> {
    /**
     * Compares two library books, using due dates.
     *
     * @return positive integer if the first library book's due date is later, and a
     *         negative integer if the first library book's due date is sooner. Zero
     *         if both are the same due date.
     */
    @Override
    public int compare(LibraryBookGeneric<Type> firstBook, LibraryBookGeneric<Type> secondBook) {
	return firstBook.getDueDate().compareTo(secondBook.getDueDate());
    }
}
