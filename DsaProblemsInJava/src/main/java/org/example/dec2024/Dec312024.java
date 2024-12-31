package org.example.dec2024;

public class Dec312024 {
    private int getCost(int[] days, int[] costs, int currInd){
        if(currInd>=days.length){
            return 0;
        }
        int indexForOneDay = currInd+1;
        int indexForSevenDay = currInd;
        while(indexForSevenDay<days.length && days[currInd]+7>days[indexForSevenDay]){
            indexForSevenDay++;
        }
        int indexForMonth = currInd;
        while(indexForMonth<days.length && days[currInd]+30 > days[indexForMonth]){
            indexForMonth++;
        }
        int oneDayCost = costs[0] + getCost(days,costs,indexForOneDay);
        int sevenDayCost = costs[1] + getCost(days,costs,indexForSevenDay);
        int monthCost = costs[2] + getCost(days,costs,indexForMonth);

        return Math.min(Math.min(oneDayCost,sevenDayCost),monthCost);
    }
    public int mincostTickets(int[] days, int[] costs) {
        return getCost(days,costs,0);
    }
}
