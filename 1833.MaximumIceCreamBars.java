class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        var count = 0;
        var len = costs.length;
        for(int i = 0; i < len; i++) {
            if(costs[i] <= coins) {
                coins -= costs[i];
                count++;
            }
        }
        return count;
    }
}