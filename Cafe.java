/* 
 * The {@code Cafe} class represents a cafe which extends the Building class and a few specific methods for Cafe class    
 * This class provides basic information about Cafe and methods for selling coffee and restocking.
 */
public class Cafe extends Building {
    /*
     * extra attributes needed for a cafe:nCoffeeOunces,nSugarPackets,nCreams,nCups
     */
    /* The number of ounces of coffee remaining in inventory */
    private int nCoffeeOunces; 
    /*
     * The number of sugar packets remaining in inventory
     */
    private int nSugarPackets; 
    /*
     * The number of "splashes" of cream remaining in inventory
     */
    private int nCreams;
    /*
     * The number of cups remaining in inventory
     */
    private int nCups; 

    /*
     * @param name, address, nFloors, nCoffeeOunces, nSugarPackets, nCreams, nCups
     * to construct a coffee with these values above, full constructor
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name,address,nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets= nSugarPackets;
        this.nCreams=nCreams;
        this.nCups=nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /* Default constructor */
    public Cafe() {
        this("<Name Unknown>", "<Address Unknown>", 1,0,0,0,0);
    }

    /* Overloaded constructor with name */
    public Cafe(String name) {
        this(); // Call full constructor with hard-coded # floors
        this.name = name;
    }

    /* Overloaded constructor with name, address */
    public Cafe(String name, String address){
        this();
        this.address = address;
        this.name = name;
    }

    /*Overloaded constructor with name,address,nFloors */
    public Cafe(String name, String address,int nFloors){
        this();
        this.address = address;
        this.name = name;
        this.nFloors = nFloors;
    }
    
    /*
     * @param size, nSugarP, nCream
     * reduce the amount of coffee, sugar, cream, cups according to the parameters given, restock if any of them is smaller than the parameters
     */
    public void sellCoffee(int size, int nSugarP, int nCream){
        if(nCups>=1 && nCoffeeOunces >= size && nSugarPackets>=nSugarP && nCreams>=nCream){
        nCoffeeOunces-=size;
        nSugarPackets-=nSugarP;
        nCreams-=nCream;
        nCups--;} else {
            System.out.println("Restocking needed.");
            restock(100,100,100,100);
            nCoffeeOunces-=size;
            nSugarPackets-=nSugarP;
            nCreams-=nCream;
            nCups--;
        }   
    }

    /*
     * @param CoffeeOunces, SugarPackets, Creams, Cups
     * increase the amount of coffee, sugar, cream, cups according to the parameters given
    */
    private void restock(int coffeeOunces, int sugarPackets, int creams, int cups){
        nCoffeeOunces+=coffeeOunces;
        nSugarPackets+=sugarPackets;
        nCreams+=creams;
        nCups+=cups;
        System.out.println("Restocked successfully. Can resume making coffee.");
    }
    /*
     * This print out all the available method for Cafe
     */
    public void showOptions() {
        super.showOptions();
        System.out.println("+\nsellCoffee()\n+restock()\n)");
    }
    
    public void goToFloor(int n){
        if (n>1){
            System.out.println("You are not allowed to access this floor");
        }
        else if (n==this.activeFloor&&this.activeFloor==1){
            System.out.println("You are already on this floor");
        }
        else if (this.activeFloor==-1){
            System.out.println("You are not even in the building yet.");
        }
    }
    /*
     * the main function for testing the cafe group
     */
    public static void main(String[] args) {
        // Create a Cafe with an address, number of floors, and initial inventory
         Cafe myCafe = new Cafe("Compass cafe","789 Oak St", 1, 50, 20, 20, 100);
         // Sell a cup of coffee
         System.out.println("Selling a cup of coffee...");
         myCafe.sellCoffee(12, 2, 3);
         
         // Attempt to sell another cup with insufficient ingredients
         System.out.println("Selling another cup of coffee...");
         myCafe.sellCoffee(16, 4, 4);
         
         // Print inventory after the attempted sale
         System.out.println("Inventory after attempted sale:");
         System.out.println("Coffee Ounces: " + myCafe.nCoffeeOunces);
         System.out.println("Sugar Packets: " + myCafe.nSugarPackets);
         System.out.println("Creams: " + myCafe.nCreams);
         System.out.println("Cups: " + myCafe.nCups);
         
         // Attempt to sell another cup after restocking
         System.out.println("Selling another cup of coffee after restocking...");
         myCafe.sellCoffee(23, 4, 4);
         
         // Print inventory after the successful sale
         System.out.println("Inventory after successful sale:");
         System.out.println("Coffee Ounces: " + myCafe.nCoffeeOunces);
         System.out.println("Sugar Packets: " + myCafe.nSugarPackets);
         System.out.println("Creams: " + myCafe.nCreams);
         System.out.println("Cups: " + myCafe.nCups);
             
         }
         
 }
