class Solution {
    /**
     * Determines if a given number is an "ugly number."
     * 
     * @param n The input number to check.
     * @return true if n is an ugly number, otherwise false.
     */
    public boolean isUgly(int n) {
        // A number '0' or negative numbers cannot be ugly
        if (n == 0) {
            return false;
        }

        // Continue dividing 'n' by 2, 3, or 5 while it's divisible
        while (n > 1) {
            if (n % 2 == 0) { // If divisible by 2, divide by 2
                n /= 2;
            } else if (n % 3 == 0) { // If divisible by 3, divide by 3
                n /= 3;
            } else if (n % 5 == 0) { // If divisible by 5, divide by 5
                n /= 5;
            } else { 
                // If not divisible by 2, 3, or 5, it's not an ugly number
                return false;
            }
        }

        // If after all divisions, n is reduced to 1, it is an ugly number
        return n == 1;
    }
}
