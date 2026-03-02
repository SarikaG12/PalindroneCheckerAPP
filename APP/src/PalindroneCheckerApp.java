/**
 * =====================================================
 * MAIN CLASS – UseCase11PalindromeCheckerApp
 * =====================================================
 *
 * Use Case 11: Object-Oriented Palindrome Service
 *
 * Description:
 * This class demonstrates palindrome validation using
 * object-oriented design.
 *
 * The palindrome logic is encapsulated inside a
 * PalindromeService class.
 *
 * @author Developer
 * @version 11.0
 */

import java.util.Scanner;

public class PalindroneCheckerApp {

    /**
     * Application entry point for UC11.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PalindromeService service = new PalindromeService();

        System.out.print("Input: ");
        String input = scanner.nextLine();

        boolean result = service.checkPalindrome(input);

        System.out.println("Is Palindrome?: " + result);

        scanner.close();
    }
}

/**
 * Service class that contains palindrome logic.
 */
class PalindromeService {

    /**
     * Checks whether the input string is a palindrome.
     * @param input Input string
     * @return true if palindrome, false otherwise
     */
    public boolean checkPalindrome(String input) {

        if (input == null) {
            return false;
        }

        // Normalize (optional improvement)
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Initialize pointers
        int start = 0;
        int end = normalized.length() - 1;

        // Compare characters moving inward
        while (start < end) {

            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}