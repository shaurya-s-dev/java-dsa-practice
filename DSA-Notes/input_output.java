import java.util.Scanner;

public class input_output {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);//creates a scanner object to read input

        //output basics

        System.out.print("This does not go to new line ");//print stays on same line
        System.out.println("This goes to new line");//println moves to next line after
        System.out.printf("Formatted output: %d and %.2f%n", 5, 3.14159);//printf lets you format output, %d=int, %.2f=decimal with 2 places, %n=new line

        //taking input for different data types

        System.out.print("Enter your name: ");
        String name = sc.nextLine();//reads a full line of text
        System.out.println("Hello " + name);

        System.out.print("Enter your age (int): ");
        int age = sc.nextInt();//reads an int
        System.out.println("Age is " + age);

        System.out.print("Enter your height (double): ");
        double height = sc.nextDouble();//reads a double
        System.out.println("Height is " + height);

        System.out.print("Enter a long number: ");
        long bigNum = sc.nextLong();//reads a long
        System.out.println("Long number is " + bigNum);

        System.out.print("Enter a float value: ");
        float fVal = sc.nextFloat();//reads a float
        System.out.println("Float value is " + fVal);

        System.out.print("Are you a student? (true/false): ");
        boolean isStudent = sc.nextBoolean();//reads a boolean
        System.out.println("Is student: " + isStudent);

        sc.nextLine();//clears leftover newline character left by nextInt/nextDouble/etc before reading a char/line again

        System.out.print("Enter a single character: ");
        String charInput = sc.nextLine();//Scanner has no direct nextChar(), so read as String then take first character
        char ch = charInput.charAt(0);
        System.out.println("Character entered: " + ch);

        sc.close();//closes the scanner, good practice to free resources
    }
}
