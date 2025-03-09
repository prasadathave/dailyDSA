class Solution:
    def getVal(self,colors: List[int],index:int)->int:
        index = (index+len(colors))%len(colors)
        return colors[index]
    def numberOfAlternatingGroups(self, colors: List[int], k: int) -> int:
        left =0
        counter =0
        for right in range(1,len(colors)+k-1):
            if(self.getVal(colors,right)==self.getVal(colors,right-1)):
                left = right
            if(right-left+1>k):
                left+=1
            if(right-left+1==k):
                counter+=1

        return counter

        