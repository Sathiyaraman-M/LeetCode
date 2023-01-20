public class Solution {
    public int SubarraysDivByK(int[] nums, int k) {
        var len = nums.Length;
        var count = 0;
        var arr = new int[k];
        arr[0] += 1;
        var currSum = 0;
        for(int i = 0; i < len; i++) {
            currSum = (currSum + nums[i] % k + k) % k; // Extra +k is to get Positive Modulus value
            count += arr[currSum];
            arr[currSum]++;
        }
        return count;
    }
}