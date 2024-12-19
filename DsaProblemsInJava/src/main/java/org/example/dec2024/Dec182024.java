package org.example.dec2024;

public class Dec182024 {
    private int getDiscountElement(int[] prices, int currentIndex){
        for(int i=currentIndex+1; i<prices.length; i++){
            if(prices[i]<=prices[currentIndex]){
                return i;
            }
        }
        return -1;
    }
    public int[] finalPrices(int[] prices) {
        int[] resultArr = new int[prices.length];
        for(int i=0; i<prices.length; i++){
            int num = getDiscountElement(prices,i);
            if(num!=-1){
                resultArr[i] = prices[i] - prices[num];
            }
            else{
                resultArr[i] = prices[i];
            }
        }
        return resultArr;
    }

    // Another approach -
    
}
