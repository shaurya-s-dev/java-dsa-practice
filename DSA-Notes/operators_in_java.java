public class operators_in_java {
    public static void main(String[] args){

        //operators in java

        //arithmetic operators - used for basic math
        int x = 10, y = 3;
        System.out.println(x + y);//addition, prints 13
        System.out.println(x - y);//subtraction, prints 7
        System.out.println(x * y);//multiplication, prints 30
        System.out.println(x / y);//division, prints 3 (int division drops decimal)
        System.out.println(x % y);//modulus, prints 1 (remainder)

        //relational operators - compare values, always return boolean
        System.out.println(x > y);//greater than, prints true
        System.out.println(x < y);//less than, prints false
        System.out.println(x == y);//equal to, prints false
        System.out.println(x != y);//not equal to, prints true
        System.out.println(x >= y);//greater than or equal to, prints true
        System.out.println(x <= y);//less than or equal to, prints false

        //logical operators - combine boolean conditions
        boolean p = true, q = false;
        System.out.println(p && q);//logical AND, true only if both true, prints false
        System.out.println(p || q);//logical OR, true if either true, prints true
        System.out.println(!p);//logical NOT, flips the value, prints false

        //assignment operators - assign and update values
        int z = 5;
        z += 3;//same as z = z + 3
        System.out.println(z);//prints 8
        z -= 2;//same as z = z - 2
        System.out.println(z);//prints 6
        z *= 2;//same as z = z * 2
        System.out.println(z);//prints 12
        z /= 4;//same as z = z / 4
        System.out.println(z);//prints 3
        z %= 2;//same as z = z % 2
        System.out.println(z);//prints 1

        //unary operators - work on a single operand
        int u = 5;
        System.out.println(++u);//pre-increment, increases first then prints, prints 6
        System.out.println(u++);//post-increment, prints first then increases, prints 6 (u becomes 7 after)
        System.out.println(u);//prints 7
        System.out.println(--u);//pre-decrement, decreases first then prints, prints 6
        System.out.println(u--);//post-decrement, prints first then decreases, prints 6 (u becomes 5 after)
        System.out.println(u);//prints 5
        System.out.println(-u);//unary minus, flips sign, prints -5

        //ternary operator - shorthand for if-else, condition ? valueIfTrue : valueIfFalse
        int max = (x > y) ? x : y;
        System.out.println(max);//prints 10, since x(10) > y(3)

        //bitwise operators - work directly on bits (mostly used with int/long)
        int m = 5, n = 3;//5 is 101 in binary, 3 is 011 in binary
        System.out.println(m & n);//bitwise AND, prints 1 (001)
        System.out.println(m | n);//bitwise OR, prints 7 (111)
        System.out.println(m ^ n);//bitwise XOR, prints 6 (110)
        System.out.println(~m);//bitwise NOT, flips all bits, prints -6
        System.out.println(m << 1);//left shift, multiplies by 2, prints 10
        System.out.println(m >> 1);//right shift, divides by 2, prints 2
    }
}
