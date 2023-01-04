import java.util.*;
class Solution {
    public int removeDuplicates(int[] nums) {
        var index = 0;
        var len = nums.length;
        var set = new HashSet<Integer>();
        for(int i = 0; i < len; i++) {
            nums[index] = nums[i];
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
                index++;
            }
        }
        return index;
    }
}