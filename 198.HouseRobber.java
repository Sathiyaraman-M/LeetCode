class Solution {
    public int rob(int[] nums) {
        var len = nums.length;
        var arr = new int[len];
        if(len == 1) {
            return nums[0];
        }
        arr[0] = nums[0];
        arr[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < len; i++) {
            arr[i] = Math.max(arr[i - 1], nums[i] + arr[i - 2]);
        }
        return arr[len - 1];
    }
}