class Solution {
    public int maxProfit(int[] prices) {
        // comparator for currentMin price
        // comparator for currentMaxProfit
        int currentMaxProfit = 0;
        int currentMinPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < currentMinPrice) {
                currentMinPrice = price;
            } else {
                int tempMaxProfit = price - currentMinPrice;
                currentMaxProfit = Math.max(currentMaxProfit,tempMaxProfit);
            }
        }
        return currentMaxProfit;
        
    }
}
