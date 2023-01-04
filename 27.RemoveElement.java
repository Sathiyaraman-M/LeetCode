class Solution {
    public int removeElement(int[] nums, int val) {
        var index = 0;
        var len = nums.length;
        for(int i = 0; i < len; i++) {
            nums[index] = nums[i];
            if(nums[i] != val) {
                index++;
            }
        }
        return index;
    }
}