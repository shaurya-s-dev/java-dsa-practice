class Solution {
    public boolean isPalindrome(int n) {
        if (n < 0) {
            return false;
        }
        int r = 0;
        int o = n;
        while (n != 0) {
            int a = n % 10;
            n = n / 10;
            r = r * 10 + a;
        }
        return r == o;
    }
}