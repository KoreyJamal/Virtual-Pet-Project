import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class VirtualPetShelter {
  
  private Map<String, VirtualPet> pets = new HashMap<>();

  // Return a *Collection* pets in shelter
  public Collection<VirtualPet>showAllPets(){
    return pets.values();
  }

  // Return a specific VirtualPet given its name
  public VirtualPet getName(String name){
    return pets.get(name);
  }

  public void receivePetNames(){
    for (VirtualPet pet : pets.values()){
      System.out.println(pet.getName());
    }
  }

  // Check if pet is in shelter
  public boolean isPetAvailable(String petName){
    return pets.containsKey(petName);
  }

  // Allow intake of a homeless pet (adding a pet to the shelter)
  public void intakePet(VirtualPet takePet){
    pets.put(takePet.getName(), takePet);
  }

  // Allow adoption of a homeless pet (Removing a pet from the shelter)
  public void adoptedPet(String name){
    pets.remove(name);
  }

  // Feed all of the pets in the shelter
  public void feedAllPets(){
    for (Entry<String, VirtualPet> hungryPet : pets.entrySet()){
      hungryPet.getValue().feed();
    }
    System.out.println("Thank you for feeding all the pets");
    tickAllPets();
  }

  // Water all of the pets in the shelter
  public void giveAllPetsWater(){
    for (VirtualPet thirstyPet : pets.values()){
      thirstyPet.giveWater();
    }
    System.out.println("Thank you for giving the pets water!");
    tickAllPets();
  }

  // Plays (or performs some other interaction(s)) with an individual pet in the shelter
  public void playWithOnePet(String petName){
    pets.get(petName).play();
    tickAllPets();
  }

  // Takes all pets to use bathroom
  public void takeAllPetToBathroom(){
    for (VirtualPet bathroomPet : pets.values()){
      bathroomPet.useBathroom();;
    }
    System.out.println("Thank you for taking pets to use the bathroom");
    tickAllPets();
  }

  public void allPetsTakeNap(){
    for (VirtualPet sleepyPet : pets.values()){
      sleepyPet.sleep();
    }
    System.out.println("All the animals feel refreshed after their nap. Thank you!");
    tickAllPets();
  }

  // Include a tick method that calls the tick method for each of the pets in the shelter
  // updting their needs
  public void tickAllPets(){
    for (VirtualPet pet : pets.values()){
      pet.tick();
    }
  }

  public void getNameAndDescription(){
    for (VirtualPet pet : pets.values()){
      System.out.println(pet.getName().toUpperCase() + " - " + pet.getDescription()+"\n"+ "Hunger: "+ pet.getHunger()+"\n"+ "Thirst: " + pet.getThirst()+
      "\n"+ "Boredom: "+ pet.getBoredom()+"\n"+ "Tiredness: " + pet.getTiredness()+"\n"+ "Waste: " + pet.getWaste()
      + "\n" + "========================================================================================================================");
      System.out.println();
    }
  }
}
