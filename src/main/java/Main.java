import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        double scale = Math.pow(10, 1);
        double luckyResultsGame1 = Math.ceil((luckProbability(winningCounts(gameWithChanges()))) * scale) / scale;
        double badLuck1 = (Math.ceil(luckyResultsGame1 * scale) / scale - 100) * (-1);
        double luckyResultsGame2 = Math.ceil((luckProbability(winningCounts(gameWithoutChanges()))) * scale) / scale;
        double badLuck2 = (Math.ceil(luckyResultsGame2 * scale) / scale - 100) * (-1);

        System.out.println("If the participant changes his choice during the game, then the probability of luck = " +
                luckyResultsGame1 + "%" + "\nand the probability of bad luck = " + badLuck1 + "%");

        System.out.println("If the participant changes his choice during the game, then the probability of luck = " +
                luckyResultsGame2 + "%" + "\nand the probability of bad luck = " + badLuck2 + "%");

    }

    public static Map<Integer, Boolean> gameWithoutChanges() {
        int attemptCount = 1000;
        Map<Integer, Boolean> results = new HashMap<>();

        Random rnd = new Random();

        for (int i = 0; i < attemptCount; i++) {
            int participantChoice = rnd.nextInt(3);
            int winningChoice = rnd.nextInt(3);

            if (participantChoice == winningChoice) {
                results.put(i, true);
            } else
                results.put(i, false);
        }
        return results;
    }

    public static Map<Integer, Boolean> gameWithChanges() {
        int attemptCount = 1000;
        Map<Integer, Boolean> results = new HashMap<>();

        Random rnd = new Random();

        for (int i = 0; i < attemptCount; i++) {
            int participantChoice = rnd.nextInt(3);
            int winningChoice = rnd.nextInt(3);
            int temp = participantChoice;

            if (participantChoice == winningChoice) {
                results.put(i, true);
            } else {
                while (temp == participantChoice) {
                    participantChoice = rnd.nextInt(3);
                }
                if (participantChoice == winningChoice) {
                    results.put(i, true);
                } else {
                    results.put(i, false);
                }
            }
        }
        return results;
    }

    public static long winningCounts(Map<Integer, Boolean> map) {
        return map.entrySet()
                .stream()
                .filter(result -> result.setValue(true))
                .count();
    }

    public static double luckProbability(long count) {
        return (double) count / 1000 * 100;
    }

}
