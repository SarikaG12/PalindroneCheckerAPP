import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * ============================================================
 * MAIN CLASS - UseCase13PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 13: Performance Comparison
 *
 * This class measures and compares the execution
 * performance of different palindrome algorithms.
 *
 * It:
 *  - Runs multiple algorithms
 *  - Captures execution start and end time
 *  - Calculates total execution duration
 *  - Displays benchmarking results
 */

public class PalindroneCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input : ");
        String input = scanner.nextLine();

        // Run Stack Strategy
        PalindromeStrategy stackStrategy = new StackStrategy();
        long startTime = System.nanoTime();
        boolean stackResult = stackStrategy.check(input);
        long endTime = System.nanoTime();
        long stackDuration = endTime - startTime;

        // Run Deque Strategy
        PalindromeStrategy dequeStrategy = new DequeStrategy();
        startTime = System.nanoTime();
        boolean dequeResult = dequeStrategy.check(input);
        endTime = System.nanoTime();
        long dequeDuration = endTime - startTime;

        // Display Results
        System.out.println("\n--- Performance Results ---");
        System.out.println("Stack Strategy  -> Is Palindrome? : "
                + stackResult + " | Execution Time: " + stackDuration + " ns");

        System.out.println("Deque Strategy  -> Is Palindrome? : "
                + dequeResult + " | Execution Time: " + dequeDuration + " ns");

        scanner.close();
    }
}

/**
 * Strategy Interface
 */
interface PalindromeStrategy {
    boolean check(String input);
}

/**
 * Stack-based palindrome check
 */
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

/**
 * Deque-based palindrome check
 */
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}