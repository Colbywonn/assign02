package assign02;

import java.util.Objects;

/**
 * Represents a book, in which the ISBN (unique), author, and title information
 * cannot change once the book is created.
 *
 * @author CS 2420 course staff and ***PROGRAMMING PAIR: FILL IN YOUR NAMES***
 * @version ***FILL IN THE DATE***
 */
public class Book {
	private long isbn;
	private String authorSurname;
	private String authorOtherName;
	private String title;

	/**
	 * Creates a book from the given ISBN, author, and title.
	 *
	 * @param isbn            - unique id for this book
	 * @param authorSurname   - last name for this book's author
	 * @param authorOtherName - rest of name for this book's author
	 * @param title           - title for this book
	 */
	public Book(long isbn, String authorSurname, String authorOtherName, String title) {
		this.isbn = isbn;
		this.authorSurname = authorSurname;
		this.authorOtherName = authorOtherName;
		this.title = title;
	}

	/**
	 * Gets the surname of this book's author. (NOTE: Surname is the same as last
	 * name or family name.)
	 *
	 * @return surname of this book's author
	 */
	public String getAuthorSurname() {
		return this.authorSurname;
	}

	/**
	 * Gets the other name of this book's author. (NOTE: Other name is a first or
	 * given name and optional middle name or initial.)
	 *
	 * @return other name of this book's author
	 */
	public String getAuthorOtherName() {
		return this.authorOtherName;
	}

	/**
	 * Gets the ISBN for this book.
	 *
	 * @return ISBN for this book
	 */
	public long getIsbn() {
		return this.isbn;
	}

	/**
	 * Gets the title for this book.
	 *
	 * @return title for this book
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Generates a textual representation of this book.
	 *
	 * @return user-friendly string containing information for this book
	 */
	@Override
	public String toString() {
		return this.isbn + ", " + this.authorOtherName + " " + this.authorSurname + ", \"" + this.title + "\"";
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorOtherName, authorSurname, Long.valueOf(isbn), title);
	}

	/**
	 * Determines whether this book is the same as a given object. Two books are
	 * considered equal if they have the same ISBN, author, and title information.
	 *
	 * @param other - object begin compared with this book
	 * @return true if other is a Book type and is equal to this book, false
	 *         otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Book))
			return false;
		Book other = (Book) obj;
		return Objects.equals(authorOtherName, other.authorOtherName)
				&& Objects.equals(authorSurname, other.authorSurname) && isbn == other.isbn
				&& Objects.equals(title, other.title);
	}

}