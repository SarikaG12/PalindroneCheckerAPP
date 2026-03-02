/**
 * ===============================================================
 * MAIN CLASS - UseCase8PalindromeCheckerApp
 * ===============================================================
 *
 * Use Case 8: Linked List Based Palindrome Checker
 *
 * Description:
 * This class checks whether a string is a palindrome
 * using a Singly Linked List.
 *
 * Steps:
 * 1. Convert string into linked list
 * 2. Find middle using fast & slow pointer
 * 3. Reverse second half in-place
 * 4. Compare both halves
 *
 * Author: Developer
 * Version: 8.0
 */

public class PalindroneCheckerApp {

    // Node class for Singly Linked List
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to check palindrome
    public static boolean isPalindrome(String input) {

        if (input == null || input.length() <= 1) {
            return true;
        }

        // Step 1: Convert string to linked list
        Node head = new Node(input.charAt(0));
        Node current = head;

        for (int i = 1; i < input.length(); i++) {
            current.next = new Node(input.charAt(i));
            current = current.next;
        }

        // Step 2: Find middle using fast & slow pointer
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 3: Reverse second half
        Node secondHalf = reverse(slow);
        Node firstHalf = head;

        // Step 4: Compare both halves
        Node tempSecond = secondHalf;
        while (tempSecond != null) {
            if (firstHalf.data != tempSecond.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            tempSecond = tempSecond.next;
        }

        return true;
    }

    // Helper method to reverse linked list
    private static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    /**
     * Application entry point for UC8.
     */
    public static void main(String[] args) {

        String input = "level";

        boolean result = isPalindrome(input);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
    }
}