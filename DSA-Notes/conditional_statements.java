public class conditional_statements {
    public static void main(String[] args){

        //conditional statements in java

        //if statement - runs the block only if condition is true
        int a = 10;
        if (a > 5){
            System.out.println("a is greater than 5");//runs only if condition is true
        }

        //if-else statement - runs one block or the other, never both
        int b = 3;
        if (b % 2 == 0){
            System.out.println("b is even");
        }
        else{
            System.out.println("b is odd");//this runs since 3 is odd
        }

        //if-else if-else ladder - checks multiple conditions in order, stops at first true one
        int marks = 75;
        if (marks >= 90){
            System.out.println("Grade: A");
        }
        else if (marks >= 75){
            System.out.println("Grade: B");//this runs, 75 matches this condition first
        }
        else if (marks >= 50){
            System.out.println("Grade: C");
        }
        else{
            System.out.println("Grade: F");//runs only if none of the above matched
        }

        //nested if - an if statement inside another if statement
        int age = 20;
        boolean hasID = true;
        if (age >= 18){
            if (hasID){
                System.out.println("Entry allowed");//both conditions true, so this runs
            }
            else{
                System.out.println("ID required for entry");
            }
        }
        else{
            System.out.println("Too young for entry");
        }

        //switch statement - checks one variable against multiple fixed values, cleaner than long if-else ladder
        int day = 3;
        switch (day){
            case 1:
                System.out.println("Monday");
                break;//break stops it from falling through to next case
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");//this runs, day matches case 3
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            default:
                System.out.println("Weekend");//runs if no case matches
                break;
        }

        //switch without break - shows fall-through behavior (usually a bug if unintentional)
        int num = 2;
        switch (num){
            case 1:
                System.out.println("one");
            case 2:
                System.out.println("two");//this runs
            case 3:
                System.out.println("three");//this ALSO runs since there's no break after case 2, execution falls through
                break;
            default:
                System.out.println("other");
        }

        //modern switch expression (Java 14+) - shorter syntax using arrow, no break needed, no fall-through
        int monthNum = 4;
        String season = switch (monthNum){
            case 12, 1, 2 -> "Winter";
            case 3, 4, 5 -> "Spring";//this matches, monthNum is 4
            case 6, 7, 8 -> "Summer";
            case 9, 10, 11 -> "Autumn";
            default -> "Invalid month";
        };
        System.out.println(season);
    }
}
