class Solution {
    public int maxArea(int[] heights) {
        // We compare ends 
        // Calculate water: take length * min(height)
        // Keep saving the water with max value calculated from current
        int maxWater = 0;
        int left=0;
        int right = heights.length-1;
        while (left<right) {
            int axis = right - left;
            int height = Math.min(heights[right],heights[left]);
            int totalWater = axis*height;
            maxWater = Math.max(totalWater,maxWater);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
        
    }
}
