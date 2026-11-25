import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Game[] games = readGameData("data/week.csv");
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner, games);
        menu.run();
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
        

    public static void writePicksData(Picks pick, String filePath) throws IOException {
        File file = new File(filePath);
        boolean isNew = !file.exists();
        try (PrintWriter out = new PrintWriter(new FileWriter(file, true))) {
            if (isNew) {
                out.println("Name,Game ID,Pick,Confidence");
            }
            out.println(pick.toCsv());

        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }


    public static Picks[] readPicksData(String filePath) throws IOException {
        ArrayList<Picks> picks = new ArrayList<>();
        ArrayList<String> lines;
        try {
            lines = readAllLines(filePath);
        } catch (FileNotFoundException e) {
            return new Picks[0];
        }
        for (int i = 1; i < lines.size(); i++) {
            if (lines.get(i).trim().isEmpty()) {
                continue; 
            }
            String[] pickData = lines.get(i).split(",");
            Picks pick = new Picks(pickData[0], pickData[1], pickData[2], Double.parseDouble(pickData[3]));
            picks.add(pick);
        }
        
        return picks.toArray(new Picks[0]);
    }

        
}