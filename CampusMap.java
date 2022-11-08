import java.util.ArrayList;

public class CampusMap {

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
        myMap.addBuilding(new Building("Seelye Hall", "2 Seelye Drive, Northampton, MA 01063", 3));
        myMap.addBuilding(new House("Baldwin", "15 Bedford Terrace, Northampton, MA 01063", 4, false, false));
        myMap.addBuilding(new House("Albright", "11 Bedford Terrace, Northampton, MA 01063", 4, false, false));
        myMap.addBuilding(new House("Chase", "1 Elm Street, Northampton, MA 01063", 3, true, true));
        myMap.addBuilding(new Library("Forbes", "12 Green St, Northampton, MA 01063", 3));
        myMap.addBuilding(new Library("Neilson", "1 Neilson Drive, Northampton, MA 01063", 4));
        myMap.addBuilding(new Library("Hillyer", "2 Elm Street, Northampton, MA 01063", 3));
        myMap.addBuilding(new Cafe("Roost", "1 Market St, Northampton, MA 01063", 2, 50, 50, 50, 50));
        myMap.addBuilding(new Cafe("Woodstar", "1 Center St, Northampton, MA 01063", 1, 150, 150, 150, 50));
        myMap.addBuilding(new Cafe("Shelburne Falls", "39 Main St, Northampton, MA 01063", 1, 60, 70, 80, 50));
        System.out.println(myMap);
    }
    
}
