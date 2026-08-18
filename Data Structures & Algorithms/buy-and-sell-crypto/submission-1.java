class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices == null || prices.length == 1) { // edge cases
            return 0;
        } // if
        
        int difference = 0;
        int maxDifference = 0;
        
        for (int i=1; i<prices.length; i++) {
            for (int j=i-1; j>=0; j--) {
                difference = prices[i] - prices[j];
                
                if (difference > maxDifference) {
                    maxDifference = difference;
                } // if
            } // for
        } // for
        
        if (maxDifference < 1) {
            return 0;
        }
        else return maxDifference;
    
    }
}
