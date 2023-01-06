class Solution {
    public int maxCoins(int[] piles) {
        var len = piles.length;
        var iterations = len / 3;
        Arrays.sort(piles);
        var index = len - 2;
        var sum = 0;
        for(int i = 0; i < iterations; i++) {
            sum += piles[index];
            index -= 2;
        }
        return sum;
    }
}