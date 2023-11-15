
/* This is a stub for the Library class */
import java.util.Hashtable;
/*
 * The {@code Library} class represents a Library which extends the Building class and a few specific methods for Library class    
 * This class provides basic information about Library and methods for adding, removing, checkout, and return the books.
 */
public class Library extends Building {
  /*
  * extra attributes needed for building a library:a hashtable of collections
  */
  /*This is a hashtable for the collection of books in the Library */
  private Hashtable<String, Boolean> collection;
  /*This is a boolean indicating whether the building has elevator or not */
  private boolean hasElevator;
  /*
  * @param name,address,nFloors
  * construct a house with name, address, nFloors, and its collection
  */
  public Library(String name, String address, int nFloors,boolean hasElevator) {
    super(name,address,nFloors);
    this.hasElevator();
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }
  
  /* Default constructor */
  public Library() {
    this("<Name Unknown>", "<Address Unknown>", 1,false);
  }

  /* Overloaded constructor with name */
  public Library(String name, String address,int nFloors) {
    this(); // Call full constructor with hard-coded # floors
    this.name = name;
    this.address = address;
    this.nFloors = nFloors;
  }

  /* Overloaded constructor with name, address */
  public Library(String name, String address){
    this();
    this.address = address;
    this.name = name;
  }

  /*Overloaded constructor with only name */
  public Library(String name){
    this();
    this.name = name;
  }
    
  /*
   * @return true/false of hasElevator
   */
  public boolean hasElevator(){
    return hasElevator;
  }

  /*
   * @param title
   * add the title into collection if it doesn't include title as a key, otherwise, print a message.
   */
  public void addTitle(String title){
    if (!collection.containsKey(title)){
      collection.put(title, true);  
    } else{
      System.out.println("This title is already included in the collection.");
    }
  }

  /*
   * @param title
   * remove the title if title is included in the collection,print a message otherwise
   * @return title if removed successfully, null otherwise 
   */
  public String removeTitle(String title){
    Boolean removed = collection.get(title);
    if (removed != null && removed) {
      collection.remove(title);
      return title;} else {
      System.out.println("The title is not contained in the collection.");
      return null;
    }
  } // return the title that we removed
  /*
  * @param title
  * mark the value of the title as false if title is contained in the collection
  */
  public void checkOut(String title){
    if (collection.containsKey(title)) {
      collection.put(title, false); // Mark the title as checked out
    }
  }

  /*
  * @param title
  * mark the value of the title true if title is contained in the collection
  */
  public void returnBook(String title){
    if (collection.containsKey(title)){
      collection.put(title,true);// Mark the title as returned
    }
  }
    
  /*
   * @param title
   * @return false if not contained in collection, true if contained in collection
   */
  public boolean containsTitle(String title){
    return collection.containsKey(title);
  } // returns true if the title appears as a key in the Libary's collection, false otherwise

  /*
   * @param title
   * @return false if title's corresponding value is false, true if the corresponding value is true.
   */
  public boolean isAvailable(String title){
    return collection.get(title);
  }// returns true if the title is currently available, false otherwise

  /*
   * for each key in the collection, print each title and its value which is the availibility
   */
  public void printCollection(){
    for (String key : collection.keySet()) {
      boolean value = collection.get(key);
      System.out.println(key + ": " + value);
    }
  } 

  /*
  * print out all the options available for this object Library
  */
  public void showOptions() {
    if (!this.hasElevator){
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) + addTitle(n) + removeTitle(n) + checkout(n) + removeBook(n) + printCollection()");
    }
    else{
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp(n) \n + goDown(n)\n + goToFloor(n) + addTitle(n) + removeTitle(n) + checkout(n) + removeBook(n) + printCollection()");
    }
  }
  /*
   * @param floorNum
   * use the elevator to directly go to the floor or goUp or goDown for a number of designated times
   */
  public void goToFloor(int floorNum){
    super.goToFloor(floorNum);
  }
  
  /*
   * Check if it's in the building
   * no elevator
   * go up one floor at a time
   */
  public void goUp(){
    if(activeFloor ==-1)
  {
    throw new RuntimeException("You are not inside this Building. Must call enter() before exit().");
  }
  if (this.hasElevator){
    throw new RuntimeException("Please uses goUp(n).");
  }
  this.goToFloor(this.activeFloor + 1);
  }
  /*
   * Check if it's in the building
   * no elevator
   * go down one floor at a time
   */
  public void goDown(){
    if(activeFloor ==-1)
  {
    throw new RuntimeException("You are not inside this Building. Must call enter() before exit().");
  }
  if (this.hasElevator){
    throw new RuntimeException("Please uses goDown(n).");
  }
  this.goToFloor(this.activeFloor -1);
  }

  /*
   * check if it is in the building
   * has elevator
   * @param floor
   * go to the floor 
   */
  public void goUp(int floor){
    if(activeFloor ==-1)
    {
      throw new RuntimeException("You are not inside this Building. Must call enter() before exit().");
    }
    if(!this.hasElevator)
    {
      throw new RuntimeException("Please uses goUp().");
    }
    if(floor<=activeFloor){
      throw new RuntimeException("This elevator only goes up, please uses goDown(n).");
    }
    this.goToFloor(floor);
  }

  /*
   * check if it is in the building
   * has elevator
   * @param floor
   * go to the floor 
   */
  public void goDown(int floor){
    if(activeFloor ==-1)
    {
      throw new RuntimeException("You are not inside this Building. Must call enter() before exit().");
    }
    if(!this.hasElevator)
    {
      throw new RuntimeException("Please uses goUp().");
    }
    if(floor>=activeFloor){
      throw new RuntimeException("This elevator only goes up, please uses goDown(n).");
    }
    this.goToFloor(floor);
  }
  /*
   * main function for testing the library class
   */
  public static void main(String[] args) {
    Library myLibrary = new Library("Neilson","56 Elm St", 3,true);
    // Add books to the collection
    myLibrary.addTitle("Book 1");
    myLibrary.addTitle("Book 2");
    myLibrary.addTitle("Book 3");
    // Check out a book
    myLibrary.checkOut("Book 2");
    // Print the entire collection
    System.out.println("Library Collection:");
    myLibrary.printCollection();
    // Check if a book is available
    System.out.println("Is 'Book 1' available? " + myLibrary.isAvailable("Book 1"));
    System.out.println("Is 'Book 2' available? " + myLibrary.isAvailable("Book 2"));
    // Remove a book from the collection
    String removedBook = myLibrary.removeTitle("Book 3");
    if (removedBook != null) {
      System.out.println(removedBook + " was removed from the collection.");
    } else {
       System.out.println("The book was not removed.");
    }
    // Print the updated collection
    System.out.println("Updated Library Collection:");
    myLibrary.printCollection();
  }
    
    
}