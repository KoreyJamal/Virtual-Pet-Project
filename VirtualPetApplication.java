import java.util.Scanner;

public class VirtualPetApplication {
  public static void main(String[] args) {
    VirtualPet pet = new VirtualPet("Jackson", "Cat");
    VirtualPet pet1 = new VirtualPet("Oliver", "Cat");
    Scanner scanner = new Scanner(System.in);

    
    
    //Game Loop
    while (true){
      System.out.println();
      System.out.println(pet1);
      System.out.println();
      System.out.println("-----Virtual Pet Menu-----");
      System.out.println("1. Feed " + pet1.getName());
      System.out.println("2. Give " + pet1.getName() + " water");
      System.out.println("3. Play with " + pet1.getName());
      System.out.println("4. Put " + pet1.getName() + " to sleep");
      System.out.println("5. Take " + pet1.getName() + " outside to use bathroom");
      System.out.println("6. Exit");

      int choice = scanner.nextInt();

      switch (choice){
        case 1:
          pet1.feed();
          break;
        case 2:
          pet1.giveWater();
          break;
        case 3:
          pet1.play();
          break;
        case 4:
          pet1.sleep();
          break;
        case 5:
          pet1.useBathroom();
          break;
        case 6:
          System.exit(0);
          break;
        default:
          System.out.println("Invalid Choice. Please try again.");
          continue;
      }
      
      System.out.println();
      pet1.displayStatus();
    }
  }
}
