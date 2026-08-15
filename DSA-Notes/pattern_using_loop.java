public class pattern_using_loop {
    public static void main(String[] args) {
        int n = 4;


        // Pattern 0: Solid square (n x n) of stars
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 1: Right-angled triangle of stars (increasing)
        /*
         * MY ORIGINAL THOUGHT PROCESS:
         * I wanted row "row" to have "row" stars, so I made inner loop "col < row".
         * For the outer loop I used "row <= n" thinking it would just run
         * n rows (1 star, 2 stars, 3 stars, 4 stars).
         *
         * ORIGINAL CODE:
         * for (int row = 0; row <= n; row++) {
         *     for (int col = 0; col < row; col++) {
         *         System.out.print("* ");
         *     }
         *     System.out.println();
         * }
         *
         * FLAW:
         * "row <= n" makes the outer loop run n+1 times (row = 0,1,2,3,4 for n=4).
         * - When row=0 -> 0 stars (blank row, unwanted extra empty line)
         * - When row=4 -> 4 stars (an extra row I didn't plan for)
         * So instead of exactly n rows (1,2,3,4 stars), I got 5 rows (0,1,2,3,4 stars).
         *
         * FIX:
         * Change outer loop to "row < n" starting from row=1, OR keep row starting
         * at 0 but change condition to "row < n" and inner loop to "col <= row".
         * Below I start row from 1 so the count is intuitive (row = row stars).
         */
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 2: Numbers 1 to row in each row (increasing count)
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 3: Same number "row" repeated row times in each row
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(row);
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 4: Inverted triangle of stars (decreasing)
        /*
         * MY ORIGINAL THOUGHT PROCESS:
         * I wanted the first row to have n stars, and each next row to have
         * one less star, counting down with col from a fixed starting point.
         *
         * ORIGINAL CODE:
         * for (int row = 0; row < n; row++) {
         *     for (int col = 4; col > row; col--) {
         *         System.out.print("*");
         *     }
         *     System.out.println();
         * }
         *
         * FLAW:
         * I hardcoded "col = 4" instead of using "col = n".
         * This only works correctly because n happens to equal 4 right now.
         * If I change n to, say, 6, this block will still only print a
         * maximum of 4 stars per row instead of 6 - the pattern breaks
         * silently because it doesn't scale with n.
         *
         * FIX:
         * Replace the hardcoded 4 with n so the inner loop always starts
         * from the current value of n, not a fixed number.
         */
        for (int row = 0; row < n; row++) {
            for (int col = n; col > row; col--) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 5: Numbers counting up, row length decreasing (matches TUF+ example)
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n - row + 1; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 6: Solid pyramid of stars (5 rows)
        int nn = 5;
        for (int row = 1; row <= nn; row++) {
            for (int col = 1; col <= nn - row; col++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= 2 * row - 1; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 7: Solid pyramid of stars (5 rows) - reverse
        int nb = 5;
        for (int row = 1; row <= nb; row++) {
            for (int col = 1; col <= row - 1; col++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= 2 * nb - 2 * row + 1; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 8: Hollow rectangle/square (only boundary is stars, middle is blank)
        int rows = 5;
        int cols = 8;
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
                if (row == 1 || row == rows || col == 1 || col == cols) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }


            for (int row = 1; row <= nn; row++) {

                if (row == 1 || row == nn || row==2) {
                    for (int col = 1; col <=row; col++) {
                        System.out.print("*");
                    }
                }
                else{
                    System.out.print("*");
                    for( int col=1;col<=(row - 2);col++){
                        System.out.print(" ");
                    }
                    System.out.print("*");
                }
                System.out.println();
            }

        }
    }
