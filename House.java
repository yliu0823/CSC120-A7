import java.util.ArrayList;
/*
 * The {@code House} class represents a House which extends the Building class and a few specific methods for House class    
 * This class provides basic information about House and methods for adding and removing residents.
 */
public class House extends Building{
  /*
  * extra attributes needed for a House: residents and two booleans hasDiningRoom and hasElevator
  */
  /* This is an arraylist of the residents in a House */
  private ArrayList<String> residents; 
  /* This is an boolean of whether the house has a dining room or not */
  private boolean hasDiningRoom;
  /* This is an boolean of whether the house has a elevator or not */
  private boolean hasElevator;

  /*
  * @param name,address,nFloors,boolean hasDiningRoom
  * construct a house with name, address, nFloors, and its availability for dinning room
  */
  public House(String name, String address, int nFloors,boolean hasDiningRoom,boolean hasElevator) {
    super(name,address,nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }
  /* Default constructor */
  public House() {
    this("<Name Unknown>", "<Address Unknown>", 1,false,false);
  }

  /* Overloaded constructor with name,address,nFloors */
  public House(String name, String address, int nFloors) {
    this(); // Call full constructor with hard-coded # floors
    this.name = name;
    this.address = address;
    this.nFloors = nFloors;
  }

  /* Overloaded constructor with name,address,nFloors,diningroom status*/
  public House(String name, String address, int nFloors,boolean hasDiningRoom) {
    this(); // Call full constructor with hard-coded # floors
    this.name = name;
    this.address = address;
    this.nFloors = nFloors;
    this.hasDiningRoom=hasDiningRoom;
  }

  /* Overloaded constructor with name, address */
  public House(String name, String address){
    this();
    this.address = address;
    this.name = name;
  }

  /*
   * @return true/false of hasElevator
   */
  public boolean hasElevator(){
    return hasElevator;
  }

  /*
  * @return true/false of hasDiningRoom
  */
  public boolean hasDiningRoom() {
    return hasDiningRoom;
  }

  /*
  * @return number of residents in integer form
  */
  public int nResidents(){
    return residents.size();
  }

  /*
  * @param name of resident
  * add the name to the arraylist if arraylist not contains name, print a message otherwise
  */
  public void moveIn(String name){
    if(!residents.contains(name)){
      residents.add(name);
    } else{
    System.out.println("This student is already in the house!");
    }
  }

  /*
  * @param name
  * remove the name from the arraylist if arraylist contains name, print a message otherwise
  */
  public String moveOut(String name){
    if (residents.contains(name)){
      residents.remove(name);
      return name;
    } else{
      System.out.println("This student is not in this house");
      return null;
    }
  }

  /*
  * @param person
  * @return true/false about whether this person is contained in the residents ArrayList.
  */
  public boolean isResident(String person){
    return residents.contains(person);
  }

  /*
   * @ no param
   * print out the options available for the House class
   */
  public void showOptions() {
    super.showOptions();
    System.out.println("+\nhasDiningRoom()\n+nResidents()\n+moveIn(x)\n+moveOut(x)\n+isResident()");
  }
  
  /*
   * @param floorNum
   * use the elevator to directly go to the floor or goUp or goDown floor by floor
   */
  public void goToFloor(int floorNum){
    if (hasElevator){
      super.goToFloor(floorNum);
      System.out.println("You have taken the elevator and get to floor"+floorNum);
    } else {if (this.activeFloor<floorNum){
        for (int i = 0; i < floorNum-this.activeFloor; i++) {
          super.goUp();
        }
      }
      if (this.activeFloor>floorNum){
        for (int i = 0; i < this.activeFloor-floorNum;i++){
          super.goDown();
        }
      }
      System.out.println("You have got to the floor on foot");
    }
  }


  /*
   * main function for testing the class
   */
  public static void main(String[] args) {
    House myHouse = new House("Cutter","123 Main St", 2, true,true);
    myHouse.moveIn("John");
    myHouse.moveIn("Alice");
    myHouse.moveIn("Bob");

    // Check the dining room status
    System.out.println("Does the house have a dining room? " + myHouse.hasDiningRoom());

    // Check the number of residents
    System.out.println("Number of residents: " + myHouse.nResidents());

    // Check if a person is a resident
    System.out.println("Is Alice a resident? " + myHouse.isResident("Alice"));
    System.out.println("Is Mary a resident? " + myHouse.isResident("Mary"));

    // Remove a resident
    String removedPerson = myHouse.moveOut("Bob");
    if (removedPerson != null) {
        System.out.println(removedPerson + " moved out.");
    } else {
        System.out.println("The person was not a resident.");
    }

    // Check the updated number of residents
    System.out.println("Number of residents after someone moved out: " + myHouse.nResidents());
    }
  } 

