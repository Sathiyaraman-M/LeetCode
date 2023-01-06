class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (x, y) -> Integer.compare(x[1], y[1]));
        var count = 1;
        var index = 0;        
        var len = points.length;
        for(int i = 1; i < len; i++) {
            if(points[i][0] > points[index][1]) {
                count++;
                index = i;
            }
        }
        return count;
    }
}