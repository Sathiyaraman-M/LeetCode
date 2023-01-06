class Solution {
    public int[] searchRange(int[] nums, int target) {
        var len = nums.length;
        var start = -1;
        for(int i = 0; i < len; i++) {
            if(nums[i] == target) {
                start = i;
                break;
            }
        }
        if(start == -1) {
            return new int[] { -1, -1 };
        }
        for(int i = start + 1; i < len; i++) {            
            if(nums[i] != target) {
                return new int[] { start, i - 1 };
            }
        }
        return new int[] { start, len - 1 };
    }
}