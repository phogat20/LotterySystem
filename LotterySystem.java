import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class LotterySystem {
    public static final int NUMBERS = 6;
    public static final int MAX_NUMBER = 40;
    public static final int PRIZE = 100;

    public static void main(String[] args) {

        // Getting winning number and ticket.
        Set<Integer> winning = createWinningNumber();
        Set<Integer> ticket = getTicket();

        // Checking and Storing matches gussed by user
        Set<Integer> guessed = new TreeSet<>(ticket);
        guessed.retainAll(winning);

        System.out.println("Your guessed numbers:" + ticket);
        System.out.println("Number guessed by you:" + guessed);

        // Prize Calculation
        if (guessed.size() > 0) {
            double prize = PRIZE * guessed.size();
            System.out.println("Guessed Number by User:" + guessed);
            System.out.println("Total prize money earned:" + prize);
        }
    }

    // Genrating random lottery numbers.
    public static Set<Integer> createWinningNumber() {
        Set<Integer> winning = new TreeSet<>();
        Random random = new Random();
        while (winning.size() < NUMBERS) {
            int number = random.nextInt(MAX_NUMBER) + 1;
            winning.add(number);
        }
        return winning;

    }

    // Taking guessed number by user.
    public static Set<Integer> getTicket() {
        Set<Integer> ticket = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter" + NUMBERS + " Lottery Number");

        while (ticket.size() < NUMBERS) {
            int number = scanner.nextInt();
            if (number <= MAX_NUMBER)
                ticket.add(number);
        }
        return ticket;
    }

}