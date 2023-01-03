public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        var count = 0;
        for(int i = 0; i < 32; i++) {
            var digit = n & 1;
            System.out.printf("%d", digit);
            if(digit == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}