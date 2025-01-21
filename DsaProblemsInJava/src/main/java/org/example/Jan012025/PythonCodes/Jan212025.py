class Solution:
    def getPrefixArr(self,grid):
        m = len(grid)
        n = len(grid[0])
        prefixArr = [[0 for i in range(n)]for j in range(m)]
        for i in range(m):
            prefixSum = 0
            for j in range(n):
                prefixSum += grid[i][j]
                prefixArr[i][j] = prefixSum
        return prefixArr


    def gridGame(self, grid: List[List[int]]) -> int:
        prefixArr = self.getPrefixArr(grid)
        minVal = prefixArr[0][-1]+prefixArr[1][-1]
        for i in range(len(grid[0])):
            maxFori = max(prefixArr[0][-1]-prefixArr[0][i],prefixArr[1][i]-grid[1][i])
            minVal = min(maxFori,minVal)
        return minVal
