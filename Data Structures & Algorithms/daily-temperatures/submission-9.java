class Solution {
    // 30 38 30 36 35 40 28
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for (int i=0;i<temperatures.length;i++) {
            int currentTemp = temperatures[i];
            while (!stack.isEmpty() && stack.peek()[0] < currentTemp) {
                int indexToAdd = stack.peek()[1];
                int difference = i-indexToAdd;
                result[indexToAdd] = difference;
                stack.pop();
            }
            stack.push(new int[]{currentTemp,i});
        }
        return result;
    }
}
