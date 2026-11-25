import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private int choice;
    private Game[] games;


    public Menu(Scanner scanner, Game[] games) {
        this.scanner = scanner;
        this.games = games;
    }

    private void viewGames() {
        System.out.println("(viewGames not written yet)");
    }

    private void makePick() {
        System.out.println("(makePick not written yet)");
    }

    public void run() {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. View Games");
            System.out.println("2. Make a Pick");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();
            try {
                choice = Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
                continue;
            } // Consume the newline character

            switch (choice) {
                case 1:
                    viewGames();
                    break;
                case 2:
                    makePick();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
