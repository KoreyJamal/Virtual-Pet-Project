import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class VirtualPetShelterApp {
  public static void main(String[] args) {

    // Starting pets in the shelter
    VirtualPet pet1 = new VirtualPet("Jackson", "He is an older, cuddly cat with golden fur and yellow eyes.");
    VirtualPet pet2 = new VirtualPet("Oliver", "He is a young cat with bronze and gold fur and green eyes.");
    VirtualPet pet3 = new VirtualPet("Sammy", "He is a 7 year old bearded dragon who loves to bask in the sun.");
    VirtualPet pet4 = new VirtualPet("Bega", "He is the younger sibling of Sammy, but is larger and loves mealworms.");
    VirtualPet pet5 = new VirtualPet("Blue", "He is a younger cat with blueish grey fur and prefers all doors opened.");

    // Initializing my shelter
    VirtualPetShelter myShelter = new VirtualPetShelter();

    // Put the pets in the shelter
    myShelter.intakePet(pet1);
    myShelter.intakePet(pet2);
    myShelter.intakePet(pet3);
    myShelter.intakePet(pet4);
    myShelter.intakePet(pet5);


    // Implement a game loop.
    int choice = 0;
    // User options
    while (choice != 8) {
      System.out.println();
      welcomeMessage();
      myShelter.getNameAndDescription();

      System.out.println("--------------------------------------------------");
      System.out.println();

      // User interaction screen
      System.out.println("How would you like to interact with the pets?");
      System.out.println("1. Feed the pets");
      System.out.println("2. Give the pets fresh water");
      System.out.println("3. Play with a individual pet");
      System.out.println("4. Take pets out to use bathroom");
      System.out.println("5. Pets take a nap");
      System.out.println("6. Adopt a pet");
      System.out.println("7. Add a new pet ");
      System.out.println("8. Leave the shelter");
      System.out.print("Which do you choose: ");

      // Asks for user petInfo.
      Scanner petInfo = new Scanner(System.in);
      choice = petInfo.nextInt();

      switch (choice) {
        case 1:
          myShelter.feedAllPets();
          break;
        case 2:
          myShelter.giveAllPetsWater();
          break;
        case 3:
          System.out.println("List of pets available");
          System.out.print("Please choose a pet to play with: ");
          myShelter.receivePetNames();
          String chosenPet = petInfo.next();
          if (myShelter.isPetAvailable(chosenPet)) {
            myShelter.playWithOnePet(chosenPet);
          } else {
            System.out.println("Please choose from selected names: ");
          }
          break;
        case 4:
          myShelter.takeAllPetToBathroom();
          break;
        case 5:
          myShelter.allPetsTakeNap();
          break;
        case 6:
          adoptPet(petInfo, myShelter);
        break;
        case 7:
        addPet(petInfo, myShelter);
          break;
        case 8:
          petInfo.close();
          break;
        default:
          System.out.println("Invalid choice please choose from listed options");
          break;
      }
    }
    System.out.println("Thank you for visiting our VirtualPet Shelter.");
    System.out.println("Have a nice day");
  }

  private static void welcomeMessage() {
    System.out.println("                     Welcome to our VirtualPet Shelter");
    System.out.println("                           ---CURRENT PETS---");
    System.out
        .println("---------------------------------------------------------------------------------------------------");
  }

  private static void addPet(Scanner petInfo, VirtualPetShelter myShelter) {
    String petName;
    String petDescription;
    petInfo.nextLine(); 
    System.out.println("Looking to add a new pet, great! What is the pet name?  ");
    petName = petInfo.nextLine();
    System.out.println("Which type of animal is: " + petName + " and a short description");
    petDescription = petInfo.nextLine();
    VirtualPet newPet = new VirtualPet(petName, petDescription);
    myShelter.intakePet(newPet);
    System.out.println("Great! " + petName + " has been added.");
  }

  private static void adoptPet(Scanner petInfo, VirtualPetShelter myShelter) {
    String petName;
    petInfo.nextLine();
    myShelter.receivePetNames();
    System.out.println("Which animal would you like to adopt today: ");
    petName = petInfo.nextLine();
    if (myShelter.isPetAvailable(petName)) {
      System.out.println(petName+ " was just adopted. You'll absolutely love your new pet.");
      myShelter.adoptedPet(petName);
    } else {
      System.out.println("Please choose from available pets.");
    }
  }
}
