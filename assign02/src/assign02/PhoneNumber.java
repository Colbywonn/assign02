package assign02;

/**
 * Represents a phone number; e.g., 801-867-5309 where 801 is the area code, 867
 * is the trunk, and 5309 is the rest.
 *
 * @author CS 2420 course staff
 * @version September 3, 2026
 */
public class PhoneNumber {
    private String areaCode;
    private String trunk;
    private String rest;

    /**
     * Creates a phone number by parsing the given string.
     *
     * @param phoneNumberString - formatted string from which to create a
     *                          PhoneNumber object
     */
    public PhoneNumber(String phoneNumberString) {
	phoneNumberString = phoneNumberString.replaceAll("-|\\s|\\.|\\(|\\)", "");

	if (phoneNumberString.length() != 10)
	    throw new IllegalArgumentException("Phone number \"" + phoneNumberString + "\" is not formatted correctly");
	for (int i = 0; i < 10; i++)
	    if (!Character.isDigit(phoneNumberString.charAt(i)))
		throw new IllegalArgumentException(
			"Phone number \"" + phoneNumberString + "\" is not formatted correctly");

	this.areaCode = phoneNumberString.substring(0, 3);
	this.trunk = phoneNumberString.substring(3, 6);
	this.rest = phoneNumberString.substring(6, 10);
    }

    /**
     * Determines whether this phone number is the same as a given object. Two phone
     * numbers are considered equal if they have the same area code, trunk, and
     * remaining numbers.
     *
     * @param other - object begin compared with this phone number
     * @return true if other is a PhoneNumber type and is equal to this phone
     *         number, false otherwise
     */
    @Override
    public boolean equals(Object other) {
	if (!(other instanceof PhoneNumber))
	    return false;

	PhoneNumber otherPhoneNumber = (PhoneNumber) other;
	return this.areaCode.equals(otherPhoneNumber.areaCode) && this.trunk.equals(otherPhoneNumber.trunk)
		&& this.rest.equals(otherPhoneNumber.rest);
    }

    /**
     * Generates a textual representation of this phone number.
     *
     * @return formatted string for this phone number
     */
    @Override
    public String toString() {
	return "(" + this.areaCode + ") " + this.trunk + "-" + this.rest;
    }
}