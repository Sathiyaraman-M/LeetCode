import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        var resultSet = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 1; i < nums.length - 1; i++) {
            binSearch(nums, resultSet, i, 0 - nums[i]);
        }
        return List.copyOf(resultSet);
    }

    private void binSearch(int[] arr, Set<List<Integer>> result, int i, int target) {
        int left = 0, right = arr.length - 1;
        while(left < right) {                        
            int sum = arr[left] + arr[right];
            if(sum < target) {
                left++;
            } else if(sum > target) {
                right--;
            } else {
                if(left != i && right != i) {
                    List<Integer> triplet = Arrays.asList(arr[left], arr[i], arr[right]);
                    Collections.sort(triplet);
                    result.add(triplet);
                }
                left++;
                right--;
            }
        }
    }
}