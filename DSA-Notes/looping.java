public class looping {
    public static void main(String[] args){

        //loops in java

        //for loop - used when number of iterations is known beforehand
        for (int i = 1; i <= 5; i++){//initialization; condition; increment
            System.out.println("for loop: " + i);//prints 1 to 5
        }

        //while loop - used when number of iterations is NOT known beforehand, condition checked first
        int j = 1;
        while (j <= 5){
            System.out.println("while loop: " + j);//prints 1 to 5
            j++;//manual increment needed, else infinite loop
        }

        //do-while loop - runs body at least once, condition checked AFTER
        int k = 1;
        do{
            System.out.println("do-while loop: " + k);//prints 1 to 5
            k++;
        } while (k <= 5);

        //do-while runs at least once even if condition is false from the start
        int m = 10;
        do{
            System.out.println("this runs once even though m > 5: " + m);//prints 10
        } while (m <= 5);

        //enhanced for loop (for-each) - used to iterate over arrays/collections directly, no index needed
        int[] arr = {10, 20, 30, 40, 50};
        for (int num : arr){//reads as "for each num in arr"
            System.out.println("for-each: " + num);
        }

        //nested loops - loop inside another loop, inner loop completes fully for each outer iteration
        for (int row = 1; row <= 3; row++){
            for (int col = 1; col <= 3; col++){
                System.out.print(row * col + " ");//prints multiplication table pattern
            }
            System.out.println();//moves to next line after each row
        }

        //break - exits the loop immediately, skips remaining iterations
        for (int i = 1; i <= 10; i++){
            if (i == 5){
                break;//stops loop entirely once i reaches 5
            }
            System.out.println("break example: " + i);//prints 1,2,3,4 only
        }

        //continue - skips current iteration only, loop continues with next value
        for (int i = 1; i <= 5; i++){
            if (i == 3){
                continue;//skips printing when i is 3, but loop keeps going
            }
            System.out.println("continue example: " + i);//prints 1,2,4,5 (skips 3)
        }

        //infinite loop - condition always true, needs a break inside to stop (shown here, commented to avoid actually running forever)
        /*
        while (true){
            System.out.println("runs forever");
            break;//without this, loop never ends
        }
        */

        //labeled break - breaks out of an OUTER loop from inside a nested loop
        outer:
        for (int i = 1; i <= 3; i++){
            for (int l = 1; l <= 3; l++){
                if (i == 2 && l == 2){
                    break outer;//exits BOTH loops, not just inner one
                }
                System.out.println("labeled break: i=" + i + " l=" + l);
            }
        }
    }
}
