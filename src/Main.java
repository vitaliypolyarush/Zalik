import java.util.Scanner;

public class Main {
    private static final String[] QUESTIONS = {
            "1. What time ___ you usually wake up? (a) do (b) does (c) did (d) done",
            "2. My brother ___ to the gym every day. (a) go (b) goes (c) went (d) gone",
            "3. They ___ English lessons on Mondays. (a) have (b) has (c) had (d) having",
            "4. She ___ coffee in the morning. (a) drink (b) drinks (c) drank (d) drunk",
            "5. We ___ a movie last night. (a) watch (b) watches (c) watched (d) watching"
    };

    private static final String[] ANSWERS = {"b", "b", "a", "b", "c"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isAdmin = false;
        String password = "1111";
        int correctAnswers = 0;

        System.out.println("Welcome to the Present Simple Quiz!");

        for (int i = 0; i < QUESTIONS.length; i++) {
            System.out.println("\n" + QUESTIONS[i]);
            System.out.print("Enter your choice (a, b, c, d): ");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("q")) {
                break;
            } else if (choice.equals(password)) {
                isAdmin = true;
                System.out.println("\nAdmin mode activated!");
                break;
            } else if (isAdmin) {
                showAnswers();
                break;
            } else if (!isValidChoice(choice)) {
                System.out.println("\nInvalid choice! Please try again.");
                break;
            }

            if (choice.equals(ANSWERS[i])) {
                correctAnswers++;
            }
        }

        if (!isAdmin) {
            double percentage = (double) correctAnswers / QUESTIONS.length * 100;

            System.out.println("\n--- Quiz Results ---");
            System.out.println("Correct Answers: " + correctAnswers + "/" + QUESTIONS.length);
            System.out.println("Percentage: " + percentage + "%");
        }

        System.out.println("\nThank you for taking the Present Simple Quiz!");
    }

    private static boolean isValidChoice(String choice) {
        return choice.equals("a") || choice.equals("b") || choice.equals("c") || choice.equals("d");
    }

    private static void showAnswers() {
        System.out.println("\n--- Correct Answers ---");
        for (int i = 0; i < QUESTIONS.length; i++) {
            System.out.println(QUESTIONS[i] + " Answer: " + ANSWERS[i]);
        }
    }
}
