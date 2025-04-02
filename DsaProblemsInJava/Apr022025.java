public class Apr022025 {
    public long maximumTripletValue(int[] nums) {
        long ans =0L;
        int n = nums.length;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    long value = ((long)nums[i] - (long) nums[j]) * ((long) nums[k]);
                    ans = Math.max(ans,value);
                }
            }
        }
        return ans;
    }
}
