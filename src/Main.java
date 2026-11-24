import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String gameDataFilePath = "data/week.csv"; 
        Game[] games = readGameData(gameDataFilePath);
        
        // Print the game data to verify
        for (Game game : games) {
            System.out.println("Game ID: " + game.getGameId());
            System.out.println("Home Team: " + game.getHomeTeam());
            System.out.println("Away Team: " + game.getAwayTeam());
            System.out.println("Game Date: " + game.getGameDate());
            System.out.println("Game Week: " + game.getGameWeek());
            System.out.println("Home Score: " + game.getHomeScore());
            System.out.println("Away Score: " + game.getAwayScore());
            System.out.println("Winner: " + game.getWinner());
            System.out.println();
        }
    }

    
    public static ArrayList<String> readAllLines(String path) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                lines.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e; // Rethrow the exception to be handled by the caller
        } 
        return lines;
        
    }
    
    
    
    public static Game[] readGameData(String filePath) throws IOException {
        // Implement the logic to read game data from the specified file
        ArrayList<Game> games = new ArrayList<>();
        ArrayList<String> lines = readAllLines(filePath);
        for (int i = 1; i < lines.size(); i++) {
            if (lines.get(i).trim().isEmpty()) {
                continue; 
            }
            String[] gameData = lines.get(i).split(",");   
            Game game = new Game(gameData[0], gameData[5], gameData[3], gameData[1], gameData[2], Integer.parseInt(gameData[6]), Integer.parseInt(gameData[4]), gameData[7]);
            games.add(game);
        }
        return games.toArray(new Game[0]);
    }
        


        
}