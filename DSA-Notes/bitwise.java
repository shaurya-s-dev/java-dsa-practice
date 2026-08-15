/*
============================================================
BITWISE OPERATORS - THEORY + EXAMPLES (Java)
============================================================

WHY BITWISE?
Computers store every number in BINARY (0s and 1s).
Example: 5 is stored as 101, 3 is stored as 011.

Bitwise operators work directly on these binary digits (bits),
comparing them one position at a time. They're much faster than
normal math operations because the CPU works with bits natively.

THE 6 BITWISE OPERATORS IN JAVA:
1. &   AND
2. |   OR
3. ^   XOR
4. ~   NOT (complement)
5. <<  Left Shift
6. >>  Right Shift
------------------------------------------------------------
*/

public class bitwise {

    public static void main(String[] args) {

        // ------------------------------------------------------
        // 1. AND (&)
        // Rule: result bit is 1 ONLY if BOTH bits are 1
        //   0 & 0 = 0
        //   0 & 1 = 0
        //   1 & 0 = 0
        //   1 & 1 = 1
        // Think: "both must agree to be 1, else 0"
        // ------------------------------------------------------
        int a = 5;  // binary: 101
        int b = 3;  // binary: 011
        int andResult = a & b;
        // 101
        // 011
        // ---
        // 001  -> 1
        System.out.println("5 & 3 = " + andResult); // 1


        // ------------------------------------------------------
        // 2. OR (|)
        // Rule: result bit is 1 if AT LEAST ONE bit is 1
        //   0 | 0 = 0
        //   0 | 1 = 1
        //   1 | 0 = 1
        //   1 | 1 = 1
        // Think: "if either one is 1, result is 1"
        // ------------------------------------------------------
        int orResult = a | b;
        // 101
        // 011
        // ---
        // 111  -> 7
        System.out.println("5 | 3 = " + orResult); // 7


        // ------------------------------------------------------
        // 3. XOR (^) - "exclusive or"
        // Rule: result bit is 1 if bits are DIFFERENT
        //   0 ^ 0 = 0
        //   0 ^ 1 = 1
        //   1 ^ 0 = 1
        //   1 ^ 1 = 0
        // Think: "1 if they disagree, 0 if they agree"
        //
        // SPECIAL PROPERTIES (very commonly asked in interviews):
        //   x ^ x = 0        (a number XOR itself is always 0)
        //   x ^ 0 = x        (XOR with 0 changes nothing)
        //   XOR is order-independent (a^b^c == c^b^a)
        // ------------------------------------------------------
        int xorResult = a ^ b;
        // 101
        // 011
        // ---
        // 110  -> 6
        System.out.println("5 ^ 3 = " + xorResult); // 6
        System.out.println("5 ^ 5 = " + (a ^ a));   // 0, always
        System.out.println("5 ^ 0 = " + (a ^ 0));   // 5, unchanged


        // ------------------------------------------------------
        // 4. NOT (~) - complement, flips every bit
        // Rule: 0 becomes 1, 1 becomes 0, for EVERY bit
        // In Java, integers are 32-bit and signed, so this
        // also flips the sign. Formula: ~x = -(x+1)
        // ------------------------------------------------------
        int notResult = ~a;
        // ~5 = ~(...00000101) = ...11111010 = -6
        System.out.println("~5 = " + notResult); // -6


        // ------------------------------------------------------
        // 5. LEFT SHIFT (<<)
        // Shifts all bits to the LEFT by n positions,
        // filling empty spots on the right with 0.
        // Effect: multiplies the number by 2^n
        // ------------------------------------------------------
        int leftShift = a << 1;
        // 5 = 101 -> shift left by 1 -> 1010 = 10
        System.out.println("5 << 1 = " + leftShift); // 10 (5*2)
        System.out.println("5 << 2 = " + (a << 2));  // 20 (5*4)


        // ------------------------------------------------------
        // 6. RIGHT SHIFT (>>)
        // Shifts all bits to the RIGHT by n positions,
        // dropping bits that fall off the right end.
        // Effect: divides the number by 2^n (integer division)
        // ------------------------------------------------------
        int rightShift = a >> 1;
        // 5 = 101 -> shift right by 1 -> 10 = 2
        System.out.println("5 >> 1 = " + rightShift); // 2 (5/2, floor)


        // ============================================================
        // COMMON BITWISE TRICKS USED IN DSA PROBLEMS
        // ============================================================

        // ------------------------------------------------------
        // TRICK 1: Check if a number is EVEN or ODD
        // The last bit of a binary number tells you this:
        //   last bit 0 -> even
        //   last bit 1 -> odd
        // (n & 1) isolates just the last bit
        // ------------------------------------------------------
        int n = 7;
        if ((n & 1) == 0) {
            System.out.println(n + " is even");
        } else {
            System.out.println(n + " is odd"); // this runs
        }


        // ------------------------------------------------------
        // TRICK 2: Check if a number is a POWER OF 2
        // A power of 2 (1,2,4,8,16...) in binary has EXACTLY
        // one '1' bit. Example: 8 = 1000
        //
        // n-1 flips everything after that single 1 bit:
        //   8     = 1000
        //   8-1=7 = 0111
        //   8 & 7 = 0000  -> result is 0, confirms power of 2
        //
        // For a non-power of 2, this AND will NOT be 0.
        // ------------------------------------------------------
        int num = 16;
        boolean isPowerOfTwo = (num > 0) && ((num & (num - 1)) == 0);
        System.out.println(num + " is power of 2? " + isPowerOfTwo); // true


        // ------------------------------------------------------
        // TRICK 3: Find the SINGLE NUMBER in an array where
        // every other number appears exactly twice.
        // XOR-ing everything cancels out all pairs (x^x=0),
        // leaving only the lone number.
        // ------------------------------------------------------
        int[] arr = {4, 1, 2, 1, 2};
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result ^ arr[i];
        }
        System.out.println("Single number: " + result); // 4


        // ------------------------------------------------------
        // TRICK 4: Count number of SET BITS (1s) in a number
        // Repeatedly check the last bit with (n & 1),
        // then shift right to check the next bit.
        // ------------------------------------------------------
        int countSetBits = 0;
        int temp = 13; // binary: 1101 -> three 1s
        while (temp != 0) {
            if ((temp & 1) == 1) {
                countSetBits++;
            }
            temp = temp >> 1;
        }
        System.out.println("Set bits in 13: " + countSetBits); // 3


        // ------------------------------------------------------
        // TRICK 5: Swap two numbers WITHOUT a third variable
        // Uses XOR's self-cancelling property three times.
        // ------------------------------------------------------
        int x = 5, y = 9;
        x = x ^ y;
        y = x ^ y; // now y becomes original x
        x = x ^ y; // now x becomes original y
        System.out.println("After swap: x=" + x + " y=" + y); // x=9 y=5


        // ------------------------------------------------------
        // TRICK 6: Toggle a specific bit (turn 1->0 or 0->1)
        // XOR-ing with a bit turns it OFF if it was ON,
        // and turns it ON if it was OFF, at that exact position.
        // (1 << pos) creates a number with only that position set to 1.
        // ------------------------------------------------------
        int value = 5;      // 101
        int pos = 1;         // toggle bit at position 1 (0-indexed from right)
        int toggled = value ^ (1 << pos);
        // 101
        // 010  <- (1<<1)
        // ---
        // 111 -> 7
        System.out.println("Toggle bit " + pos + " of 5: " + toggled); // 7
    }
}