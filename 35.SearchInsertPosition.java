class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;        
        while(start <= end) {
            var mid = (start + end) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else if(nums[mid] > target) {
                end = mid - 1;
            }
        }
        return start;
    }
}