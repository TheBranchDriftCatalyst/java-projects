package project1REDO;

/**
 * Abstract class representing an item in a library catalog.
 * Different types of media are represented as subclasses.
 * Common functionality includes checking in and out items.
 */
abstract public class LibraryItem implements Comparable<LibraryItem>
{
    private String title;
    private int year;
    private boolean checkedOut;
    
    /**
     * Constructs a library item with the specified title and year.
     * @param title of the item
     * @param year of publication
     */
    public LibraryItem(String title, int year) 
    {
        this.title = title;
        this.year = year;
        this.checkedOut = false;
    }

    /**
     * Sets the checkout status of the item (if it needs changing)
     * It will print out the result to the standard output
     * @param checkedOut new wanted status of item (true == check-out, 
     * false == check-in)
     */
    public void setCheckedOut(boolean checkedOut)
    {
    	if (this.checkedOut != checkedOut) {
            this.checkedOut = checkedOut;
            System.out.println("Item " + title + " is now checked-" +
               (checkedOut ? "out" : "in"));
        } else {
        	System.out.println("Item was already checked "
               + (checkedOut ? "out" : "in") + "!");
        }
    }

    /**
     * Returns true if item is currently checked out.
     * @return checked out status
     */
    public boolean checkedOut(){
    	
        return checkedOut;
    }


    public int compareTo(LibraryItem other){
    	
    	return this.title.compareToIgnoreCase(other.title);
    		
   	}

    /**
     * Returns the type of item (book, DVD, magazine, etc.)
     */
    abstract public String getType();
	
    /**
     * Overwrites the default toString() to return a full description
     * of the item.
     */
    public String toString()
    {
        return this.getType() + " -- " + this.title + " (" + this.year + ") " + " -- ";
    }
    
    public String getTitle(){
    	return this.title;
    }
    
    public int getYear(){
    	return this.year;
    }
}
