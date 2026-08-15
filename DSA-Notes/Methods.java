public class Methods {

    public static void main(String[] args) {

        // 1. Calling a method with NO parameters and NO return value (void)
        greet();

        // 2. Calling a method WITH parameters, still no return value
        greetByName("Shaurya");

        // 3. Calling a method that RETURNS a value
        int sum = addNumbers(5, 10);
        System.out.println("Sum: " + sum);

        // 4. Using a method's return value directly inside another expression
        System.out.println("Double the sum: " + (addNumbers(5, 10) * 2));

        // 5. Method overloading - same method name, different parameter types/counts
        System.out.println(addNumbers(5, 10, 15));       // calls 3-int version
        System.out.println(addNumbers(5.5, 2.5));         // calls double version

        // 6. Passing an array to a method
        int[] marks = {90, 85, 76, 60};
        System.out.println("Average: " + findAverage(marks));

        // 7. Recursive method (a method that calls itself)
        System.out.println("Factorial of 5: " + factorial(5));

        // 8. Static vs instance methods - see note near bottom
        Methods obj = new Methods();
        obj.instanceMethodExample();
    }

    // ---------- METHOD 1: no parameters, no return value ----------
    // "void" means this method does NOT give back any value
    static void greet() {
        System.out.println("Hello!");
    }

    // ---------- METHOD 2: takes a parameter, still void ----------
    // "String name" is a PARAMETER - a placeholder for whatever value gets passed in
    static void greetByName(String name) {
        System.out.println("Hello, " + name + "!");
    }

    // ---------- METHOD 3: returns a value ----------
    // "int" before the method name means this method MUST return an int
    static int addNumbers(int a, int b) {
        return a + b; // "return" sends this value back to wherever the method was called
    }

    // ---------- METHOD 5: overloading examples ----------
    // Same name "addNumbers", but different parameter list = a DIFFERENT method
    // Java picks the right one based on what you pass in
    static int addNumbers(int a, int b, int c) {
        return a + b + c;
    }

    static double addNumbers(double a, double b) {
        return a + b;
    }

    // ---------- METHOD 6: taking an array as a parameter ----------
    static double findAverage(int[] numbers) {
        int total = 0;
        for (int i = 0; i < numbers.length; i++) {
            total = total + numbers[i];
        }
        return (double) total / numbers.length; // cast to double so we don't lose decimals
    }

    // ---------- METHOD 7: recursion ----------
    // A recursive method calls ITSELF, with a smaller version of the problem each time
    // It MUST have a "base case" (a stopping point) or it will run forever and crash
    static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // base case - stops the recursion
        }
        return n * factorial(n - 1); // recursive case - calls itself with a smaller n
    }

    // ---------- METHOD 8: instance method (non-static) ----------
    // Static methods belong to the CLASS itself - callable without creating an object (addNumbers, greet, etc above)
    // Instance methods belong to an OBJECT - you must create an object first (see main: "obj.instanceMethodExample()")
    void instanceMethodExample() {
        System.out.println("This is an instance method - needed an object to call it.");
    }
}

