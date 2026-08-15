class Solution {
    public boolean isSameAfterReversals(int num) {
        int r = 0;
        int o = num;

        while (num != 0) {
            int a = num % 10;
            num = num / 10;
            r = r * 10 + a;
        }
        int r1 = r;

        int rr = 0;
        while (r1 != 0) {
            int b = r1 % 10;
            r1 = r1 / 10;
            rr = rr * 10 + b;
        }

        return rr == o;
    }
}