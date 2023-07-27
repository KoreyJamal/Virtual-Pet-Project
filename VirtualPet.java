import java.util.concurrent.ThreadLocalRandom;

public class VirtualPet {
  
  private String name;
  private String description;
  private int hunger;
  private int thirst;
  private int boredom;
  private int waste;
  private int tiredness;
  

  // Constructors
  // public VirtualPet(String name, String description, int hunger, int thirst, int boredom, int tiredness, int waste) {
  //   this.name = name;
  //   this.description = description;
  //   this.hunger = 5;
  //   this.thirst = 5;
  //   this.boredom = 5;
  //   this.tiredness = 5;
  //   this.waste = 0;
  // }

  public VirtualPet(String name, String description){
    this.name = name;
    this.description = description;
    this.hunger = ThreadLocalRandom.current().nextInt(1, 10);
    this.thirst = ThreadLocalRandom.current().nextInt(1, 10);
    this.boredom = ThreadLocalRandom.current().nextInt(1, 10);
    this.tiredness = ThreadLocalRandom.current().nextInt(1, 10);
    this.waste = ThreadLocalRandom.current().nextInt(1, 10);

  }


  // Getters and Setters

  public String getName(){
    return name;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description){
    this.description = description;
  }


  public int getHunger() {
    return hunger;
  }

  public void setHunger(int hunger) {
    this.hunger = hunger;
  }

  public int getThirst() {
    return thirst;
  }

  public void setThirst(int thirst) {
    this.thirst = thirst;
  }

  public int getBoredom() {
    return boredom;
  }

  public void setBoredom(int boredom) {
    this.boredom = boredom;
  }

  public int getWaste() {
    return waste;
  }

  public void setWaste(int waste) {
    this.waste = waste;
  }

  


  public int getTiredness() {
    return tiredness;
  }


  public void setTiredness(int tiredness) {
    this.tiredness = tiredness;
  }

  



  //Methods

  public void feed(){
    tick();
    hunger-= 5;
    thirst+= 2;
    waste+= 2;
    if (hunger < 0){
      hunger = 0;
    }
  }

  public void giveWater(){
    tick();
    thirst-= 5;
    waste+= 1;
    if (thirst < 0){
      thirst = 0;
    }
  }

  public void play(){
    tick();
    System.out.println(name + " had fun playing");
    boredom-= 6;
    tiredness+= 2;
    if (boredom < 0){
      boredom = 0;
    }
  }

  void useBathroom(){
    tick();
    waste-= 7;
    if (waste < 0){
      waste = 0;
    }
  }

  public void sleep(){
    tick();
    tiredness-= 5;
    hunger+= 2;
    thirst+=2;
    if (tiredness < 0){
      tiredness = 0;
    }
  }

  public void tick(){
    hunger++;
    thirst++;
    boredom++;
    tiredness++;
    waste++;

  }

  public String toString(){
    return name + " - the " + description+"\n"+ "Hunger: " + hunger+"\n"+ "Thirst: "+ thirst+"\n"+"Boredom: "+ boredom+"\n"+"Tiredness: "+ tiredness+"\n"+ "Waste: "+ waste;

  }


  public void displayStatus() {
    tick();
    System.out.println("Hunger: " + hunger);
    System.out.println("Thirst: " + thirst);
    System.out.println("Boredom: " + boredom);
    System.out.println("Tiredness: " + tiredness);
    System.out.println("Waste: " + waste);
  }
}
