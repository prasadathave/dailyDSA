class Solution:
    def getValidNeighbours(self,isWater,point):
        directions =[[1,0],[-1,0],[0,1],[0,-1]]
        xm = len(isWater)
        ym = len(isWater[0])
        x = point[0]
        y = point[1]
        valids = []
        for d in directions:
            if((d[0]+x>=0 and d[0]+x<xm) and ((d[1]+y)>=0 and (d[1]+y<ym))):
                valids.append([d[0]+x,d[1]+y])
        return valids


    def highestPeak(self, isWater: List[List[int]]) -> List[List[int]]:
        # create a dummy height array
        maxNum = len(isWater)*len(isWater[0]) +1
        heightArr = [ [maxNum for i in range(len(isWater[0]))] for j in range(len(isWater))]
        remaining =0
        iterationStack = []
        for i in range(len(isWater)):
            for j in range(len(isWater[0])):
                remaining+=1
                if(isWater[i][j]==1):
                    heightArr[i][j] = 0
                    remaining-=1
                    iterationStack.append([i,j])

        while len(iterationStack)!=0:
            pt = iterationStack.pop(0)
            x0 = pt[0]
            y0 = pt[1]
            valids = self.getValidNeighbours(isWater,pt)
            for elem in valids:
                x = elem[0]
                y = elem[1]
                if(heightArr[x][y]>heightArr[x0][y0]+1):
                    heightArr[x][y] = heightArr[x0][y0]+1
                    iterationStack.append([x,y])
        return heightArr
