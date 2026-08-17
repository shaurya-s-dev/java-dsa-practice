class Solution {
    public boolean isEven(int N){//name and signature must match exactly what the driver expects
        return (N & 1) == 0;//returns true if even, false if odd
    }
}