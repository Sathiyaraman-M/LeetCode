class Solution {
    private int[] memory;
    
    public Solution() {
        memory = new int[31];
        Arrays.fill(memory, -1);
        memory[0] = 0;
        memory[1] = 1;
    }
    
    public int fib(int n) {
        if(n != 0 && n != 1 && memory[n] == -1) {
            memory[n] = fib(n - 1) + fib(n - 2);
        }
        return memory[n];
    }
}