class Solution {
    public int search(int[] nums, int target) {

        //Search for target and return index, if not found then return -1;
        // 1 2 3 4 5 6 7 8 9 find 7
        // midpoint = 5
        // increment left to midpoint + 1
        int left =0;
        int right = nums.length - 1;

        while (left<=right) {
            int midpoint = left + (right-left) / 2;
            if (nums[midpoint] == target) {
                return midpoint;
            } else {
                if (nums[midpoint] > target) {
                    right = midpoint -1;
                } else {
                    left = midpoint+1;
                }
            }
        }
        return -1;
        
    }
}
