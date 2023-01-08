class Solution {
    public int maxPoints(int[][] points) {
        int m = 0;
        for(var i: points) {
            var map = new HashMap<Double, Integer>();
            for(var j: points) {
                if(i == j) continue;
                double denom = j[0] - i[0], slope = 0;
                if(denom == 0) {
                    slope = Double.POSITIVE_INFINITY;
                } else {
                    slope = (j[1] - i[1]) / denom;
                }
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                m = Math.max(m, map.get(slope));
            }
        }
        return m + 1;
    }
}