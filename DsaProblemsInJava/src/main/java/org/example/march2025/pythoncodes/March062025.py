class Solution:
    def findMissingAndRepeatedValues(self, grid: List[List[int]]) -> List[int]:
        n = len(grid)
        mapping = [0]*(n*n+1)
        for elem in grid:
            for num in elem:
                mapping[num]+=1
        result =[]
        for i in range(1,len(mapping)):
            if(mapping[i]==2):
                result.append(i)
        for i in range(1,len(mapping)):
            if(mapping[i]==0):
                result.append(i)
        return result