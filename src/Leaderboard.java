import java.util.ArrayList;
import java.util.HashMap;

public class Leaderboard {


    
    public static ArrayList<PlayerScore> buildStandings(Picks[] picks, Game[] games) {
        HashMap<String, Game> gameMap = new HashMap<>();
        HashMap<String, PlayerScore> playerScores = new HashMap<>();


        
        for (Game game : games) {
            gameMap.put(game.getGameId(), game);
        }

        for (Picks pick : picks) {
            Game game = gameMap.get(pick.getGameId());
            if (game == null) {
                continue;
            }
            PlayerScore playerScore = playerScores.get(pick.getName());
            if (playerScore == null) {
                playerScore = new PlayerScore(pick.getName(), 0, 0);
                playerScores.put(pick.getName(), playerScore);
            }
            playerScore.addTotal();
            if (pick.getPick().equals(game.getWinner())) {
                playerScore.addCorrect();
            }
        }
        ArrayList<PlayerScore> standings = new ArrayList<>(playerScores.values());

        return standings;
    }

    public static void printStandings(ArrayList<PlayerScore> standings) {
        System.out.println("Leaderboard:");
        for (PlayerScore playerScore : standings) {
            System.out.printf("%-10s %d/%d (%.1f%%)%n", playerScore.getName(), playerScore.getCorrect(), playerScore.getTotal(), playerScore.getPercentage());
        }
    }
}
