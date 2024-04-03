import java.util.Scanner;

public class sumofstringnums {
    // Function to find sum of all possible substrings of the given string.
    public static long sumSubstrings(String s) {
        long sum = 0;
        long mul = 1;
        long mod = 1000000007;
        for (int i = s.length() - 1; i >= 0; i--) {
            sum = (sum + (s.charAt(i) - '0') * mul * (i + 1)) % mod;
            mul = (mul * 10 + 1) % mod;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the string
        System.out.print("Enter the string: ");
        String s = scanner.next();

        // Calculate the sum of all possible substrings of the given string
        long result = sumSubstrings(s);

        // Print the result
        System.out.println("Sum of all possible substrings of the given string: " + result);

        // Close the scanner
        scanner.close();
    }
}
