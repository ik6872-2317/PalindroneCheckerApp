public class PalindroneCheckerApp{

    /**
     * Application entry point for UC4.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // Declare and initialize input
        String input = "radar";

        // Convert string to character array
        char[] chars = input.toCharArray();

        // Initialize pointers
        int start = 0;
        int end = chars.length - 1;

        boolean isPalindrome = true;

        // Two-pointer comparison
        while (start < end) {

            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }

            start++;
            end--;
        }

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}