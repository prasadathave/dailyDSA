package org.example.Feb2025;

public class Feb152025 {
    private boolean isDivisionPossible(String s1,int sum){
        if(sum<0){
            return false;
        }
        if(s1.length()==0 && sum==0){
            return true;
        }
        if(s1.length()==0 && sum!=0){
            return false;
        }
        for(int i=0; i<s1.length(); i++){
            String sub1 = s1.substring(0,i+1);
            String sub2 = s1.substring(i+1,s1.length());
            int n1 =0;
            int n2 =0;
            if(sub1.length()!=0)



            {
                n1 = Integer.parseInt(sub1);
            }
            if(sub2.length()!=0){
                n2 = Integer.parseInt(sub2);
            }
            if(sum==(n2+n1)){
                return true;
            }
            if(sub2.length()!=0){
                if(isDivisionPossible(sub1,sum-n2)){
                    return true;
                }
            }
            if(sub1.length()!=0){
                if(isDivisionPossible(sub2,sum-n1)){
                    return true;
                }
            }

        }

        return false;
    }
    public int punishmentNumber(int n) {
        int sum =0;
        for(int i=1; i<=n; i++){
            int sqr = i*i;
            String s1 = Integer.toString(sqr);
            if(isDivisionPossible(s1,i)){
                sum+=sqr;
            }
        }
        return sum;
    }
}
