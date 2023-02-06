class Solution {
    public int[] shuffle(int[] nums, int n) {
        var result = new int[2 * n];
        for(int i = 0; i < 2 * n; i++) {
            if(i % 2 == 0) {
                result[i] = nums[i / 2];
            } else {
                result[i] = nums[(i / 2) + n];
            }
        }
        return result;
    }
}