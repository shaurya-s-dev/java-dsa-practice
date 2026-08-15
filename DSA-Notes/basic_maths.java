// ============================================================
// BASIC MATH CODING QUESTIONS - JAVA (with comments)
// Most commonly asked in labs, interviews, DSA practice
// ============================================================

import java.util.*;

public class basic_maths {

    // ------------------------------------------------------
    // 1. CHECK PRIME NUMBER
    // A number is prime if it has no divisors other than 1 and itself
    // Trick: only check up to sqrt(n), not up to n-1 (faster + avoids bugs)
    // ------------------------------------------------------
    static boolean isPrime(int n) {
        if (n < 2) return false; // 0 and 1 are NOT prime
        for (int i = 2; i * i <= n; i++) { // i*i<=n means i<=sqrt(n)
            if (n % i == 0) return false; // found a divisor -> not prime
        }
        return true;
    }

    // ------------------------------------------------------
    // 2. PALINDROME NUMBER
    // A number is a palindrome if it reads the same forwards and backwards
    // Example: 121 -> reverse is 121 -> palindrome
    // ------------------------------------------------------
    static boolean isPalindromeNumber(int num) {
        int original = num;
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;         // extract last digit
            reversed = reversed * 10 + digit; // build reversed number
            num = num / 10;               // remove last digit
        }
        return original == reversed;
    }

    // ------------------------------------------------------
    // 3. PALINDROME STRING
    // Same idea but for strings (used a lot in interviews)
    // ------------------------------------------------------
    static boolean isPalindromeString(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // ------------------------------------------------------
    // 4. REVERSE A NUMBER
    // Same digit extraction trick used everywhere in this list
    // ------------------------------------------------------
    static int reverseNumber(int num) {
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num = num / 10;
        }
        return reversed;
    }

    // ------------------------------------------------------
    // 5. SUM OF DIGITS
    // ------------------------------------------------------
    static int sumOfDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum = sum + (num % 10); // add last digit
            num = num / 10;        // remove last digit
        }
        return sum;
    }

    // ------------------------------------------------------
    // 6. COUNT NUMBER OF DIGITS
    // ------------------------------------------------------
    static int countDigits(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = num / 10;
        }
        return count;
    }

    // ------------------------------------------------------
    // 7. ARMSTRONG NUMBER
    // Number equal to sum of its digits each raised to power = number of digits
    // Example: 153 -> 1^3 + 5^3 + 3^3 = 1+125+27 = 153 -> Armstrong
    // Needs TWO passes: first count digits, then compute powered sum
    // ------------------------------------------------------
    static boolean isArmstrong(int num) {
        int digits = countDigits(num); // step 1: know the power first

        int temp = num;
        int sum = 0;
        while (temp != 0) {
            int digit = temp % 10;
            sum += (int) Math.pow(digit, digits); // digit raised to 'digits' power
            temp = temp / 10;
        }
        return sum == num;
    }

    // ------------------------------------------------------
    // 8. FACTORIAL OF A NUMBER
    // n! = n * (n-1) * (n-2) * ... * 1
    // ------------------------------------------------------
    static long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    // ------------------------------------------------------
    // 9. FIBONACCI SERIES (first n terms)
    // Each number = sum of previous two: 0,1,1,2,3,5,8,13...
    // ------------------------------------------------------
    static void printFibonacci(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
    }

    // ------------------------------------------------------
    // 10. GCD (Greatest Common Divisor) - Euclidean Algorithm
    // GCD(a,b) = GCD(b, a%b), stop when b becomes 0
    // ------------------------------------------------------
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a; // when b=0, a holds the GCD
    }

    // ------------------------------------------------------
    // 11. LCM (Least Common Multiple)
    // Formula: LCM(a,b) = (a*b) / GCD(a,b)
    // ------------------------------------------------------
    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // ------------------------------------------------------
    // 12. PERFECT NUMBER
    // Sum of proper divisors (excluding itself) equals the number
    // Example: 6 -> divisors 1,2,3 -> 1+2+3=6 -> perfect
    // ------------------------------------------------------
    static boolean isPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) { // check divisors less than num
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }

    // ------------------------------------------------------
    // 13. STRONG NUMBER
    // Sum of factorial of each digit equals the number
    // Example: 145 -> 1! + 4! + 5! = 1+24+120 = 145 -> Strong
    // ------------------------------------------------------
    static boolean isStrongNumber(int num) {
        int temp = num;
        int sum = 0;
        while (temp != 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp = temp / 10;
        }
        return sum == num;
    }

    // ------------------------------------------------------
    // 14. PRINT ALL PRIME NUMBERS UP TO N (Sieve of Eratosthenes)
    // Much faster than checking isPrime() for every number one by one
    // ------------------------------------------------------
    static void sieveOfEratosthenes(int n) {
        boolean[] isComposite = new boolean[n + 1]; // false = assume prime initially
        for (int i = 2; i * i <= n; i++) {
            if (!isComposite[i]) {
                // mark all multiples of i as composite (not prime)
                for (int j = i * i; j <= n; j += i) {
                    isComposite[j] = true;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (!isComposite[i]) System.out.print(i + " ");
        }
    }

    // ------------------------------------------------------
    // 15. CHECK IF NUMBER IS POWER OF 2
    // Trick: powers of 2 in binary have only one '1' bit -> n & (n-1) == 0
    // ------------------------------------------------------
    static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

    // ------------------------------------------------------
    // 16. SWAP TWO NUMBERS WITHOUT A THIRD VARIABLE
    // ------------------------------------------------------
    static void swapWithoutTemp(int a, int b) {
        a = a + b;
        b = a - b; // b becomes original a
        a = a - b; // a becomes original b
        System.out.println("a=" + a + " b=" + b);
    }

    // ------------------------------------------------------
    // 17. CHECK ARMSTRONG-STYLE: DUCK NUMBER
    // A number where the digit '0' appears somewhere but not at start
    // (Just a common variant question, quick to write)
    // ------------------------------------------------------
    static boolean isDuckNumber(String num) {
        if (num.charAt(0) == '0') return false; // leading zero not allowed
        return num.contains("0");
    }

    // ------------------------------------------------------
    // 18. NEON NUMBER
    // Sum of digits of (num*num) equals num
    // Example: 9 -> 9*9=81 -> 8+1=9 -> Neon
    // ------------------------------------------------------
    static boolean isNeonNumber(int num) {
        int square = num * num;
        return sumOfDigits(square) == num;
    }

    // ------------------------------------------------------
    // 19. FIND ALL PREFIXES AND SUFFIXES OF A NUMBER
    // Used in problems like "Complete Prime Number"
    // ------------------------------------------------------
    static void printPrefixesAndSuffixes(int num) {
        // prefixes: keep removing last digit
        System.out.print("Prefixes: ");
        int p = num;
        while (p != 0) {
            System.out.print(p + " ");
            p = p / 10;
        }

        // suffixes: keep taking last k digits using mod
        System.out.print("\nSuffixes: ");
        int mod = 10;
        int s = num % mod;
        while (true) {
            System.out.print(s + " ");
            if (mod > num) break;
            mod = mod * 10;
            s = num % mod;
        }
    }

    // ------------------------------------------------------
    // 20. GCD OF DIGITS OF A NUMBER
    // ------------------------------------------------------
    static int gcdOfDigits(int num) {
        int temp = num;
        int result = 0;
        while (temp != 0) {
            int digit = temp % 10;
            result = gcd(result, digit); // gcd(0,x)=x, builds up correctly
            temp = temp / 10;
        }
        return result;
    }

    // ============================================================
    // MAIN - quick test of everything above
    // ============================================================
    public static void main(String[] args) {
        System.out.println("isPrime(23): " + isPrime(23));
        System.out.println("isPalindromeNumber(121): " + isPalindromeNumber(121));
        System.out.println("isPalindromeString(\"madam\"): " + isPalindromeString("madam"));
        System.out.println("reverseNumber(1234): " + reverseNumber(1234));
        System.out.println("sumOfDigits(2345): " + sumOfDigits(2345));
        System.out.println("countDigits(9834): " + countDigits(9834));
        System.out.println("isArmstrong(153): " + isArmstrong(153));
        System.out.println("factorial(5): " + factorial(5));
        System.out.print("Fibonacci(7): "); printFibonacci(7); System.out.println();
        System.out.println("gcd(12,18): " + gcd(12, 18));
        System.out.println("lcm(4,6): " + lcm(4, 6));
        System.out.println("isPerfectNumber(28): " + isPerfectNumber(28));
        System.out.println("isStrongNumber(145): " + isStrongNumber(145));
        System.out.print("Primes up to 30: "); sieveOfEratosthenes(30); System.out.println();
        System.out.println("isPowerOfTwo(64): " + isPowerOfTwo(64));
        swapWithoutTemp(5, 10);
        System.out.println("isNeonNumber(9): " + isNeonNumber(9));
        printPrefixesAndSuffixes(257);
        System.out.println();
        System.out.println("gcdOfDigits(248): " + gcdOfDigits(248));
    }
}