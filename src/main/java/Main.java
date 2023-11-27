import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        System.out.println("If the participant changes his choice during the game, then the probability of luck = " +
                luckProbability(winningCounts(gameWithChanges())) + "%");
        System.out.println("If the participant doesn't change his choice during the game, then the probability of luck = " +
                luckProbability(winningCounts(gameWithoutChanges())) + "%");
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

    public static String luckProbability(long count) {
        double value = (double) count / 1000 * 100;
        DecimalFormat decimalFormat = new DecimalFormat( "#.###" );
        return decimalFormat.format(value);
    }

}
