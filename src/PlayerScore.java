public class PlayerScore {

    private String name;
    private int correct;
    private int total;
    private double percentage;

    public PlayerScore(String name, int correct, int total) {
        this.name = name;
        this.correct = correct;
        this.total = total;
        this.percentage = 100.0 * (correct / (double) total);
    }

    public String getName() {
        return name;
    }

    public int getCorrect() {
        return correct;
    }

    public int getTotal() {
        return total;
    }

    public void addCorrect() {
        this.correct++;
    }

    public void addTotal() {
        this.total++;
    }

    public double getPercentage() {
        if (total == 0) {
            return 0.0;
        }

        return 100.0 * (correct / (double) total);
    }

    public String toString() {
        return String.format("%.1f%% - %s (%d/%d)", percentage, name, correct, total);
    }

}
