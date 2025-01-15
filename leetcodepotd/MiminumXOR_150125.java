package leetcodepotd;

/**
 * This class provides utility functions for bit manipulation and a method to minimize
 * the XOR value between two integers by constructing a specific integer.
 */
class Solution {

    /**
     * Checks if a specific bit in a number is set (i.e., equals 1).
     * 
     * @param x The integer to check.
     * @param bit The bit position to check (0-based, right-to-left).
     * @return True if the bit at the specified position is set, false otherwise.
     */
    public boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0;
    }

    /**
     * Sets a specific bit in a number to 1.
     * 
     * @param x The integer to modify.
     * @param bit The bit position to set (0-based, right-to-left).
     * @return The modified integer with the specified bit set.
     */
    public int setBit(int x, int bit) {
        return x | (1 << bit);
    }

    /**
     * Unsets a specific bit in a number (sets it to 0).
     * 
     * @param x The integer to modify.
     * @param bit The bit position to unset (0-based, right-to-left).
     * @return The modified integer with the specified bit unset.
     */
    public int unsetBit(int x, int bit) {
        return x & ~(1 << bit);
    }

    /**
     * Checks if a specific bit in a number is unset (i.e., equals 0).
     * 
     * @param x The integer to check.
     * @param bit The bit position to check (0-based, right-to-left).
     * @return True if the bit at the specified position is unset, false otherwise.
     */
    public boolean isUnSet(int x, int bit) {
        return (x & (1 << bit)) == 0;
    }

    /**
     * Constructs an integer `x` such that the XOR of `x` and `num1` is minimized, while ensuring
     * that the number of set bits in `x` is equal to the number of set bits in `num2`.
     * 
     * @param num1 The first integer.
     * @param num2 The second integer, whose set bit count is used as a reference.
     * @return The integer `x` that satisfies the given conditions.
     */
    public int minimizeXor(int num1, int num2) {
        int x = 0; // Initialize the result to 0.

        // Calculate the number of set bits required in `x`.
        int requiredSetBitCount = Integer.bitCount(num2);

        // Iterate over the bits of `num1` from most significant to least significant.
        for (int bit = 31; bit >= 0 && requiredSetBitCount > 0; bit--) {
            if (isSet(num1, bit)) {
                x |= (1 << bit); // Set the bit in `x`.
                requiredSetBitCount--; // Decrease the count of required set bits.
            }
        }

        // If more set bits are needed, set them starting from the least significant bit.
        for (int bit = 0; bit < 32 && requiredSetBitCount > 0; bit++) {
            if (isUnSet(num1, bit)) {
                x |= (1 << bit); // Set the bit in `x`.
                requiredSetBitCount--; // Decrease the count of required set bits.
            }
        }

        return x; // Return the constructed number `x`.
    }
}
