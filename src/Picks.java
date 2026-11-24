public class Picks {

    private String name;
    private String gameId;
    private String pick;
    private double confidence;

    public Picks(String name, String gameId, String pick, double confidence) {
        this.name = name;
        this.gameId = gameId;
        this.pick = pick;
        this.confidence = confidence;
    }

    public String getName() {
        return name;
    }

    public String getGameId() {
        return gameId;
    }

    public String getPick() {
        return pick;
    }

    public double getConfidence() {
        return confidence;
    }

    

}
