/* This is a stub for the Cafe class */
public class Cafe extends Building {
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of to-go cups remaining in inventory

    public Cafe(String name, String address, int nFloors, int coffee, int sugar, int cream, int cups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = coffee;
        this.nSugarPackets = sugar;
        this.nCreams = cream;
        this.nCups = cups;
        System.out.println("You have built a cafe: ☕");
    }
    //Say we need two sellCoffee methods, since we need to record the number of to-go cups we have
    //for customers who take their coffee to go
    //but we have a different method that does not take in nCups for customers who don't
    //take to-go cups but instead use in-store reusable mugs.
    //Overloaded method for sellCoffee, one that has nCups has a parameter and one that does not.
    public void sellCoffee(int size, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces = this.nCoffeeOunces - size;
        this.nSugarPackets = this.nSugarPackets - nSugarPackets;
        this.nCreams = this.nCreams - nCreams;
        this.nCups = this.nCups - nCups;
        if (this.nCoffeeOunces < 0 || this.nSugarPackets < 0 || this.nCreams <0 || this.nCups <0){
            restock(50, 50, 50,50);
        }
    }
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        this.nCoffeeOunces = this.nCoffeeOunces - size;
        this.nSugarPackets = this.nSugarPackets - nSugarPackets;
        this.nCreams = this.nCreams - nCreams;
        if (this.nCoffeeOunces < 0 || this.nSugarPackets < 0 || this.nCreams <0){
            restock(50, 50, 50);
        }
    }
    //Overloaded methods for restock, one that has to-go cups and one that does not count them
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams){
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
    }
    public void showOptions(){
        super.showOptions();
        System.out.println(" + sellCoffee(size, nSugarPackets, nCreams, nCups) \n + restock(nCoffeeOunces, nSugarPackets, nCreams, nCups)");
    }
    public void goToFloor(int floorNum){
        //super.goToFloor(floorNum);
        if (floorNum != 1){
            System.out.println("Sorry, customers can only be on the first floor!");
        }
        else{
            System.out.println("You're on the first floor of this wonderful Cafe!");
        }
      }
       
    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println("Test of Cafe constructor/methods");
        System.out.println("------------------------------------");
        Cafe roost = new Cafe("Roost", "1 Market St", 2, 50, 50, 50, 50);
        System.out.println(roost);
        roost.showOptions();
        System.out.println("-----------------------------------");
        System.out.println("Demonstrating enter/exit/navigation");
        System.out.println("-----------------------------------");
        roost.enter();
        roost.goUp();
        roost.goDown();
        roost.exit();
    }
    
}
