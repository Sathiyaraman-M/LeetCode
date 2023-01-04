import java.util.*;
class Solution {
    public int minimumRounds(int[] tasks) {
        var len = tasks.length;
        Arrays.sort(tasks);
        var map = new HashMap<Integer, Integer>();
        for(int i = 0; i < len; i++) {
            if(map.get(tasks[i]) == null) {
                map.put(tasks[i], 1);
            } else {
                var value = map.get(tasks[i]);
                map.replace(tasks[i], value + 1);
            }
        }
        var count = 0;
        for(var i: map.keySet()) {
            var value = map.get(i);
            if(value == 1) {
                return -1;
            }
            while(value > 0) {                
                if(value % 3 == 0) {
                    value -= 3;
                } else if (value % 2 == 0) {
                    value -= 2;
                } else if (value > 3) {
                    value -= 3;
                } else {
                    value -= 2;
                }
                count += 1;
            }
        }
        return count > 0 ? count : -1;
    }
}