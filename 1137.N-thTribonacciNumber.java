class Solution {
    private int[] memory;
    
    public Solution() {
        memory = new int[38];
        Arrays.fill(memory, -1);
        memory[0] = 0;
        memory[1] = memory[2] = 1;
    }

    public int tribonacci(int n) {
        if(memory[n] != -1) {
            return memory[n];
        } else if(n == 0) {
            return 0;
        } else if(n == 1 || n == 2) { 
            return 1;
        } else { 
            memory[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
            return memory[n];
        }
    }
}