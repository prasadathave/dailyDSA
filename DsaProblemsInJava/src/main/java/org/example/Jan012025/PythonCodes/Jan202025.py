class Solution:
    def firstCompleteIndex(self, arr: List[int], mat: List[List[int]]) -> int:
        map = {}
        for i in range(len(arr)):
            map[arr[i]] = i

        minRowsVal = len(arr)
        for i in range(len(mat)):
            row = mat[i]
            completionPt = 0
            for elem in row:
                completionPt = max(completionPt,map[elem])
            minRowsVal = min(minRowsVal,completionPt)

        minColVal = len(arr)
        for i in range(len(mat[0])):
            completionPt = 0
            for j in range(len(mat)):
                completionPt = max(completionPt,map[mat[j][i]])
            minColVal = min(minColVal,completionPt)

        return min(minColVal,minRowsVal)