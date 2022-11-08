import java.util.Hashtable;

public class Library extends Building {

  private Hashtable<String, Boolean> collection;

    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String,Boolean>();
    }
    //Overloaded constructor with name 
    public Library(String name) {
      super(name); 
    }

    //Overloaded constructor with name and address
    public Library(String name, String address) {
     super(name, address); 
    }

    public void addTitle(String title){
      collection.put(title, true);
    }
    public String removeTitle(String title){
      collection.remove(title);
      return title;
    }

    public void checkOut(String title){
      collection.replace(title, true, false);
     }

    public void returnBook(String title){
      collection.replace(title, false, true);
    }

    public boolean containsTitle(String title){
      if (collection.contains(title)){
        return true;}
      else{
        return false;}
      }

    public boolean isAvailable(String title){
      Boolean return_value = true;
      if (collection.contains(title)){
        if (collection.get(title) == true){
          return_value = true;
          }
      else{
        return_value = false;}
      }
      return return_value;}

    public void printCollection(){
      System.out.println(collection.toString());
    }
    public void goToFloor(int floorNum){
      super.goToFloor(floorNum);
     }
    public void goUp(int floor){
      int floors_travelled = floor - this.activeFloor;
      if(floor <= nFloors){
        if(floors_travelled > 0){
            this.goToFloor(this.activeFloor + floors_travelled);}
      else{
        throw new RuntimeException("Invalid action, please try again with a different floor that is above your current floor.");}
      }}

    public void goDown(int floor) {
      int floors_travelled = this.activeFloor - floor;
      if(floor >= 1){
          if(floors_travelled > 0){
              this.goToFloor(this.activeFloor - floors_travelled);}
      else{
        throw new RuntimeException("Invalid action, please try again with a different floor that's below your current floor.");}}
    }

    public void showOptions(){
      super.showOptions();
      System.out.println(" + addTitle(String title) \n + removeTitle(String title) \n + checkOut(String title) \n + returnBook(String title) \n + containsTitle(String title) \n + isAvailable(String title) \n + printCollection() ");
    }
  
    public static void main(String[] args) {
      System.out.println("------------------------------------");
      System.out.println("Test of Library constructor/methods");
      System.out.println("------------------------------------");
      Library forbes = new Library("Forbes", "Green St", 3);
      System.out.println(forbes);
      forbes.showOptions();
      System.out.println("-----------------------------------");
      System.out.println("Demonstrating enter/exit/navigation");
      System.out.println("-----------------------------------");
      forbes.enter();
      forbes.goUp(3);
      forbes.goDown();
      forbes.exit();

    }
  
  }