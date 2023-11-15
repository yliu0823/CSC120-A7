import java.util.ArrayList;
/*
 * The {@code CampusMap} class represents a CampusMap class    
 * This class provides basic information about buildings in campus and methods for adding and removing buildings, and a toString method to print out a list of buildings .
 */
public class CampusMap {
    /*
     * This attribute is an arraylist of all buildings 
     */
    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Seelye Hall", "2 Seelye Drive Northampton, MA 01060",3));
        myMap.addBuilding(new House("Cutter house","10 Prospect Street Northampton, MA 01063",3,true,true));
        myMap.addBuilding(new House("Talbot house","10 Prospect Street Northampton, MA 01063",5));
        myMap.addBuilding(new Cafe("Campus Cafe", "100 Elm Street Northampton, MA 01063"));
        myMap.addBuilding(new Cafe("Compass Cafe","7 Neilson Drive Northampton, MA 01063",2));
        myMap.addBuilding(new Library("Neilson Library","7 Neilson Drive Northampton, MA 01063",4,true));
        myMap.addBuilding(new House("Tyler house", "151-199 Green St, Northampton, MA 01060",4,true));
        myMap.addBuilding(new Building("Sage Hall","151-199 Green St, Northampton, MA 01060",3));
        myMap.addBuilding(new Library("Smith Art Museum Library","20 Elm St Northampton, MA 01063"));
        myMap.addBuilding(new House("Chase house","10 Elm Street Northampton, MA 01063",4));
        System.out.println(myMap);
    }
    
}
