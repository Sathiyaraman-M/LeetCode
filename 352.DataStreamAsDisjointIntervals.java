class SummaryRanges {
    private TreeMap<Integer, int[]> map;

    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int value) {
        if(map.containsKey(value)) return;
        var least = map.lowerKey(value);
        var most = map.higherKey(value);
        if(least != null && most != null && map.get(least)[1] + 1 == value && most == value + 1) {
            map.get(least)[1] = map.get(most)[1];
            map.remove(most);
        } else if(least != null && map.get(least)[1] + 1 >= value) {
            map.get(least)[1] = Math.max(value, map.get(least)[1]);
        } else if(most != null && most == value + 1) {
            map.put(value, new int[] { value, map.get(most)[1] });
            map.remove(most);
        } else {
            map.put(value, new int[] { value, value });
        }
    }
    
    public int[][] getIntervals() {    
        var intervals = new ArrayList<int[]>(map.values());
        return intervals.toArray(new int[intervals.size()][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */