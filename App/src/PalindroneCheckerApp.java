import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

interface PalindroneStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindroneStrategy {

    public boolean check(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        String reversed = "";

        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        return input.equals(reversed);
    }
}

class DequeStrategy implements PalindroneStrategy {

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
public class PalindroneCheckerApp {

    public static void main(String[] args) {

        String input = "level";

        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeStrategy dequeStrategy = new DequeStrategy();

        long start1 = System.nanoTime();
        boolean result1 = stackStrategy.check(input);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        boolean result2 = dequeStrategy.check(input);
        long end2 = System.nanoTime();

        System.out.println("Input : " + input);

        System.out.println("Stack Result : " + result1);
        System.out.println("Stack Execution Time : " + (end1 - start1) + " ns");

        System.out.println("Deque Result : " + result2);
        System.out.println("Deque Execution Time : " + (end2 - start2) + " ns");
    }
}