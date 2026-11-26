import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Menu {
    private Scanner scanner;
    private int choice;
    private Game[] games;


    public Menu(Scanner scanner, Game[] games) {
        this.scanner = scanner;
        this.games = games;
    }

    public int askInput(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                choice = Integer.parseInt(input.trim());
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.println("Invalid choice. Please enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
            }
        }
    }

    private void viewGames() {
        if (games.length == 0) {
            System.out.println("No games loaded.");
            return;
        }
        System.out.println("Games:");
        for (int i = 0; i < games.length; i++) {
            System.out.println((i + 1) + ". " + games[i].getAwayTeam() + " at " + games[i].getHomeTeam());
        }
    }

    private void makePick() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        if (name.trim().isEmpty()) {
            System.out.println("Name cannot be empty. Please try again.");
            return;
        }
        if (games.length == 0) {
            System.out.println("No games loaded.");
            return;
        }
        viewGames();
        int gameIndex = askInput("Enter the game number: ", 1, games.length) - 1;
        String gameId = games[gameIndex].getGameId();
        System.out.print("Enter your pick (home or away team): ");
        String pick = scanner.nextLine().toUpperCase();
        while (!pick.equalsIgnoreCase(games[gameIndex].getHomeTeam()) && !pick.equalsIgnoreCase(games[gameIndex].getAwayTeam())) {
            System.out.println("Invalid pick. Please enter either the home team or the away team.");
            System.out.print("Enter your pick (home or away team): ");
            pick = scanner.nextLine().toUpperCase();
        }
        double confidence = askInput("Enter your confidence level (1-5): ", 1, 5);

        Picks userPick = new Picks(name, gameId, pick, confidence);
        try {
            Main.writePicksData(userPick, "data/picks.csv");
            System.out.println("Pick saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving pick: " + e.getMessage());
        }
    }


    public void run() {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. View Games");
            System.out.println("2. Make a Pick");
            System.out.println("3. View Leaderboard");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();
            try {
                choice = Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    viewGames();
                    break;
                case 2:
                    makePick();
                    break;
                case 3:
                    try {
                        Leaderboard.printStandings(Leaderboard.buildStandings(Main.readPicksData("data/picks.csv"), games));
                    } catch (IOException e) {
                        System.out.println("Error reading picks data: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
