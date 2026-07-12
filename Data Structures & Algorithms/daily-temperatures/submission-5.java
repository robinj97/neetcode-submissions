class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // 30,38,30,36,35,40,28
        //    ^  
        // 1. 2. 3. 4. 5. 6
        // 38,30,36,35,40,28
        // 38,1 -> 30,2 -> 

        int[] results = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for (int i=0;i<temperatures.length;i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp > stack.peek()[0]) {
                int indexToAddAt = stack.peek()[1];
                int days = i-indexToAddAt;
                results[indexToAddAt] = days;
                stack.pop();
            }
            stack.push(new int[]{temp,i});
        }
        return results;
        
    }
}
