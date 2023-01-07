class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        var len = gas.length;
        var totalGas = 0;
        var rem = 0;
        var result = 0;
        for(int i = 0; i < len; i++) {
            var extra = gas[i] - cost[i];
            totalGas += extra;
            rem += extra;
            if(rem < 0) {
                result = i + 1;
                rem = 0;
            }
        }
        return totalGas >= 0 ? result : -1;
    }
}