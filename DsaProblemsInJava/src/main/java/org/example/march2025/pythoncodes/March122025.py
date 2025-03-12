class Solution:
    def maximumCount(self, nums: List[int]) -> int:
        pos =0
        neg =0
        for elem in nums:
            if(elem>0):
                pos+=1
            if(elem<0):
                neg+=1
        return max(pos,neg)