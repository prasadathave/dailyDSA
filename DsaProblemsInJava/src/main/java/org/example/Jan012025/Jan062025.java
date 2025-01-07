package org.example.Jan012025;

public class Jan062025 {
    public int[] minOperations(String boxes) {
        int[] answer = new int[boxes.length()];
        for(int i=0; i<boxes.length(); i++){
            int val =0;
            for(int j =0; j<boxes.length(); j++){
                if(boxes.charAt(j)=='1'){
                    val+=Math.abs(i-j);
                }
            }
            answer[i] = val;
        }
        return answer;
    }
}
