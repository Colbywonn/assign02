package assign02;

import java.util.Comparator;

/**
 * Defines a custom comparison for library books, using author name
 * lexicographically by surname then title.
 *
 * @author Colby Miller & Todd Sorensen
 * @version September 10, 2026
 */
public class OrderByAuthor<Type> implements Comparator<LibraryBookGeneric<Type>> {
    /**
     * Compares two library books, using author name lexicographically by surname
     * then title.
     *
     * @return positive integer if the first library book's author's name appears
     *         first lexicographically, and a negative integer if the first library
     *         book's author's name appears second. Zero if both are the same.
     */
    @Override
    public int compare(LibraryBookGeneric<Type> firstBook, LibraryBookGeneric<Type> secondBook) {
	int comp = firstBook.getAuthorSurname().compareTo(secondBook.getAuthorSurname());
	if (comp != 0)
	    return comp;
	return firstBook.getTitle().compareTo(secondBook.getTitle());
    }
}
