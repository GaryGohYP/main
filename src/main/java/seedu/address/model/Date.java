package seedu.address.model;

/**
 * Represents a date in the address book.
 */
public class Date {

    /** String representation of the date */
    private String date;

    public Date(String date) {
        this.date = date;
    }

    /**
     *
     * @return whether this date is a valid date.
     */
    public boolean isValid() {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Date) {
            Date otherDate = (Date) obj;
            return date.equals(otherDate.date);
        } else {
            return false;
        }
    }
}