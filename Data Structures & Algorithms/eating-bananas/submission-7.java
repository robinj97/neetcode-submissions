class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // We can calculate based on the largest if we eat the biggest pile first, decrement.
        // 1 4 3 2  9 -> k=4 4hours, we need to get as close to 9 as possible
        //              k=3 5,hours
        // low and high k, we calculate the midpoint and total hours, if above, we need to 
        // k=1 t>h -> increase k
        // lower k -> higher hours
        // take k as middle value
        // If total hours is too high, we incrase k
        // if total hours is too low, we decrease k
        
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        int foundK = right;
        while (left<=right) {
            //k is the midpoint
            int k = left + (right-left) /2;
            int totalTimeTaken = calculateTotalHours(k,piles);
            if (totalTimeTaken > h) {
                // Need to keep looking
                left = k+1;
            } else {
                // We found a potential candidate, but we need to see if we can decrease k more -> increase totalHours
                if (k < foundK) {   
                    foundK = k;
                }
                right = k-1;
            }
        }
        return foundK;
    }

    private int calculateTotalHours(int k,int[] piles) {
        int counter = 0;
        for (int i=0;i<piles.length;i++) {
            if (k>=piles[i]) {
                counter++;
            } else {
                int timesToEat = piles[i] / k;
                counter += (timesToEat+1);
            }
        }
        return counter;
    }
}
