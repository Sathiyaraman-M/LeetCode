class Solution {
    public int snakesAndLadders(int[][] board) {
        var len = board.length;
        var visited = new boolean[len * len + 1]; // Use indices from 1 to len * len
        visited[1] = true;
        var queue = new ArrayDeque<Integer>();
        queue.add(1);
        var result = 0;
        while(!queue.isEmpty()) {
            var size = queue.size();
            for(int i = 0; i < size; i++) {
                var curr = queue.poll();
                if(curr == len * len) {
                    return result;
                }
                var max = Math.min(curr + 6, len * len);
                var min = curr + 1;
                for (int j = min; j <= max; j++) {
                    var r = len - 1 - (j - 1) / len;
                    var c = r % 2 != len % 2 ? (j - 1) % len : len - 1 - (j - 1) % len;
                    var dest = board[r][c] != -1 ? board[r][c] : j;
                    if (!visited[dest]) {
                        visited[dest] = true;
                        queue.offer(dest);
                    }
                }
            }
            result++;
        }
        for(int i = 0; i < len; i++) {
            if(i % 2 == 0) {
                for(int j = 0; j < len; j++) {
                    System.out.printf("%d ", (i * len) + j + 1);
                }
            } else {
                for(int j = len - 1; j >= 0; j--) {
                    System.out.printf("%d ", (i * len) + j + 1);
                }
            }
            System.out.println();
        }
        return -1;
    }
}