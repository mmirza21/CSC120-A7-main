/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building {
  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private Boolean hasElevator;

  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }
  //Overloaded constructor with residents
  public House(String name, String address, int nFloors, boolean hasDiningRoom, ArrayList<String> residents ) {
    super(name, address, nFloors);
    this.residents = residents;
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: 🏠");
  }

    /**
   * Checks if the house has a dining room
   * @return True or False: if the house has dining room or not
   */
  public boolean hasDiningRoom(){
    return hasDiningRoom;
 }

  public int nResidents(){
    return residents.size();
  }

  public void moveIn(String name){
    residents.add(name);
  }
// Overloaded moveOut() methods that can remove a person from the house both 
//by name and by their index on the residents ArrayList.
  public String moveOut(String name){
    residents.remove(name);
    return name;
  }
  public String moveOut(int index){
    name = residents.get(index);
    residents.remove(index);
    return name;}

  public boolean isResident(String person){
    if (residents.contains(person)){
      return true;}
    else{
      return false;
    }
    }

    public void goToFloor(int floorNum){
      super.goToFloor(floorNum);
     }
    public void goUp(int floor){
      int floors_travelled = floor - this.activeFloor;
      if(floor <= nFloors){
        if(floors_travelled > 0){
          if(hasElevator == true){
            this.goToFloor(this.activeFloor + floors_travelled);}
          else if(hasElevator == false){
            System.out.println("There is no elevator in this building so you'll have to take the stairs one level up." );
            this.goToFloor(this.activeFloor + 1);}
        }
      else{
        throw new RuntimeException("Invalid action, please try again with a different floor that is above your current floor.");}
      }}

    public void goDown(int floor) {
      int floors_travelled = this.activeFloor - floor;
      if(floor >= 1){
          if(floors_travelled > 0){
            if(hasElevator == true){
              this.goToFloor(this.activeFloor - floors_travelled);}
            else if(hasElevator == false){
              System.out.println("There is no elevator in this building so you'll have to take the stairs one level down." );
              this.goToFloor(this.activeFloor - 1);}
          }
      else{
        throw new RuntimeException("Invalid action, please try again with a different floor that's below your current floor.");}}
    }

  public void showOptions(){
    super.showOptions();
    System.out.println(" + hasDiningRoom() \n + nResidents() \n + moveIn(name) \n + moveOut(name)\n + isResident(person)");
  }
  public static void main(String[] args) {
    System.out.println("------------------------------------");
    System.out.println("Test of House constructor/methods");
    System.out.println("------------------------------------");
    House baldwin = new House("Baldwin", "15 Bedford Terrace", 4, false, false);
    System.out.println(baldwin);
    baldwin.showOptions();
    System.out.println("-----------------------------------");
    System.out.println("Demonstrating enter/exit/navigation");
    System.out.println("-----------------------------------");
    baldwin.enter();
    baldwin.goUp(3);
    baldwin.goDown();
    baldwin.exit();
  }

}