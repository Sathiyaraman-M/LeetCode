import java.util.*;
class Solution {
    public int divide(int dividend, int divisor) {
        int sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? 1 : -1;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int result = 0;
        int power = 31;
        while(a >= b) {
            while(a < b << power) {
                power--;
            }
            a -= b << power;
            result += 1 << power;
        }
        if(result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        return sign > 0 ? result : 0 - result;
    }
}