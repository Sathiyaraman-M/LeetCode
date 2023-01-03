import java.util.*;
class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        var len = nums.length;
        var max = 0;
        for(int i = 2; i < len; i++) {
            if(nums[i - 1] + nums[i - 2] > nums[i]) {
                var perimeter = nums[i - 2] + nums[i - 1] + nums[i];
                if(perimeter > max) {
                    max = perimeter;
                }
            }
        }
        return max;
    }
}