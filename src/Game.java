public class Game {
    private String gameId;
    private String homeTeam;
    private String awayTeam;
    private String gameDate;
    private String gameWeek;
    private int homeScore;
    private int awayScore;
    private String winner;

    public Game(String gameId, String homeTeam, String awayTeam, String gameDate, String gameWeek, int homeScore, int awayScore, String winner) {
        this.gameId = gameId;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.gameDate = gameDate;
        this.gameWeek = gameWeek;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.winner = winner;
    }

    public String getGameId() {
        return gameId;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getGameDate() {
        return gameDate;
    }

    public String getGameWeek() {
        return gameWeek;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public String getWinner() {
        return winner;
    }

    public String toString() {
        return "Game{" +
                "gameId='" + gameId + '\'' +
                ", homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", gameDate='" + gameDate + '\'' +
                ", gameWeek='" + gameWeek + '\'' +
                ", homeScore=" + homeScore +
                ", awayScore=" + awayScore +
                ", winner='" + winner + '\'' +
                '}';
    }


}
