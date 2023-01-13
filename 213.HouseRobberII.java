class Solution {
    public int rob(int[] nums) {
        var len = nums.length;
        if(len == 1) {
            return nums[0];
        } else {
            var range1 = rob(nums, 0, len - 2);
            var range2 = rob(nums, 1, len - 1);
            System.out.printf("%d %d", range1, range2);
            return Math.max(range1, range2);
        }
    }

    public int rob(int[] nums, int start, int end) {
        var len = nums.length;
        var arr = new int[len];
        if(end == start) {
            return nums[start];
        }
        arr[start] = nums[start];
        arr[start + 1] = Math.max(nums[start], nums[start + 1]);
        for(int i = start + 2; i <= end; i++) {
            arr[i] = Math.max(arr[i - 1], nums[i] + arr[i - 2]);
        }
        return arr[end];
    }
}