public class patterns {
    public static void main(String[] args) {
        int n=5;
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



        for (int row = 1; row <= nn; row++) {
            if (row==1){
                continue;
            }
            for (int col = 1; col <= row - 1; col++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= 2 * nn - 2 * row + 1; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int row = 0; row < n; row++) {
            if(row==0){
                continue;
            }
            for (int col = n; col > row; col--) {
                System.out.print("* ");
            }
            System.out.println();
        }System.out.println();
        for(int row=1; row <= n ; row++) {
//for each row -> variable copl
            for(int col=1; col <= row; col++) {
                int a = row;
                int b = ('D' - 1);
                int ans = a+b;
                char finalAns = (char)ans;
                System.out.print(finalAns);
            }
            System.out.println();
        }System.out.println();

        for(int row=1; row <= n ; row++) {
//for each row -> variable copl
            for(int col=1; col <= n-row+1; col++) {
                int a = col;
                int b = ('A' - 1);
                int ans = a+b;
                char finalAns = (char)ans;
                System.out.print(finalAns);
            }
            System.out.println();
        }System.out.println();

        for(int row=1; row <= n ; row++) {
//for each row -> variable copl
            for(int col=1; col <= row; col++) {
                int a = row;
                int b = ('A' - 1);
                int ans = a+b;
                char finalAns = (char)ans;
                System.out.print(finalAns);
            }
            System.out.println();
        }System.out.println();

        for (int row = 1; row <= nn; row++) {
            for (int col = 1; col <= nn - row; col++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= 2 * row - 1; col++) {

                int a = col;
                int b = ('A' - 1);
                int ans = a+b;
                char finalAns = (char)ans;
                System.out.print(finalAns);
            }
            System.out.println();
        }System.out.println();
        for(int row=1; row <= n ; row++) {
//for each row -> variable copl
            for (int col = 1; col <= row; col++) {
                int a = n-col;
                int b = ('A');
                int ans = a + b;
                char finalAns = (char) ans;
                System.out.print(finalAns);
            }
            System.out.println();
        }
    }
}
