package org.example.Apr2025;

public class April182025 {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        if(n==2){
            return "11";
        }
        if(n==3){
            return "21";
        }
        if(n==4){
            return "1211";
        }

        String lastString = countAndSay(n-1);
        int start = 0;
        int end =0;
        StringBuilder sb = new StringBuilder();
        while(end<lastString.length()){
            char cs = lastString.charAt(start);
            while(end<lastString.length() && cs==lastString.charAt(end)){
                end++;
            }
            sb.append(""+(end-start));
            sb.append(cs);
            start = end;
        }
        return sb.toString();

    }
}
